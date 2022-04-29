package com.manide.xml.envevento;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TretEvento", namespace = "http://www.portalfiscal.inf.br/nfe", propOrder = { "infEvento", "signature" })
public class TretEvento {

    @XmlElement(required = true)
    protected InfEvento2 infEvento;
    @XmlElement(name = "Signature", namespace = "http://www.w3.org/2000/09/xmldsig#")
    protected SignatureType signature;
    @XmlAttribute(name = "versao", required = true)
    protected String versao;

    public InfEvento2 getInfEvento() {
	return infEvento;
    }

    public void setInfEvento(InfEvento2 value) {
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
