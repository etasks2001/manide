//
// Este arquivo foi gerado pela Arquitetura JavaTM para Implementação de Referência (JAXB) de Bind XML, v2.2.8-b130911.1802 
// Consulte <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas as modificações neste arquivo serão perdidas após a recompilação do esquema de origem. 
// Gerado em: 2022.04.29 às 10:51:24 AM GMT-03:00 
//


package com.manide.xml.consnfedest;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Classe Java de anonymous complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="chNFe" type="{http://www.portalfiscal.inf.br/nfe}TChNFe"/>
 *         &lt;element name="dhEvento">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;whiteSpace value="preserve"/>
 *               &lt;pattern value="(((20(([02468][048])|([13579][26]))-02-29))|(20[0-9][0-9])-((((0[1-9])|(1[0-2]))-((0[1-9])|(1\d)|(2[0-8])))|((((0[13578])|(1[02]))-31)|(((0[1,3-9])|(1[0-2]))-(29|30)))))T(20|21|22|23|[0-1]\d):[0-5]\d:[0-5]\d-0[1-4]:00"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="tpEvento">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;whiteSpace value="preserve"/>
 *               &lt;pattern value="[0-9]{6}"/>
 *               &lt;enumeration value="110110"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="nSeqEvento">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;whiteSpace value="preserve"/>
 *               &lt;pattern value="[1-9]|[1][0-9]{0,1}|20"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="descEvento">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;whiteSpace value="preserve"/>
 *               &lt;enumeration value="Carta de Correção"/>
 *               &lt;enumeration value="Carta de Correcao"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="xCorrecao" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;whiteSpace value="preserve"/>
 *               &lt;minLength value="15"/>
 *               &lt;maxLength value="1000"/>
 *               &lt;pattern value="[!-ÿ]{1}[ -ÿ]{0,}[!-ÿ]{1}|[!-ÿ]{1}"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="tpNF">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;whiteSpace value="preserve"/>
 *               &lt;enumeration value="0"/>
 *               &lt;enumeration value="1"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="dhRecbto" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *       &lt;/sequence>
 *       &lt;attribute name="NSU" use="required" type="{http://www.portalfiscal.inf.br/nfe}TNSU" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "chNFe",
    "dhEvento",
    "tpEvento",
    "nSeqEvento",
    "descEvento",
    "xCorrecao",
    "tpNF",
    "dhRecbto"
})
public class ResCCe {

    @XmlElement(required = true)
    protected String chNFe;
    @XmlElement(required = true)
    protected String dhEvento;
    @XmlElement(required = true)
    protected String tpEvento;
    @XmlElement(required = true)
    protected String nSeqEvento;
    @XmlElement(required = true)
    protected String descEvento;
    protected String xCorrecao;
    @XmlElement(required = true)
    protected String tpNF;
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dhRecbto;
    @XmlAttribute(name = "NSU", required = true)
    protected String nsu;

    /**
     * Obtém o valor da propriedade chNFe.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getChNFe() {
        return chNFe;
    }

    /**
     * Define o valor da propriedade chNFe.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setChNFe(String value) {
        this.chNFe = value;
    }

    /**
     * Obtém o valor da propriedade dhEvento.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDhEvento() {
        return dhEvento;
    }

    /**
     * Define o valor da propriedade dhEvento.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDhEvento(String value) {
        this.dhEvento = value;
    }

    /**
     * Obtém o valor da propriedade tpEvento.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTpEvento() {
        return tpEvento;
    }

    /**
     * Define o valor da propriedade tpEvento.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTpEvento(String value) {
        this.tpEvento = value;
    }

    /**
     * Obtém o valor da propriedade nSeqEvento.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNSeqEvento() {
        return nSeqEvento;
    }

    /**
     * Define o valor da propriedade nSeqEvento.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNSeqEvento(String value) {
        this.nSeqEvento = value;
    }

    /**
     * Obtém o valor da propriedade descEvento.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescEvento() {
        return descEvento;
    }

    /**
     * Define o valor da propriedade descEvento.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescEvento(String value) {
        this.descEvento = value;
    }

    /**
     * Obtém o valor da propriedade xCorrecao.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getXCorrecao() {
        return xCorrecao;
    }

    /**
     * Define o valor da propriedade xCorrecao.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setXCorrecao(String value) {
        this.xCorrecao = value;
    }

    /**
     * Obtém o valor da propriedade tpNF.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTpNF() {
        return tpNF;
    }

    /**
     * Define o valor da propriedade tpNF.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTpNF(String value) {
        this.tpNF = value;
    }

    /**
     * Obtém o valor da propriedade dhRecbto.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDhRecbto() {
        return dhRecbto;
    }

    /**
     * Define o valor da propriedade dhRecbto.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDhRecbto(XMLGregorianCalendar value) {
        this.dhRecbto = value;
    }

    /**
     * Obtém o valor da propriedade nsu.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNSU() {
        return nsu;
    }

    /**
     * Define o valor da propriedade nsu.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNSU(String value) {
        this.nsu = value;
    }

}
