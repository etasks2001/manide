package com.manide.util;

import java.io.File;
import java.io.FileInputStream;

import org.w3c.dom.Document;

public abstract class DocumentoUtil {

    public static String assinar(String xml) throws Exception {
	Document document = UtilXml.createDocument(xml.getBytes());

	KeyRepository keyRepository = KeyRepository.getInstance(new FileInputStream(new File("C:\\x\\franco\\fdasfdsa.pfx")), "448006".toCharArray());

	String xmlAssinado = Certificado.assinarXML(keyRepository.getCertificate(), keyRepository.getPrivateKey(), "ID0123456789012345678901234567890123456789012345678911", document, "evento");

	Document documentAssinado = UtilXml.createDocument(xmlAssinado.getBytes());
	boolean isAssinaturaValida = ValidarXmlAssinado.isValid(documentAssinado);

	if (!isAssinaturaValida) {
	    throw new Exception("Assinatura inválida evento!");
	}
	return xmlAssinado;
    }
}