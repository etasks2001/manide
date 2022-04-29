package com.manide.xml.xmldsigcore;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
public class DigestMethod {

    @XmlAttribute(name = "Algorithm", required = true)
    @XmlSchemaType(name = "anyURI")
    protected String algorithm;

    public String getAlgorithm() {
	if (algorithm == null) {
	    return "http://www.w3.org/2000/09/xmldsig#sha1";
	} else {
	    return algorithm;
	}
    }

    public void setAlgorithm(String value) {
	this.algorithm = value;
    }

}
