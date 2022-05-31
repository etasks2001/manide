package com.manide.util;

import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;

import com.manide.exception.ManideException;

import br.inf.portalfiscal.nfe.EnvEventoDocument;

@Component
public class UtilXml {
    private static final String XML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";

    private static final String SCHEMA_LANGUAGE = "http://www.w3.org/2001/XMLSchema";

    public String getDocumentString(Object document, boolean xmlDeclaration) {
	XmlOptions xmlOptions = new XmlOptions();
	xmlOptions.setUseDefaultNamespace();
	xmlOptions.setSaveAggressiveNamespaces();
	xmlOptions.setDocumentType(EnvEventoDocument.type);
	return xmlDeclaration ? (XML + ((XmlObject) document).xmlText(xmlOptions)) : ((XmlObject) document).xmlText(xmlOptions);
    }

    public Document createDocument(byte[] xml) throws Exception {
	SchemaFactory xsdFactory = SchemaFactory.newInstance(SCHEMA_LANGUAGE);
	Schema schema = xsdFactory.newSchema(UtilXml.class.getResource("/Evento_ManifestaDest_PL_v1.01/envConfRecebto_v1.00.xsd"));
	DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
	documentBuilderFactory.setSchema(schema);
	documentBuilderFactory.setNamespaceAware(true);
	documentBuilderFactory.setValidating(false);

	ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(xml);
	InputStreamReader inputStreamReader = new InputStreamReader(byteArrayInputStream);
	InputSource inputSource = new InputSource(inputStreamReader);
	Document document = documentBuilderFactory.newDocumentBuilder().parse(inputSource);

	return document;
    }

    public void saveXml(Document documentAssinado, String path) {
	try {
	    OutputStream os = new FileOutputStream(path);
	    TransformerFactory transformerFactory = TransformerFactory.newInstance();
	    Transformer transformer = transformerFactory.newTransformer();
	    transformer.transform(new DOMSource(documentAssinado), new StreamResult(os));
	    os.close();
	} catch (TransformerException | IOException e) {
	    throw new ManideException("Problema ao salvar o xml.");
	}
    }
}