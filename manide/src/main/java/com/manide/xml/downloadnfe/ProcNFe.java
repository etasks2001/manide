package com.manide.xml.downloadnfe;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

import org.w3c.dom.Element;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "any" })
public class ProcNFe {

    @XmlAnyElement
    protected Element any;
    @XmlAttribute(name = "schema", required = true)
    protected String schema;

    public Element getAny() {
	return any;
    }

    public void setAny(Element value) {
	this.any = value;
    }

    public String getSchema() {
	return schema;
    }

    public void setSchema(String value) {
	this.schema = value;
    }

}
