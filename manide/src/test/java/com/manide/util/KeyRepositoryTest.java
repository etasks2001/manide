package com.manide.util;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.manide.certificado.KeyRepository;
import com.manide.exception.ManideException;

@SpringBootTest
@DisplayName("Key Repository")
class KeyRepositoryTest {

    @Test
    @DisplayName("Arquivo não encontrado")
    void test_arquivo_nao_encontrado() {

	ManideException exception = Assertions.assertThrows(ManideException.class, () -> new KeyRepository("./mde", "".toCharArray()));

	MatcherAssert.assertThat(exception.getMessage(), Matchers.is("Verifique o seu certificado. Pode ser caminho, senha ou nome."));
    }

}
