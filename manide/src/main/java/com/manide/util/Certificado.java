package com.manide.util;

import java.io.StringWriter;
import java.security.InvalidAlgorithmParameterException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.Collections;

import javax.xml.crypto.MarshalException;
import javax.xml.crypto.dsig.CanonicalizationMethod;
import javax.xml.crypto.dsig.DigestMethod;
import javax.xml.crypto.dsig.Reference;
import javax.xml.crypto.dsig.SignatureMethod;
import javax.xml.crypto.dsig.SignedInfo;
import javax.xml.crypto.dsig.Transform;
import javax.xml.crypto.dsig.XMLSignature;
import javax.xml.crypto.dsig.XMLSignatureException;
import javax.xml.crypto.dsig.XMLSignatureFactory;
import javax.xml.crypto.dsig.dom.DOMSignContext;
import javax.xml.crypto.dsig.keyinfo.KeyInfo;
import javax.xml.crypto.dsig.keyinfo.KeyInfoFactory;
import javax.xml.crypto.dsig.keyinfo.X509Data;
import javax.xml.crypto.dsig.spec.C14NMethodParameterSpec;
import javax.xml.crypto.dsig.spec.TransformParameterSpec;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public abstract class Certificado {
    private static final String RSA_SHA1 = "http://www.w3.org/2000/09/xmldsig#rsa-sha1";
    private static final String XMLDSIG_SHA1 = "http://www.w3.org/2000/09/xmldsig#sha1";
    private static final String C14N_20010315 = "http://www.w3.org/TR/2001/REC-xml-c14n-20010315";
    private static final String ENVELOPED_SIGNATURE = "http://www.w3.org/2000/09/xmldsig#enveloped-signature";

    public static final String assinarXML(X509Certificate certificado, PrivateKey privateKey, String referenceURI, Document document, String tagPaiAssinatura)
	    throws NoSuchAlgorithmException, InvalidAlgorithmParameterException, MarshalException, XMLSignatureException, TransformerException {

	TransformParameterSpec transformParameterSpec = null;
	C14NMethodParameterSpec c14NMethodParameterSpec = null;

	XMLSignatureFactory signatureFactory = XMLSignatureFactory.getInstance("DOM");

	Transform transform1 = signatureFactory.newTransform(ENVELOPED_SIGNATURE, transformParameterSpec);
	Transform transform2 = signatureFactory.newTransform(C14N_20010315, transformParameterSpec);

	DigestMethod digestMethod = signatureFactory.newDigestMethod(XMLDSIG_SHA1, null);

	Reference reference = signatureFactory.newReference('#' + referenceURI, digestMethod, Arrays.asList(transform1, transform2), null, null);

	SignatureMethod signatureMethod = signatureFactory.newSignatureMethod(RSA_SHA1, null);

	CanonicalizationMethod canonicalizationMethod = signatureFactory.newCanonicalizationMethod(C14N_20010315, c14NMethodParameterSpec);

	SignedInfo signedInfo = signatureFactory.newSignedInfo(canonicalizationMethod, signatureMethod, Collections.singletonList(reference));

	KeyInfoFactory keyInfoFactory = signatureFactory.getKeyInfoFactory();
	X509Data x509Data = keyInfoFactory.newX509Data(Collections.singletonList(certificado));
	KeyInfo keyInfo = keyInfoFactory.newKeyInfo(Collections.singletonList(x509Data));

	Node tagPai = document.getDocumentElement();

	if (tagPaiAssinatura != null && !tagPaiAssinatura.isEmpty()) {
	    NodeList nodeList = document.getElementsByTagName(tagPaiAssinatura);
	    tagPai = nodeList.item(0);
	}

	DOMSignContext dOMSignContext = new DOMSignContext(privateKey, tagPai);
	XMLSignature xmlSignature = signatureFactory.newXMLSignature(signedInfo, keyInfo);
	xmlSignature.sign(dOMSignContext);

	TransformerFactory transformerFactory = TransformerFactory.newInstance();
	Transformer transformer = transformerFactory.newTransformer();

	StringWriter stringWriter = new StringWriter();
	StreamResult streamResult = new StreamResult(stringWriter);
	transformer.transform(new DOMSource(document), streamResult);
	String retorno = stringWriter.toString();
	return retorno;
    }
}
