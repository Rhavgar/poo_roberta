package persistencia;

import modelo.Produto;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class DMProduto extends DMGeral
{
	String codigo = null;
	
	// implementação do método incluir
	public void incluir(Object obj)
	{
		Produto objP = (Produto) obj;
		
		try
		{
			Statement statement = getConnection().createStatement();
			
			// montagem da String SQL de inclusão na tabela
			String incluirSQL = "INSERT INTO produto(" +
								"codigo, fabricacao, validade, quantidade, preco_venda, preco_custo " +
								") VALUES ('" +
								objP.getCodigo() + "', '" +
								objP.getFabricacao() + "', '" +
								objP.getValidade() + "', '" +
								objP.getQuantidade() + "', '" +
								objP.getPreco_venda() + "', '" +
								objP.getPreco_custo() + "')" ;
			
			System.out.println("Enviando código SQL: " + getConnection().nativeSQL(incluirSQL) + "\n");
			
			int result = statement.executeUpdate(incluirSQL);
			
			if (result == 1)
			{
				JOptionPane.showMessageDialog(null, "Produto cadastrado corretamente!", "Mensagem de Informação", JOptionPane.INFORMATION_MESSAGE);
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Erro ao cadastrar produto!", "Mensagem de Erro", JOptionPane.ERROR_MESSAGE);
				
				objP.getCodigo();
				objP.getFabricacao();
				objP.getValidade();
				objP.getQuantidade();
				objP.getPreco_venda();
				objP.getPreco_custo();
			}
			statement.close();
		}
		catch (SQLException e)
		{
			System.out.println("Problemas com o SQL de inclusão de produto");
		}
	}
	
	// implementação do método consultar
	public Object consultar(Object obj)
	{
		Produto objP = (Produto) obj;
		
		try
		{
			Statement statement = getConnection().createStatement();
			
			//montagem da String SQL de consulta na tabela
			String consultarSQL = "SELECT * FROM produto WHERE (codigo = '" + objP.getCodigo() + "')";
			System.out.println("Enviando código SQL: " + getConnection().nativeSQL(consultarSQL));
			
			ResultSet result = statement.executeQuery(consultarSQL);
			
			if (result.next())
			{
				System.out.println("Produto existente!");
				System.out.println("Produto");
				System.out.println("Codigo................: " + result.getString("codigo"));
				System.out.println("Fabricação............: " + result.getString("fabricacao"));
				System.out.println("Validade..............: " + result.getString("validade"));
				System.out.println("Quantidade............: " + result.getString("quantidade"));
				System.out.println("Preço de venda........: " + result.getString("preco_venda"));
				System.out.println("Preço de custo........: " + result.getString("preco_custo"));
				result.close();
			}
			else
			{
				System.out.println("Produto não encontrado!\n");
				objP = null;
			}
			statement.close();
		}
		catch (SQLException e)
		{
			System.out.println("Problemas com o SQL de consulta de Funcionário!");
		}
		
		return objP;
	}
	
	public Produto buscar(String codigo)
	{
		Produto objP = new Produto();
		
		try
		{
			Statement statement = getConnection().createStatement();
			
			//montagem da String SQL de consulta na tabela
			String consultarSQL = "SELECT * FROM produto WHERE (codigo = '" + codigo + "')";
			System.out.println("Enviando código SQL: " + getConnection().nativeSQL(consultarSQL));
			
			ResultSet result = statement.executeQuery(consultarSQL);
			
			if (result.next())
			{
				System.out.println("Produto existente!");
				System.out.println("Produto");
				System.out.println("Codigo................: " + result.getString("codigo"));
				System.out.println("Fabricação............: " + result.getString("fabricacao"));
				System.out.println("Validade..............: " + result.getString("validade"));
				System.out.println("Quantidade............: " + result.getString("quantidade"));
				System.out.println("Preço de venda........: " + result.getString("preco_venda"));
				System.out.println("Preço de custo........: " + result.getString("preco_custo"));
				
				objP.setCodigo(codigo);
				objP.setQuantidade(result.getString("quantidade"));
				JOptionPane.showMessageDialog(null, objP.getQuantidade());
				result.close();
			}
			else
			{
				System.out.println("Produto não encontrado!\n");
				objP = null;
			}
			statement.close();
		}
		catch (SQLException e)
		{
			System.out.println("Problemas com o SQL de consulta de Produto!");
		}
		
		return objP;
	}

	@Override
	public void excluir(Object obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void alterar(Object obj) {
		// TODO Auto-generated method stub
		
	}
}
