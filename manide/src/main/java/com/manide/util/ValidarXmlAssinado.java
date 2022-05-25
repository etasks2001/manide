package com.manide.util;

import java.util.Iterator;

import javax.xml.crypto.dsig.Reference;
import javax.xml.crypto.dsig.XMLSignature;
import javax.xml.crypto.dsig.XMLSignatureFactory;
import javax.xml.crypto.dsig.dom.DOMValidateContext;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

public abstract class ValidarXmlAssinado {
    public static boolean isValid(Document document) throws Exception {
	int indexSignature = 0;
	boolean coreValidity = false;
	try {
	    NodeList nl = document.getElementsByTagNameNS(XMLSignature.XMLNS, "Signature");
	    if (nl.getLength() == 0)
		throw new Exception("O documento não está assinado.");
	    XMLSignatureFactory fac = XMLSignatureFactory.getInstance("DOM");
	    DOMValidateContext valContext = null;
	    XMLSignature signature = null;
	    do {
		valContext = new DOMValidateContext(new KeyValueKeySelector(), nl.item(indexSignature++));
		signature = fac.unmarshalXMLSignature(valContext);
		coreValidity = signature.validate(valContext);
	    } while (coreValidity && indexSignature < nl.getLength());
	} catch (Exception e) {

	    throw new Exception("Ocorreu um problema durante a validação assinatura");
	}

	return coreValidity;
    }

    public static boolean isValid2(Document document) throws Exception {
	NodeList nl = document.getElementsByTagNameNS(XMLSignature.XMLNS, "Signature");
	if (nl.getLength() == 0)
	    throw new Exception("O documento não está assinado.");
	XMLSignatureFactory fac = XMLSignatureFactory.getInstance("DOM");
	DOMValidateContext valContext = null;
	XMLSignature signature = null;
	boolean coreValidity = false;
	valContext = new DOMValidateContext(new X509KeySelector(), nl.item(0));
	signature = fac.unmarshalXMLSignature(valContext);
	coreValidity = signature.validate(valContext);
	if (coreValidity == false) {
	    System.err.println("Signature failed core validation");
	    boolean sv = signature.getSignatureValue().validate(valContext);
	    System.out.println("signature validation status: " + sv);
	    if (sv == false) {
		// Check the validation status of each Reference.
		Iterator<?> i = signature.getSignedInfo().getReferences().iterator();
		for (int j = 0; i.hasNext();) {
		    boolean refValid = ((Reference) i.next()).validate(valContext);
		    System.out.println("ref[" + j + "] validity status: " + refValid);
		    return refValid;
		}
	    }
	} else {
	    return true;
	}
	return false;

    }

}
