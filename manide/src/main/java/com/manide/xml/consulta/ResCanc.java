package com.manide.xml.consulta;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "chNFe", "cnpj", "cpf", "xNome", "ie", "dEmi", "tpNF", "vnf", "digVal", "dhRecbto", "cSitNFe", "cSitConf" })
public class ResCanc {

    @XmlElement(required = true)
    protected String chNFe;
    @XmlElement(name = "CNPJ")
    protected String cnpj;
    @XmlElement(name = "CPF")
    protected String cpf;
    @XmlElement(required = true)
    protected String xNome;
    @XmlElement(name = "IE", required = true)
    protected String ie;
    @XmlElement(required = true)
    protected String dEmi;
    @XmlElement(required = true)
    protected String tpNF;
    @XmlElement(name = "vNF", required = true)
    protected String vnf;
    @XmlElement(required = true)
    protected String digVal;
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dhRecbto;
    @XmlElement(required = true)
    protected String cSitNFe;
    @XmlElement(required = true)
    protected String cSitConf;
    @XmlAttribute(name = "NSU", required = true)
    protected String nsu;

    public String getChNFe() {
	return chNFe;
    }

    public void setChNFe(String value) {
	this.chNFe = value;
    }

    public String getCNPJ() {
	return cnpj;
    }

    public void setCNPJ(String value) {
	this.cnpj = value;
    }

    public String getCPF() {
	return cpf;
    }

    public void setCPF(String value) {
	this.cpf = value;
    }

    public String getXNome() {
	return xNome;
    }

    public void setXNome(String value) {
	this.xNome = value;
    }

    public String getIE() {
	return ie;
    }

    public void setIE(String value) {
	this.ie = value;
    }

    public String getDEmi() {
	return dEmi;
    }

    public void setDEmi(String value) {
	this.dEmi = value;
    }

    public String getTpNF() {
	return tpNF;
    }

    public void setTpNF(String value) {
	this.tpNF = value;
    }

    public String getVNF() {
	return vnf;
    }

    public void setVNF(String value) {
	this.vnf = value;
    }

    public String getDigVal() {
	return digVal;
    }

    public void setDigVal(String value) {
	this.digVal = value;
    }

    public XMLGregorianCalendar getDhRecbto() {
	return dhRecbto;
    }

    public void setDhRecbto(XMLGregorianCalendar value) {
	this.dhRecbto = value;
    }

    public String getCSitNFe() {
	return cSitNFe;
    }

    public void setCSitNFe(String value) {
	this.cSitNFe = value;
    }

    public String getCSitConf() {
	return cSitConf;
    }

    public void setCSitConf(String value) {
	this.cSitConf = value;
    }

    public String getNSU() {
	return nsu;
    }

    public void setNSU(String value) {
	this.nsu = value;
    }

}
