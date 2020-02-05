package modelo;

import javax.swing.JOptionPane;

import persistencia.DMEstoque;

public class Estoque extends Senha
{
	private String lote;
	private String quantidade;
	private String preco_venda;
	private String preco_custo;
	private String fabricacao;
	private String validade;
	private String produto_codigo;
	
	private DMEstoque dm_estoque;
	
	public Estoque()
	{
		dm_estoque = new DMEstoque();
		
		dm_estoque.conectaDataBase("dougstore", "root", super.getSenha());
		
		System.out.println("Conexão feita à tabela Estoque com sucesso!");
	}
	
	
	public Estoque(String lote)
	{
		this.lote = lote;
		this.quantidade = "";
		this.preco_venda = "";
		this.preco_custo = "";
		this.fabricacao = "";
		this.validade = "";
		this.produto_codigo = "";
		
		dm_estoque = new DMEstoque();
		
		dm_estoque.conectaDataBase("dougstore", "root", super.getSenha());
		
		System.out.println("Conexão feita à tabela Estoque com sucesso!");
	}
	public Estoque(String lote, String quantidade, String preco_venda, String preco_custo, String fabricacao, String validade, String produto_codigo)
	{
		this.lote = lote;
		this.quantidade = quantidade;
		this.preco_venda = preco_venda;
		this.preco_custo = preco_custo;
		this.fabricacao = fabricacao;
		this.validade = validade;
		this.produto_codigo = produto_codigo;
		
		dm_estoque = new DMEstoque();
		
		dm_estoque.conectaDataBase("dougstore", "root", super.getSenha());
		
		System.out.println("Conexão feita à tabela Estoque com sucesso!");
	}
	
	public void incluir()
	{
		if (this.getLote().equals(""))
		{
			JOptionPane.showMessageDialog(null, "O Codigo do Estoque é obrigatório!", "Mensagem de alerta", JOptionPane.WARNING_MESSAGE);
			System.out.println("O Codigo do Estoque é obrigatório!");
		}
		else
		{
			if (dm_estoque.consultar(this) != null)
			{
				JOptionPane.showMessageDialog(null, "Cadastro de Estoque não realizado!\n Já existe um Estoque com este Codigo!", "Mensagem de Erro", JOptionPane.ERROR_MESSAGE);
				System.out.println("Cadastro de Estoque não realizado! Já existe um Estoque com este Codigo!");
			}
			else
			{
				dm_estoque.incluir(this);
			}
		}
	}
	
	public void consultar()
	{
		if (this.getLote().equals(""))
		{
			JOptionPane.showMessageDialog(null, "O Codigo do Estoque é obrigatório!", "Mensagem de alerta", JOptionPane.WARNING_MESSAGE);
			System.out.println("O Codigo do Estoque é obrigatório!");
		}
		else
		{
			dm_estoque.consultar(this);
		}
	}
	
	public void alterar()
	{
		if (this.getLote().equals(""))
		{
			JOptionPane.showMessageDialog(null, "O Codigo do Estoque é obrigatório!", "Mensagem de alerta", JOptionPane.WARNING_MESSAGE);
			System.out.println("O Codigo do Estoque é obrigatório!");
		}
		else
		{
			dm_estoque.alterar(this);
		}
	}
	
	public void excluir()
	{
		if (this.getLote().equals(""))
		{
			JOptionPane.showMessageDialog(null, "O Codigo do Estoque é obrigatório!", "Mensagem de alerta", JOptionPane.WARNING_MESSAGE);
			System.out.println("O Codigo do Estoque é obrigatório!");
		}
		else
		{
			dm_estoque.excluir(this);
		}
	}
	
	public void buscar()
	{
		if (this.getLote().equals(""))
		{
			JOptionPane.showMessageDialog(null, "O Codigo do Estoque é obrigatório!", "Mensagem de alerta", JOptionPane.WARNING_MESSAGE);
			System.out.println("O Codigo do Estoque é obrigatório!");
		}
		else
		{
			dm_estoque.buscar(this);
		}
	}
	
	public String relatorio()
	{
		return dm_estoque.relatorio();
	}


	public String getLote()
	{
		return lote;
	}


	public void setLote(String lote)
	{
		this.lote = lote;
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


	public String getProduto_codigo() 
	{
		return produto_codigo;
	}


	public void setProduto_codigo(String produto_codigo) 
	{
		this.produto_codigo = produto_codigo;
	}
	
	
}
