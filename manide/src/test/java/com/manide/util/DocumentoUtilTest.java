package com.manide.util;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import org.junit.jupiter.api.Test;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;

class DocumentoUtilTest {

    @Test
    void test() {
	try {
	    DocumentoUtil util = new DocumentoUtil();
	    String xml = util.xmlAssinado();
	    System.out.println(xml);

	    Transformer transformer = getTransformer();
	    OutputStream os = new FileOutputStream("c:/mde/teste-assinado.xml");
	    DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
	    String constant = "http://www.w3.org/2001/XMLSchema";
	    SchemaFactory xsdFactory = SchemaFactory.newInstance(constant);
	    Schema schema = xsdFactory.newSchema(getClass().getResource("/Evento_ManifestaDest_PL_v1.01/envConfRecebto_v1.00.xsd"));
	    documentBuilderFactory.setSchema(schema);
	    documentBuilderFactory.setNamespaceAware(true);
	    documentBuilderFactory.setValidating(false);

	    Document documentAssinado = documentBuilderFactory.newDocumentBuilder().parse(new InputSource(new InputStreamReader(new ByteArrayInputStream(xml.getBytes()))));

	    transformer.transform(new DOMSource(documentAssinado), new StreamResult(os));
	    os.close();

	} catch (Exception e) {
	    e.printStackTrace();
	}

    }

    @Test
    void test2() {
	try {
	    DocumentoUtil util = new DocumentoUtil();
	    DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

	    DocumentBuilder bd = dbf.newDocumentBuilder();

	    Document document = bd.parse(new File("c:/mde/teste-assinado.xml"));

	    boolean isValid = util.validarAssinaturaXML(document);

	    System.out.println(isValid);
	} catch (Exception e) {
	    e.printStackTrace();
	}

    }

    private Transformer getTransformer() throws TransformerConfigurationException {
	TransformerFactory tf = TransformerFactory.newInstance();
	Transformer transformer = tf.newTransformer();
	return transformer;
    }

}
