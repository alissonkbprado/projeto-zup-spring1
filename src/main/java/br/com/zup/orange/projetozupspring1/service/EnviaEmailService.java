package br.com.zup.orange.projetozupspring1.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
//@Profile("prod")
public class EnviaEmailService {

    public void enviEmail(String email){
        System.out.println("Email enviado: " + email);
    }

}
