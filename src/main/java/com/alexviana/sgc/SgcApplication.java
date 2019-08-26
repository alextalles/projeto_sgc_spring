package com.alexviana.sgc;

import java.util.stream.LongStream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.alexviana.sgc.entities.Cliente;
import com.alexviana.sgc.enums.StageEnum;
import com.alexviana.sgc.enums.TipoEnum;
import com.alexviana.sgc.repositories.ClienteRepository;

@SpringBootApplication
public class SgcApplication {

	public static void main(String[] args) {
		SpringApplication.run(SgcApplication.class, args);
	}
	
	/** *
	 * Indica para o container do Spring que deve gerenciar esse método.
	 * O repositório é passado como parâmetro para o método, para que possa ser acessado de dentro do método. 
	 * O método retorna o ComandLinerRunner (que é a interface) que indica que o mesmo deverá ser executado, quando a aplicação foi executada dentro do contexto do Spring.
	 * @param clienteRepository
	 * @return
	 */
	@Bean
    CommandLineRunner init(ClienteRepository clienteRepository) {
        return args -> {
        	clienteRepository.deleteAll();
            LongStream.range(1, 11)
                    .mapToObj(i -> {
                        Cliente cliente = new Cliente();
                        cliente.setNome("Cliente " + i);
                        cliente.setEmail("E-mail" + i + "@alextalles@yahoo.com.br");
                        cliente.setCpf("309.994.510-22");
                        cliente.setCnpj("38.140.080/0001-53");
                        cliente.setCodigoPostal("31.910-520");
                        cliente.setTipo(TipoEnum.FISICA);
                        cliente.setStage(StageEnum.ACTIVE);
                        cliente.setTelefone1("(031) 1111-1111");
                        cliente.setTelefone2("(031) 2222-2222");
                        
                        return cliente;
                    })
                    .map(v -> clienteRepository.save(v))
                    .forEach(System.out::println);
        };
    }
}
