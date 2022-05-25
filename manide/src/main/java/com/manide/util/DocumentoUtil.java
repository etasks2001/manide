package com.manide.util;

import java.io.File;
import java.io.FileInputStream;
import java.security.Key;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.cert.X509Certificate;
import java.util.Enumeration;

import org.w3c.dom.Document;

public abstract class DocumentoUtil {

    public static String assinarXml(String xml) throws Exception {

	Document document = UtilXml.createDocument(xml.getBytes());

	KeyStore rep = KeyStore.getInstance("PKCS12");
	rep.load(new FileInputStream(new File("C:\\x\\franco\\fdasfdsa.pfx")), "448006".toCharArray());

	String alias = null;
	Enumeration<String> aliases = rep.aliases();

	while (aliases.hasMoreElements()) {
	    alias = aliases.nextElement();
	}
	X509Certificate certificate = (X509Certificate) rep.getCertificate(alias);

	PrivateKey privateKey = null;
	Key chavePrivada = (Key) rep.getKey(alias, "448006".toCharArray());
	if (chavePrivada instanceof PrivateKey) {
	    privateKey = (PrivateKey) chavePrivada;
	}

	String xmlAssinado = Certificado.assinarXML(certificate, privateKey, "ID0123456789012345678901234567890123456789012345678911", document, "evento");

	Document documentAssinado = UtilXml.createDocument(xmlAssinado.getBytes());
	boolean isAssinaturaValida = ValidarXmlAssinado.isValid(documentAssinado);

	if (!isAssinaturaValida)
	    throw new Exception("Assinatura inválida evento!");
	return xmlAssinado;
    }

}
