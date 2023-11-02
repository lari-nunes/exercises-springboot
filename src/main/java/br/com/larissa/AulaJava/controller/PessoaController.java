package br.com.larissa.AulaJava.controller;
import br.com.larissa.AulaJava.modelo.Endereco;
import br.com.larissa.AulaJava.modelo.Pessoa;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

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

//    @GetMapping("/{cpf}")
//    public ResponseEntity<Pessoa> lissPessoasCod(@PathVariable(value = "cpf") String cpf){}
    @PostMapping()
    public ResponseEntity<Pessoa> atualPessoas(@RequestBody Pessoa pessoa){
        //pessoa = new Pessoa();

        pessoa.setId((idPessoa++));
        pessoas.add(pessoa);

        for(Endereco end : pessoa.getEnderecos()){
            end.setId(idEndereco++);
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(pessoa);
    }

    @PostMapping("/endereco")
    public ResponseEntity<Endereco> atualEndereco(@RequestBody Endereco endereco){
        endereco.setId((idEndereco++));
        enderecos.add(endereco);

        return ResponseEntity.status(HttpStatus.CREATED).body(endereco);
    }


}
