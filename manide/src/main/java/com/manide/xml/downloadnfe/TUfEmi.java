package com.manide.xml.downloadnfe;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "TUfEmi")
@XmlEnum
public enum TUfEmi {

    AC, AL, AM, AP, BA, CE, DF, ES, GO, MA, MG, MS, MT, PA, PB, PE, PI, PR, RJ, RN, RO, RR, RS, SC, SE, SP, TO;

    public String value() {
	return name();
    }

    public static TUfEmi fromValue(String v) {
	return valueOf(v);
    }

}
