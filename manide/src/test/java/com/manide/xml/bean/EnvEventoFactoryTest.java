package com.manide.xml.bean;

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

import com.manide.certificado.Certificado;
import com.manide.certificado.KeyRepository;
import com.manide.xml.UtilXml;
import com.manide.xml.bean.EnvEventoFactory;

@SpringBootTest
@DisplayName("XML - Manifestação do Destinatário")
class EnvEventoFactoryTest {

    private static final String PATH_XML_ASSINADO = "c:/mde/teste-assinado.xml";
    @Autowired
    private KeyRepository keyRepository;

    @Autowired
    EnvEventoFactory EnvEventoFactory;

    @Autowired
    UtilXml utilXml;

    @Autowired
    Certificado certificado;

    @Test
    @DisplayName("gera xml, assina, verifica assinatura digital e grava arquivo")
    void test() throws Exception {
	String xml = EnvEventoFactory.build();

	Document document = utilXml.createDocument(xml.getBytes());

	String xmlAssinado = certificado.assinarXML(keyRepository.getCertificado(), keyRepository.getPrivateKey(), "ID0123456789012345678901234567890123456789012345678911", document, "evento");

	Document documentAssinado = utilXml.createDocument(xmlAssinado.getBytes());

	utilXml.saveXml(documentAssinado, PATH_XML_ASSINADO);

	boolean isValida = certificado.isValid(documentAssinado);

	MatcherAssert.assertThat(isValida, Matchers.is(Boolean.TRUE));
    }

    @Test
    @DisplayName("verifica se tem assinatura")
    void valida_se_tem_assinatura() throws Exception {
	String xml = EnvEventoFactory.build();

	Document documentCriado = utilXml.createDocument(xml.getBytes());

	utilXml.saveXml(documentCriado, PATH_XML_ASSINADO);

	Path path = Paths.get(PATH_XML_ASSINADO);

	byte[] xmlBytes = Files.readAllBytes(path);
	Document document = utilXml.createDocument(xmlBytes);

	Exception exception = Assertions.assertThrows(Exception.class, () -> certificado.isValid(document));

	MatcherAssert.assertThat(exception.getMessage(), Matchers.is("Ocorreu um problema durante a validação assinatura. O documento não está assinado."));
    }

    @Test
    @DisplayName("verifica se assinatura está correta")
    void verifica_se_assinatura_esta_correta() throws Exception {
	String xml = EnvEventoFactory.build();

	Document document = utilXml.createDocument(xml.getBytes());

	String xmlAssinado = certificado.assinarXML(keyRepository.getCertificado(), keyRepository.getPrivateKey(), "ID0123456789012345678901234567890123456789012345678911", document, "evento");

	xmlAssinado = xmlAssinado.replace("justificativa de manifestacao do destinatario", "justificativa de manifestacao do destinatario alteradao");
	Document documentCriado = utilXml.createDocument(xmlAssinado.getBytes());

	utilXml.saveXml(documentCriado, PATH_XML_ASSINADO);

	Path path = Paths.get(PATH_XML_ASSINADO);

	byte[] xmlBytes = Files.readAllBytes(path);
	document = utilXml.createDocument(xmlBytes);

	MatcherAssert.assertThat(certificado.isValid(document), Matchers.is(Boolean.FALSE));
    }
}