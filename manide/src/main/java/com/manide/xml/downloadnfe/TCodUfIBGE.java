//
// Este arquivo foi gerado pela Arquitetura JavaTM para Implementação de Referência (JAXB) de Bind XML, v2.2.8-b130911.1802 
// Consulte <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas as modificações neste arquivo serão perdidas após a recompilação do esquema de origem. 
// Gerado em: 2022.04.29 às 10:54:59 AM GMT-03:00 
//


package com.manide.xml.downloadnfe;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de TCodUfIBGE.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * <p>
 * <pre>
 * &lt;simpleType name="TCodUfIBGE">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;whiteSpace value="preserve"/>
 *     &lt;enumeration value="11"/>
 *     &lt;enumeration value="12"/>
 *     &lt;enumeration value="13"/>
 *     &lt;enumeration value="14"/>
 *     &lt;enumeration value="15"/>
 *     &lt;enumeration value="16"/>
 *     &lt;enumeration value="17"/>
 *     &lt;enumeration value="21"/>
 *     &lt;enumeration value="22"/>
 *     &lt;enumeration value="23"/>
 *     &lt;enumeration value="24"/>
 *     &lt;enumeration value="25"/>
 *     &lt;enumeration value="26"/>
 *     &lt;enumeration value="27"/>
 *     &lt;enumeration value="28"/>
 *     &lt;enumeration value="29"/>
 *     &lt;enumeration value="31"/>
 *     &lt;enumeration value="32"/>
 *     &lt;enumeration value="33"/>
 *     &lt;enumeration value="35"/>
 *     &lt;enumeration value="41"/>
 *     &lt;enumeration value="42"/>
 *     &lt;enumeration value="43"/>
 *     &lt;enumeration value="50"/>
 *     &lt;enumeration value="51"/>
 *     &lt;enumeration value="52"/>
 *     &lt;enumeration value="53"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "TCodUfIBGE")
@XmlEnum
public enum TCodUfIBGE {

    @XmlEnumValue("11")
    VALUE_1("11"),
    @XmlEnumValue("12")
    VALUE_2("12"),
    @XmlEnumValue("13")
    VALUE_3("13"),
    @XmlEnumValue("14")
    VALUE_4("14"),
    @XmlEnumValue("15")
    VALUE_5("15"),
    @XmlEnumValue("16")
    VALUE_6("16"),
    @XmlEnumValue("17")
    VALUE_7("17"),
    @XmlEnumValue("21")
    VALUE_8("21"),
    @XmlEnumValue("22")
    VALUE_9("22"),
    @XmlEnumValue("23")
    VALUE_10("23"),
    @XmlEnumValue("24")
    VALUE_11("24"),
    @XmlEnumValue("25")
    VALUE_12("25"),
    @XmlEnumValue("26")
    VALUE_13("26"),
    @XmlEnumValue("27")
    VALUE_14("27"),
    @XmlEnumValue("28")
    VALUE_15("28"),
    @XmlEnumValue("29")
    VALUE_16("29"),
    @XmlEnumValue("31")
    VALUE_17("31"),
    @XmlEnumValue("32")
    VALUE_18("32"),
    @XmlEnumValue("33")
    VALUE_19("33"),
    @XmlEnumValue("35")
    VALUE_20("35"),
    @XmlEnumValue("41")
    VALUE_21("41"),
    @XmlEnumValue("42")
    VALUE_22("42"),
    @XmlEnumValue("43")
    VALUE_23("43"),
    @XmlEnumValue("50")
    VALUE_24("50"),
    @XmlEnumValue("51")
    VALUE_25("51"),
    @XmlEnumValue("52")
    VALUE_26("52"),
    @XmlEnumValue("53")
    VALUE_27("53");
    private final String value;

    TCodUfIBGE(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static TCodUfIBGE fromValue(String v) {
        for (TCodUfIBGE c: TCodUfIBGE.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
