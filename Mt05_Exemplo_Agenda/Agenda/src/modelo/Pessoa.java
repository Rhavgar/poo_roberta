package modelo;

public abstract class Pessoa
{
	//atributo comum
	protected String nome;
	
	//atributos de referência
	protected Endereco atRefEndereco;
	protected Telefone atRefTelefone;
	
	//métodos de acesso
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Endereco getAtRefEndereco() {
		return atRefEndereco;
	}
	public void setAtRefEndereco(Endereco atRefEndereco) {
		this.atRefEndereco = atRefEndereco;
	}
	public Telefone getAtRefTelefone() {
		return atRefTelefone;
	}
	public void setAtRefTelefone(Telefone atRefTelefone) {
		this.atRefTelefone = atRefTelefone;
	}
	
}