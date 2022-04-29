package com.manide.xml.consulta.retorno.info;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "resNFe", "resCanc", "resCCe" })
public class Ret {

    protected ResNFe resNFe;
    protected ResCanc resCanc;
    protected ResCCe resCCe;

    public ResNFe getResNFe() {
	return resNFe;
    }

    public void setResNFe(ResNFe value) {
	this.resNFe = value;
    }

    public ResCanc getResCanc() {
	return resCanc;
    }

    public void setResCanc(ResCanc value) {
	this.resCanc = value;
    }

    public ResCCe getResCCe() {
	return resCCe;
    }

    public void setResCCe(ResCCe value) {
	this.resCCe = value;
    }

}
