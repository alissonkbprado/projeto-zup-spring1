package br.com.zup.orange.projetozupspring1.config.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@Configuration
@Profile("dev")
public class SecurityConfigurationsDev extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/**").permitAll()
                .and().csrf().disable(); //desabilitar verificação de segunrançã desnecessária em autenticações sem sessão
    }

    //Configurações de recursos estáticos (css, js, imagens)
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/**.html", "/v2/api-docs", "/webjars/**", "/configuration/**", "/swagger-resources/**");
    }

    //gerar hash da senha
    /*public static void main(String[] args) {
        System.out.println(new BCryptPasswordEncoder().encode("123456"));
        $2a$10$eiYvvAwH805y6uvWqs9Cr.WRsO0CUjKBQBu.wtUgSC3eAVttVoOF2
    }*/
}
