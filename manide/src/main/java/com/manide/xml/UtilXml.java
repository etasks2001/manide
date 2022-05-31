package com.manide.xml;

import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;

import javax.xml.crypto.dsig.XMLSignature;
import javax.xml.crypto.dsig.XMLSignatureFactory;
import javax.xml.crypto.dsig.dom.DOMValidateContext;
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
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import com.manide.certificado.KeyValueKeySelector;

import br.inf.portalfiscal.nfe.EnvEventoDocument;

@Component
public class UtilXml {
    private static final String XML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";

    private static final String SCHEMA_LANGUAGE = "http://www.w3.org/2001/XMLSchema";

    public String getDocumentString(XmlObject document, boolean xmlDeclaration) {
	XmlOptions xmlOptions = new XmlOptions();
	xmlOptions.setUseDefaultNamespace();
	xmlOptions.setSaveAggressiveNamespaces();
	xmlOptions.setDocumentType(EnvEventoDocument.type);
	return (xmlDeclaration ? (XML) : "") + document.xmlText(xmlOptions);
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
	return documentBuilderFactory.newDocumentBuilder().parse(inputSource);
    }

    public void saveXml(Document documentAssinado, String path) throws TransformerException, IOException {
	OutputStream os = new FileOutputStream(path);
	TransformerFactory transformerFactory = TransformerFactory.newInstance();
	Transformer transformer = transformerFactory.newTransformer();
	transformer.transform(new DOMSource(documentAssinado), new StreamResult(os));
	os.close();
    }

    public boolean isValid(Document document) throws Exception {
	int indexSignature = 0;
	boolean coreValidity = false;
	try {
	    NodeList nl = document.getElementsByTagNameNS(XMLSignature.XMLNS, "Signature");

	    if (nl.getLength() == 0) {
		throw new Exception("O documento não está assinado.");
	    }

	    XMLSignatureFactory fac = XMLSignatureFactory.getInstance("DOM");
	    DOMValidateContext valContext = null;
	    XMLSignature signature = null;

	    do {
		valContext = new DOMValidateContext(new KeyValueKeySelector(), nl.item(indexSignature++));
		signature = fac.unmarshalXMLSignature(valContext);
		coreValidity = signature.validate(valContext);
	    } while (coreValidity && indexSignature < nl.getLength());
	} catch (Exception e) {
	    throw new Exception("Ocorreu um problema durante a validação assinatura. " + e.getMessage());
	}

	return coreValidity;
    }

}