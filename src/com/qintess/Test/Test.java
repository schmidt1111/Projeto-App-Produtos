package com.qintess.Test;

import com.qintess.model.GenericDao;
import com.qintess.model.ItemVenda;
import com.qintess.model.Produto;
import com.qintess.model.Venda;

public class Test {
	public static void main(String[] args) {
		
		//acesso aos daos
		GenericDao <Produto> produtoDao = new GenericDao <Produto>();
		GenericDao<ItemVenda> itemvendaDao = new GenericDao <ItemVenda>();
		GenericDao <Venda> vendaDao = new GenericDao <Venda>();
		
		//inserindo dados e salvando
		Produto produto1 = new Produto();
		produto1.setNome("Estojo");
		produto1.setPreco(5.00);
		produtoDao.salvar(produto1);

		Produto produto2 = new Produto();
		produto2.setNome("Lapis");
		produto2.setPreco(2.00);
		produtoDao.salvar(produto2);

		Produto produto3 = new Produto();
		produto3.setNome("Caneta");
		produto3.setPreco(3.00);
		produtoDao.salvar(produto3);

		Venda venda1 = new Venda();
		venda1.setTotal(12.00);
		vendaDao.salvar(venda1);
		
		ItemVenda itemvenda1 = new ItemVenda();
		itemvenda1.setProduto(produto1);
		itemvenda1.setQtd(1);
		itemvenda1.setSubtotal(5.00);
		itemvenda1.setVenda(venda1);
		itemvendaDao.salvar(itemvenda1);
		
		
		ItemVenda itemvenda2 = new ItemVenda();
		itemvenda2.setProduto (produto2);
		itemvenda2.setQtd(2);
		itemvenda2.setSubtotal(4.00);
		itemvenda2.setVenda(venda1);
		itemvendaDao.salvar(itemvenda2);
		
		ItemVenda itemvenda3 = new ItemVenda();
		itemvenda3.setProduto(produto3);
		itemvenda3.setQtd(1);
		itemvenda3.setSubtotal(3.00);
		itemvenda3.setVenda(venda1);
		itemvendaDao.salvar(itemvenda3);
		
		//buscar por Id
		vendaDao.buscaPorId(venda1, 1);
		
	}

}
