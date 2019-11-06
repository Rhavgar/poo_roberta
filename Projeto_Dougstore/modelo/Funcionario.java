package modelo;

import javax.swing.JOptionPane;

import modelo.Funcionario;
import persistencia.DMFuncionario;

public class Funcionario 
{
	private String cpf;
	private String nome;
	private String nasc;
	
	//atributo de referência para conexão com banco de dados
	private DMFuncionario dm_funcionario;
	
	//método construtor 1
	public Funcionario()
	{}
	
	//método construtor 2
	public Funcionario(String cpf, String nome, String nasc)
	{
		this.cpf = cpf;
		this.nome = nome;
		this.nasc = nasc;
		dm_funcionario = new DMFuncionario();
		
		//Fazer a Conexão com o BD
		dm_funcionario.conectaDataBase("dougstore", "root", "tether55");
		
		System.out.println("Conexão feita à tabela Funcionário com sucesso!");
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
	public void incluir(Funcionario objF)
	{
		if (objF.getCpf().equals(""))
		{
			JOptionPane.showMessageDialog(null, "O CPF do Funcionário é obrigatório!", "Mensagem de alerta", JOptionPane.WARNING_MESSAGE);
			System.out.println("O CPF do Funcionário é obrigatório!");
		}
		else
		{
			if (dm_funcionario.consultar(this) != null)
			{
				JOptionPane.showMessageDialog(null, "Cadastro de Funcionário não realizado!\n Já existe um Funcioário com este CPF!", "Mensagem de Erro", JOptionPane.ERROR_MESSAGE);
				System.out.println("Cadastro de Funcionário não realizado! Já existe um Funcionário com este CPF!");
			}
			else
			{
				dm_funcionario.incluir(this);
			}
		}
	}
}
