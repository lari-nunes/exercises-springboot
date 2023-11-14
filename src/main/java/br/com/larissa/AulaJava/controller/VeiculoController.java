package br.com.larissa.AulaJava.controller;

import br.com.larissa.AulaJava.dto.VeiculoDto;
import br.com.larissa.AulaJava.modelo.Veiculo;
import br.com.larissa.AulaJava.repository.VeiculoRepository;
import feign.Response;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/veiculo")
public class VeiculoController {

    @Autowired
    private VeiculoRepository veiculoRepository;

    @PostMapping("")
    public ResponseEntity<Veiculo> gravarVeiculo(@RequestBody @Valid VeiculoDto veiculoDto){
        var veiculo = new Veiculo();
        BeanUtils.copyProperties(veiculoDto, veiculo);
        return ResponseEntity.status(HttpStatus.CREATED).body(veiculoRepository.save(veiculo));
    }

    @GetMapping("")
    public ResponseEntity<List<Veiculo>> buscarVeiculos(){
        return ResponseEntity.status(HttpStatus.OK).body(veiculoRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> buscarIdVeiculo(@PathVariable(value = "id")Long id){
        Optional<Veiculo> product = veiculoRepository.findById(id);
        if(product.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Veículo noão existe.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(product.get());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> atualizarVeiculo(@PathVariable(value = "id")Long id, @RequestBody @Valid VeiculoDto veiculoDto){
        Optional<Veiculo> veiculo1 = veiculoRepository.findById(id);
        if(veiculo1.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Veículo não existe.");
        }
        var veiculo = veiculo1.get();
        BeanUtils.copyProperties(veiculoDto, veiculo);
        return ResponseEntity.status(HttpStatus.OK).body(veiculoRepository.save(veiculo));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletarVeiculo(@PathVariable(value = "id")Long id){
        Optional<Veiculo> veiculo = veiculoRepository.findById(id);
        if(veiculo.isEmpty()){
            return ResponseEntity.status(HttpStatus.OK).body("Veículo não existe.");
        }
        veiculoRepository.delete(veiculo.get());
        return ResponseEntity.status(HttpStatus.OK).body("Veículo deletado com sucesso.");
    }
}
