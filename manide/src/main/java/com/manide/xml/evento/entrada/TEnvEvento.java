package com.manide.xml.evento.entrada;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TEnvEvento", namespace = "http://www.portalfiscal.inf.br/nfe", propOrder = { "idLote", "evento" })
public class TEnvEvento {

    @XmlElement(required = true)
    protected String idLote;
    @XmlElement(required = true)
    protected List<TEvento> evento = new ArrayList<TEvento>();
    @XmlAttribute(name = "versao", required = true)
    protected String versao;

    public String getIdLote() {
	return idLote;
    }

    public void setIdLote(String value) {
	this.idLote = value;
    }

    public List<TEvento> getEvento() {
	return this.evento;
    }

    public String getVersao() {
	return versao;
    }

    public void setVersao(String value) {
	this.versao = value;
    }

}
