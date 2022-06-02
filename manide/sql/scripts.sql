﻿drop table XMLTEST

CREATE TABLE XMLTEST (
	id serial,
	Name XML

)

do $$
begin
   for cnt in 1..50000 loop
    INSERT INTO XMLTEST (name) VALUES ('<?xml version="1.0" encoding="UTF-8"?><envEvento xmlns="http://www.portalfiscal.inf.br/nfe" versao="1.00"><idLote>1654176998153</idLote><evento versao="1.00"><infEvento Id="ID0123456789012345678901234567890123456789012345678911"><cOrgao>91</cOrgao><tpAmb>1</tpAmb><CNPJ>11222333000199</CNPJ><chNFe>01234567890123456789012345678901234567891234</chNFe><dhEvento>2022-06-02T10:36:38-03:00</dhEvento><tpEvento>210200</tpEvento><nSeqEvento>1</nSeqEvento><verEvento>1.00</verEvento><detEvento versao="1.00"><descEvento>Ciencia da Operacao</descEvento><xJust>justificativa de manifestacao do destinatario alteradao</xJust></detEvento></infEvento><Signature xmlns="http://www.w3.org/2000/09/xmldsig#"><SignedInfo><CanonicalizationMethod Algorithm="http://www.w3.org/TR/2001/REC-xml-c14n-20010315"/><SignatureMethod Algorithm="http://www.w3.org/2000/09/xmldsig#rsa-sha1"/><Reference URI="#ID0123456789012345678901234567890123456789012345678911"><Transforms><Transform Algorithm="http://www.w3.org/2000/09/xmldsig#enveloped-signature"/><Transform Algorithm="http://www.w3.org/TR/2001/REC-xml-c14n-20010315"/></Transforms><DigestMethod Algorithm="http://www.w3.org/2000/09/xmldsig#sha1"/><DigestValue>D29Q88OPGMWFjs/tSL0joPZTDsU=</DigestValue></Reference></SignedInfo><SignatureValue>h/I9BIx6mLjd2fcmMDn8q+jpE6iHLN21dqEujLY10JDGOf2XBoCfeFl5x0JrR8EeqV3erwAJM1x1 0etBJckvVNm90A8SibCSfTWV83CkcYScxHFEr/gXnBg9CGAMxXB6m9msGG3PZJs0HD43nWlkaJXv lDIxPxflMl9ag7UtU3TmJORETscPhLvblaGkSWSofbpZz6uhuPVAVJxVo7K1kQhHMPa+I4AwOnrH jo9mGzdWm6v6/4IttA4lloQtShhfzuQS9d2RopXgmklccy28DEh8OScXz/T6XvPO3c3oISBSFnKO /HShy/FEZa3H3v2HmmAfZYrTBDNjAQCz6fKVlw==</SignatureValue><KeyInfo><X509Data><X509Certificate>MIIIJDCCBgygAwIBAgIQFeQRSqFhGjJWesdsI/2ckTANBgkqhkiG9w0BAQsFADB4MQswCQYDVQQG EwJCUjETMBEGA1UEChMKSUNQLUJyYXNpbDE2MDQGA1UECxMtU2VjcmV0YXJpYSBkYSBSZWNlaXRh IEZlZGVyYWwgZG8gQnJhc2lsIC0gUkZCMRwwGgYDVQQDExNBQyBDZXJ0aXNpZ24gUkZCIEc1MB4X DTIyMDEzMTEzNDA0NVoXDTIzMDEzMTEzNDA0NVowggESMQswCQYDVQQGEwJCUjETMBEGA1UECgwK SUNQLUJyYXNpbDELMAkGA1UECAwCU1AxEjAQBgNVBAcMCVNhbyBQYXVsbzEZMBcGA1UECwwQVmlk ZW9Db25mZXJlbmNpYTEXMBUGA1UECwwOMTQzOTc1ODgwMDAxNzMxNjA0BgNVBAsMLVNlY3JldGFy aWEgZGEgUmVjZWl0YSBGZWRlcmFsIGRvIEJyYXNpbCAtIFJGQjEWMBQGA1UECwwNUkZCIGUtQ05Q SiBBMTFJMEcGA1UEAwxARlJBTkNPIFNVSVNTQSBJTVBPUlRBQ0FPIEVYUE9SVEFDQU8gRSBSRVBS RVNFTlRBQzo2MTEzMDM3MzAwMDE3MTCCASIwDQYJKoZIhvcNAQEBBQADggEPADCCAQoCggEBALR0 F9AZeuDN4cSduG1lHEj4NqTabwQOPSKhuLH1U4US1UygzfOaqLMA8hFusGdTx8wXkhrVL4Bc40nD hU93kwj/knawUJgRd9PPsYZ3y3pulFlTWrE27hFJcqD4P+8aRYLV4lza7vAteTaS43O4DMYfeILD e6i7HYJBVnYugbIWESkkyGCAhToLu9YpO5kRqgvXDfU++g3rKLdRQVjzN1YDzMJy7VZBUF87NDlp 2jm74ok+1L6nI7nhvz8kXjYyEa2s7g4s51UAyn82RFgNgKIXfX0oZvW2Yy4BdSd8HLaHX7GpYGjF fJI/QEbBdG///UmE+KHD3aUoTloL8R+VflcCAwEAAaOCAwwwggMIMIG7BgNVHREEgbMwgbCgPQYF YEwBAwSgNAQyMDIwNDE5NjYwNzYyNjU2MjgwMTAwMDAwMDAwMDAwMDAwMDAwMTMwMjIzMzM1U1NQ U1CgHwYFYEwBAwKgFgQUQ0xBVURJQSBNT05JQ0EgU1JPVVKgGQYFYEwBAwOgEAQONjExMzAzNzMw MDAxNzGgFwYFYEwBAwegDgQMMDAwMDAwMDAwMDAwgRpPTElOREFARlJBTkNPU1VJU1NBLkNPTS5C UjAJBgNVHRMEAjAAMB8GA1UdIwQYMBaAFFN9f52+0WHQILran+OJpxNzWM1CMH8GA1UdIAR4MHYw dAYGYEwBAgEMMGowaAYIKwYBBQUHAgEWXGh0dHA6Ly9pY3AtYnJhc2lsLmNlcnRpc2lnbi5jb20u YnIvcmVwb3NpdG9yaW8vZHBjL0FDX0NlcnRpc2lnbl9SRkIvRFBDX0FDX0NlcnRpc2lnbl9SRkIu cGRmMIG8BgNVHR8EgbQwgbEwV6BVoFOGUWh0dHA6Ly9pY3AtYnJhc2lsLmNlcnRpc2lnbi5jb20u YnIvcmVwb3NpdG9yaW8vbGNyL0FDQ2VydGlzaWduUkZCRzUvTGF0ZXN0Q1JMLmNybDBWoFSgUoZQ aHR0cDovL2ljcC1icmFzaWwub3V0cmFsY3IuY29tLmJyL3JlcG9zaXRvcmlvL2xjci9BQ0NlcnRp c2lnblJGQkc1L0xhdGVzdENSTC5jcmwwDgYDVR0PAQH/BAQDAgXgMB0GA1UdJQQWMBQGCCsGAQUF BwMCBggrBgEFBQcDBDCBrAYIKwYBBQUHAQEEgZ8wgZwwXwYIKwYBBQUHMAKGU2h0dHA6Ly9pY3At YnJhc2lsLmNlcnRpc2lnbi5jb20uYnIvcmVwb3NpdG9yaW8vY2VydGlmaWNhZG9zL0FDX0NlcnRp c2lnbl9SRkJfRzUucDdjMDkGCCsGAQUFBzABhi1odHRwOi8vb2NzcC1hYy1jZXJ0aXNpZ24tcmZi LmNlcnRpc2lnbi5jb20uYnIwDQYJKoZIhvcNAQELBQADggIBALTtMZhzha8xelr/O1gN9MOdlF11 KjmgC/IvTlgrmkBH3fgyZQXYJLxBXw0Dn5Nu8zdY3pOk7+bqzJQW0ivs2h3nwLxkdJALcqbm1cjd /LNpOKcc53p9x1sufNYzbeuaJo8iFaQSCJA/l8eMYsbUaCY09sRufhg6OJlKla2RfTgEE8sP/gR+ WXZeGAdxuVg6jKKk6BPxcC1IJLi0TZBwuX2sSZboETEvrN9DEiC4SH+ZbigIrMaFNN/jHkbD0XQT FvSVSfYkKjSUeRd9PluMxdiZEbOYP1TGgGQzv1m5FINhOiZGfUHWxtgYsZ/GyUXY43UqxireUAnG EX2ZSLndxQ+IiraVOd0zgPwSwFpBOIQP823IgSiPHbKpSi+4utJ8EqNHyXkDv8H+CS0AQUA7WRWK xAHwARmyOeHoGY8R/vMKoU7lRSwXvvOq6Iy/aiEmtL4XuHAEMFdm57Ptd6LEuKo/X/xY0Jsg1jz5 l7BojiXFn4KJZvAj1FaNxir+R8sHQ13Bg9GISR1c2PXyIM6c+z77TVZBQIWMkIOGdFi8nFXF4cIj jkRLvoN7r/XvxyBJOBZ743dMtZNb/yeC9eTsxZqn7WhjnA48i/fyOpWJ1l1Hx78pxR0Xm6yzLDvc fB9eH1lsU6aqVUdMOtmIxac05VpZkyStarxlSZWadpP711V5</X509Certificate></X509Data></KeyInfo></Signature></evento></envEvento>');
   end loop;
end; $$


select * from xmltest where id = 50000
delete from xmltest




SELECT unnest(xpath('.//evento/infEvento/cOrgao/text()', Name::xml))::text AS XMLDATA FROM XMLTEST 





SELECT unnest(xpath('//id/text()', Name::XML)) AS Name FROM XMLTEST;



