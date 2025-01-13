package com.cadastroproduto.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.cadastroproduto.entities.Produto;
import com.cadastroproduto.repository.ProdutoRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{

	@Autowired
	private ProdutoRepository repository;

	@Override
	public void run(String... args) throws Exception {

		/*Produto p1 = new Produto(null, "pulseira", "Vermelho", 15.0, true);
		Produto p2 = new Produto(null, "abraçadeira", "azul", 16.0, true);

		repository.saveAll(Arrays.asList(p1, p2));*/
	}
}
