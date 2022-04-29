package com.manide.xml.xmldsigcore;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

@XmlRegistry
public class ObjectFactory {

    private final static QName _Signature_QNAME = new QName("http://www.w3.org/2000/09/xmldsig#", "Signature");

    public ObjectFactory() {
    }

    public SignatureType createSignatureType() {
	return new SignatureType();
    }

    public X509DataType createX509DataType() {
	return new X509DataType();
    }

    public SignatureValueType createSignatureValueType() {
	return new SignatureValueType();
    }

    public TransformsType createTransformsType() {
	return new TransformsType();
    }

    public SignedInfoType createSignedInfoType() {
	return new SignedInfoType();
    }

    public TransformType createTransformType() {
	return new TransformType();
    }

    public ReferenceType createReferenceType() {
	return new ReferenceType();
    }

    public KeyInfoType createKeyInfoType() {
	return new KeyInfoType();
    }

    public DigestMethod createDigestMethod() {
	return new DigestMethod();
    }

    public CanonicalizationMethod createCanonicalizationMethod() {
	return new CanonicalizationMethod();
    }

    public SignatureMethod createSignatureMethod() {
	return new SignatureMethod();
    }

    @XmlElementDecl(namespace = "http://www.w3.org/2000/09/xmldsig#", name = "Signature")
    public JAXBElement<SignatureType> createSignature(SignatureType value) {
	return new JAXBElement<SignatureType>(_Signature_QNAME, SignatureType.class, null, value);
    }

}
