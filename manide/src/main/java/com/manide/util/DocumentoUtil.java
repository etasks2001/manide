package com.manide.util;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.security.Key;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.cert.X509Certificate;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.crypto.dsig.Reference;
import javax.xml.crypto.dsig.XMLSignature;
import javax.xml.crypto.dsig.XMLSignatureFactory;
import javax.xml.crypto.dsig.dom.DOMValidateContext;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

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
	envEvento.setVersao("1.00");
	envEvento.setIdLote(String.valueOf((new Date()).getTime()));
	envEventoDocument.setEnvEvento(envEvento);
	return envEventoDocument;
    }

    private static String criarXMLEnvioEventoManifestacao() {
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

	String idInfEvento = "ID0123456789012345678901234567890123456789012345678911";
	infEvento.setId(idInfEvento);
	TEvento.InfEvento.DetEvento detEvento = TEvento.InfEvento.DetEvento.Factory.newInstance();
	detEvento.setXJust("justificativa de manifestacao do destinatario");
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

    public String xmlAssinado() throws Exception {
	String constant = "http://www.w3.org/2001/XMLSchema";
	SchemaFactory xsdFactory = SchemaFactory.newInstance(constant);
	Schema schema = xsdFactory.newSchema(getClass().getResource("/Evento_ManifestaDest_PL_v1.01/envConfRecebto_v1.00.xsd"));
	DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
	documentBuilderFactory.setSchema(schema);
	documentBuilderFactory.setNamespaceAware(true);
	documentBuilderFactory.setValidating(false);
	Document document = documentBuilderFactory.newDocumentBuilder()
		.parse(new InputSource(new InputStreamReader(new ByteArrayInputStream(DocumentoUtil.criarXMLEnvioEventoManifestacao().getBytes()))));

	KeyStore rep = KeyStore.getInstance("PKCS12");
	rep.load(new FileInputStream(new File("C:\\x\\franco\\fdasfdsa.pfx")), "448006".toCharArray());

	String alias = null;
	Enumeration<String> aliases = rep.aliases();

	while (aliases.hasMoreElements()) {
	    alias = aliases.nextElement();
	}
	X509Certificate certificate = (X509Certificate) rep.getCertificate(alias);

	PrivateKey privateKey = null;
	Key chavePrivada = (Key) rep.getKey(alias, "448006".toCharArray());
	if (chavePrivada instanceof PrivateKey) {
	    privateKey = (PrivateKey) chavePrivada;
	}

	Certificado certificado = new Certificado();
	String xmlAssinado = certificado.assinarXML(certificate, privateKey, "ID0123456789012345678901234567890123456789012345678911", document, "evento");
	Document documentAssinado = documentBuilderFactory.newDocumentBuilder().parse(new InputSource(new InputStreamReader(new ByteArrayInputStream(xmlAssinado.getBytes()))));
	boolean isAssinaturaValida = validarAssinaturaXML(documentAssinado);
	if (!isAssinaturaValida)
	    throw new Exception("Assinatura inválida evento!");
	return xmlAssinado;
    }

    public boolean validarAssinaturaXML(Document document) throws Exception {
	int indexSignature = 0;
	boolean coreValidity = false;
	try {
	    NodeList nl = document.getElementsByTagNameNS(XMLSignature.XMLNS, "Signature");
	    if (nl.getLength() == 0)
		throw new Exception("O documento não está assinado.");
	    XMLSignatureFactory fac = XMLSignatureFactory.getInstance("DOM");
	    DOMValidateContext valContext = null;
	    XMLSignature signature = null;
	    do {
		valContext = new DOMValidateContext(new KeyValueKeySelector(), nl.item(indexSignature++));
		signature = fac.unmarshalXMLSignature(valContext);
		coreValidity = signature.validate(valContext);
	    } while (coreValidity && indexSignature < nl.getLength());
	} catch (Exception e) {

	    throw new Exception("Ocorreu um problema durante a validação assinatura");
	}

	return coreValidity;
    }

    public boolean validarAssinaturaXML2(Document document) throws Exception {
	NodeList nl = document.getElementsByTagNameNS(XMLSignature.XMLNS, "Signature");
	if (nl.getLength() == 0)
	    throw new Exception("O documento não está assinado.");
	XMLSignatureFactory fac = XMLSignatureFactory.getInstance("DOM");
	DOMValidateContext valContext = null;
	XMLSignature signature = null;
	boolean coreValidity = false;
	valContext = new DOMValidateContext(new X509KeySelector(), nl.item(0));
	signature = fac.unmarshalXMLSignature(valContext);
	coreValidity = signature.validate(valContext);
	if (coreValidity == false) {
	    System.err.println("Signature failed core validation");
	    boolean sv = signature.getSignatureValue().validate(valContext);
	    System.out.println("signature validation status: " + sv);
	    if (sv == false) {
		// Check the validation status of each Reference.
		Iterator<?> i = signature.getSignedInfo().getReferences().iterator();
		for (int j = 0; i.hasNext();) {
		    boolean refValid = ((Reference) i.next()).validate(valContext);
		    System.out.println("ref[" + j + "] validity status: " + refValid);
		    return refValid;
		}
	    }
	} else {
	    return true;
	}
	return false;

    }

}
