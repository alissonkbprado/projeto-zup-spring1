package br.com.zup.orange.projetozupspring1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
class ProjetoZupSpring1ApplicationTests {

	@Test
	void contextLoads() {

		Assertions.assertTrue(true);
	}

}
