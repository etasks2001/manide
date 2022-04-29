//
// Este arquivo foi gerado pela Arquitetura JavaTM para Implementação de Referência (JAXB) de Bind XML, v2.2.8-b130911.1802 
// Consulte <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas as modificações neste arquivo serão perdidas após a recompilação do esquema de origem. 
// Gerado em: 2022.04.29 às 10:51:24 AM GMT-03:00 
//


package com.manide.xml.consnfedest;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de anonymous complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice>
 *         &lt;element name="resNFe">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="chNFe" type="{http://www.portalfiscal.inf.br/nfe}TChNFe"/>
 *                   &lt;choice>
 *                     &lt;element name="CNPJ" type="{http://www.portalfiscal.inf.br/nfe}TCnpj"/>
 *                     &lt;element name="CPF" type="{http://www.portalfiscal.inf.br/nfe}TCpf"/>
 *                   &lt;/choice>
 *                   &lt;element name="xNome">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.portalfiscal.inf.br/nfe}TString">
 *                         &lt;minLength value="3"/>
 *                         &lt;maxLength value="60"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="IE" type="{http://www.portalfiscal.inf.br/nfe}TIe"/>
 *                   &lt;element name="dEmi" type="{http://www.portalfiscal.inf.br/nfe}TData"/>
 *                   &lt;element name="tpNF">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;whiteSpace value="preserve"/>
 *                         &lt;enumeration value="0"/>
 *                         &lt;enumeration value="1"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="vNF" type="{http://www.portalfiscal.inf.br/nfe}TDec_1302"/>
 *                   &lt;element name="digVal">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;whiteSpace value="preserve"/>
 *                         &lt;length value="28"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="dhRecbto" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *                   &lt;element name="cSitNFe">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;whiteSpace value="preserve"/>
 *                         &lt;enumeration value="1"/>
 *                         &lt;enumeration value="2"/>
 *                         &lt;enumeration value="3"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="cSitConf">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;whiteSpace value="preserve"/>
 *                         &lt;enumeration value="0"/>
 *                         &lt;enumeration value="1"/>
 *                         &lt;enumeration value="2"/>
 *                         &lt;enumeration value="3"/>
 *                         &lt;enumeration value="4"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *                 &lt;attribute name="NSU" use="required" type="{http://www.portalfiscal.inf.br/nfe}TNSU" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="resCanc">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="chNFe" type="{http://www.portalfiscal.inf.br/nfe}TChNFe"/>
 *                   &lt;choice>
 *                     &lt;element name="CNPJ" type="{http://www.portalfiscal.inf.br/nfe}TCnpj"/>
 *                     &lt;element name="CPF" type="{http://www.portalfiscal.inf.br/nfe}TCpf"/>
 *                   &lt;/choice>
 *                   &lt;element name="xNome">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.portalfiscal.inf.br/nfe}TString">
 *                         &lt;minLength value="3"/>
 *                         &lt;maxLength value="60"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="IE" type="{http://www.portalfiscal.inf.br/nfe}TIe"/>
 *                   &lt;element name="dEmi" type="{http://www.portalfiscal.inf.br/nfe}TData"/>
 *                   &lt;element name="tpNF">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;whiteSpace value="preserve"/>
 *                         &lt;enumeration value="0"/>
 *                         &lt;enumeration value="1"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="vNF" type="{http://www.portalfiscal.inf.br/nfe}TDec_1302"/>
 *                   &lt;element name="digVal">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;whiteSpace value="preserve"/>
 *                         &lt;length value="28"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="dhRecbto" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *                   &lt;element name="cSitNFe">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;whiteSpace value="preserve"/>
 *                         &lt;enumeration value="3"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="cSitConf">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;whiteSpace value="preserve"/>
 *                         &lt;enumeration value="0"/>
 *                         &lt;enumeration value="1"/>
 *                         &lt;enumeration value="2"/>
 *                         &lt;enumeration value="3"/>
 *                         &lt;enumeration value="4"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *                 &lt;attribute name="NSU" use="required" type="{http://www.portalfiscal.inf.br/nfe}TNSU" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="resCCe">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="chNFe" type="{http://www.portalfiscal.inf.br/nfe}TChNFe"/>
 *                   &lt;element name="dhEvento">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;whiteSpace value="preserve"/>
 *                         &lt;pattern value="(((20(([02468][048])|([13579][26]))-02-29))|(20[0-9][0-9])-((((0[1-9])|(1[0-2]))-((0[1-9])|(1\d)|(2[0-8])))|((((0[13578])|(1[02]))-31)|(((0[1,3-9])|(1[0-2]))-(29|30)))))T(20|21|22|23|[0-1]\d):[0-5]\d:[0-5]\d-0[1-4]:00"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="tpEvento">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;whiteSpace value="preserve"/>
 *                         &lt;pattern value="[0-9]{6}"/>
 *                         &lt;enumeration value="110110"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="nSeqEvento">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;whiteSpace value="preserve"/>
 *                         &lt;pattern value="[1-9]|[1][0-9]{0,1}|20"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="descEvento">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;whiteSpace value="preserve"/>
 *                         &lt;enumeration value="Carta de Correção"/>
 *                         &lt;enumeration value="Carta de Correcao"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="xCorrecao" minOccurs="0">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;whiteSpace value="preserve"/>
 *                         &lt;minLength value="15"/>
 *                         &lt;maxLength value="1000"/>
 *                         &lt;pattern value="[!-ÿ]{1}[ -ÿ]{0,}[!-ÿ]{1}|[!-ÿ]{1}"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="tpNF">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;whiteSpace value="preserve"/>
 *                         &lt;enumeration value="0"/>
 *                         &lt;enumeration value="1"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="dhRecbto" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *                 &lt;/sequence>
 *                 &lt;attribute name="NSU" use="required" type="{http://www.portalfiscal.inf.br/nfe}TNSU" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/choice>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "resNFe",
    "resCanc",
    "resCCe"
})
public class Ret {

    protected ResNFe resNFe;
    protected ResCanc resCanc;
    protected ResCCe resCCe;

    /**
     * Obtém o valor da propriedade resNFe.
     * 
     * @return
     *     possible object is
     *     {@link ResNFe }
     *     
     */
    public ResNFe getResNFe() {
        return resNFe;
    }

    /**
     * Define o valor da propriedade resNFe.
     * 
     * @param value
     *     allowed object is
     *     {@link ResNFe }
     *     
     */
    public void setResNFe(ResNFe value) {
        this.resNFe = value;
    }

    /**
     * Obtém o valor da propriedade resCanc.
     * 
     * @return
     *     possible object is
     *     {@link ResCanc }
     *     
     */
    public ResCanc getResCanc() {
        return resCanc;
    }

    /**
     * Define o valor da propriedade resCanc.
     * 
     * @param value
     *     allowed object is
     *     {@link ResCanc }
     *     
     */
    public void setResCanc(ResCanc value) {
        this.resCanc = value;
    }

    /**
     * Obtém o valor da propriedade resCCe.
     * 
     * @return
     *     possible object is
     *     {@link ResCCe }
     *     
     */
    public ResCCe getResCCe() {
        return resCCe;
    }

    /**
     * Define o valor da propriedade resCCe.
     * 
     * @param value
     *     allowed object is
     *     {@link ResCCe }
     *     
     */
    public void setResCCe(ResCCe value) {
        this.resCCe = value;
    }

}
