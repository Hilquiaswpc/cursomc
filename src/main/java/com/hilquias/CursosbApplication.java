package com.hilquias;

import com.hilquias.domain.*;
import com.hilquias.enums.EstadoPagamento;
import com.hilquias.enums.TipoCliente;
import com.hilquias.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;

@SpringBootApplication
public class CursosbApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriaRepository;

	@Autowired
	private ProdutoRepository produtoRepository;

	@Autowired
	private EstadoRepository estadoRepository;

	@Autowired
	private CidadeRepository cidadeRepository;

	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private EnderecoRepository enderecoRepository;

	@Autowired
	private PedidoRepository pedidoRepository;

	@Autowired
	private PagamentoRepository pagamentoRepository;

	@Autowired
	private ItemPedidoRepository itemPedidoRepository;

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

		Estado e1 = new Estado(null, "São Paulo");
		Estado e2 = new Estado(null, "Pernambuco");

		Cidade c1 = new Cidade(null, "Uberlandia", e1);
		Cidade c2 = new Cidade(null, "Recife", e2);
		Cidade c3 = new Cidade(null, "Sao Lourenco da Mata", e2);

		Cliente cli1 = new Cliente(null, "Hilquias Camelo", "hilquias@gmail.com", "07435693421", TipoCliente.PESSOAFISICA);

		cli1.getTelefones().addAll(Arrays.asList("81 98879-9043", "81 99661-1447"));

		Endereco End = new Endereco(null,"Rua Luiz Bezerra de Souza","Casa", "Centro", "54735-815", cli1,c2);

		SimpleDateFormat sdf = new  SimpleDateFormat("dd/MM/yyy HH:mm");

		Pedido ped1 = new Pedido(null,sdf.parse("16/02/2022 18:45"), cli1, End);
		Pedido ped2 = new Pedido(null,sdf.parse("16/02/2022 18:50"), cli1, End);

		Pagamento pag1 = new PagamentoComCartao(null, EstadoPagamento.QUITADO, ped1, 6);
		ped1.setPagamento(pag1);

		Pagamento pag2 = new PagamentoComBoleto(null,EstadoPagamento.PENDENTE,ped2,sdf.parse("20/10/2022 00:00"), null);
		ped2.setPagamento(pag2);

		itemPedido ip1 = new itemPedido(ped1, p1,0.00, 1,2000.00);
		itemPedido ip2 = new itemPedido(ped1, p1,0.00, 2, 80.00);
		itemPedido ip3 = new itemPedido(ped2, p2, 100.00,1, 800.00);

		ped1.getItens().addAll(Arrays.asList(ip1,ip2));
		ped2.getItens().addAll(Arrays.asList(ip3));
	
		p1.getItens().addAll(Arrays.asList(ip1));
		p2.getItens().addAll(Arrays.asList(ip3));
		p3.getItens().addAll(Arrays.asList(ip2));

		cli1.getPedidos().addAll((Arrays.asList(ped1,ped2)));

		cat1.getProdutos().addAll(Arrays.asList(p2, p2, p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));

		cli1.getEnderecos().addAll(Arrays.asList(End));



		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));

		e1.getCidades().addAll(Arrays.asList(c1));
		e1.getCidades().addAll(Arrays.asList(c2, c3));



		estadoRepository.saveAll(Arrays.asList(e1, e2));
		cidadeRepository.saveAll(Arrays.asList(c1, c2, c3));

		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));

		produtoRepository.saveAll(Arrays.asList(p1, p2, p3));

		clienteRepository.saveAll(Arrays.asList(cli1));

		enderecoRepository.saveAll(Arrays.asList(End));

		pedidoRepository.saveAll(Arrays.asList(ped1, ped2));
		pagamentoRepository.saveAll(Arrays.asList(pag1, pag2));

		itemPedidoRepository.saveAll(Arrays.asList(ip1,ip2,ip3));

	}
}
