package com.manide.xml.consulta.entrada;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

import com.manide.xml.TAmb;
import com.manide.xml.consulta.retorno.TVeConsNFeDest;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TConsNFeDest", propOrder = { "tpAmb", "xServ", "cnpj", "indNFe", "indEmi", "ultNSU" })
public class TConsNFeDest {

    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected TAmb tpAmb;
    @XmlElement(required = true)
    protected String xServ;
    @XmlElement(name = "CNPJ", required = true)
    protected String cnpj;
    @XmlElement(required = true)
    protected String indNFe;
    @XmlElement(required = true)
    protected String indEmi;
    @XmlElement(required = true)
    protected String ultNSU;
    @XmlAttribute(name = "versao", required = true)
    protected TVeConsNFeDest versao;

    public TAmb getTpAmb() {
	return tpAmb;
    }

    public void setTpAmb(TAmb value) {
	this.tpAmb = value;
    }

    public String getXServ() {
	return xServ;
    }

    public void setXServ(String value) {
	this.xServ = value;
    }

    public String getCNPJ() {
	return cnpj;
    }

    public void setCNPJ(String value) {
	this.cnpj = value;
    }

    public String getIndNFe() {
	return indNFe;
    }

    public void setIndNFe(String value) {
	this.indNFe = value;
    }

    public String getIndEmi() {
	return indEmi;
    }

    public void setIndEmi(String value) {
	this.indEmi = value;
    }

    public String getUltNSU() {
	return ultNSU;
    }

    public void setUltNSU(String value) {
	this.ultNSU = value;
    }

    public TVeConsNFeDest getVersao() {
	return versao;
    }

    public void setVersao(TVeConsNFeDest value) {
	this.versao = value;
    }

}
