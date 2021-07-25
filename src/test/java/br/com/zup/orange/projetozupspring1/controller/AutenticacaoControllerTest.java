package br.com.zup.orange.projetozupspring1.controller;

import br.com.zup.orange.projetozupspring1.modelo.Usuario;
import br.com.zup.orange.projetozupspring1.repository.UsuarioRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.net.URI;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
class AutenticacaoControllerTest {

    //Simula uma requisição HTTP
    @Autowired
    MockMvc mockMvc;

    @Autowired
    UsuarioRepository usuarioRepository;

    @Test
    public void testaAutenticacaoComErro() throws Exception {
        URI uri = new URI("/auth");
        String json = "{\"email\":\"teste@zup.com.br\",\"senha\"=\"123456\"}";

        //simula a requisição
        mockMvc.perform(MockMvcRequestBuilders.post(uri)
                .content(json)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(400));
    }

//    @Test
//    public void testaAutenticacaoComSucesso() throws Exception {
//
//        Usuario usuario = new Usuario();
//        usuario.setNome("Alisson");
//        usuario.setEmail("alisson.prado@zup.com.br");
//        usuario.setSenha("$2a$10$1Gh7hksQa7IZyyu1KVTKruS8s1kOfFMwiYAkqfywKgaBmSprB/6By");
////        usuario.setSenha("123456");
//
//        usuarioRepository.save(usuario);
//
//        Usuario usuario1 = usuarioRepository.findById(1L).get();
//
//        Assertions.assertEquals("alisson.prado@zup.com.br", usuario1.getEmail());
////        Assertions.assertEquals("123456", usuario1.getSenha());
//
//        System.out.println("Usuario: " + usuario1.getEmail());
//        System.out.println("Senha: " + usuario1.getSenha());
//
//        URI uri = new URI("/auth");
//        String json = "{\"email\":\"alisson.prado@zup.com.br\",\"senha\"=\"123456\"}";
//
//        //simula a requisição
//        mockMvc.perform(MockMvcRequestBuilders.post(uri)
//                .content(json)
//                .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(MockMvcResultMatchers.status().is(200));
//    }

}