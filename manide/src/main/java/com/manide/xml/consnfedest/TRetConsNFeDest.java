//
// Este arquivo foi gerado pela Arquitetura JavaTM para Implementação de Referência (JAXB) de Bind XML, v2.2.8-b130911.1802 
// Consulte <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas as modificações neste arquivo serão perdidas após a recompilação do esquema de origem. 
// Gerado em: 2022.04.29 às 10:51:24 AM GMT-03:00 
//


package com.manide.xml.consnfedest;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * Tipo Retorno do pedido de Consulta de Nota Fiscal Eletrônica
 * 
 * <p>Classe Java de TRetConsNFeDest complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="TRetConsNFeDest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="tpAmb" type="{http://www.portalfiscal.inf.br/nfe}TAmb"/>
 *         &lt;element name="verAplic" type="{http://www.portalfiscal.inf.br/nfe}TVerAplic"/>
 *         &lt;element name="cStat" type="{http://www.portalfiscal.inf.br/nfe}TStat"/>
 *         &lt;element name="xMotivo" type="{http://www.portalfiscal.inf.br/nfe}TMotivo"/>
 *         &lt;element name="dhResp" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="indCont" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;whiteSpace value="preserve"/>
 *               &lt;enumeration value="0"/>
 *               &lt;enumeration value="1"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="ultNSU" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;whiteSpace value="preserve"/>
 *               &lt;pattern value="[1-9][0-9]{0,14}"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="ret" maxOccurs="50" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;choice>
 *                   &lt;element name="resNFe">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="chNFe" type="{http://www.portalfiscal.inf.br/nfe}TChNFe"/>
 *                             &lt;choice>
 *                               &lt;element name="CNPJ" type="{http://www.portalfiscal.inf.br/nfe}TCnpj"/>
 *                               &lt;element name="CPF" type="{http://www.portalfiscal.inf.br/nfe}TCpf"/>
 *                             &lt;/choice>
 *                             &lt;element name="xNome">
 *                               &lt;simpleType>
 *                                 &lt;restriction base="{http://www.portalfiscal.inf.br/nfe}TString">
 *                                   &lt;minLength value="3"/>
 *                                   &lt;maxLength value="60"/>
 *                                 &lt;/restriction>
 *                               &lt;/simpleType>
 *                             &lt;/element>
 *                             &lt;element name="IE" type="{http://www.portalfiscal.inf.br/nfe}TIe"/>
 *                             &lt;element name="dEmi" type="{http://www.portalfiscal.inf.br/nfe}TData"/>
 *                             &lt;element name="tpNF">
 *                               &lt;simpleType>
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                                   &lt;whiteSpace value="preserve"/>
 *                                   &lt;enumeration value="0"/>
 *                                   &lt;enumeration value="1"/>
 *                                 &lt;/restriction>
 *                               &lt;/simpleType>
 *                             &lt;/element>
 *                             &lt;element name="vNF" type="{http://www.portalfiscal.inf.br/nfe}TDec_1302"/>
 *                             &lt;element name="digVal">
 *                               &lt;simpleType>
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                                   &lt;whiteSpace value="preserve"/>
 *                                   &lt;length value="28"/>
 *                                 &lt;/restriction>
 *                               &lt;/simpleType>
 *                             &lt;/element>
 *                             &lt;element name="dhRecbto" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *                             &lt;element name="cSitNFe">
 *                               &lt;simpleType>
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                                   &lt;whiteSpace value="preserve"/>
 *                                   &lt;enumeration value="1"/>
 *                                   &lt;enumeration value="2"/>
 *                                   &lt;enumeration value="3"/>
 *                                 &lt;/restriction>
 *                               &lt;/simpleType>
 *                             &lt;/element>
 *                             &lt;element name="cSitConf">
 *                               &lt;simpleType>
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                                   &lt;whiteSpace value="preserve"/>
 *                                   &lt;enumeration value="0"/>
 *                                   &lt;enumeration value="1"/>
 *                                   &lt;enumeration value="2"/>
 *                                   &lt;enumeration value="3"/>
 *                                   &lt;enumeration value="4"/>
 *                                 &lt;/restriction>
 *                               &lt;/simpleType>
 *                             &lt;/element>
 *                           &lt;/sequence>
 *                           &lt;attribute name="NSU" use="required" type="{http://www.portalfiscal.inf.br/nfe}TNSU" />
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="resCanc">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="chNFe" type="{http://www.portalfiscal.inf.br/nfe}TChNFe"/>
 *                             &lt;choice>
 *                               &lt;element name="CNPJ" type="{http://www.portalfiscal.inf.br/nfe}TCnpj"/>
 *                               &lt;element name="CPF" type="{http://www.portalfiscal.inf.br/nfe}TCpf"/>
 *                             &lt;/choice>
 *                             &lt;element name="xNome">
 *                               &lt;simpleType>
 *                                 &lt;restriction base="{http://www.portalfiscal.inf.br/nfe}TString">
 *                                   &lt;minLength value="3"/>
 *                                   &lt;maxLength value="60"/>
 *                                 &lt;/restriction>
 *                               &lt;/simpleType>
 *                             &lt;/element>
 *                             &lt;element name="IE" type="{http://www.portalfiscal.inf.br/nfe}TIe"/>
 *                             &lt;element name="dEmi" type="{http://www.portalfiscal.inf.br/nfe}TData"/>
 *                             &lt;element name="tpNF">
 *                               &lt;simpleType>
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                                   &lt;whiteSpace value="preserve"/>
 *                                   &lt;enumeration value="0"/>
 *                                   &lt;enumeration value="1"/>
 *                                 &lt;/restriction>
 *                               &lt;/simpleType>
 *                             &lt;/element>
 *                             &lt;element name="vNF" type="{http://www.portalfiscal.inf.br/nfe}TDec_1302"/>
 *                             &lt;element name="digVal">
 *                               &lt;simpleType>
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                                   &lt;whiteSpace value="preserve"/>
 *                                   &lt;length value="28"/>
 *                                 &lt;/restriction>
 *                               &lt;/simpleType>
 *                             &lt;/element>
 *                             &lt;element name="dhRecbto" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *                             &lt;element name="cSitNFe">
 *                               &lt;simpleType>
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                                   &lt;whiteSpace value="preserve"/>
 *                                   &lt;enumeration value="3"/>
 *                                 &lt;/restriction>
 *                               &lt;/simpleType>
 *                             &lt;/element>
 *                             &lt;element name="cSitConf">
 *                               &lt;simpleType>
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                                   &lt;whiteSpace value="preserve"/>
 *                                   &lt;enumeration value="0"/>
 *                                   &lt;enumeration value="1"/>
 *                                   &lt;enumeration value="2"/>
 *                                   &lt;enumeration value="3"/>
 *                                   &lt;enumeration value="4"/>
 *                                 &lt;/restriction>
 *                               &lt;/simpleType>
 *                             &lt;/element>
 *                           &lt;/sequence>
 *                           &lt;attribute name="NSU" use="required" type="{http://www.portalfiscal.inf.br/nfe}TNSU" />
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="resCCe">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="chNFe" type="{http://www.portalfiscal.inf.br/nfe}TChNFe"/>
 *                             &lt;element name="dhEvento">
 *                               &lt;simpleType>
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                                   &lt;whiteSpace value="preserve"/>
 *                                   &lt;pattern value="(((20(([02468][048])|([13579][26]))-02-29))|(20[0-9][0-9])-((((0[1-9])|(1[0-2]))-((0[1-9])|(1\d)|(2[0-8])))|((((0[13578])|(1[02]))-31)|(((0[1,3-9])|(1[0-2]))-(29|30)))))T(20|21|22|23|[0-1]\d):[0-5]\d:[0-5]\d-0[1-4]:00"/>
 *                                 &lt;/restriction>
 *                               &lt;/simpleType>
 *                             &lt;/element>
 *                             &lt;element name="tpEvento">
 *                               &lt;simpleType>
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                                   &lt;whiteSpace value="preserve"/>
 *                                   &lt;pattern value="[0-9]{6}"/>
 *                                   &lt;enumeration value="110110"/>
 *                                 &lt;/restriction>
 *                               &lt;/simpleType>
 *                             &lt;/element>
 *                             &lt;element name="nSeqEvento">
 *                               &lt;simpleType>
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                                   &lt;whiteSpace value="preserve"/>
 *                                   &lt;pattern value="[1-9]|[1][0-9]{0,1}|20"/>
 *                                 &lt;/restriction>
 *                               &lt;/simpleType>
 *                             &lt;/element>
 *                             &lt;element name="descEvento">
 *                               &lt;simpleType>
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                                   &lt;whiteSpace value="preserve"/>
 *                                   &lt;enumeration value="Carta de Correção"/>
 *                                   &lt;enumeration value="Carta de Correcao"/>
 *                                 &lt;/restriction>
 *                               &lt;/simpleType>
 *                             &lt;/element>
 *                             &lt;element name="xCorrecao" minOccurs="0">
 *                               &lt;simpleType>
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                                   &lt;whiteSpace value="preserve"/>
 *                                   &lt;minLength value="15"/>
 *                                   &lt;maxLength value="1000"/>
 *                                   &lt;pattern value="[!-ÿ]{1}[ -ÿ]{0,}[!-ÿ]{1}|[!-ÿ]{1}"/>
 *                                 &lt;/restriction>
 *                               &lt;/simpleType>
 *                             &lt;/element>
 *                             &lt;element name="tpNF">
 *                               &lt;simpleType>
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                                   &lt;whiteSpace value="preserve"/>
 *                                   &lt;enumeration value="0"/>
 *                                   &lt;enumeration value="1"/>
 *                                 &lt;/restriction>
 *                               &lt;/simpleType>
 *                             &lt;/element>
 *                             &lt;element name="dhRecbto" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *                           &lt;/sequence>
 *                           &lt;attribute name="NSU" use="required" type="{http://www.portalfiscal.inf.br/nfe}TNSU" />
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/choice>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *       &lt;attribute name="versao" use="required" type="{http://www.portalfiscal.inf.br/nfe}TVeConsNFeDest" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TRetConsNFeDest", propOrder = {
    "tpAmb",
    "verAplic",
    "cStat",
    "xMotivo",
    "dhResp",
    "indCont",
    "ultNSU",
    "ret"
})
public class TRetConsNFeDest {

    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected TAmb tpAmb;
    @XmlElement(required = true)
    protected String verAplic;
    @XmlElement(required = true)
    protected String cStat;
    @XmlElement(required = true)
    protected String xMotivo;
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dhResp;
    protected String indCont;
    protected String ultNSU;
    protected List<Ret> ret;
    @XmlAttribute(name = "versao", required = true)
    protected TVeConsNFeDest versao;

    /**
     * Obtém o valor da propriedade tpAmb.
     * 
     * @return
     *     possible object is
     *     {@link TAmb }
     *     
     */
    public TAmb getTpAmb() {
        return tpAmb;
    }

    /**
     * Define o valor da propriedade tpAmb.
     * 
     * @param value
     *     allowed object is
     *     {@link TAmb }
     *     
     */
    public void setTpAmb(TAmb value) {
        this.tpAmb = value;
    }

    /**
     * Obtém o valor da propriedade verAplic.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVerAplic() {
        return verAplic;
    }

    /**
     * Define o valor da propriedade verAplic.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVerAplic(String value) {
        this.verAplic = value;
    }

    /**
     * Obtém o valor da propriedade cStat.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCStat() {
        return cStat;
    }

    /**
     * Define o valor da propriedade cStat.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCStat(String value) {
        this.cStat = value;
    }

    /**
     * Obtém o valor da propriedade xMotivo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getXMotivo() {
        return xMotivo;
    }

    /**
     * Define o valor da propriedade xMotivo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setXMotivo(String value) {
        this.xMotivo = value;
    }

    /**
     * Obtém o valor da propriedade dhResp.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDhResp() {
        return dhResp;
    }

    /**
     * Define o valor da propriedade dhResp.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDhResp(XMLGregorianCalendar value) {
        this.dhResp = value;
    }

    /**
     * Obtém o valor da propriedade indCont.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIndCont() {
        return indCont;
    }

    /**
     * Define o valor da propriedade indCont.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIndCont(String value) {
        this.indCont = value;
    }

    /**
     * Obtém o valor da propriedade ultNSU.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUltNSU() {
        return ultNSU;
    }

    /**
     * Define o valor da propriedade ultNSU.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUltNSU(String value) {
        this.ultNSU = value;
    }

    /**
     * Gets the value of the ret property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the ret property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRet().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Ret }
     * 
     * 
     */
    public List<Ret> getRet() {
        if (ret == null) {
            ret = new ArrayList<Ret>();
        }
        return this.ret;
    }

    /**
     * Obtém o valor da propriedade versao.
     * 
     * @return
     *     possible object is
     *     {@link TVeConsNFeDest }
     *     
     */
    public TVeConsNFeDest getVersao() {
        return versao;
    }

    /**
     * Define o valor da propriedade versao.
     * 
     * @param value
     *     allowed object is
     *     {@link TVeConsNFeDest }
     *     
     */
    public void setVersao(TVeConsNFeDest value) {
        this.versao = value;
    }

}
