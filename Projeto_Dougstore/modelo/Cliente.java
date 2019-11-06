package modelo;

import javax.swing.JOptionPane;

import modelo.Cliente;
import persistencia.DMCliente;

public class Cliente 
{
	private String cpf;
	private String nome;
	private String nasc;
	
	//atributo de referência para conexão com banco de dados
	private DMCliente dm_cliente;
	
	//método construtor 1
	public Cliente()
	{}
	
	//método construtor 2
	public Cliente(String cpf, String nome, String nasc)
	{
		this.cpf = cpf;
		this.nome = nome;
		this.nasc = nasc;
		dm_cliente = new DMCliente();
		
		//Fazer a Conexão com o BD
		dm_cliente.conectaDataBase("dougstore", "root", "tether55");
		
		System.out.println("Conexão feita à tabela Cliente com sucesso!");
		incluir(this);
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

	public String getNasc() 
	{
		return nasc;
	}

	public void setNasc(String nasc) 
	{
		this.nasc = nasc;
	}
	
	//método incluir
	public void incluir(Cliente objC)
	{
		if (objC.getCpf().equals(""))
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
}
