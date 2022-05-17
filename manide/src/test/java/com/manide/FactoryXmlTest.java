package com.manide;

import org.springframework.stereotype.Component;

import com.manide.xml.envevento.DetEvento;
import com.manide.xml.envevento.InfEvento;
import com.manide.xml.envevento.TAmb;
import com.manide.xml.envevento.TCOrgaoIBGE;
import com.manide.xml.envevento.TEnvEvento;
import com.manide.xml.envevento.TEvento;

@Component
public class FactoryXmlTest {
    private static final String VERSAO = "1.00";

    public TEnvEvento createEvent() {
	TEnvEvento envEvento = new TEnvEvento();
	envEvento.setVersao(VERSAO);
	envEvento.setIdLote("1");

	return envEvento;
    }

    public TEvento createEvento1() {
	TEvento evento = new TEvento();
	DetEvento detEvento = new DetEvento();
	InfEvento infEvento = new InfEvento();

	infEvento.setId("1");
	infEvento.setCOrgao(TCOrgaoIBGE.VALUE_20);
	infEvento.setTpAmb(TAmb.VALUE_2);
	infEvento.setCNPJ("11222333000199");
	infEvento.setChNFe("01234567890123456789012345678901234567890122");
	infEvento.setDhEvento("2010-08-19T13:00:15-03:00");
	infEvento.setTpEvento("210200");
	infEvento.setNSeqEvento("1");
	infEvento.setVerEvento(VERSAO);

	detEvento.setVersao(VERSAO);
	detEvento.setDescEvento("Confirmacao da Operacao");
	detEvento.setXJust("pedido nao foi realizado");

	infEvento.setDetEvento(detEvento);

	evento.setInfEvento(infEvento);
	evento.setVersao(VERSAO);

	return evento;
    }

    public TEvento createEvento2() {
	InfEvento infEvento = new InfEvento();
	TEvento evento = new TEvento();
	DetEvento detEvento = new DetEvento();

	infEvento.setId("2");
	infEvento.setCOrgao(TCOrgaoIBGE.VALUE_20);
	infEvento.setTpAmb(TAmb.VALUE_2);
	infEvento.setCNPJ("11222333000199");
	infEvento.setChNFe("01234567890123456789012345678901234567890123");
	infEvento.setDhEvento("2010-08-19T13:00:15-03:00");
	infEvento.setTpEvento("210200");
	infEvento.setNSeqEvento("2");
	infEvento.setVerEvento(VERSAO);

	detEvento.setVersao(VERSAO);
	detEvento.setDescEvento("Confirmacao da Operacao");
	detEvento.setXJust("pedido nao foi realizado");

	infEvento.setDetEvento(detEvento);

	evento.setVersao(VERSAO);
	evento.setInfEvento(infEvento);

	return evento;
    }

}