package com.manide.util;

import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

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
import org.xml.sax.InputSource;

@SpringBootTest
@TestInstance(Lifecycle.PER_CLASS)
@TestMethodOrder(OrderAnnotation.class)
@DisplayName("XML - Manifestação do Destinatário")
class DocumentoUtilTest {

    @Test
    @DisplayName("gera xml, assina, verifica assinatura digital e grava arquivo")
    @Order(1)
    void test() throws Exception {
	DocumentoUtil util = new DocumentoUtil();
	String xml = util.xmlAssinado();

	Transformer transformer = getTransformer();
	DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
	String constant = "http://www.w3.org/2001/XMLSchema";
	SchemaFactory xsdFactory = SchemaFactory.newInstance(constant);
	Schema schema = xsdFactory.newSchema(getClass().getResource("/Evento_ManifestaDest_PL_v1.01/envConfRecebto_v1.00.xsd"));
	documentBuilderFactory.setSchema(schema);
	documentBuilderFactory.setNamespaceAware(true);
	documentBuilderFactory.setValidating(false);

	Document documentAssinado = documentBuilderFactory.newDocumentBuilder().parse(new InputSource(new InputStreamReader(new ByteArrayInputStream(xml.getBytes()))));

	OutputStream os = new FileOutputStream("c:/mde/teste-assinado.xml");
	transformer.transform(new DOMSource(documentAssinado), new StreamResult(os));
	os.close();

	documentAssinado = documentBuilderFactory.newDocumentBuilder().parse(new InputSource(new InputStreamReader(new ByteArrayInputStream(xml.getBytes()))));
	boolean isAssinaturaValida = util.validarAssinaturaXML(documentAssinado);
	isAssinaturaValida = util.validarAssinaturaXML2(documentAssinado);

	MatcherAssert.assertThat(isAssinaturaValida, Matchers.is(Boolean.TRUE));

    }

    @Test
    @DisplayName("verifica assinatura digital do xml gravado")
    @Order(2)
    void test2() throws Exception {
	DocumentoUtil util = new DocumentoUtil();
	DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
	String constant = "http://www.w3.org/2001/XMLSchema";
	SchemaFactory xsdFactory = SchemaFactory.newInstance(constant);
	Schema schema = xsdFactory.newSchema(getClass().getResource("/Evento_ManifestaDest_PL_v1.01/envConfRecebto_v1.00.xsd"));
	documentBuilderFactory.setSchema(schema);
	documentBuilderFactory.setNamespaceAware(true);
	documentBuilderFactory.setValidating(false);

	Path path = FileSystems.getDefault().getPath("c:/mde", "teste-assinado3.xml");
	byte[] xml = Files.readAllBytes(path);

	Document document = documentBuilderFactory.newDocumentBuilder().parse(new InputSource(new InputStreamReader(new ByteArrayInputStream(xml))));

	boolean isValid2 = util.validarAssinaturaXML2(document);
	boolean isValid = util.validarAssinaturaXML(document);

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
