package com.manide.util;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.boot.test.context.SpringBootTest;
import org.w3c.dom.Document;

@SpringBootTest
@TestInstance(Lifecycle.PER_CLASS)
@TestMethodOrder(OrderAnnotation.class)
@DisplayName("XML - Manifestação do Destinatário")
class DocumentoUtilTest {

    private static final String PATH_XML_ASSINADO = "c:/mde/teste-assinado.xml";
    private static final String PATH_XML_ASSINADO2 = "c:/mde/teste-assinado2.xml";

    @Test
    @DisplayName("gera xml, assina, verifica assinatura digital e grava arquivo")
    @Order(1)
    void test() throws Exception {
	String xml = EventoManifestacaoDestinatario.build();
	String xmlAssinado = DocumentoUtil.assinar(xml);

	Document documentAssinado = UtilXml.createDocument(xmlAssinado.getBytes());

	UtilXml.saveXml(documentAssinado, PATH_XML_ASSINADO);

	boolean isValida = ValidarXmlAssinado.isValid(documentAssinado);
	boolean isValida2 = ValidarXmlAssinado.isValid2(documentAssinado);

	MatcherAssert.assertThat(isValida, Matchers.is(Boolean.TRUE));
	MatcherAssert.assertThat(isValida2, Matchers.is(Boolean.TRUE));

    }

    @Test
    @DisplayName("verifica assinatura digital do xml gravado")
    @Order(2)
    void test2() throws Exception {

	Path path = Paths.get(PATH_XML_ASSINADO2);

	byte[] xml = Files.readAllBytes(path);

	Document document = UtilXml.createDocument(xml);

	boolean isValid2 = ValidarXmlAssinado.isValid(document);
	boolean isValid = ValidarXmlAssinado.isValid2(document);

	MatcherAssert.assertThat(isValid2, Matchers.is(true));
	MatcherAssert.assertThat(isValid, Matchers.is(true));

//	Document document = bd.parse(new File("c:/mde/teste-assinado.xml"));
//	Exception exception = Assertions.assertThrows(Exception.class, () -> util.validarAssinaturaXML(document));
//	MatcherAssert.assertThat(exception.getMessage(), Matchers.is("Ocorreu um problema durante a validação assinatura."));
    }
}