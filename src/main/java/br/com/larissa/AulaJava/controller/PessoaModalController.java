package br.com.larissa.AulaJava.controller;

import br.com.larissa.AulaJava.dto.PessoaDto;
import br.com.larissa.AulaJava.dto.VeiculoDto;
import br.com.larissa.AulaJava.modelo.Pessoa;
import br.com.larissa.AulaJava.modelo.PessoaModel;
import br.com.larissa.AulaJava.modelo.Veiculo;
import br.com.larissa.AulaJava.repository.PessoaRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pessoa")
public class PessoaModalController {

    @Autowired
    private PessoaRepository pessoaRepository;

    @PostMapping("/")
    public ResponseEntity<PessoaModel> criarPessoa(@RequestBody @Valid PessoaDto pessoaDto){
        var pessoa = new PessoaModel();
        BeanUtils.copyProperties(pessoaDto, pessoa);
        return ResponseEntity.status(HttpStatus.CREATED).body(pessoaRepository.save(pessoa));
    }

    @GetMapping("")
    public ResponseEntity<List<PessoaModel>> buscarPssoa(){
        return ResponseEntity.status(HttpStatus.OK).body(pessoaRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> buscarIdPessoa(@PathVariable(value = "id")Long id){
        Optional<PessoaModel> pessoa = pessoaRepository.findById(id);
        if(pessoa.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pessoa não encontrada.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(pessoa.get());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> atualizarPessoa(@PathVariable(value = "id")Long id, @RequestBody @Valid PessoaDto pessoaDto){
        Optional<PessoaModel> pessoa1 = pessoaRepository.findById(id);
        if(pessoa1.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("VPessoa não existe.");
        }
        var pessoa = pessoa1.get();
        BeanUtils.copyProperties(pessoaDto, pessoa);
        return ResponseEntity.status(HttpStatus.OK).body(pessoaRepository.save(pessoa));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletarPessoa(@PathVariable(value = "id")Long id){
        Optional<PessoaModel> pessoa = pessoaRepository.findById(id);
        if(pessoa.isEmpty()){
            return ResponseEntity.status(HttpStatus.OK).body("Pessoa não existe.");
        }
        pessoaRepository.delete(pessoa.get());
        return ResponseEntity.status(HttpStatus.OK).body("Pessoa deletado com sucesso.");
    }

}
