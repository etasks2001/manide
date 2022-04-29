package com.manide.xml.downloadnfe;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "TMod")
@XmlEnum
public enum TMod {

    @XmlEnumValue("55")
    VALUE_1("55");
    private final String value;

    TMod(String v) {
	value = v;
    }

    public String value() {
	return value;
    }

    public static TMod fromValue(String v) {
	for (TMod c : TMod.values()) {
	    if (c.value.equals(v)) {
		return c;
	    }
	}
	throw new IllegalArgumentException(v);
    }

}
