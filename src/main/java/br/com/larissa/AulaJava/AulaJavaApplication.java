package br.com.larissa.AulaJava;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class AulaJavaApplication {

	public static void main(String[] args) {
		SpringApplication.run(AulaJavaApplication.class, args);

		System.out.println("Testando minha aplicação!");

	}

}