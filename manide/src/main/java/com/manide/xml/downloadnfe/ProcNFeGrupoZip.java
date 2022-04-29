
package com.manide.xml.downloadnfe;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "nFeZip", "protNFeZip" })
public class ProcNFeGrupoZip {

    @XmlElement(name = "NFeZip", required = true)
    protected byte[] nFeZip;
    @XmlElement(required = true)
    protected byte[] protNFeZip;

    public byte[] getNFeZip() {
	return nFeZip;
    }

    public void setNFeZip(byte[] value) {
	this.nFeZip = value;
    }

    public byte[] getProtNFeZip() {
	return protNFeZip;
    }

    public void setProtNFeZip(byte[] value) {
	this.protNFeZip = value;
    }

}
