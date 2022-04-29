package com.manide.xml.xmldsigcore;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TransformType", propOrder = { "xPath" })
public class TransformType {

    @XmlElement(name = "XPath")
    protected List<String> xPath;
    @XmlAttribute(name = "Algorithm", required = true)
    protected String algorithm;

    public List<String> getXPath() {
	if (xPath == null) {
	    xPath = new ArrayList<String>();
	}
	return this.xPath;
    }

    public String getAlgorithm() {
	return algorithm;
    }

    public void setAlgorithm(String value) {
	this.algorithm = value;
    }

}
