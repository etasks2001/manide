package com.manide.xml.download.entrada;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

import com.manide.xml.TAmb;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TDownloadNFe", propOrder = { "tpAmb", "xServ", "cnpj", "chNFe" })
public class TDownloadNFe {

    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected TAmb tpAmb;
    @XmlElement(required = true)
    protected String xServ;
    @XmlElement(name = "CNPJ", required = true)
    protected String cnpj;
    @XmlElement(required = true)
    protected List<String> chNFe = new ArrayList<String>();
    @XmlAttribute(name = "versao", required = true)
    protected TVerDownloadNFe versao;

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

    public List<String> getChNFe() {
	return this.chNFe;
    }

    public TVerDownloadNFe getVersao() {
	return versao;
    }

    public void setVersao(TVerDownloadNFe value) {
	this.versao = value;
    }

}
