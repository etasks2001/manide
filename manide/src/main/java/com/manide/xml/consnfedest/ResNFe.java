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
 *         &lt;choice>
 *           &lt;element name="CNPJ" type="{http://www.portalfiscal.inf.br/nfe}TCnpj"/>
 *           &lt;element name="CPF" type="{http://www.portalfiscal.inf.br/nfe}TCpf"/>
 *         &lt;/choice>
 *         &lt;element name="xNome">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.portalfiscal.inf.br/nfe}TString">
 *               &lt;minLength value="3"/>
 *               &lt;maxLength value="60"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="IE" type="{http://www.portalfiscal.inf.br/nfe}TIe"/>
 *         &lt;element name="dEmi" type="{http://www.portalfiscal.inf.br/nfe}TData"/>
 *         &lt;element name="tpNF">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;whiteSpace value="preserve"/>
 *               &lt;enumeration value="0"/>
 *               &lt;enumeration value="1"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="vNF" type="{http://www.portalfiscal.inf.br/nfe}TDec_1302"/>
 *         &lt;element name="digVal">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;whiteSpace value="preserve"/>
 *               &lt;length value="28"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="dhRecbto" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="cSitNFe">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;whiteSpace value="preserve"/>
 *               &lt;enumeration value="1"/>
 *               &lt;enumeration value="2"/>
 *               &lt;enumeration value="3"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="cSitConf">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;whiteSpace value="preserve"/>
 *               &lt;enumeration value="0"/>
 *               &lt;enumeration value="1"/>
 *               &lt;enumeration value="2"/>
 *               &lt;enumeration value="3"/>
 *               &lt;enumeration value="4"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
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
    "cnpj",
    "cpf",
    "xNome",
    "ie",
    "dEmi",
    "tpNF",
    "vnf",
    "digVal",
    "dhRecbto",
    "cSitNFe",
    "cSitConf"
})
public class ResNFe {

    @XmlElement(required = true)
    protected String chNFe;
    @XmlElement(name = "CNPJ")
    protected String cnpj;
    @XmlElement(name = "CPF")
    protected String cpf;
    @XmlElement(required = true)
    protected String xNome;
    @XmlElement(name = "IE", required = true)
    protected String ie;
    @XmlElement(required = true)
    protected String dEmi;
    @XmlElement(required = true)
    protected String tpNF;
    @XmlElement(name = "vNF", required = true)
    protected String vnf;
    @XmlElement(required = true)
    protected String digVal;
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dhRecbto;
    @XmlElement(required = true)
    protected String cSitNFe;
    @XmlElement(required = true)
    protected String cSitConf;
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
     * Obtém o valor da propriedade cnpj.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCNPJ() {
        return cnpj;
    }

    /**
     * Define o valor da propriedade cnpj.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCNPJ(String value) {
        this.cnpj = value;
    }

    /**
     * Obtém o valor da propriedade cpf.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCPF() {
        return cpf;
    }

    /**
     * Define o valor da propriedade cpf.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCPF(String value) {
        this.cpf = value;
    }

    /**
     * Obtém o valor da propriedade xNome.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getXNome() {
        return xNome;
    }

    /**
     * Define o valor da propriedade xNome.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setXNome(String value) {
        this.xNome = value;
    }

    /**
     * Obtém o valor da propriedade ie.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIE() {
        return ie;
    }

    /**
     * Define o valor da propriedade ie.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIE(String value) {
        this.ie = value;
    }

    /**
     * Obtém o valor da propriedade dEmi.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDEmi() {
        return dEmi;
    }

    /**
     * Define o valor da propriedade dEmi.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDEmi(String value) {
        this.dEmi = value;
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
     * Obtém o valor da propriedade vnf.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVNF() {
        return vnf;
    }

    /**
     * Define o valor da propriedade vnf.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVNF(String value) {
        this.vnf = value;
    }

    /**
     * Obtém o valor da propriedade digVal.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDigVal() {
        return digVal;
    }

    /**
     * Define o valor da propriedade digVal.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDigVal(String value) {
        this.digVal = value;
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
     * Obtém o valor da propriedade cSitNFe.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCSitNFe() {
        return cSitNFe;
    }

    /**
     * Define o valor da propriedade cSitNFe.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCSitNFe(String value) {
        this.cSitNFe = value;
    }

    /**
     * Obtém o valor da propriedade cSitConf.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCSitConf() {
        return cSitConf;
    }

    /**
     * Define o valor da propriedade cSitConf.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCSitConf(String value) {
        this.cSitConf = value;
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
