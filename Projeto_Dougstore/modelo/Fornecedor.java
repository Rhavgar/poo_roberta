package modelo;

import javax.swing.JOptionPane;

import persistencia.DMFornecedor;

public class Fornecedor 
{
	private String cnpj;
	private String nome_fantasia;
	private String contato;
	
	private DMFornecedor dm_fornecedor;
	
	public Fornecedor()
	{
		dm_fornecedor = new DMFornecedor();
		
		dm_fornecedor.conectaDataBase("dougstore", "root", "tether55");
		
		System.out.println("Conexão feita à tabela Fornecedor com sucesso!");
	}
	
	
	public Fornecedor(String cnpj)
	{
		this.cnpj = cnpj;
		this.nome_fantasia = "";
		this.contato = "";
		dm_fornecedor = new DMFornecedor();
		
		dm_fornecedor.conectaDataBase("dougstore", "root", "tether55");
		
		System.out.println("Conexão feita à tabela Fornecedor com sucesso!");
	}
	public Fornecedor(String cnpj, String nome_fantasia, String contato)
	{
		this.cnpj = cnpj;
		this.nome_fantasia = nome_fantasia;
		this.contato = contato;
		dm_fornecedor = new DMFornecedor();
		
		dm_fornecedor.conectaDataBase("dougstore", "root", "tether55");
		
		System.out.println("Conexão feita à tabela Fornecedor com sucesso!");
	}
	
	public void incluir()
	{
		if (this.getCnpj().equals(""))
		{
			JOptionPane.showMessageDialog(null, "O CNPJ do Fornecedor é obrigatório!", "Mensagem de alerta", JOptionPane.WARNING_MESSAGE);
			System.out.println("O CNPJ do Fornecedor é obrigatório!");
		}
		else
		{
			if (dm_fornecedor.consultar(this) != null)
			{
				JOptionPane.showMessageDialog(null, "Cadastro de Fornecedor não realizado!\n Já existe um Fornecedor com este CNPJ!", "Mensagem de Erro", JOptionPane.ERROR_MESSAGE);
				System.out.println("Cadastro de Fornecedor não realizado! Já existe um Fornecedor com este CNPJ!");
			}
			else
			{
				dm_fornecedor.incluir(this);
			}
		}
	}
	
	public void consultar()
	{
		if (this.getCnpj().equals(""))
		{
			JOptionPane.showMessageDialog(null, "O CNPJ do Fornecedor é obrigatório!", "Mensagem de alerta", JOptionPane.WARNING_MESSAGE);
			System.out.println("O CNPJ do Fornecedor é obrigatório!");
		}
		else
		{
			dm_fornecedor.consultar(this);
		}
	}
	
	public void alterar()
	{
		if (this.getCnpj().equals(""))
		{
			JOptionPane.showMessageDialog(null, "O CNPJ do Fornecedor é obrigatório!", "Mensagem de alerta", JOptionPane.WARNING_MESSAGE);
			System.out.println("O CNPJ do Fornecedor é obrigatório!");
		}
		else
		{
			dm_fornecedor.alterar(this);
		}
	}
	
	public void excluir()
	{
		if (this.getCnpj().equals(""))
		{
			JOptionPane.showMessageDialog(null, "O CNPJ do Fornecedor é obrigatório!", "Mensagem de alerta", JOptionPane.WARNING_MESSAGE);
			System.out.println("O CNPJ do Fornecedor é obrigatório!");
		}
		else
		{
			dm_fornecedor.excluir(this);
		}
	}
	
	public void buscar()
	{
		if (this.getCnpj().equals(""))
		{
			JOptionPane.showMessageDialog(null, "O CNPJ do Fornecedor é obrigatório!", "Mensagem de alerta", JOptionPane.WARNING_MESSAGE);
			System.out.println("O CNPJ do Fornecedor é obrigatório!");
		}
		else
		{
			dm_fornecedor.buscar(this);
		}
	}
	
	public String relatorio()
	{
		return dm_fornecedor.relatorio();
	}


	public String getCnpj() 
	{
		return cnpj;
	}


	public void setCnpj(String cnpj) 
	{
		this.cnpj = cnpj;
	}


	public String getNome_fantasia() 
	{
		return nome_fantasia;
	}


	public void setNome_fantasia(String nome_fantasia) 
	{
		this.nome_fantasia = nome_fantasia;
	}


	public String getContato() 
	{
		return contato;
	}


	public void setContato(String contato) 
	{
		this.contato = contato;
	}
	
	
}
