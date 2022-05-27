package com.manide.util;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.w3c.dom.Document;

@SpringBootTest
@DisplayName("XML - Manifestação do Destinatário")
class DocumentoUtilTest {

    private static final String PATH_XML_ASSINADO = "c:/mde/teste-assinado.xml";

    @Autowired
    DocumentoUtil documentUtil;

    @Test
    @DisplayName("gera xml, assina, verifica assinatura digital e grava arquivo")
    void test() throws Exception {
	String xml = new EventoManifestacaoDestinatario().build();
	String xmlAssinado = documentUtil.assinar(xml);

	Document documentAssinado = UtilXml.createDocument(xmlAssinado.getBytes());

	UtilXml.saveXml(documentAssinado, PATH_XML_ASSINADO);

	boolean isValida = new ValidarXmlAssinado().isValid(documentAssinado);

	MatcherAssert.assertThat(isValida, Matchers.is(Boolean.TRUE));
    }

    @Test
    @DisplayName("verifica se tem assinatura")
    void valida_se_tem_assinatura() throws Exception {
	String xml = new EventoManifestacaoDestinatario().build();

	Document documentCriado = UtilXml.createDocument(xml.getBytes());
	UtilXml.saveXml(documentCriado, PATH_XML_ASSINADO);

	Path path = Paths.get(PATH_XML_ASSINADO);

	byte[] xmlBytes = Files.readAllBytes(path);
	Document document = UtilXml.createDocument(xmlBytes);

	Exception exception = Assertions.assertThrows(Exception.class, () -> new ValidarXmlAssinado().isValid(document));

	MatcherAssert.assertThat(exception.getMessage(), Matchers.is("Ocorreu um problema durante a validação assinatura. O documento não está assinado."));
    }

    @Test
    @DisplayName("verifica se assinatura está correta")
    void verifica_se_assinatura_esta_correta() throws Exception {
	String xml = new EventoManifestacaoDestinatario().build();
	String xmlAssinado = documentUtil.assinar(xml);

	xmlAssinado = xmlAssinado.replace("justificativa de manifestacao do destinatario", "justificativa de manifestacao do destinatario alteradao");
	Document documentCriado = UtilXml.createDocument(xmlAssinado.getBytes());

	UtilXml.saveXml(documentCriado, PATH_XML_ASSINADO);

	Path path = Paths.get(PATH_XML_ASSINADO);

	byte[] xmlBytes = Files.readAllBytes(path);
	Document document = UtilXml.createDocument(xmlBytes);

	MatcherAssert.assertThat(new ValidarXmlAssinado().isValid(document), Matchers.is(Boolean.FALSE));
    }
}