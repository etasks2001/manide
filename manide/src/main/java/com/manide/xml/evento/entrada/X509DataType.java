package com.manide.xml.evento.entrada;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "X509DataType", propOrder = { "x509Certificate" })
public class X509DataType {

    @XmlElement(name = "X509Certificate", required = true)
    protected byte[] x509Certificate;

    public byte[] getX509Certificate() {
	return x509Certificate;
    }

    public void setX509Certificate(byte[] value) {
	this.x509Certificate = value;
    }

}
