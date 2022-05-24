package com.manide.util;

import java.security.PublicKey;
import java.security.cert.X509Certificate;
import java.util.List;

import javax.xml.crypto.AlgorithmMethod;
import javax.xml.crypto.KeySelector;
import javax.xml.crypto.KeySelectorException;
import javax.xml.crypto.KeySelectorResult;
import javax.xml.crypto.XMLCryptoContext;
import javax.xml.crypto.XMLStructure;
import javax.xml.crypto.dsig.SignatureMethod;
import javax.xml.crypto.dsig.keyinfo.KeyInfo;
import javax.xml.crypto.dsig.keyinfo.X509Data;

public class KeyValueKeySelector extends KeySelector {
    public KeySelectorResult select(KeyInfo keyInfo, KeySelector.Purpose purpose, AlgorithmMethod method, XMLCryptoContext context) throws KeySelectorException {
	if (keyInfo == null)
	    throw new KeySelectorException("Null KeyInfo object!");
	SignatureMethod sm = (SignatureMethod) method;
	List<XMLStructure> list = keyInfo.getContent();
	for (int i = 0; i < list.size(); i++) {
	    XMLStructure xmlStructure = list.get(i);
	    if (xmlStructure instanceof X509Data) {
		X509Certificate cert = null;
		PublicKey pk = null;
		try {
		    X509Data g = (X509Data) xmlStructure;
		    cert = (X509Certificate) g.getContent().get(0);
		    pk = cert.getPublicKey();
		} catch (Exception e) {
		    throw new KeySelectorException(e);
		}
		if (algEquals(sm.getAlgorithm(), pk.getAlgorithm()))
		    return new SimpleKeySelectorResult(pk);
	    }
	}
	throw new KeySelectorException("No KeyValue element found!");
    }

    boolean algEquals(String algURI, String algName) {
	if (algName.equalsIgnoreCase("DSA") && algURI.equalsIgnoreCase("http://www.w3.org/2000/09/xmldsig#dsa-sha1"))
	    return true;
	if (algName.equalsIgnoreCase("RSA") && algURI.equalsIgnoreCase("http://www.w3.org/2000/09/xmldsig#rsa-sha1"))
	    return true;
	return false;
    }
}