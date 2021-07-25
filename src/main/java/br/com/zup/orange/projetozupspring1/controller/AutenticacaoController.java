package br.com.zup.orange.projetozupspring1.controller;

import br.com.zup.orange.projetozupspring1.config.security.GeraTokenService;
import br.com.zup.orange.projetozupspring1.dto.TokenDTO;
import br.com.zup.orange.projetozupspring1.form.LoginForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/auth")
@Profile("prod")
public class AutenticacaoController {

    @Autowired
    private AuthenticationManager authManager;

    @Autowired
    private GeraTokenService geraTokenService;

    //Método para implementar a lógica de autenticação
    @PostMapping
    public ResponseEntity<TokenDTO> autenticar(@RequestBody @Valid LoginForm loginForm) {
        UsernamePasswordAuthenticationToken dadosLogin = loginForm.converter();

        try {
            //O Spring sabe chamar a nossa classe de autenticação(AutenticacaoService) e validar logine senha.
            Authentication authentication = authManager.authenticate(dadosLogin);

            //Gerar o token para retornar ao cliente
            String token = geraTokenService.gerarToken(authentication);

            //Retornar o Token por maio de um DTO + o tipo de autenticação "Bearer"
            return ResponseEntity.ok(new TokenDTO(token, "Bearer"));
        } catch (AuthenticationException e){
            return ResponseEntity.badRequest().build();
        }
    }
}
