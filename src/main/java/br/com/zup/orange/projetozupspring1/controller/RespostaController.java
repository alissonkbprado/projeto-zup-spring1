package br.com.zup.orange.projetozupspring1.controller;

import br.com.zup.orange.projetozupspring1.dto.RespostaTodosDto;
import br.com.zup.orange.projetozupspring1.form.RespostaForm;
import br.com.zup.orange.projetozupspring1.modelo.Aluno;
import br.com.zup.orange.projetozupspring1.modelo.Resposta;
import br.com.zup.orange.projetozupspring1.repository.AlunoRepository;
import br.com.zup.orange.projetozupspring1.repository.AvaliacaoRepository;
import br.com.zup.orange.projetozupspring1.repository.RespostaRepository;
import br.com.zup.orange.projetozupspring1.service.EnviaEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/resposta")
public class RespostaController {

    @Autowired
    private RespostaRepository respostaRepository;

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    EnviaEmailService enviaEmailService;

    @Autowired
    private Environment environment;

    @Autowired
    private AvaliacaoRepository avaliacaoRepository;

    @GetMapping
    public Page<RespostaTodosDto>  lista(@PageableDefault(sort = "id",
                                         direction = Sort.Direction.ASC,
                                         page = 0,
                                         size = 100) Pageable paginacao) {
        Page<Resposta> respostaList;

        respostaList = respostaRepository.findAll(paginacao);

        return RespostaTodosDto.converter(respostaList);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<?> cadastrar(@RequestBody @Valid RespostaForm respostaForm){

        Boolean dadosOk = respostaForm.verifica(alunoRepository, avaliacaoRepository);

        if(!dadosOk){
            return ResponseEntity.badRequest().build();
        }

        Resposta resposta = respostaForm.toEntity();

        respostaRepository.save(resposta);

        List<String> profile = Arrays.asList(environment.getActiveProfiles());

        Aluno aluno = alunoRepository.findById(resposta.getAluno().getId()).get();

        if(profile.contains("prod")){
            enviaEmailService.enviEmail(aluno.getEmail());
        } else {
            System.out.println("Teste envio de email: " + aluno.getEmail());
        }

        return ResponseEntity.status(201).build();

    }

}
