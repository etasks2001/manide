package com.manide.xml;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.w3c.dom.Document;

import com.manide.certificado.Certificado;
import com.manide.certificado.KeyRepository;
import com.manide.xml.UtilXml;

@Component
public class EventoManifestacaoDestinatarioFacade {

    @Autowired
    private KeyRepository keyRepository;

    @Autowired
    private UtilXml utilXml;

    @Autowired
    private Certificado certificado;

    public String assinar(String xml) throws Exception {
	Document document = utilXml.createDocument(xml.getBytes());

	String xmlAssinado = certificado.assinarXML(keyRepository.getCertificado(), keyRepository.getPrivateKey(), "ID0123456789012345678901234567890123456789012345678911", document, "evento");

	return xmlAssinado;
    }
}