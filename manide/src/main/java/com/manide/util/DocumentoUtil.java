package com.manide.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.w3c.dom.Document;

@Component
public class DocumentoUtil {

    @Autowired
    private KeyRepository keyRepository;

    public String assinar(String xml) throws Exception {
	Document document = UtilXml.createDocument(xml.getBytes());

	String xmlAssinado = Certificado.assinarXML(keyRepository.getCertificado(), keyRepository.getPrivateKey(), "ID0123456789012345678901234567890123456789012345678911", document, "evento");

	return xmlAssinado;
    }
}