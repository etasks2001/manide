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
@XmlType(name = "", propOrder = { "cOrgao", "tpAmb", "cnpj", "cpf", "chNFe", "dhEvento", "tpEvento", "nSeqEvento", "verEvento", "detEvento" })
public class InfEvento {

    @XmlElement(namespace = "http://www.portalfiscal.inf.br/nfe", required = true)
    @XmlSchemaType(name = "string")
    protected TCOrgaoIBGE cOrgao;
    @XmlElement(namespace = "http://www.portalfiscal.inf.br/nfe", required = true)
    @XmlSchemaType(name = "string")
    protected TAmb tpAmb;
    @XmlElement(name = "CNPJ", namespace = "http://www.portalfiscal.inf.br/nfe")
    protected String cnpj;
    @XmlElement(name = "CPF", namespace = "http://www.portalfiscal.inf.br/nfe")
    protected String cpf;
    @XmlElement(namespace = "http://www.portalfiscal.inf.br/nfe", required = true)
    protected String chNFe;
    @XmlElement(namespace = "http://www.portalfiscal.inf.br/nfe", required = true)
    protected String dhEvento;
    @XmlElement(namespace = "http://www.portalfiscal.inf.br/nfe", required = true)
    protected String tpEvento;
    @XmlElement(namespace = "http://www.portalfiscal.inf.br/nfe", required = true)
    protected String nSeqEvento;
    @XmlElement(namespace = "http://www.portalfiscal.inf.br/nfe", required = true)
    protected String verEvento;
    @XmlElement(namespace = "http://www.portalfiscal.inf.br/nfe", required = true)
    protected DetEvento detEvento;
    @XmlAttribute(name = "Id", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    protected String id;

    public TCOrgaoIBGE getCOrgao() {
	return cOrgao;
    }

    public void setCOrgao(TCOrgaoIBGE value) {
	this.cOrgao = value;
    }

    public TAmb getTpAmb() {
	return tpAmb;
    }

    public void setTpAmb(TAmb value) {
	this.tpAmb = value;
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

    public String getChNFe() {
	return chNFe;
    }

    public void setChNFe(String value) {
	this.chNFe = value;
    }

    public String getDhEvento() {
	return dhEvento;
    }

    public void setDhEvento(String value) {
	this.dhEvento = value;
    }

    public String getTpEvento() {
	return tpEvento;
    }

    public void setTpEvento(String value) {
	this.tpEvento = value;
    }

    public String getNSeqEvento() {
	return nSeqEvento;
    }

    public void setNSeqEvento(String value) {
	this.nSeqEvento = value;
    }

    public String getVerEvento() {
	return verEvento;
    }

    public void setVerEvento(String value) {
	this.verEvento = value;
    }

    public DetEvento getDetEvento() {
	return detEvento;
    }

    public void setDetEvento(DetEvento value) {
	this.detEvento = value;
    }

    public String getId() {
	return id;
    }

    public void setId(String value) {
	this.id = value;
    }

}
