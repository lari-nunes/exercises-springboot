package br.com.larissa.AulaJava.service;

import br.com.larissa.AulaJava.dto.CepDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient( url = "https://viacep.com.br/ws/" , name = "cep")
public interface CepService {

    @GetMapping(value = "/{cep}/json")
    CepDto buscaCep(@PathVariable String cep);
}
