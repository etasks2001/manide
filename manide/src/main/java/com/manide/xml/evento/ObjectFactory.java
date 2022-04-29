package com.manide.xml.evento;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

import org.springframework.stereotype.Component;

import com.manide.xml.evento.entrada.DetEvento;
import com.manide.xml.evento.entrada.InfEvento;
import com.manide.xml.evento.entrada.TEnvEvento;
import com.manide.xml.evento.entrada.TEvento;
import com.manide.xml.evento.retorno.InfEvento2;
import com.manide.xml.evento.retorno.TProcEvento;
import com.manide.xml.evento.retorno.TRetEnvEvento;
import com.manide.xml.evento.retorno.TretEvento;
import com.manide.xml.xmldsigcore.CanonicalizationMethod;
import com.manide.xml.xmldsigcore.DigestMethod;
import com.manide.xml.xmldsigcore.KeyInfoType;
import com.manide.xml.xmldsigcore.ReferenceType;
import com.manide.xml.xmldsigcore.SignatureMethod;
import com.manide.xml.xmldsigcore.SignatureType;
import com.manide.xml.xmldsigcore.SignatureValueType;
import com.manide.xml.xmldsigcore.SignedInfoType;
import com.manide.xml.xmldsigcore.TransformType;
import com.manide.xml.xmldsigcore.TransformsType;
import com.manide.xml.xmldsigcore.X509DataType;

@Component
@XmlRegistry
public class ObjectFactory {

    private final static QName _Signature_QNAME = new QName("http://www.w3.org/2000/09/xmldsig#", "Signature");
    private final static QName _EnvEvento_QNAME = new QName("http://www.portalfiscal.inf.br/nf", "envEvento");

    public ObjectFactory() {
    }

    public TEnvEvento createTEnvEvento() {
	return new TEnvEvento();
    }

    public TRetEnvEvento createTRetEnvEvento() {
	return new TRetEnvEvento();
    }

    public TretEvento createTretEvento() {
	return new TretEvento();
    }

    public TProcEvento createTProcEvento() {
	return new TProcEvento();
    }

    public TEvento createTEvento() {
	return new TEvento();
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

    public InfEvento createInfEvento() {
	return new InfEvento();
    }

    public DetEvento createDetEvento() {
	return new DetEvento();
    }

    public InfEvento2 createInfEvento2() {
	return new InfEvento2();
    }

    @XmlElementDecl(namespace = "http://www.w3.org/2000/09/xmldsig#", name = "Signature")
    public JAXBElement<SignatureType> createSignature(SignatureType value) {
	return new JAXBElement<SignatureType>(_Signature_QNAME, SignatureType.class, null, value);
    }

    @XmlElementDecl(namespace = "http://www.portalfiscal.inf.br/nf", name = "envEvento")
    public JAXBElement<TEnvEvento> createEnvEvento(TEnvEvento value) {
	return new JAXBElement<TEnvEvento>(_EnvEvento_QNAME, TEnvEvento.class, null, value);
    }

}