package com.manide.xml.evento.retorno;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import com.manide.xml.evento.entrada.TEvento;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TProcEvento", namespace = "http://www.portalfiscal.inf.br/nfe", propOrder = { "evento", "retEvento" })
public class TProcEvento {

    @XmlElement(required = true)
    protected TEvento evento;
    @XmlElement(required = true)
    protected TretEvento retEvento;
    @XmlAttribute(name = "versao", required = true)
    protected String versao;

    public TEvento getEvento() {
	return evento;
    }

    public void setEvento(TEvento value) {
	this.evento = value;
    }

    public TretEvento getRetEvento() {
	return retEvento;
    }

    public void setRetEvento(TretEvento value) {
	this.retEvento = value;
    }

    public String getVersao() {
	return versao;
    }

    public void setVersao(String value) {
	this.versao = value;
    }

}
