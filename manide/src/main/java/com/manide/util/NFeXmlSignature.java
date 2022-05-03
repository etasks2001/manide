package com.manide.util;

import static javax.xml.crypto.dsig.CanonicalizationMethod.INCLUSIVE;
import static javax.xml.crypto.dsig.DigestMethod.SHA1;
import static javax.xml.crypto.dsig.SignatureMethod.RSA_SHA1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.InvalidAlgorithmParameterException;
import java.security.Key;
import java.security.KeyStore;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.xml.crypto.dsig.Reference;
import javax.xml.crypto.dsig.SignedInfo;
import javax.xml.crypto.dsig.Transform;
import javax.xml.crypto.dsig.XMLSignature;
import javax.xml.crypto.dsig.XMLSignatureFactory;
import javax.xml.crypto.dsig.dom.DOMSignContext;
import javax.xml.crypto.dsig.keyinfo.KeyInfo;
import javax.xml.crypto.dsig.keyinfo.KeyInfoFactory;
import javax.xml.crypto.dsig.keyinfo.X509Data;
import javax.xml.crypto.dsig.spec.C14NMethodParameterSpec;
import javax.xml.crypto.dsig.spec.TransformParameterSpec;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public final class NFeXmlSignature {

    private String alias = "";

    private static final String C14N_TRANSFORM_METHOD = "http://www.w3.org/TR/2001/REC-xml-c14n-20010315";

    private X509Certificate cert = null;

    private InputStream dado = null;

    private String keyStore = "";

    private char[] keyStorePassword;

    private PrivateKey privateKey = null;

    private KeyStore rep = null;

    private String elementToSign;

    public NFeXmlSignature(String keyStore, char[] keyStorePassword, String elementToSign) throws Exception {
	this.keyStore = keyStore;
	this.keyStorePassword = keyStorePassword;
	this.elementToSign = elementToSign;
	this.config();
    }

    private void config() throws Exception {
	// try {
	File file = new File(keyStore);
	dado = new FileInputStream(file);
	boolean valid = isValid();
	if (!valid) {
	    throw new Exception("URL do certificado n�o encontrado.");
	}
	//
	// } catch (Exception e) {
	// throw new Exception("URL do certificado n�o encontrado.", e);
	// }
    }

    private boolean isValid() throws Exception {
	// try {
	alias = "fs";
	rep = KeyStore.getInstance("JKS");
	rep.load(dado, keyStorePassword);
	cert = (X509Certificate) rep.getCertificate(alias);
	return this.validate(cert);
	// } catch (Exception e) {
	// throw new Exception(e.getMessage(), e);
	// }
    }

    private List<Transform> createTransform(XMLSignatureFactory sig) throws NoSuchAlgorithmException, InvalidAlgorithmParameterException {
	Transform enveloped = sig.newTransform(Transform.ENVELOPED, (TransformParameterSpec) null);
	Transform c14n = sig.newTransform(C14N_TRANSFORM_METHOD, (TransformParameterSpec) null);

	List<Transform> transformList = new ArrayList<Transform>();
	transformList.add(enveloped);
	transformList.add(c14n);

	return transformList;
    }

    private SignedInfo createSignedInfo(XMLSignatureFactory sig, String elementToSign, Document doc) throws NoSuchAlgorithmException, InvalidAlgorithmParameterException {
	NodeList elements = doc.getElementsByTagName(elementToSign);
	Element el = (Element) elements.item(0);
	String id2 = el.getAttribute("Id");
	el.setIdAttribute("Id", true);
	Reference reference = sig.newReference("#".concat(id2), sig.newDigestMethod(SHA1, null), createTransform(sig), null, null);
	// "http://www.w3.org/2001/04/xmldsig-more#rsa-sha256"

	/*
	 * newSignatureMethod ("http://www.w3.org/2001/04/xmldsig-more#rsa-sha256",
	 * (SignatureMethodParameterSpec) null)
	 */
	SignedInfo signedInfo = sig.newSignedInfo(sig.newCanonicalizationMethod(INCLUSIVE, (C14NMethodParameterSpec) null), sig.newSignatureMethod(RSA_SHA1, null),
		Collections.singletonList(reference));

	return signedInfo;
    }

    private List<X509Certificate> getX509Content(X509Certificate cert2) {
	List<X509Certificate> x509Content = new ArrayList<X509Certificate>();
	x509Content.add(cert2);
	return x509Content;
    }

    private KeyInfo getKeyInfo(X509Certificate cert2, XMLSignatureFactory sig) {
	KeyInfoFactory kif = sig.getKeyInfoFactory();
	X509Data xd = kif.newX509Data(getX509Content(cert));
	KeyInfo ki = kif.newKeyInfo(Collections.singletonList(xd));
	return ki;
    }

    private Document getDocument(String fileName) throws FileNotFoundException, SAXException, IOException, ParserConfigurationException {
	DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
	dbf.setNamespaceAware(true);
	Document doc = dbf.newDocumentBuilder().parse(new FileInputStream(fileName));
	return doc;
    }

    private Transformer getTransformer() throws TransformerConfigurationException {
	TransformerFactory tf = TransformerFactory.newInstance();
	Transformer transformer = tf.newTransformer();
	return transformer;
    }

    private XMLSignature getXMLSignature(Document doc, String elementToSign) throws NoSuchAlgorithmException, InvalidAlgorithmParameterException {
	XMLSignatureFactory sig = XMLSignatureFactory.getInstance("DOM");
	SignedInfo signedInfo = createSignedInfo(sig, elementToSign, doc);
	KeyInfo ki = getKeyInfo(cert, sig);
	XMLSignature signature = sig.newXMLSignature(signedInfo, ki);
	return signature;
    }

    private boolean fileSigned(Document doc, String newFileName) throws TransformerException, IOException {
	Transformer transformer = getTransformer();
	OutputStream os = new FileOutputStream(newFileName);
	transformer.transform(new DOMSource(doc), new StreamResult(os));
	os.close();
	return true;
    }

    public boolean signXML(String xmlFile, String xmlFileSigned) throws Exception {
	// try {
	Document doc = getDocument(xmlFile);
	doc.setXmlStandalone(true);
	XMLSignature signature = getXMLSignature(doc, elementToSign);
	DOMSignContext dsc = new DOMSignContext(privateKey, doc.getDocumentElement());
	signature.sign(dsc);
	boolean fileSigned = fileSigned(doc, xmlFileSigned);
	return fileSigned;
	// } catch (SAXException | IOException | ParserConfigurationException |
	// NoSuchAlgorithmException | InvalidAlgorithmParameterException |
	// MarshalException | XMLSignatureException | TransformerException e) {
	// throw new Exception(e.getMessage(), e);
	// }
    }

    private boolean validate(X509Certificate cert) throws Exception {
	// try {
	cert.checkValidity();
	// ---------------------------------------------------------------------------------
	Key chavePrivada = (Key) rep.getKey(alias, keyStorePassword);
	if (chavePrivada instanceof PrivateKey) {
	    privateKey = (PrivateKey) chavePrivada;
	}
	return true;
	// } catch (Exception e) {
	// throw new Exception(e.getMessage(), e);
	// }
    }
}