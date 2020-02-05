package modelo;

import javax.swing.JOptionPane;

import persistencia.DMFuncao;

public class Funcao extends Senha
{
	private String codigo;
	private String descricao;
	private String salario;
	
	private DMFuncao dm_funcao;
	
	public Funcao()
	{
		dm_funcao = new DMFuncao();
		
		dm_funcao.conectaDataBase("dougstore", "root", super.getSenha());
		
		System.out.println("Conexão feita à tabela Funcao com sucesso!");
	}
	
	
	public Funcao(String codigo)
	{
		this.codigo = codigo;
		this.descricao = "";
		this.salario = "";
		dm_funcao = new DMFuncao();
		
		dm_funcao.conectaDataBase("dougstore", "root", super.getSenha());
		
		System.out.println("Conexão feita à tabela Funcao com sucesso!");
	}
	public Funcao(String codigo, String descricao, String salario)
	{
		this.codigo = codigo;
		this.descricao = descricao;
		this.salario = salario;
		dm_funcao = new DMFuncao();
		
		dm_funcao.conectaDataBase("dougstore", "root", super.getSenha());
		
		System.out.println("Conexão feita à tabela Funcao com sucesso!");
	}
	
	public void incluir()
	{
		if (this.getCodigo().equals(""))
		{
			JOptionPane.showMessageDialog(null, "O Codigo da Funcao é obrigatório!", "Mensagem de alerta", JOptionPane.WARNING_MESSAGE);
			System.out.println("O Codigo da Funcao é obrigatório!");
		}
		else
		{
			if (dm_funcao.consultar(this) != null)
			{
				JOptionPane.showMessageDialog(null, "Cadastro de Funcao não realizado!\n Já existe uma Funcao com este Сodigo!", "Mensagem de Erro", JOptionPane.ERROR_MESSAGE);
				System.out.println("Cadastro de Funcao não realizado! Já existe uma Funcao com este Codigo!");
			}
			else
			{
				dm_funcao.incluir(this);
			}
		}
	}
	
	public void consultar()
	{
		if (this.getCodigo().equals(""))
		{
			JOptionPane.showMessageDialog(null, "O Codigo da Funcao é obrigatório!", "Mensagem de alerta", JOptionPane.WARNING_MESSAGE);
			System.out.println("O Codigo da Funcao é obrigatório!");
		}
		else
		{
			dm_funcao.consultar(this);
		}
	}
	
	public void alterar()
	{
		if (this.getCodigo().equals(""))
		{
			JOptionPane.showMessageDialog(null, "O Codigo da Funcao é obrigatório!", "Mensagem de alerta", JOptionPane.WARNING_MESSAGE);
			System.out.println("O Codigo da Funcao é obrigatório!");
		}
		else
		{
			dm_funcao.alterar(this);
		}
	}
	
	public void excluir()
	{
		if (this.getCodigo().equals(""))
		{
			JOptionPane.showMessageDialog(null, "O Codigo da Funcao é obrigatório!", "Mensagem de alerta", JOptionPane.WARNING_MESSAGE);
			System.out.println("O Codigo da Funcao é obrigatório!");
		}
		else
		{
			dm_funcao.excluir(this);
		}
	}
	
	public void buscar()
	{
		if (this.getCodigo().equals(""))
		{
			JOptionPane.showMessageDialog(null, "O Codigo da Funcao é obrigatório!", "Mensagem de alerta", JOptionPane.WARNING_MESSAGE);
			System.out.println("O Codigo da Funcao é obrigatório!");
		}
		else
		{
			dm_funcao.buscar(this);
		}
	}
	
	public String relatorio()
	{
		return dm_funcao.relatorio();
	}


	public String getCodigo() 
	{
		return codigo;
	}


	public void setCodigo(String codigo) 
	{
		this.codigo = codigo;
	}


	public String getDescricao() 
	{
		return descricao;
	}


	public void setDescricao(String descricao) 
	{
		this.descricao = descricao;
	}


	public String getSalario() 
	{
		return salario;
	}


	public void setSalario(String salario) 
	{
		this.salario = salario;
	}
}
