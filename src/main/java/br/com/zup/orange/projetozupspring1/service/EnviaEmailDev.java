package br.com.zup.orange.projetozupspring1.service;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@Profile("dev")
public class EnviaEmailDev implements EnviaEmail {

    public void envia(String email){
        System.out.println("Teste envio de email: " + email);
    }

}
