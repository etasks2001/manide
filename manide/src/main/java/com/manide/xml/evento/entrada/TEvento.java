package com.manide.xml.evento.entrada;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TEvento", propOrder = { "infEvento" })
public class TEvento {

    @XmlElement(required = true)
    protected InfEvento infEvento;
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

}
