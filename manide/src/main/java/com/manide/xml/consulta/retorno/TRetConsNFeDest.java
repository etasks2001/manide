package com.manide.xml.consulta.retorno;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

import com.manide.xml.TAmb;
import com.manide.xml.consulta.retorno.info.Ret;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TRetConsNFeDest", propOrder = { "tpAmb", "verAplic", "cStat", "xMotivo", "dhResp", "indCont", "ultNSU", "ret" })
public class TRetConsNFeDest {

    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected TAmb tpAmb;
    @XmlElement(required = true)
    protected String verAplic;
    @XmlElement(required = true)
    protected String cStat;
    @XmlElement(required = true)
    protected String xMotivo;
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dhResp;
    protected String indCont;
    protected String ultNSU;
    protected List<Ret> ret = new ArrayList<Ret>();
    @XmlAttribute(name = "versao", required = true)
    protected TVeConsNFeDest versao;

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

    public XMLGregorianCalendar getDhResp() {
	return dhResp;
    }

    public void setDhResp(XMLGregorianCalendar value) {
	this.dhResp = value;
    }

    public String getIndCont() {
	return indCont;
    }

    public void setIndCont(String value) {
	this.indCont = value;
    }

    public String getUltNSU() {
	return ultNSU;
    }

    public void setUltNSU(String value) {
	this.ultNSU = value;
    }

    public List<Ret> getRet() {
	return this.ret;
    }

    public TVeConsNFeDest getVersao() {
	return versao;
    }

    public void setVersao(TVeConsNFeDest value) {
	this.versao = value;
    }

}
