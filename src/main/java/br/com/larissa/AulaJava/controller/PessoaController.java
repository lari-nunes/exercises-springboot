package br.com.larissa.AulaJava.controller;
import br.com.larissa.AulaJava.modelo.Endereco;
import br.com.larissa.AulaJava.modelo.Pessoa;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/pessoas")
public class PessoaController {

    private List<Pessoa> pessoas = new ArrayList<>();
    private List<Endereco> enderecos = new ArrayList<>();

    private Pessoa pessoa;
    private Endereco endereco;

    private Long idPessoa = Long.valueOf(1);
    private Long idEndereco = Long.valueOf(1);
    @GetMapping()
    public List<Pessoa> listaPessoas(){
        return pessoas;
    }

    @GetMapping("/{cpf}")
    public ResponseEntity<Object> listarPorCPF(@PathVariable(value = "cpf") String cpf){
        //  usa-se o stream para realizar operações de filtragem e busca a partir dessa lista.
        Optional<Pessoa> pessoaEncontrada = pessoas.stream().filter(p -> p.getCpf().equals(cpf)).findFirst();
        if(pessoaEncontrada.isPresent()){
            return ResponseEntity.ok(pessoaEncontrada.get());
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Esse CPF não existe!");
        }
    }
    @PostMapping()
    public ResponseEntity<Object> criaPessoas(@RequestBody Pessoa pessoa){

        // verifica se o CPF da Pessoa atual (p.getCpf()) na lista é igual ao CPF da Pessoa que está sendo adicionada (pessoa.getCpf()).
        boolean cpfExistente = pessoas.stream().anyMatch(p -> p.getCpf().equals(pessoa.getCpf()));

        if (cpfExistente) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Este CPF já está cadastrado. Por favor, forneça um CPF diferente.");
        } else {
            pessoa.setId(idPessoa++);
            pessoas.add(pessoa);
        }

        for(Endereco end : pessoa.getEnderecos()){
            end.setId(idEndereco++);
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(pessoa);
    }

    @PutMapping("/{cpf}")
    public ResponseEntity<Object> atualizarPessoa(@PathVariable(value = "cpf") String cpf, @RequestBody Pessoa pessoaAtualizada) {
        // Procurar a pessoa existente com base no CPF
        Optional<Pessoa> pessoaExistente = pessoas.stream().filter(p -> p.getCpf().equals(cpf)).findFirst();

        if (pessoaExistente.isPresent()) {
            Pessoa pessoa = pessoaExistente.get();
            pessoa.setNome(pessoaAtualizada.getNome());
            pessoa.setSexo(pessoaAtualizada.getSexo());
            pessoa.setDataNascimento(pessoaAtualizada.getDataNascimento());
            pessoa.setEnderecos(pessoaAtualizada.getEnderecos());

            for(Endereco end : pessoa.getEnderecos()){
                end.setId(idEndereco);
            }

            return ResponseEntity.ok(pessoa);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pessoa com o CPF informado não foi encontrada.");
        }
    }

    @DeleteMapping("/{cpf}")
    public ResponseEntity<Object> deletePessoa(@PathVariable(value = "cpf")String cpf){
        Optional<Pessoa> pessoaExistente = pessoas.stream().filter(p -> p.getCpf().equals(cpf)).findFirst();
        if(pessoaExistente.isPresent()){
            pessoas.remove(pessoaExistente);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pessoa com o CPF informado não foi encontrada");
        }
    }
}
