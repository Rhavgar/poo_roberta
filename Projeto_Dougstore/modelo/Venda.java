package modelo;

import java.sql.Statement;

import javax.swing.JOptionPane;

import persistencia.DMVenda;

public class Venda 
{
	private String id;
	private String forma_pag;
	private String funcionario_cpf;
	private String cliente_cpf;
	
	private float valor;
	private String item;
	private String overview;
	
	private DMVenda dm_venda;
	
	public Venda()
	{
		dm_venda = new DMVenda();
		
		dm_venda.conectaDataBase("dougstore", "root", "tether55");
		
		System.out.println("Conexão feita à tabela Produto com sucesso!");
	}
	
	public Venda(String id, String forma_pag, String funcionario_cpf, String cliente_cpf)
	{
		this.id = id;
		this.forma_pag = forma_pag;
		this.funcionario_cpf = funcionario_cpf;
		this.cliente_cpf = cliente_cpf;
		
		this.valor = 0;
		this.item = "";
		this.overview = "";
		
		dm_venda = new DMVenda();
		
		dm_venda.conectaDataBase("dougstore", "root", "tether55");
		
		System.out.println("Conexão feita à tabela Produto com sucesso!");
	}
	
	public void adicionarValor(float valor)
	{
		this.valor = this.valor + valor;
	}
	
	public void adicionarOverview(String lote, float qtd, float total)
	{
		this.overview += "\nNome Comercial: " + dm_venda.nome_item(lote) + "; Quantidade: " + qtd + "; Total: " + total +".";
	}
	
	public void adicionarItem(String lote, float qtd)
	{		
		float valor_total = dm_venda.total_item(lote, qtd);
		
		this.item += "\nINSERT INTO item_venda (quantidade, valor_total, venda_id, estoque_lote) VALUES ("
				+ qtd + ", " + valor_total + ", " + id + ", " + lote + ");";
		
		this.adicionarValor(valor_total);
		
		this.adicionarOverview(lote, qtd, valor_total);
	}
	
	public void incluir()
	{
		if (this.getId().equals(""))
		{
			JOptionPane.showMessageDialog(null, "O ID da Venda é obrigatório!", "Mensagem de alerta", JOptionPane.WARNING_MESSAGE);
			System.out.println("O ID da Venda é obrigatório!");
		}
		else
		{
			if (dm_venda.consultar(this) != null)
			{
				JOptionPane.showMessageDialog(null, "Registro da Venda não realizado!\n Já existe um Produto com este Codigo!", "Mensagem de Erro", JOptionPane.ERROR_MESSAGE);
				System.out.println("Registro da Venda não realizado! Já existe uma Venda com este ID!");
			}
			else
			{
				dm_venda.incluir(this);
			}
		}
	}
	
	public String relatorio()
	{
		return dm_venda.relatorio();
	}

	public String getId() 
	{
		return id;
	}

	public void setId(String id) 
	{
		this.id = id;
	}

	public String getForma_pag()
	{
		return forma_pag;
	}

	public void setForma_pag(String forma_pag)
	{
		this.forma_pag = forma_pag;
	}

	public String getFuncionario_cpf()
	{
		return funcionario_cpf;
	}

	public void setFuncionario_cpf(String funcionario_cpf)
	{
		this.funcionario_cpf = funcionario_cpf;
	}

	public String getCliente_cpf()
	{
		return cliente_cpf;
	}

	public void setCliente_cpf(String cliente_cpf)
	{
		this.cliente_cpf = cliente_cpf;
	}

	public float getValor()
	{
		return valor;
	}

	public void setValor(float valor) 
	{
		this.valor = valor;
	}

	public String getItem()
	{
		return item;
	}

	public void setItem(String item) 
	{
		this.item = item;
	}

	public String getOverview() 
	{
		return overview;
	}

	public void setOverview(String overview) 
	{
		this.overview = overview;
	}
	
	
}
