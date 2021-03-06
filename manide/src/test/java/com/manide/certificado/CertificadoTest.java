package com.manide.certificado;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.security.cert.CertificateEncodingException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.manide.exception.ManideException;

@SpringBootTest
@DisplayName("Certificado")
class CertificadoTest {

    @Autowired
    Certificado certificado;

    @Autowired
    KeyRepository keyRepository;

    @Test
    @DisplayName("Verificar se CNPJ é o mesmo do certificado")
    void test_localizadoCNPJ() throws CertificateEncodingException {

	assertThat(certificado.cnpjEncontrado(keyRepository.getCertificado(), "61130373000171"), is(Boolean.TRUE));

	ManideException exception = assertThrows(ManideException.class, () -> certificado.cnpjEncontrado(keyRepository.getCertificado(), "61130373000172"));
	assertThat(exception.getMessage(), is("CNPJ não encontrado."));

    }

}
