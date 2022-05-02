package com.manide;

import org.springframework.stereotype.Component;

import com.manide.xml.TAmb;
import com.manide.xml.TCOrgaoIBGE;
import com.manide.xml.evento.entrada.DetEvento;
import com.manide.xml.evento.entrada.InfEvento;
import com.manide.xml.evento.entrada.TEnvEvento;
import com.manide.xml.evento.entrada.TEvento;

@Component
public class FactoryXmlTest {
	private static final String VERSAO = "1.00";

	public TEnvEvento createEvent() {

		TEvento evento = new TEvento();
		evento.setVersao(VERSAO);

		InfEvento infEvento = new InfEvento();
		infEvento.setId("1");
		infEvento.setCOrgao(TCOrgaoIBGE.SP);
		infEvento.setTpAmb(TAmb.HOMOLOGACAO);
		infEvento.setCNPJ("11222333000199");
		infEvento.setChNFe("01234567890123456789012345678901234567890123");
		infEvento.setDhEvento("2010-08-19T13:00:15-03:00");
		infEvento.setTpEvento("210200");
		infEvento.setNSeqEvento("1");
		infEvento.setVerEvento(VERSAO);

		DetEvento detEvento = new DetEvento();
		detEvento.setVersao(VERSAO);
		detEvento.setDescEvento("Confirmacao da Operacao");
		detEvento.setXJust("pedido não foi realizado");

		infEvento.setDetEvento(detEvento);

		evento.setInfEvento(infEvento);

		TEnvEvento envEvento = new TEnvEvento();
		envEvento.setVersao(VERSAO);
		envEvento.setIdLote("1");
		envEvento.addEvento(evento);

		return envEvento;

	}

}
