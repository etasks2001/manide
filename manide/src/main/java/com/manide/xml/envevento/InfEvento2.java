package com.manide.xml.envevento;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.manide.xml.TAmb;
import com.manide.xml.TCOrgaoIBGE;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "tpAmb", "verAplic", "cOrgao", "cStat", "xMotivo", "chNFe", "tpEvento", "xEvento", "nSeqEvento", "cnpjDest", "cpfDest", "emailDest", "dhRegEvento", "nProt" })
public class InfEvento2 {

    @XmlElement(namespace = "http://www.portalfiscal.inf.br/nfe", required = true)
    @XmlSchemaType(name = "string")
    protected TAmb tpAmb;
    @XmlElement(namespace = "http://www.portalfiscal.inf.br/nfe", required = true)
    protected String verAplic;
    @XmlElement(namespace = "http://www.portalfiscal.inf.br/nfe", required = true)
    @XmlSchemaType(name = "string")
    protected TCOrgaoIBGE cOrgao;
    @XmlElement(namespace = "http://www.portalfiscal.inf.br/nfe", required = true)
    protected String cStat;
    @XmlElement(namespace = "http://www.portalfiscal.inf.br/nfe", required = true)
    protected String xMotivo;
    @XmlElement(namespace = "http://www.portalfiscal.inf.br/nfe")
    protected String chNFe;
    @XmlElement(namespace = "http://www.portalfiscal.inf.br/nfe")
    protected String tpEvento;
    @XmlElement(namespace = "http://www.portalfiscal.inf.br/nfe")
    protected String xEvento;
    @XmlElement(namespace = "http://www.portalfiscal.inf.br/nfe")
    protected String nSeqEvento;
    @XmlElement(name = "CNPJDest", namespace = "http://www.portalfiscal.inf.br/nfe")
    protected String cnpjDest;
    @XmlElement(name = "CPFDest", namespace = "http://www.portalfiscal.inf.br/nfe")
    protected String cpfDest;
    @XmlElement(namespace = "http://www.portalfiscal.inf.br/nfe")
    protected String emailDest;
    @XmlElement(namespace = "http://www.portalfiscal.inf.br/nfe", required = true)
    protected String dhRegEvento;
    @XmlElement(namespace = "http://www.portalfiscal.inf.br/nfe")
    protected String nProt;
    @XmlAttribute(name = "Id")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    protected String id;

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

    public String getChNFe() {
	return chNFe;
    }

    public void setChNFe(String value) {
	this.chNFe = value;
    }

    public String getTpEvento() {
	return tpEvento;
    }

    public void setTpEvento(String value) {
	this.tpEvento = value;
    }

    public String getXEvento() {
	return xEvento;
    }

    public void setXEvento(String value) {
	this.xEvento = value;
    }

    public String getNSeqEvento() {
	return nSeqEvento;
    }

    public void setNSeqEvento(String value) {
	this.nSeqEvento = value;
    }

    public String getCNPJDest() {
	return cnpjDest;
    }

    public void setCNPJDest(String value) {
	this.cnpjDest = value;
    }

    public String getCPFDest() {
	return cpfDest;
    }

    public void setCPFDest(String value) {
	this.cpfDest = value;
    }

    public String getEmailDest() {
	return emailDest;
    }

    public void setEmailDest(String value) {
	this.emailDest = value;
    }

    public String getDhRegEvento() {
	return dhRegEvento;
    }

    public void setDhRegEvento(String value) {
	this.dhRegEvento = value;
    }

    public String getNProt() {
	return nProt;
    }

    public void setNProt(String value) {
	this.nProt = value;
    }

    public String getId() {
	return id;
    }

    public void setId(String value) {
	this.id = value;
    }

}
