package com.manide.util;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

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

    @Test
    @DisplayName("gera xml, assina, verifica assinatura digital e grava arquivo")
    @Order(1)
    void test() throws Exception {
	String xml = CriarEventoManifestacaoDestinatario.criarXMLEnvioEventoManifestacao();
	String xmlAssinado = DocumentoUtil.assinarXml(xml);

	Document documentAssinado = UtilXml.createDocument(xmlAssinado.getBytes());

	OutputStream os = new FileOutputStream(PATH_XML_ASSINADO);
	Transformer transformer = getTransformer();
	transformer.transform(new DOMSource(documentAssinado), new StreamResult(os));
	os.close();

	documentAssinado = UtilXml.createDocument(xmlAssinado.getBytes());
	boolean isAssinaturaValida = ValidarXmlAssinado.isValid(documentAssinado);
	isAssinaturaValida = ValidarXmlAssinado.isValid2(documentAssinado);

	MatcherAssert.assertThat(isAssinaturaValida, Matchers.is(Boolean.TRUE));

    }

    @Test
    @DisplayName("verifica assinatura digital do xml gravado")
    @Order(2)
    void test2() throws Exception {

	Path path = Paths.get(PATH_XML_ASSINADO);

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

    private Transformer getTransformer() throws TransformerConfigurationException {
	TransformerFactory tf = TransformerFactory.newInstance();
	Transformer transformer = tf.newTransformer();
	return transformer;
    }

}
