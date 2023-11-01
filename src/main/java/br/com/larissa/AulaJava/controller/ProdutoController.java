package controller;

import modelo.Produto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
