package com.manide.util;

import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;

import br.inf.portalfiscal.nfe.EnvEventoDocument;

public abstract class UtilXml {
    private static String XML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";
    private static final String SCHEMA_LANGUAGE = "http://www.w3.org/2001/XMLSchema";

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

    private static List<String> getTagConteudo(String xml, String nomeTag, boolean incluirTag, boolean decodeSpecialChars) {
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

    public static Document createDocument(byte[] xml) throws Exception {
	SchemaFactory xsdFactory = SchemaFactory.newInstance(SCHEMA_LANGUAGE);
	Schema schema = xsdFactory.newSchema(UtilXml.class.getResource("/Evento_ManifestaDest_PL_v1.01/envConfRecebto_v1.00.xsd"));
	DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
	documentBuilderFactory.setSchema(schema);
	documentBuilderFactory.setNamespaceAware(true);
	documentBuilderFactory.setValidating(false);
	Document document = documentBuilderFactory.newDocumentBuilder().parse(new InputSource(new InputStreamReader(new ByteArrayInputStream(xml))));
	return document;
    }

}
