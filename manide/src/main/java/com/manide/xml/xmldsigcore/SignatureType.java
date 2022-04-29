
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
@XmlType(name = "SignatureType", propOrder = { "signedInfo", "signatureValue", "keyInfo" })
public class SignatureType {

    @XmlElement(name = "SignedInfo", required = true)
    protected SignedInfoType signedInfo;
    @XmlElement(name = "SignatureValue", required = true)
    protected SignatureValueType signatureValue;
    @XmlElement(name = "KeyInfo", required = true)
    protected KeyInfoType keyInfo;
    @XmlAttribute(name = "Id")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    @XmlSchemaType(name = "ID")
    protected String id;

    public SignedInfoType getSignedInfo() {
	return signedInfo;
    }

    public void setSignedInfo(SignedInfoType value) {
	this.signedInfo = value;
    }

    public SignatureValueType getSignatureValue() {
	return signatureValue;
    }

    public void setSignatureValue(SignatureValueType value) {
	this.signatureValue = value;
    }

    public KeyInfoType getKeyInfo() {
	return keyInfo;
    }

    public void setKeyInfo(KeyInfoType value) {
	this.keyInfo = value;
    }

    public String getId() {
	return id;
    }

    public void setId(String value) {
	this.id = value;
    }

}
