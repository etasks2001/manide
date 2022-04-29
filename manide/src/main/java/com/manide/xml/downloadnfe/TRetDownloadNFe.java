package com.manide.xml.downloadnfe;

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
import com.manide.xml.TVerDownloadNFe;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TRetDownloadNFe", propOrder = { "tpAmb", "verAplic", "cStat", "xMotivo", "dhResp", "retNFe" })
public class TRetDownloadNFe {

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
    protected List<RetNFe> retNFe = new ArrayList<RetNFe>();
    @XmlAttribute(name = "versao", required = true)
    protected TVerDownloadNFe versao;

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

    public List<RetNFe> getRetNFe() {
	return this.retNFe;
    }

    public TVerDownloadNFe getVersao() {
	return versao;
    }

    public void setVersao(TVerDownloadNFe value) {
	this.versao = value;
    }

}
