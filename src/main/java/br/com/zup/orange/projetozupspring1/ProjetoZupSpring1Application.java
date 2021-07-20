package br.com.zup.orange.projetozupspring1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

@EnableSpringDataWebSupport // Para habilitar paginação
@EnableCaching // Para habilitar uso de cache
@SpringBootApplication
public class ProjetoZupSpring1Application {

	public static void main(String[] args) {
		SpringApplication.run(ProjetoZupSpring1Application.class, args);
	}

}
