package com.manide.xml.bean;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.manide.util.Util;
import com.manide.xml.UtilXml;

import br.inf.portalfiscal.nfe.EnvEventoDocument;
import br.inf.portalfiscal.nfe.TAmb;
import br.inf.portalfiscal.nfe.TCOrgaoIBGE;
import br.inf.portalfiscal.nfe.TEnvEvento;
import br.inf.portalfiscal.nfe.TEvento;
import br.inf.portalfiscal.nfe.TEvento.InfEvento.DetEvento;
import br.inf.portalfiscal.nfe.TEvento.InfEvento.DetEvento.DescEvento.Enum;
import br.inf.portalfiscal.nfe.TEvento.InfEvento.DetEvento.Versao;
import br.inf.portalfiscal.nfe.TEvento.InfEvento.TpEvento;

@Component
public class EnvEventoFactory {

    @Autowired
    private Util util;

    @Autowired
    private UtilXml utilXml;

    private EnvEventoDocument criarDocumentoEnvioEventos() {
	EnvEventoDocument envEventoDocument = EnvEventoDocument.Factory.newInstance();

	TEnvEvento envEvento = envEventoDocument.addNewEnvEvento();

	envEvento.setVersao("1.00");
	envEvento.setIdLote(String.valueOf((new Date()).getTime()));

	envEventoDocument.setEnvEvento(envEvento);

	return envEventoDocument;
    }

    public String build() {
	String versaoEvento = "1.00";
	TAmb.Enum tpAmb = TAmb.X_1;
	TpEvento.Enum tpEvento = TpEvento.X_210200;
	String verEvento = "1.00";
	String chNFe = "01234567890123456789012345678901234567891234";
	String cnpj = "11222333000199";
	String idInfEvento = "ID0123456789012345678901234567890123456789012345678911";
	String xJust = "justificativa de manifestacao do destinatario";
	Versao.Enum detEventoVersao = Versao.X_1_00;
	Enum descEvento = TEvento.InfEvento.DetEvento.DescEvento.CIENCIA_DA_OPERACAO;

	EnvEventoDocument envEventoDocument = criarDocumentoEnvioEventos();

	TEvento evento = envEventoDocument.getEnvEvento().addNewEvento();
	evento.setVersao(versaoEvento);

	TEvento.InfEvento infEvento = evento.addNewInfEvento();
	infEvento.setTpAmb(tpAmb);
	infEvento.setTpEvento(tpEvento);
	infEvento.setNSeqEvento(String.valueOf(1));
	infEvento.setVerEvento(verEvento);
	infEvento.setChNFe(chNFe);
	infEvento.setCNPJ(cnpj);
	infEvento.setCOrgao(TCOrgaoIBGE.X_91);
	infEvento.setDhEvento(util.getDh());
	infEvento.setId(idInfEvento);

	DetEvento detEvento = DetEvento.Factory.newInstance();
	detEvento.setXJust(xJust);
	detEvento.setVersao(detEventoVersao);
	detEvento.setDescEvento(descEvento);
	infEvento.setDetEvento(detEvento);

	evento.setInfEvento(infEvento);

	String xmlEnvEvento = utilXml.getDocumentString(envEventoDocument, true);

	return xmlEnvEvento;
    }

}
