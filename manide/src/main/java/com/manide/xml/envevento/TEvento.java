package com.manide.xml.envevento;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import com.manide.xml.xmldsigcore.SignatureType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TEvento", namespace = "http://www.portalfiscal.inf.br/nfe", propOrder = { "infEvento", "signature" })
public class TEvento {

    @XmlElement(required = true)
    protected InfEvento infEvento;
    @XmlElement(name = "Signature", namespace = "http://www.w3.org/2000/09/xmldsig#", required = true)
    protected SignatureType signature;
    @XmlAttribute(name = "versao", required = true)
    protected String versao;

    public InfEvento getInfEvento() {
	return infEvento;
    }

    public void setInfEvento(InfEvento value) {
	this.infEvento = value;
    }

    public SignatureType getSignature() {
	return signature;
    }

    public void setSignature(SignatureType value) {
	this.signature = value;
    }

    public String getVersao() {
	return versao;
    }

    public void setVersao(String value) {
	this.versao = value;
    }

}
