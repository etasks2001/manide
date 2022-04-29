package com.manide.xml.download.retorno;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "chNFe", "cStat", "xMotivo", "procNFeGrupoZip", "procNFeZip", "procNFe" })
public class RetNFe {

    @XmlElement(required = true)
    protected String chNFe;
    @XmlElement(required = true)
    protected String cStat;
    @XmlElement(required = true)
    protected String xMotivo;
    protected ProcNFeGrupoZip procNFeGrupoZip;
    protected byte[] procNFeZip;
    protected ProcNFe procNFe;

    public String getChNFe() {
	return chNFe;
    }

    public void setChNFe(String value) {
	this.chNFe = value;
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

    public ProcNFeGrupoZip getProcNFeGrupoZip() {
	return procNFeGrupoZip;
    }

    public void setProcNFeGrupoZip(ProcNFeGrupoZip value) {
	this.procNFeGrupoZip = value;
    }

    public byte[] getProcNFeZip() {
	return procNFeZip;
    }

    public void setProcNFeZip(byte[] value) {
	this.procNFeZip = value;
    }

    public ProcNFe getProcNFe() {
	return procNFe;
    }

    public void setProcNFe(ProcNFe value) {
	this.procNFe = value;
    }

}
