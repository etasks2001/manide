//
// Este arquivo foi gerado pela Arquitetura JavaTM para Implementação de Referência (JAXB) de Bind XML, v2.2.8-b130911.1802 
// Consulte <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas as modificações neste arquivo serão perdidas após a recompilação do esquema de origem. 
// Gerado em: 2022.04.29 às 10:54:59 AM GMT-03:00 
//


package com.manide.xml.downloadnfe;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.manide.xml.downloadnfe package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _DownloadNFe_QNAME = new QName("http://www.portalfiscal.inf.br/nfe", "downloadNFe");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.manide.xml.downloadnfe
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link TDownloadNFe }
     * 
     */
    public TDownloadNFe createTDownloadNFe() {
        return new TDownloadNFe();
    }

    /**
     * Create an instance of {@link TRetDownloadNFe }
     * 
     */
    public TRetDownloadNFe createTRetDownloadNFe() {
        return new TRetDownloadNFe();
    }

    /**
     * Create an instance of {@link RetNFe }
     * 
     */
    public RetNFe createRetNFe() {
        return new RetNFe();
    }

    /**
     * Create an instance of {@link ProcNFeGrupoZip }
     * 
     */
    public ProcNFeGrupoZip createProcNFeGrupoZip() {
        return new ProcNFeGrupoZip();
    }

    /**
     * Create an instance of {@link ProcNFe }
     * 
     */
    public ProcNFe createProcNFe() {
        return new ProcNFe();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TDownloadNFe }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.portalfiscal.inf.br/nfe", name = "downloadNFe")
    public JAXBElement<TDownloadNFe> createDownloadNFe(TDownloadNFe value) {
        return new JAXBElement<TDownloadNFe>(_DownloadNFe_QNAME, TDownloadNFe.class, null, value);
    }

}
