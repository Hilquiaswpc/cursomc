package com.hilquias;

import com.hilquias.domain.Categoria;
import com.hilquias.domain.Produtos;
import com.hilquias.repositories.CategoriaRepository;
import com.hilquias.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class CursosbApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriaRepository;

	@Autowired
	private ProdutoRepository produtoRepository;

	public static void main(String[] args) {
		SpringApplication.run(CursosbApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria cat1 = new Categoria(null, "Informatica");
		Categoria cat2 = new Categoria(null, "Escritorio");

		Produtos p1 = new Produtos(null, "Computado", 2000.00);
		Produtos p2 = new Produtos(null, "Impressora", 800.00);
		Produtos p3 = new Produtos(null, "Mause", 80.00);

		cat1.getProdutos().addAll(Arrays.asList(p2,p2,p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));

		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1,cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));



		
		categoriaRepository .saveAll( Arrays.asList(cat1,cat2));
		produtoRepository .saveAll(Arrays.asList(p1,p2,p3));

	}
}
