package com.manide.xml.envevento;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

import com.manide.xml.TAmb;
import com.manide.xml.TCOrgaoIBGE;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TRetEnvEvento", namespace = "http://www.portalfiscal.inf.br/nfe", propOrder = { "idLote", "tpAmb", "verAplic", "cOrgao", "cStat", "xMotivo", "retEvento" })
public class TRetEnvEvento {

    @XmlElement(required = true)
    protected String idLote;
    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected TAmb tpAmb;
    @XmlElement(required = true)
    protected String verAplic;
    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected TCOrgaoIBGE cOrgao;
    @XmlElement(required = true)
    protected String cStat;
    @XmlElement(required = true)
    protected String xMotivo;
    protected List<TretEvento> retEvento;
    @XmlAttribute(name = "versao", required = true)
    protected String versao;

    public String getIdLote() {
	return idLote;
    }

    public void setIdLote(String value) {
	this.idLote = value;
    }

    public TAmb getTpAmb() {
	return tpAmb;
    }

    public void setTpAmb(TAmb value) {
	this.tpAmb = value;
    }

    public String getVerAplic() {
	return verAplic;
    }

    public void setVerAplic(String value) {
	this.verAplic = value;
    }

    public TCOrgaoIBGE getCOrgao() {
	return cOrgao;
    }

    public void setCOrgao(TCOrgaoIBGE value) {
	this.cOrgao = value;
    }

    public String getCStat() {
	return cStat;
    }

    public void setCStat(String value) {
	this.cStat = value;
    }

    public String getXMotivo() {
	return xMotivo;
    }

    public void setXMotivo(String value) {
	this.xMotivo = value;
    }

    public List<TretEvento> getRetEvento() {
	if (retEvento == null) {
	    retEvento = new ArrayList<TretEvento>();
	}
	return this.retEvento;
    }

    public String getVersao() {
	return versao;
    }

    public void setVersao(String value) {
	this.versao = value;
    }

}
