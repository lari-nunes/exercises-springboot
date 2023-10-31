package br.com.larissa.AulaJava;

import modelo.Produto;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AulaJavaApplication {

	public static void main(String[] args) {
		SpringApplication.run(AulaJavaApplication.class, args);

		System.out.println("TESTE");

		Produto produto = new Produto(1, "Comida brasileira", 500.00);

		System.out.println("O código do produto é " + produto.getCodigo() + ", descrição é: " + produto.getDescricao() + " e o valor é de " + produto.getValor());
	}
}