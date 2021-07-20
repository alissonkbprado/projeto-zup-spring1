package br.com.zup.orange.projetozupspring1.controller;

import br.com.zup.orange.projetozupspring1.dto.AlunoDto;
import br.com.zup.orange.projetozupspring1.form.AlunoForm;
import br.com.zup.orange.projetozupspring1.modelo.Aluno;
import br.com.zup.orange.projetozupspring1.repository.AlunoRepository;
import br.com.zup.orange.projetozupspring1.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/aluno")
public class AlunoController {

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private AlunoService alunoService;

    @GetMapping
    @Cacheable(value = "listaDeAlunos")
    public Page<AlunoDto>  lista(@RequestParam(required = false) String nome,
                                 @PageableDefault(sort = "id",
                                         direction = Sort.Direction.ASC,
                                         page = 0,
                                         size = 100) Pageable paginacao) {

        Page<Aluno> alunoList;

        if(nome ==null) {
            alunoList = alunoRepository.findAll(paginacao);
        } else {
            alunoList = alunoRepository.findByNome(nome, paginacao);
        }

        return AlunoDto.converter(alunoList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AlunoDto> detalhar(@PathVariable Long id) {
        Optional<Aluno> alunoOptional = alunoRepository.findById(id);

        if(alunoOptional.isPresent()){
            return ResponseEntity.ok(new AlunoDto(alunoOptional.get()));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    @Transactional
    @CacheEvict(value = "listaDeAlunos", allEntries = true)
    public ResponseEntity<AlunoDto> cadastrar(@RequestBody @Valid AlunoForm alunoForm, UriComponentsBuilder uriBuilder){

        Aluno aluno = alunoService.cadastra(alunoForm);

        URI uri = uriBuilder.path("/aluno/{id}").buildAndExpand(aluno.getId()).toUri();
        return ResponseEntity.created(uri).body(new AlunoDto(aluno));

    }

}
