package com.manide.xml.xmldsigcore;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SignedInfoType", propOrder = { "canonicalizationMethod", "signatureMethod", "reference" })
public class SignedInfoType {

    @XmlElement(name = "CanonicalizationMethod", required = true)
    protected CanonicalizationMethod canonicalizationMethod;
    @XmlElement(name = "SignatureMethod", required = true)
    protected SignatureMethod signatureMethod;
    @XmlElement(name = "Reference", required = true)
    protected ReferenceType reference;
    @XmlAttribute(name = "Id")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    @XmlSchemaType(name = "ID")
    protected String id;

    public CanonicalizationMethod getCanonicalizationMethod() {
	return canonicalizationMethod;
    }

    public void setCanonicalizationMethod(CanonicalizationMethod value) {
	this.canonicalizationMethod = value;
    }

    public SignatureMethod getSignatureMethod() {
	return signatureMethod;
    }

    public void setSignatureMethod(SignatureMethod value) {
	this.signatureMethod = value;
    }

    public ReferenceType getReference() {
	return reference;
    }

    public void setReference(ReferenceType value) {
	this.reference = value;
    }

    public String getId() {
	return id;
    }

    public void setId(String value) {
	this.id = value;
    }

}
