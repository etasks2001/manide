package com.manide.xml.evento.retorno;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TretEvento", namespace = "http://www.portalfiscal.inf.br/nfe", propOrder = { "infEvento" })
public class TretEvento {

    @XmlElement(required = true)
    protected InfEvento2 infEvento;
    @XmlAttribute(name = "versao", required = true)
    protected String versao;

    public InfEvento2 getInfEvento() {
	return infEvento;
    }

    public void setInfEvento(InfEvento2 value) {
	this.infEvento = value;
    }

    public String getVersao() {
	return versao;
    }

    public void setVersao(String value) {
	this.versao = value;
    }

}
