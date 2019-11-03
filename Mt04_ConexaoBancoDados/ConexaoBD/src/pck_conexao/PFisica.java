package pck_conexao;

import javax.swing.JOptionPane;

import pck_conexao.PFisica;
import pck_persistencia.DMPFisica;

public class PFisica {

	private String cpf;
	private String nome;
	private String email;
	
	//atributo de referência para conexão com banco de dados
	private DMPFisica dm_pfisica;

	
	//método construtor 1
	public PFisica()
	{	}
	
	//método construtor2
	public PFisica(String cpf, String nome, String email)
	{ 	this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		dm_pfisica = new DMPFisica();
		
		//Fazer a Conexao com o BD
		dm_pfisica.conectaDataBase("db_agenda","root","mysql");
	   	
	   	System.out.println("Conexão feita à tabela Pfisicas com sucesso!");
	    incluir(this);
	}

	
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	   //método incluir
    public void incluir(PFisica objPF)
    {   if (objPF.getCpf().equals(""))
        {   JOptionPane.showMessageDialog(null,"O cpf da Pessoa Física é obrigatório!","Mensagem de alerta",JOptionPane.WARNING_MESSAGE);
            System.out.println("O cpf da Pessoa Física é obrigatório!");
        }
        else
        {   if (dm_pfisica.consultar(this)!= null)
            {   JOptionPane.showMessageDialog(null,"Cadastro de Pessoa Física não realizado!\n Já existe uma Pessoa Física com este cpf!","Mensagem de Erro",JOptionPane.ERROR_MESSAGE);
                System.out.println("Cadastro de Pessoa Física não realizado! Já existe uma Pessoa Física com este cpf!"); 
            }
            else
            { dm_pfisica.incluir(this); }
        }
    }   

}
