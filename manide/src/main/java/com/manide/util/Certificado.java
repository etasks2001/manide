package com.manide.util;

import java.io.StringWriter;
import java.security.InvalidAlgorithmParameterException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.xml.crypto.MarshalException;
import javax.xml.crypto.dsig.Reference;
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

public class Certificado {
    public String assinarXML(X509Certificate certificado, PrivateKey privateKey, String referenceURI, Document document, String cnpjBase, String tagPaiAssinatura)
	    throws NoSuchAlgorithmException, InvalidAlgorithmParameterException, MarshalException, XMLSignatureException, TransformerException {
	XMLSignatureFactory signatureFactory = XMLSignatureFactory.getInstance("DOM");
	List<Transform> listTransforms = new ArrayList<>();
	listTransforms.add(signatureFactory.newTransform("http://www.w3.org/2000/09/xmldsig#enveloped-signature", (TransformParameterSpec) null));
	listTransforms.add(signatureFactory.newTransform("http://www.w3.org/TR/2001/REC-xml-c14n-20010315", (TransformParameterSpec) null));
	Reference reference = signatureFactory.newReference("#" + referenceURI, signatureFactory.newDigestMethod("http://www.w3.org/2000/09/xmldsig#sha1", null), listTransforms, null, null);
	SignedInfo signedInfo = signatureFactory.newSignedInfo(signatureFactory.newCanonicalizationMethod("http://www.w3.org/TR/2001/REC-xml-c14n-20010315", (C14NMethodParameterSpec) null),
		signatureFactory.newSignatureMethod("http://www.w3.org/2000/09/xmldsig#rsa-sha1", null), Collections.singletonList(reference));
	KeyInfoFactory keyInfoFactory = signatureFactory.getKeyInfoFactory();
	X509Data data = keyInfoFactory.newX509Data(Collections.singletonList(certificado));
	KeyInfo keyInfo = keyInfoFactory.newKeyInfo(Collections.singletonList(data));
	Node tagPai = document.getDocumentElement();
	if (tagPaiAssinatura != null && !tagPaiAssinatura.isEmpty()) {
	    NodeList nodeList = document.getElementsByTagName(tagPaiAssinatura);
	    tagPai = nodeList.item(0);
	}
	DOMSignContext signContext = new DOMSignContext(privateKey, tagPai);
	XMLSignature signature = signatureFactory.newXMLSignature(signedInfo, keyInfo);
	signature.sign(signContext);
	TransformerFactory transformerFactory = TransformerFactory.newInstance();
	Transformer transformer = transformerFactory.newTransformer();
	StringWriter sw = new StringWriter();
	StreamResult streamResult = new StreamResult(sw);
	transformer.transform(new DOMSource(document), streamResult);
	String retorno = sw.toString();
	return retorno;
    }
}
