package modelo;

import javax.swing.JOptionPane;

import persistencia.DMCliente;

public class Cliente 
{
	private String cpf;
	private String nome;
	private String nascimento;
	
	private DMCliente dm_cliente;
	
	public Cliente()
	{
		dm_cliente = new DMCliente();
		
		dm_cliente.conectaDataBase("dougstore", "root", "tether55");
		
		System.out.println("Conexão feita à tabela Cliente com sucesso!");
	}
	
	
	public Cliente(String cpf)
	{
		this.cpf = cpf;
		this.nome = "";
		this.nascimento = "";
		dm_cliente = new DMCliente();
		
		dm_cliente.conectaDataBase("dougstore", "root", "tether55");
		
		System.out.println("Conexão feita à tabela Cliente com sucesso!");
	}
	public Cliente(String cpf, String nome, String nascimento)
	{
		this.cpf = cpf;
		this.nome = nome;
		this.nascimento = nascimento;
		dm_cliente = new DMCliente();
		
		dm_cliente.conectaDataBase("dougstore", "root", "tether55");
		
		System.out.println("Conexão feita à tabela Cliente com sucesso!");
	}
	
	public void incluir()
	{
		if (this.getCpf().equals(""))
		{
			JOptionPane.showMessageDialog(null, "O CPF do Cliente é obrigatório!", "Mensagem de alerta", JOptionPane.WARNING_MESSAGE);
			System.out.println("O CPF do Cliente é obrigatório!");
		}
		else
		{
			if (dm_cliente.consultar(this) != null)
			{
				JOptionPane.showMessageDialog(null, "Cadastro de Cliente não realizado!\n Já existe um Cliente com este CPF!", "Mensagem de Erro", JOptionPane.ERROR_MESSAGE);
				System.out.println("Cadastro de Cliente não realizado! Já existe um Cliente com este CPF!");
			}
			else
			{
				dm_cliente.incluir(this);
			}
		}
	}
	
	public void consultar()
	{
		if (this.getCpf().equals(""))
		{
			JOptionPane.showMessageDialog(null, "O CPF do Cliente é obrigatório!", "Mensagem de alerta", JOptionPane.WARNING_MESSAGE);
			System.out.println("O CPF do Cliente é obrigatório!");
		}
		else
		{
			dm_cliente.consultar(this);
		}
	}
	
	public void alterar()
	{
		if (this.getCpf().equals(""))
		{
			JOptionPane.showMessageDialog(null, "O CPF do Cliente é obrigatório!", "Mensagem de alerta", JOptionPane.WARNING_MESSAGE);
			System.out.println("O CPF do Cliente é obrigatório!");
		}
		else
		{
			dm_cliente.alterar(this);
		}
	}
	
	public void excluir()
	{
		if (this.getCpf().equals(""))
		{
			JOptionPane.showMessageDialog(null, "O CPF do Cliente é obrigatório!", "Mensagem de alerta", JOptionPane.WARNING_MESSAGE);
			System.out.println("O CPF do Cliente é obrigatório!");
		}
		else
		{
			dm_cliente.excluir(this);
		}
	}
	
	public void buscar()
	{
		if (this.getCpf().equals(""))
		{
			JOptionPane.showMessageDialog(null, "O CPF do Cliente é obrigatório!", "Mensagem de alerta", JOptionPane.WARNING_MESSAGE);
			System.out.println("O CPF do Cliente é obrigatório!");
		}
		else
		{
			dm_cliente.buscar(this);
		}
	}
	
	public String relatorio()
	{
		return dm_cliente.relatorio();
	}
	
	public String getCpf() 
	{
		return cpf;
	}

	public void setCpf(String cpf) 
	{
		this.cpf = cpf;
	}

	public String getNome() 
	{
		return nome;
	}

	public void setNome(String nome) 
	{
		this.nome = nome;
	}

	public String getNascimento() 
	{
		return nascimento;
	}

	public void setNascimento(String nascimento) 
	{
		this.nascimento = nascimento;
	}
}
