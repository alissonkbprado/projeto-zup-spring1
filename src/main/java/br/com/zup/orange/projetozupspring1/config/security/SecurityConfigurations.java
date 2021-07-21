package br.com.zup.orange.projetozupspring1.config.security;

import br.com.zup.orange.projetozupspring1.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
@Configuration
public class SecurityConfigurations extends WebSecurityConfigurerAdapter {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    AutenticacaoService autenticacaoService;

    @Autowired
    GeraTokenService geraTokenService;

    @Override
    @Bean
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    //Configurações de Autenticação
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(autenticacaoService).passwordEncoder(new BCryptPasswordEncoder());
    }

    //Configurações de Autorização usando JSON Web Token JWT
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers(HttpMethod.GET, "/aluno").permitAll()
                .antMatchers(HttpMethod.GET, "/aluno/*").permitAll()
                .antMatchers(HttpMethod.GET, "/resposta").hasRole("MENTOR")
                .antMatchers(HttpMethod.POST, "/resposta").permitAll()
                .antMatchers(HttpMethod.POST, "/auth").permitAll()
                .anyRequest().authenticated() // Qualquer outra requisição deverá ser autenticadas
                .and().csrf().disable() //desabilitar verificação de segunrançã desnecessária em autenticações sem sessão
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and().addFilterBefore(new AutenticacaoViaTokenFilter(geraTokenService, usuarioRepository), UsernamePasswordAuthenticationFilter.class);
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
