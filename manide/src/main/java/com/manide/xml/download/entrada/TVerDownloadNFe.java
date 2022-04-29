package com.manide.xml.download.entrada;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "TVerDownloadNFe")
@XmlEnum
public enum TVerDownloadNFe {

    @XmlEnumValue("1.00")
    VALUE_1("1.00");
    private final String value;

    TVerDownloadNFe(String v) {
	value = v;
    }

    public String value() {
	return value;
    }

    public static TVerDownloadNFe fromValue(String v) {
	for (TVerDownloadNFe c : TVerDownloadNFe.values()) {
	    if (c.value.equals(v)) {
		return c;
	    }
	}
	throw new IllegalArgumentException(v);
    }

}
