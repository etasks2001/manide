package com.manide.util;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;

import br.inf.portalfiscal.nfe.EnvEventoDocument;
import br.inf.portalfiscal.nfe.TAmb;
import br.inf.portalfiscal.nfe.TCOrgaoIBGE;
import br.inf.portalfiscal.nfe.TEnvEvento;
import br.inf.portalfiscal.nfe.TEvento;

public class DocumentoUtil {
    private static String XML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";

    public static EnvEventoDocument criarDocumentoEnvioEventos() {
	EnvEventoDocument envEventoDocument = EnvEventoDocument.Factory.newInstance();
	TEnvEvento envEvento = envEventoDocument.addNewEnvEvento();
	envEvento.setVersao("2");
	envEvento.setIdLote(String.valueOf((new Date()).getTime()));
	envEventoDocument.setEnvEvento(envEvento);
	return envEventoDocument;
    }

    public static String criarXMLEnvioEventoManifestacao() {
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
	String timezone = new SimpleDateFormat("Z").format(new Date());
	timezone = timezone.substring(0, timezone.length() - 2) + ":" + timezone.substring(timezone.length() - 2, timezone.length());
	infEvento.setDhEvento(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").format(new Date()) + timezone);

	String idInfEvento = "";
	infEvento.setId(idInfEvento);
	TEvento.InfEvento.DetEvento detEvento = TEvento.InfEvento.DetEvento.Factory.newInstance();
	detEvento.setXJust("eventoTO.getxDetalheEvento()");
	detEvento.setVersao(TEvento.InfEvento.DetEvento.Versao.X_1_00);
	detEvento.setDescEvento(TEvento.InfEvento.DetEvento.DescEvento.CIENCIA_DA_OPERACAO);
	infEvento.setDetEvento(detEvento);
	evento.setInfEvento(infEvento);
	String xmlEnvEvento = getDocumentString(envEventoDocument, true);
	xmlEnvEvento = xmlEnvEvento.replaceFirst("<detEvento/>", "<detEvento versao= \"" + "1.00" + "\"/>");
	return alterarTagConteudo(xmlEnvEvento, "detEvento", getFirstTagConteudo(getDocumentString(envEventoDocument, false), "detEvento", false, false));
    }

    public static String alterarTagConteudo(String xml, String tagName, String newValue) {
	Matcher matcher = Pattern.compile("(<\\s*" + tagName + "(?:\\s[^<]*)?)(?:/\\s*)>").matcher(xml);
	if (matcher.find())
	    return xml.substring(0, matcher.start()) + matcher.group(1) + ">" + newValue + "</" + tagName + ">" + xml.substring(matcher.end(), xml.length());
	matcher = Pattern.compile("(<\\s*" + tagName + "(?:\\s[^<]*)?>)(?:.*)(?:</" + tagName + "\\s*>)").matcher(xml);
	if (matcher.find())
	    return xml.substring(0, matcher.start()) + matcher.group(1) + newValue + "</" + tagName + ">" + xml.substring(matcher.end(), xml.length());
	return xml;
    }

    public static String getDocumentString(Object document, boolean xmlDeclaration) {
	XmlOptions xmlOptions = new XmlOptions();
	xmlOptions.setUseDefaultNamespace();
	xmlOptions.setSaveAggressiveNamespaces();
	xmlOptions.setDocumentType(EnvEventoDocument.type);
	return xmlDeclaration ? (XML + ((XmlObject) document).xmlText(xmlOptions)) : ((XmlObject) document).xmlText(xmlOptions);
    }

    public static String getFirstTagConteudo(String xml, String nomeTag, boolean incluirTag, boolean decodeSpecialChars) {
	List<String> list = getTagConteudo(xml, nomeTag, incluirTag, decodeSpecialChars);
	if (list != null && !list.isEmpty())
	    return list.get(0);
	return null;
    }

    public static List<String> getTagConteudo(String xml, String nomeTag, boolean incluirTag, boolean decodeSpecialChars) {
	if (xml == null || nomeTag == null)
	    return null;
	List<String> tags = new ArrayList<>();
	String regex = "(<\\s*[/]{0,1}\\s*#NOME_TAG#(\\s+[^<]*|\\s*)>|<\\s*#NOME_TAG#(\\s+[^<]*|\\s*)/{0,1}\\s*>)".replace("#NOME_TAG#", nomeTag);
	Matcher matcher = Pattern.compile(regex).matcher(xml);
	int start = 0;
	int end = 0;
	int diff = incluirTag ? 1 : 0;
	String group = null;
	while (matcher.find(start)) {
	    if (incluirTag) {
		start = matcher.start();
	    } else {
		start = matcher.end();
	    }
	    group = matcher.group();
	    if (Pattern.matches("<[^><]*/\\s*>", group)) {
		if (incluirTag) {
		    tags.add(code(group, decodeSpecialChars));
		    start += diff;
		}
		continue;
	    }
	    matcher.find(start + diff);
	    if (incluirTag) {
		end = matcher.end();
	    } else {
		end = matcher.start();
	    }
	    tags.add(code(xml.substring(start, end), decodeSpecialChars));
	    start = matcher.end();
	}
	return tags.isEmpty() ? null : tags;
    }

    private static String code(String str, boolean decodeSpecialChars) {
	if (str == null)
	    return null;
	Matcher cDataMatcher = Pattern.compile("<!\\[CDATA\\[(.*)\\]\\]").matcher(str);
	if (cDataMatcher.find()) {
	    String conteudoCDATA = cDataMatcher.group(1);
	    if (!decodeSpecialChars)
		return encodeSpecialXMLChars(conteudoCDATA);
	    return conteudoCDATA;
	}
	return decodeSpecialChars ? decodeSpecialXMLChars(str) : str;
    }

    public static String encodeSpecialXMLChars(String str) {
	if (str == null)
	    return null;
	return str.replaceAll("&", "&amp;").replaceAll("<", "&lt;").replaceAll(">", "&gt;").replaceAll("\"", "&quot;").replaceAll("'", "&#39;");
    }

    public static String decodeSpecialXMLChars(String str) {
	if (str == null)
	    return null;
	return str.replaceAll("&amp;", "&").replaceAll("&lt;", "<").replaceAll("&gt;", ">").replaceAll("&quot;", "\"").replaceAll("&#39;", "'");
    }

}
