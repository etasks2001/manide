package com.manide.util;

import javax.xml.crypto.dsig.XMLSignature;
import javax.xml.crypto.dsig.XMLSignatureFactory;
import javax.xml.crypto.dsig.dom.DOMValidateContext;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

public class ValidarXmlAssinado {
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