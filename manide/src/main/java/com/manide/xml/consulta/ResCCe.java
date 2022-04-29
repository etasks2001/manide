package com.manide.xml.consulta;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "chNFe", "dhEvento", "tpEvento", "nSeqEvento", "descEvento", "xCorrecao", "tpNF", "dhRecbto" })
public class ResCCe {

    @XmlElement(required = true)
    protected String chNFe;
    @XmlElement(required = true)
    protected String dhEvento;
    @XmlElement(required = true)
    protected String tpEvento;
    @XmlElement(required = true)
    protected String nSeqEvento;
    @XmlElement(required = true)
    protected String descEvento;
    protected String xCorrecao;
    @XmlElement(required = true)
    protected String tpNF;
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dhRecbto;
    @XmlAttribute(name = "NSU", required = true)
    protected String nsu;

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

    public void setNSU(String value) {
	this.nsu = value;
    }

}
