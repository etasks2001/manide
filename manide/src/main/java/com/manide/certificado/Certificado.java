package com.manide.certificado;

import java.io.StringWriter;
import java.security.InvalidAlgorithmParameterException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.cert.CertificateEncodingException;
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
import javax.xml.crypto.dsig.dom.DOMValidateContext;
import javax.xml.crypto.dsig.keyinfo.KeyInfo;
import javax.xml.crypto.dsig.keyinfo.KeyInfoFactory;
import javax.xml.crypto.dsig.keyinfo.X509Data;
import javax.xml.crypto.dsig.spec.C14NMethodParameterSpec;
import javax.xml.crypto.dsig.spec.TransformParameterSpec;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.bouncycastle.asn1.x500.RDN;
import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.asn1.x500.style.BCStyle;
import org.bouncycastle.asn1.x500.style.IETFUtils;
import org.bouncycastle.cert.jcajce.JcaX509CertificateHolder;
import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.manide.exception.ManideException;

@Component
public class Certificado {

    private static final String RSA_SHA1 = "http://www.w3.org/2000/09/xmldsig#rsa-sha1";

    private static final String XMLDSIG_SHA1 = "http://www.w3.org/2000/09/xmldsig#sha1";

    private static final String C14N_20010315 = "http://www.w3.org/TR/2001/REC-xml-c14n-20010315";

    private static final String ENVELOPED_SIGNATURE = "http://www.w3.org/2000/09/xmldsig#enveloped-signature";

    private static final TransformParameterSpec transformParameterSpec = null;

    private static final C14NMethodParameterSpec c14NMethodParameterSpec = null;

    public final String assinarXML(X509Certificate certificado, PrivateKey privateKey, String referenceURI, Document document, String tagPaiAssinatura)
	    throws NoSuchAlgorithmException, InvalidAlgorithmParameterException, MarshalException, XMLSignatureException, TransformerException {
	this.check();

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
	transformer.setOutputProperty(OutputKeys.DOCTYPE_PUBLIC, "");

	StringWriter stringWriter = new StringWriter();
	StreamResult streamResult = new StreamResult(stringWriter);
	transformer.transform(new DOMSource(document), streamResult);
	String assinado = stringWriter.toString();
	return assinado;
    }

    public boolean cnpjEncontrado(X509Certificate certificate, String cnpj) throws CertificateEncodingException {
	this.check();
	X500Name x500name = new JcaX509CertificateHolder(certificate).getSubject();
	RDN cn = x500name.getRDNs(BCStyle.CN)[0];
	String nome = IETFUtils.valueToString(cn.getFirst().getValue());
	String cnpjCertificado = nome.substring(nome.length() - 14, nome.length());

	if (!cnpj.equals(cnpjCertificado)) {
	    throw new ManideException("CNPJ não encontrado.");
	}
	return true;

    }

    public boolean isValid(Document document) throws Exception {
	this.check();
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

    void check() {
	System.out.println(this.getClass().getName() + ": " + this.hashCode());
    }
}
