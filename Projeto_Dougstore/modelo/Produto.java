package modelo;

import javax.swing.JOptionPane;

import persistencia.DMProduto;

public class Produto extends Senha
{
	private String codigo;
	private String nome_comercial;
	private String nome_generico;
	private String tarja;
	private String tipo;
	private String fornecedor_cnpj;
	
	private DMProduto dm_produto;
	
	public Produto()
	{
		dm_produto = new DMProduto();
		
		dm_produto.conectaDataBase("dougstore", "root", super.getSenha());
		
		System.out.println("Conexão feita à tabela Produto com sucesso!");
	}
	
	
	public Produto(String codigo)
	{
		this.codigo = codigo;
		this.nome_comercial = "";
		this.nome_generico = "";
		this.tarja = "";
		this.tipo = "";
		this.fornecedor_cnpj = "";
		
		dm_produto = new DMProduto();
		
		dm_produto.conectaDataBase("dougstore", "root", super.getSenha());
		
		System.out.println("Conexão feita à tabela Produto com sucesso!");
	}
	public Produto(String codigo, String nome_comercial, String nome_generico, String tarja, String tipo, String fornecedor_cnpj)
	{
		this.codigo = codigo;
		this.nome_comercial = nome_comercial;
		this.nome_generico = nome_generico;
		this.tarja = tarja;
		this.tipo = tipo;
		this.fornecedor_cnpj = fornecedor_cnpj;
		
		dm_produto = new DMProduto();
		
		dm_produto.conectaDataBase("dougstore", "root", super.getSenha());
		
		System.out.println("Conexão feita à tabela Produto com sucesso!");
	}
	
	public void incluir()
	{
		if (this.getCodigo().equals(""))
		{
			JOptionPane.showMessageDialog(null, "O Codigo do Produto é obrigatório!", "Mensagem de alerta", JOptionPane.WARNING_MESSAGE);
			System.out.println("O Codigo do Produto é obrigatório!");
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
	
	public void consultar()
	{
		if (this.getCodigo().equals(""))
		{
			JOptionPane.showMessageDialog(null, "O Codigo do Produto é obrigatório!", "Mensagem de alerta", JOptionPane.WARNING_MESSAGE);
			System.out.println("O Codigo do Produto é obrigatório!");
		}
		else
		{
			dm_produto.consultar(this);
		}
	}
	
	public void alterar()
	{
		if (this.getCodigo().equals(""))
		{
			JOptionPane.showMessageDialog(null, "O Codigo do Produto é obrigatório!", "Mensagem de alerta", JOptionPane.WARNING_MESSAGE);
			System.out.println("O Codigo do Produto é obrigatório!");
		}
		else
		{
			dm_produto.alterar(this);
		}
	}
	
	public void excluir()
	{
		if (this.getCodigo().equals(""))
		{
			JOptionPane.showMessageDialog(null, "O Codigo do Produto é obrigatório!", "Mensagem de alerta", JOptionPane.WARNING_MESSAGE);
			System.out.println("O Codigo do Produto é obrigatório!");
		}
		else
		{
			dm_produto.excluir(this);
		}
	}
	
	public void buscar()
	{
		if (this.getCodigo().equals(""))
		{
			JOptionPane.showMessageDialog(null, "O Codigo do Produto é obrigatório!", "Mensagem de alerta", JOptionPane.WARNING_MESSAGE);
			System.out.println("O Codigo do Produto é obrigatório!");
		}
		else
		{
			dm_produto.buscar(this);
		}
	}
	
	public String relatorio()
	{
		return dm_produto.relatorio();
	}


	public String getCodigo() 
	{
		return codigo;
	}


	public void setCodigo(String codigo)
	{
		this.codigo = codigo;
	}


	public String getNome_comercial()
	{
		return nome_comercial;
	}


	public void setNome_comercial(String nome_comercial) 
	{
		this.nome_comercial = nome_comercial;
	}


	public String getNome_generico() 
	{
		return nome_generico;
	}


	public void setNome_generico(String nome_generico)
	{
		this.nome_generico = nome_generico;
	}


	public String getTarja() 
	{
		return tarja;
	}


	public void setTarja(String tarja)
	{
		this.tarja = tarja;
	}


	public String getTipo()
	{
		return tipo;
	}


	public void setTipo(String tipo)
	{
		this.tipo = tipo;
	}


	public String getFornecedor_cnpj()
	{
		return fornecedor_cnpj;
	}


	public void setFornecedor_cnpj(String fornecedor_cnpj)
	{
		this.fornecedor_cnpj = fornecedor_cnpj;
	}
	
	
}
