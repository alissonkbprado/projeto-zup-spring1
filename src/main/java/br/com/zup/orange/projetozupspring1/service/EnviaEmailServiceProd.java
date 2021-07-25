package br.com.zup.orange.projetozupspring1.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("prod")
@Qualifier("enviaEmailProdPadrao")
public class EnviaEmailServiceProd implements EnviaEmail {

    public void envia(String email){
        System.out.println("Email enviado: " + email);
    }

}
