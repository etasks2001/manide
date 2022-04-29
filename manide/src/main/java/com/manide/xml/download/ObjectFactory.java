package com.manide.xml.download;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

import com.manide.xml.download.entrada.TDownloadNFe;
import com.manide.xml.download.retorno.ProcNFe;
import com.manide.xml.download.retorno.ProcNFeGrupoZip;
import com.manide.xml.download.retorno.RetNFe;
import com.manide.xml.download.retorno.TRetDownloadNFe;

@XmlRegistry
public class ObjectFactory {

    private final static QName _DownloadNFe_QNAME = new QName("http://www.portalfiscal.inf.br/nfe", "downloadNFe");

    public ObjectFactory() {
    }

    public TDownloadNFe createTDownloadNFe() {
	return new TDownloadNFe();
    }

    public TRetDownloadNFe createTRetDownloadNFe() {
	return new TRetDownloadNFe();
    }

    public RetNFe createRetNFe() {
	return new RetNFe();
    }

    public ProcNFeGrupoZip createProcNFeGrupoZip() {
	return new ProcNFeGrupoZip();
    }

    public ProcNFe createProcNFe() {
	return new ProcNFe();
    }

    @XmlElementDecl(namespace = "http://www.portalfiscal.inf.br/nfe", name = "downloadNFe")
    public JAXBElement<TDownloadNFe> createDownloadNFe(TDownloadNFe value) {
	return new JAXBElement<TDownloadNFe>(_DownloadNFe_QNAME, TDownloadNFe.class, null, value);
    }

}
