package br.com.larissa.AulaJava.controller;

import br.com.larissa.AulaJava.modelo.Produto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private List<Produto> listaProduto = new ArrayList<>();
    private Produto produto;
    private Long id = Long.valueOf(1);

    @GetMapping("/produtos")
    public List<Produto> listaProduto(){
        return listaProduto;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> listProdutos(@PathVariable (value = "id") Long id){

        /*
        Ele verifica se a lista de produtos não está vazia.
        Se a lista de produtos não estiver vazia, ele repete sobre a lista de produtos.
        Para cada produto na lista, ele verifica se o código do produto é igual ao código especificado na rota.
        Se o código do produto for igual ao código especificado na rota, o método retorna o produto.
        Caso contrário, o método retorna um status de "Produto não encontrado".
        */

        if(!listaProduto.isEmpty()){
            for(Produto produto : listaProduto){
                if(produto.getId() == id){
                    return ResponseEntity.status(HttpStatus.OK).body(produto);
                }
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto não encontrado");
    }

    @PostMapping()
    public ResponseEntity<Produto> addProd(@RequestBody  Produto produto1){
        produto = new Produto();
        produto.setId(Long.valueOf(id++));
        produto.setNomeProduto(produto1.getNomeProduto());
        produto.setValor(produto1.getValor());

        listaProduto.add(produto);

        return ResponseEntity.status(HttpStatus.CREATED).body(produto);

    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> atualProd(@PathVariable(value = "id")Long id, @RequestBody Produto produto){
        if(!listaProduto.isEmpty()){
            for(Produto produto1 : listaProduto){
                if(produto1.getId() == id){
                    produto.setNomeProduto(produto.getNomeProduto());
                    produto.setValor(produto.getValor());
                    return ResponseEntity.status(HttpStatus.OK).body(produto);
                }
            }
        }
        return  ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto não foi atualizado");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delProd(@PathVariable(value = "id")Long id){
        if(!listaProduto.isEmpty()){
            for(Produto produto1 : listaProduto){
                if(produto1.getId() == id){
                    listaProduto.remove(produto1);
                    return ResponseEntity.status(HttpStatus.OK).body(produto1);
                }
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto não foi deletado");
    }
}
