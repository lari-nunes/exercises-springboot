package br.com.larissa.AulaJava.facade;

import br.com.larissa.AulaJava.dto.CepDto;
import br.com.larissa.AulaJava.service.CepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class CepFacade {

    @Autowired
    private CepService cepService;

    public CepDto buscaCep(@PathVariable String cep){
        return cepService.buscaCep(cep);
    }
}
