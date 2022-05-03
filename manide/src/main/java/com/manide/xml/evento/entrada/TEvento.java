package com.manide.xml.evento.entrada;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TEvento", namespace = "http://www.portalfiscal.inf.br/nfe", propOrder = { "infEvento", "signature" })
public class TEvento {

    @XmlElement(required = true)
    protected InfEvento infEvento;

    @XmlElement(name = "Signature", namespace = "http://www.portalfiscal.inf.br/nfe", required = true)
    protected SignatureType signature;

    @XmlAttribute(name = "versao", required = true)
    protected String versao;

    public InfEvento getInfEvento() {
	return infEvento;
    }

    public void setInfEvento(InfEvento value) {
	this.infEvento = value;
    }

    public String getVersao() {
	return versao;
    }

    public void setVersao(String value) {
	this.versao = value;
    }

    public void setSignature(SignatureType value) {
	this.signature = value;
    }

    public SignatureType getSignature() {
	return signature;
    }

}
