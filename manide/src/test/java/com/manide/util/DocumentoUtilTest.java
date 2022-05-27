package com.manide.util;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.boot.test.context.SpringBootTest;
import org.w3c.dom.Document;

@SpringBootTest
@TestInstance(Lifecycle.PER_CLASS)
//@TestMethodOrder(OrderAnnotation.class)
@DisplayName("XML - Manifestação do Destinatário")
class DocumentoUtilTest {

    private static final String PATH_XML_ASSINADO = "c:/mde/teste-assinado.xml";
    private static final String PATH_XML_ASSINADO2 = "c:/mde/teste-assinado2.xml";
    private static final String PATH_XML_ASSINADO3 = "c:/mde/teste-assinado3.xml";

    @Test
    @DisplayName("gera xml, assina, verifica assinatura digital e grava arquivo")
//    @Order(1)
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
    @DisplayName("verifica se tem assinatura")
//    @Order(2)
    void valida_se_tem_assinatura() throws Exception {
	String xml = EventoManifestacaoDestinatario.build();

	Document documentCriado = UtilXml.createDocument(xml.getBytes());
	UtilXml.saveXml(documentCriado, PATH_XML_ASSINADO2);

	Path path = Paths.get(PATH_XML_ASSINADO2);

	byte[] xmlBytes = Files.readAllBytes(path);
	Document document = UtilXml.createDocument(xmlBytes);

	Exception exception = Assertions.assertThrows(Exception.class, () -> ValidarXmlAssinado.isValid(document));
	Exception exception2 = Assertions.assertThrows(Exception.class, () -> ValidarXmlAssinado.isValid2(document));

	MatcherAssert.assertThat(exception.getMessage(), Matchers.is("Ocorreu um problema durante a validação assinatura. O documento não está assinado."));
	MatcherAssert.assertThat(exception2.getMessage(), Matchers.is("O documento não está assinado."));
    }

    @Test
    @DisplayName("verifica se assinatura está correta")
    void verifica_se_assinatura_esta_correta() throws Exception {
	String xml = EventoManifestacaoDestinatario.build();
	String xmlAssinado = DocumentoUtil.assinar(xml);

	xmlAssinado = xmlAssinado.replace("justificativa de manifestacao do destinatario", "justificativa de manifestacao do destinatario alteradao");
	Document documentCriado = UtilXml.createDocument(xmlAssinado.getBytes());

	UtilXml.saveXml(documentCriado, PATH_XML_ASSINADO3);

	Path path = Paths.get(PATH_XML_ASSINADO3);

	byte[] xmlBytes = Files.readAllBytes(path);
	Document document = UtilXml.createDocument(xmlBytes);

	Exception exception = Assertions.assertThrows(Exception.class, () -> ValidarXmlAssinado.isValid(document));
	Exception exception2 = Assertions.assertThrows(Exception.class, () -> ValidarXmlAssinado.isValid2(document));

	MatcherAssert.assertThat(exception.getMessage(), Matchers.is("Ocorreu um problema durante a validação assinatura. O documento não está assinado."));
	MatcherAssert.assertThat(exception2.getMessage(), Matchers.is("O documento não está assinado."));
    }
}