//
// Este arquivo foi gerado pela Arquitetura JavaTM para Implementa��o de Refer�ncia (JAXB) de Bind XML, v2.2.8-b130911.1802 
// Consulte <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas as modifica��es neste arquivo ser�o perdidas ap�s a recompila��o do esquema de origem. 
// Gerado em: 2022.05.17 �s 11:30:23 AM GMT-03:00 
//

package com.manide.xml.envevento;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Tipo Evento
 * 
 * <p>
 * Classe Java de TEvento complex type.
 * 
 * <p>
 * O seguinte fragmento do esquema especifica o conte�do esperado contido dentro
 * desta classe.
 * 
 * <pre>
 * &lt;complexType name="TEvento">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="infEvento">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="cOrgao" type="{http://www.portalfiscal.inf.br/nfe}TCOrgaoIBGE"/>
 *                   &lt;element name="tpAmb" type="{http://www.portalfiscal.inf.br/nfe}TAmb"/>
 *                   &lt;choice>
 *                     &lt;element name="CNPJ" type="{http://www.portalfiscal.inf.br/nfe}TCnpjOpc"/>
 *                     &lt;element name="CPF" type="{http://www.portalfiscal.inf.br/nfe}TCpf"/>
 *                   &lt;/choice>
 *                   &lt;element name="chNFe" type="{http://www.portalfiscal.inf.br/nfe}TChNFe"/>
 *                   &lt;element name="dhEvento" type="{http://www.portalfiscal.inf.br/nfe}TDateTimeUTC"/>
 *                   &lt;element name="tpEvento">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;whiteSpace value="preserve"/>
 *                         &lt;pattern value="[0-9]{6}"/>
 *                         &lt;enumeration value="210200"/>
 *                         &lt;enumeration value="210210"/>
 *                         &lt;enumeration value="210220"/>
 *                         &lt;enumeration value="210240"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="nSeqEvento">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;whiteSpace value="preserve"/>
 *                         &lt;pattern value="[0-9]{1,2}"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="verEvento" type="{http://www.portalfiscal.inf.br/nfe}TVerEnvEvento"/>
 *                   &lt;element name="detEvento">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="descEvento">
 *                               &lt;simpleType>
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                                   &lt;whiteSpace value="preserve"/>
 *                                   &lt;enumeration value="Confirmacao da Operacao"/>
 *                                   &lt;enumeration value="Ciencia da Operacao"/>
 *                                   &lt;enumeration value="Desconhecimento da Operacao"/>
 *                                   &lt;enumeration value="Operacao nao Realizada"/>
 *                                 &lt;/restriction>
 *                               &lt;/simpleType>
 *                             &lt;/element>
 *                             &lt;element name="xJust" minOccurs="0">
 *                               &lt;simpleType>
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                                   &lt;whiteSpace value="preserve"/>
 *                                   &lt;minLength value="15"/>
 *                                   &lt;maxLength value="255"/>
 *                                   &lt;pattern value="[!-�]{1}[ -�]{0,}[!-�]{1}|[!-�]{1}"/>
 *                                 &lt;/restriction>
 *                               &lt;/simpleType>
 *                             &lt;/element>
 *                           &lt;/sequence>
 *                           &lt;attribute name="versao" use="required">
 *                             &lt;simpleType>
 *                               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                                 &lt;whiteSpace value="preserve"/>
 *                                 &lt;enumeration value="1.00"/>
 *                               &lt;/restriction>
 *                             &lt;/simpleType>
 *                           &lt;/attribute>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *                 &lt;attribute name="Id" use="required">
 *                   &lt;simpleType>
 *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}ID">
 *                       &lt;pattern value="ID[0-9]{52}"/>
 *                     &lt;/restriction>
 *                   &lt;/simpleType>
 *                 &lt;/attribute>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element ref="{http://www.w3.org/2000/09/xmldsig#}Signature"/>
 *       &lt;/sequence>
 *       &lt;attribute name="versao" use="required" type="{http://www.portalfiscal.inf.br/nfe}TVerEvento" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TEvento", namespace = "http://www.portalfiscal.inf.br/nfe", propOrder = { "infEvento", "signature" })
public class TEvento {

    @XmlElement(required = true)
    protected InfEvento infEvento;

    @XmlElement(name = "Signature", required = true)
    protected SignatureType signature;
    @XmlAttribute(name = "versao", required = true)
    protected String versao;

    /**
     * Obt�m o valor da propriedade infEvento.
     * 
     * @return possible object is {@link InfEvento }
     * 
     */
    public InfEvento getInfEvento() {
	return infEvento;
    }

    /**
     * Define o valor da propriedade infEvento.
     * 
     * @param value allowed object is {@link InfEvento }
     * 
     */
    public void setInfEvento(InfEvento value) {
	this.infEvento = value;
    }

    /**
     * Obt�m o valor da propriedade signature.
     * 
     * @return possible object is {@link SignatureType }
     * 
     */
    public SignatureType getSignature() {
	return signature;
    }

    /**
     * Define o valor da propriedade signature.
     * 
     * @param value allowed object is {@link SignatureType }
     * 
     */
    public void setSignature(SignatureType value) {
	this.signature = value;
    }

    /**
     * Obt�m o valor da propriedade versao.
     * 
     * @return possible object is {@link String }
     * 
     */
    public String getVersao() {
	return versao;
    }

    /**
     * Define o valor da propriedade versao.
     * 
     * @param value allowed object is {@link String }
     * 
     */
    public void setVersao(String value) {
	this.versao = value;
    }

}
