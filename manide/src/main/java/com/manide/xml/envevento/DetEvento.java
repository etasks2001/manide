package com.manide.xml.envevento;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "descEvento", "xJust" })
public class DetEvento {

    @XmlElement(namespace = "http://www.portalfiscal.inf.br/nfe", required = true)
    protected String descEvento;
    @XmlElement(namespace = "http://www.portalfiscal.inf.br/nfe")
    protected String xJust;
    @XmlAttribute(name = "versao", required = true)
    protected String versao;

    public String getDescEvento() {
	return descEvento;
    }

    public void setDescEvento(String value) {
	this.descEvento = value;
    }

    public String getXJust() {
	return xJust;
    }

    public void setXJust(String value) {
	this.xJust = value;
    }

    public String getVersao() {
	return versao;
    }

    public void setVersao(String value) {
	this.versao = value;
    }

}
