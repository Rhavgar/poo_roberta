package modelo;

import javax.swing.JOptionPane;

import modelo.Funcionario;
import persistencia.DMFuncionario;

public class Funcionario 
{
	private String cpf;
	private String nome;
	private String nascimento;
	private String sup;
	private String funcao;
	
	private DMFuncionario dm_funcionario;
	
	public Funcionario()
	{
		dm_funcionario = new DMFuncionario();
		
		dm_funcionario.conectaDataBase("dougstore", "root", "tether55");
		
		System.out.println("Conexão feita à tabela Funcionário com sucesso!");
	}
	
	public Funcionario(String cpf)
	{
		this.cpf = cpf;
		this.nome = "";
		this.nascimento = "";
		this.sup = "";
		this.funcao = "";
		
		dm_funcionario = new DMFuncionario();
		
		dm_funcionario.conectaDataBase("dougstore", "root", "tether55");
		
		System.out.println("Conexão feita à tabela Funcionário com sucesso!");
	}
	
	public Funcionario(String cpf, String nome, String nascimento, String sup, String funcao)
	{
		this.cpf = cpf;
		this.nome = nome;
		this.nascimento = nascimento;
		this.sup = sup;
		this.funcao = funcao;
		
		dm_funcionario = new DMFuncionario();
		
		dm_funcionario.conectaDataBase("dougstore", "root", "tether55");
		
		System.out.println("Conexão feita à tabela Funcionário com sucesso!");
	}
	
	public void incluir()
	{
		if (this.getCpf().equals(""))
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
	
	public void consultar()
	{
		if (this.getCpf().equals(""))
		{
			JOptionPane.showMessageDialog(null, "O CPF do Funcionario é obrigatório!", "Mensagem de alerta", JOptionPane.WARNING_MESSAGE);
			System.out.println("O CPF do Funcionario é obrigatório!");
		}
		else
		{
			dm_funcionario.consultar(this);
		}
	}
	
	public void alterar()
	{
		if (this.getCpf().equals(""))
		{
			JOptionPane.showMessageDialog(null, "O CPF do Funcionario é obrigatório!", "Mensagem de alerta", JOptionPane.WARNING_MESSAGE);
			System.out.println("O CPF do Funcionario é obrigatório!");
		}
		else
		{
			dm_funcionario.alterar(this);
		}
	}
	
	public void excluir()
	{
		if (this.getCpf().equals(""))
		{
			JOptionPane.showMessageDialog(null, "O CPF do Funcionario é obrigatório!", "Mensagem de alerta", JOptionPane.WARNING_MESSAGE);
			System.out.println("O CPF do Funcionario é obrigatório!");
		}
		else
		{
			dm_funcionario.excluir(this);
		}
	}
	
	public void buscar()
	{
		if (this.getCpf().equals(""))
		{
			JOptionPane.showMessageDialog(null, "O CPF do Funcionario é obrigatório!", "Mensagem de alerta", JOptionPane.WARNING_MESSAGE);
			System.out.println("O CPF do Funcionario é obrigatório!");
		}
		else
		{
			dm_funcionario.buscar(this);
		}
	}
	
	public String relatorio()
	{
		return dm_funcionario.relatorio();
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

	public String getSup() 
	{
		return sup;
	}

	public void setSup(String sup) 
	{
		this.sup = sup;
	}

	public String getFuncao() 
	{
		return funcao;
	}

	public void setFuncao(String funcao) 
	{
		this.funcao = funcao;
	}
	
	
}
