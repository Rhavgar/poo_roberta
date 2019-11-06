package modelo;

import javax.swing.JOptionPane;

import modelo.Produto;
import persistencia.DMProduto;

public class Produto 
{
	private String codigo;
	private String fabricacao;
	private String validade;
	private String quantidade;
	private String preco_venda;
	private String preco_custo;
	
	//atributo de referência para conexão com banco de dados
	private DMProduto dm_produto;
	
	//método construtor 1
	public Produto()
	{}
	
	//método construtor 2
	public Produto(String codigo, String fabricacao, String validade, String quantidade, String preco_venda, String preco_custo)
	{
		this.codigo = codigo;
		this.fabricacao = fabricacao;
		this.validade = validade;
		this.quantidade = quantidade;
		this.preco_venda = preco_venda;
		this.preco_custo = preco_custo;
		dm_produto = new DMProduto();
		
		//Fazer a Conexão com o BD
		dm_produto.conectaDataBase("dougstore", "root", "root");
		
		System.out.println("Conexão feita à tabela Produto com sucesso!");
		incluir(this);
	}

	
	
	public String getCodigo() 
	{
		return codigo;
	}

	public void setCodigo(String codigo) 
	{
		this.codigo = codigo;
	}

	public String getFabricacao() 
	{
		return fabricacao;
	}

	public void setFabricacao(String fabricacao) 
	{
		this.fabricacao = fabricacao;
	}

	public String getValidade() 
	{
		return validade;
	}

	public void setValidade(String validade) 
	{
		this.validade = validade;
	}

	public String getQuantidade() 
	{
		return quantidade;
	}

	public void setQuantidade(String quantidade) 
	{
		this.quantidade = quantidade;
	}

	public String getPreco_venda() 
	{
		return preco_venda;
	}

	public void setPreco_venda(String preco_venda) 
	{
		this.preco_venda = preco_venda;
	}

	public String getPreco_custo() 
	{
		return preco_custo;
	}

	public void setPreco_custo(String preco_custo) 
	{
		this.preco_custo = preco_custo;
	}

	//método incluir
	public void incluir(Produto objP)
	{
		if (objP.getCodigo().equals(""))
		{
			JOptionPane.showMessageDialog(null, "O Codigo do Produto é obrigatório!", "Mensagem de alerta", JOptionPane.WARNING_MESSAGE);
			System.out.println("O Codigodo Produto é obrigatório!");
		}
		else
		{
			if (dm_produto.consultar(this) != null)
			{
				JOptionPane.showMessageDialog(null, "Cadastro de Produto não realizado!\n Já existe um Produto com este Codigo!", "Mensagem de Erro", JOptionPane.ERROR_MESSAGE);
				System.out.println("Cadastro de Produto não realizado! Já existe um Produto com este Codigo!");
			}
			else
			{
				dm_produto.incluir(this);
			}
		}
	}
}
