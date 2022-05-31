package com.manide.util;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.inf.portalfiscal.nfe.EnvEventoDocument;
import br.inf.portalfiscal.nfe.TAmb;
import br.inf.portalfiscal.nfe.TCOrgaoIBGE;
import br.inf.portalfiscal.nfe.TEnvEvento;
import br.inf.portalfiscal.nfe.TEvento;

@Component
public class EventoManifestacaoDestinatario {

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
	EnvEventoDocument envEventoDocument = criarDocumentoEnvioEventos();
	TEvento evento = envEventoDocument.getEnvEvento().addNewEvento();
	evento.setVersao("1.00");

	TEvento.InfEvento infEvento = evento.addNewInfEvento();
	infEvento.setTpAmb(TAmb.X_1);
	infEvento.setTpEvento(TEvento.InfEvento.TpEvento.X_210200);
	infEvento.setNSeqEvento(String.valueOf(1));
	infEvento.setVerEvento("1.00");
	infEvento.setChNFe("01234567890123456789012345678901234567891234");
	infEvento.setCNPJ("11222333000199");
	infEvento.setCOrgao(TCOrgaoIBGE.X_91);
	infEvento.setDhEvento(util.getDh());

	String idInfEvento = "ID0123456789012345678901234567890123456789012345678911";
	infEvento.setId(idInfEvento);

	TEvento.InfEvento.DetEvento detEvento = TEvento.InfEvento.DetEvento.Factory.newInstance();
	detEvento.setXJust("justificativa de manifestacao do destinatario");
	detEvento.setVersao(TEvento.InfEvento.DetEvento.Versao.X_1_00);
	detEvento.setDescEvento(TEvento.InfEvento.DetEvento.DescEvento.CIENCIA_DA_OPERACAO);
	infEvento.setDetEvento(detEvento);
	evento.setInfEvento(infEvento);

	String xmlEnvEvento = utilXml.getDocumentString(envEventoDocument, true);

//	xmlEnvEvento = xmlEnvEvento.replaceFirst("<detEvento/>", "<detEvento versao= \"" + "1.00" + "\"/>");
	return xmlEnvEvento;
//	return utilXml.alterarTagConteudo(xmlEnvEvento, "detEvento", utilXml.getFirstTagConteudo(utilXml.getDocumentString(envEventoDocument, false), "detEvento", false, false));
    }

}
