package br.com.larissa.AulaJava.controller;

import br.com.larissa.AulaJava.dto.CepDto;
import br.com.larissa.AulaJava.facade.CepFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cep")
public class CepController {

    @Autowired
    private CepFacade cepFacade;

    @GetMapping(value = "/{cep}")
    public CepDto buscaCep(@PathVariable String cep){
        return cepFacade.buscaCep(cep);
    }




}
