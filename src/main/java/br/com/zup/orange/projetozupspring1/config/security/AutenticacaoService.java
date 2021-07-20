package br.com.zup.orange.projetozupspring1.config.security;

import br.com.zup.orange.projetozupspring1.modelo.Usuario;
import br.com.zup.orange.projetozupspring1.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AutenticacaoService implements UserDetailsService {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

        Optional<Usuario> usuarioOptional = usuarioRepository.findByEmail(userName);

        System.out.println("Usuario: " + usuarioOptional);

        if(usuarioOptional.isPresent()){
            return usuarioOptional.get();
        }

        throw new UsernameNotFoundException("Login invalido");
    }
}
