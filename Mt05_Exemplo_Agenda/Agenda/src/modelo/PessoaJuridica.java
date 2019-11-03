package modelo;

import javax.swing.JOptionPane;

public class PessoaJuridica extends Pessoa
{	
	//atributos comuns
	private String cnpj;
	private String razaoSocial;
	
	//metodos de acesso
	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}
	
	//método construtor
	public PessoaJuridica()
	{	super();
		cnpj = JOptionPane.showInputDialog("Informe o CNPJ: ");
		razaoSocial = JOptionPane.showInputDialog("Informe a razão social: ");	
	}

	public void imprimir()
	{	//super.imprimir();
		JOptionPane.showMessageDialog(null,"CNPJ = "+cnpj);
		JOptionPane.showMessageDialog(null,"Razão Social = "+razaoSocial);
	}
}