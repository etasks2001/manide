@XmlSchema(namespace = "http://www.w3.org/2000/09/xmldsig#", elementFormDefault = QUALIFIED, xmlns = { @XmlNs(prefix = "s", namespaceURI = "http://www.portalfiscal.inf.br/nf") })

//@XmlSchema(namespace = "http://www.w3.org/2000/09/xmldsig#",
//elementFormDefault = XmlNsForm.QUALIFIED,
//xmlns = @XmlNs(prefix = "", namespaceURI = "http://Foo/bar"))

package com.manide.xml.evento;

import static javax.xml.bind.annotation.XmlNsForm.QUALIFIED;

import javax.xml.bind.annotation.XmlNs;
import javax.xml.bind.annotation.XmlSchema;
