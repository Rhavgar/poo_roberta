package modelo;

import javax.swing.JOptionPane;

import persistencia.DMPessoaFisica;

public class PessoaFisica extends Pessoa
{	
	//atributos comuns
	private String cpf;
	private String dataNascimento;
	
	//atributo de referência para conexão com banco de dados
	private DMPessoaFisica dmPessoaFisica;
		
	//metodos de acesso
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	//métodos construtores
	//método construtor1 - usado na primeira fase
	/*
	public PessoaFisica()
	{	super();
		cpf = JOptionPane.showInputDialog("Informe o CPF: ");
		dataNascimento = JOptionPane.showInputDialog("Informe a data de nascimento: ");	
	}
	*/
	
	//método construtor2 - usado agora
	public PessoaFisica(String nome, String cpf, String dataNascimento, Endereco objE, Telefone objT)
	{ 	this.nome = nome;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		this.atRefEndereco = objE;
		this.atRefTelefone = objT;
		dmPessoaFisica = new DMPessoaFisica();
    	dmPessoaFisica.conectaDataBase("agenda","root","mysql");//Fazer a Conexao com o BD
    	System.out.println("Conexão feita à tabela Pfisicas com sucesso!");
        incluir(this);
		//this.imprimir();
	}

	public void imprimir()
	{	//super.imprimir();
		JOptionPane.showMessageDialog(null,"CPF = "+cpf);
		JOptionPane.showMessageDialog(null,"Data de Nascimento = "+dataNascimento);
	}
	
    //métodos para incluir, consultar, excluir e alterar dados da tabela pfisicas do banco de dados
    public Object consultar()
    {   return dmPessoaFisica.consultar(this);   }
    
    //método para inclusão
    public void incluir(PessoaFisica objPF)
    {   if (objPF.getCpf().equals(""))
        {   JOptionPane.showMessageDialog(null,"O cpf da Pessoa Física é obrigatório!","Mensagem de alerta",JOptionPane.WARNING_MESSAGE);
            System.out.println("O cpf da Pessoa Física é obrigatório!");
        }
        else
        {   if (dmPessoaFisica.consultar(this)!= null)
            {   JOptionPane.showMessageDialog(null,"Cadastro de Pessoa Física não realizado!\n Já existe uma Pessoa Física com este cpf!","Mensagem de Erro",JOptionPane.ERROR_MESSAGE);
                System.out.println("Cadastro de Pessoa Física não realizado! Já existe uma Pessoa Física com este cpf!"); 
            }
            else
            { dmPessoaFisica.incluir(this); }
        }
    }   

    public void excluir(PessoaFisica objPF)
    {   if (objPF.getCpf().equals(""))
        {   JOptionPane.showMessageDialog(null,"O cpf da Pessoa Física é obrigatório!","Mensagem de alerta",JOptionPane.WARNING_MESSAGE);
            System.out.println("O cpf da Pessoa Física é obrigatório!");
        }
        else
        {   if (dmPessoaFisica.consultar(this)!= null)
            { dmPessoaFisica.excluir(this); }
            else
            {   JOptionPane.showMessageDialog(null,"Exclusão de Pessoa Física não realizada!\n Este paciente não existe!","Mensagem de Erro",JOptionPane.ERROR_MESSAGE);
                System.out.println("Exclusão de Pessoa Física não realizada!\n Este paciente não existe!");
            }
        }    
    }

    public void alterar()
    {   if (dmPessoaFisica.consultar(this)!= null)
        { dmPessoaFisica.alterar(this); }
        else
        {   JOptionPane.showMessageDialog(null,"Impossivel alterar esta Pessoa Física !");
            System.out.println("Impossivel alterar esta Pessoa Física !"); }
    }

    public PessoaFisica pesquisar(PessoaFisica objPF)
    {   dmPessoaFisica.consultar(this);
        return objPF;
    }

    public void shutDown()
    {   dmPessoaFisica.shutDown();   }
}