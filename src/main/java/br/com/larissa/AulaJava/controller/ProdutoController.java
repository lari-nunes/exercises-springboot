package br.com.larissa.AulaJava.controller;

import modelo.Produto;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@RestController
@RequestMapping("/teste")
public class ProdutoController {

    private final List<Produto> listaProduto = new ArrayList<>();

    private Produto produto;

    private Long codigo = Long.valueOf(1);

    @GetMapping("/teste")
        public String teste(){
            return "Java teste";
    }

    @PostMapping()
    public ResponseEntity<Produto> addProd(@RequestBody  Produto produto1){
        produto = new Produto();
        produto.setCodigo(Long.valueOf(codigo++));
        produto.setNome(produto1.getNome());
        produto.setValor(produto1.getValor());

        listaProduto.add(produto);

        return ResponseEntity.status(HttpStatus.CREATED).body(produto);

    }

    @GetMapping()
    public List<Produto> listaProduto(){
        return listaProduto;
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<Object> codProd(@PathVariable(value = "codigo") Long codigo) {

        if (!listaProduto.isEmpty()) {
            for (Produto p : listaProduto) {
                if (produto.getCodigo() == codigo) {
                    return ResponseEntity.status(HttpStatus.OK).body(produto);
                }
            }
        }
        return null;
    }

    @DeleteMapping("/{codigo}")
    public ResponseEntity<Object> delProd(@PathVariable(value="codigo")Long codigo){
        if(!listaProduto.isEmpty()){
            for(Produto produto1 : listaProduto){
                if(produto1.getCodigo() == codigo){
                    listaProduto.remove(produto1);
                    return ResponseEntity.status(HttpStatus.OK).body(produto1);
                }
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto não encontrado");
    }

    @PutMapping("{codigo}")
    public ResponseEntity<Object> putProd(@PathVariable(value = "codigo")Long codigo, @RequestBody Produto produto){
        if(!listaProduto.isEmpty()){
            for(Produto produto1 : listaProduto){
                if(produto1.getCodigo() == codigo){
                    produto.setNome(produto1.getNome());
                    produto.setValor(produto1.getValor());
                    return ResponseEntity.status(HttpStatus.CREATED).body(produto);
                }
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto não encontrado!");
    }

}
