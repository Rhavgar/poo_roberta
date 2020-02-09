package persistencia;

import modelo.Estoque;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class DMEstoque extends DMGeral
{
	String lote = null;
	
	public void incluir(Object obj)
	{
		Estoque objE = (Estoque) obj;
		
		try
		{
			Statement statement = getConnection().createStatement();
			
			String incluirSQL = "INSERT INTO estoque(" +
								"lote, quantidade, preco_venda, preco_custo, fabricacao, validade, produto_codigo" +
								") VALUES ('" +
								objE.getLote() + "', '" +
								objE.getQuantidade() + "', '" +
								objE.getPreco_venda() + "', '" +
								objE.getPreco_custo() + "', '" +
								objE.getFabricacao() + "', '" +
								objE.getValidade() + "', '" +
								objE.getProduto_codigo() + "')";
			
			System.out.println("Enviando código SQL: " + getConnection().nativeSQL(incluirSQL) + "\n");
			
			int result = statement.executeUpdate(incluirSQL);
			
			if (result == 1)
			{
				JOptionPane.showMessageDialog(null, "Estoque cadastrado corretamente!", "Mensagem de Informação", JOptionPane.INFORMATION_MESSAGE);
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Erro ao cadastrar estoque!", "Mensagem de Erro", JOptionPane.ERROR_MESSAGE);
				
				objE.setLote("");
				objE.setQuantidade("");
				objE.setPreco_venda("");
				objE.setPreco_custo("");
				objE.setFabricacao("");
				objE.setValidade("");
				objE.setProduto_codigo("");
			}
			
			statement.close();
		}
		
		catch (SQLException e)
		{
			System.out.println("Problemas com o SQL de inclusão de Estoque");
		}
	}
	
	public Object consultar(Object obj)
	{
		Estoque objE = (Estoque) obj;
		
		try
		{
			Statement statement = getConnection().createStatement();
			
			String consultarSQL = "SELECT * FROM estoque WHERE lote = '" + objE.getLote() + "'";
			
			System.out.println("Enviando código SQL: " + getConnection().nativeSQL(consultarSQL));
			
			ResultSet result = statement.executeQuery(consultarSQL);
			
			if (result.next())
			{
				System.out.println("Estoque existente!");
				System.out.println("Estoque");
				System.out.println("Lote...............: " + result.getString("lote"));
				System.out.println("Quantidade.........: " + result.getString("quantidade"));
				System.out.println("Preco de Venda.....: " + result.getString("preco_venda"));
				System.out.println("Preco de Custo.....: " + result.getString("preco_custo"));
				System.out.println("Fabricacao.........: " + result.getString("fabricacao"));
				System.out.println("Validade...........: " + result.getString("validade"));
				System.out.println("Codigo do Produto..: " + result.getString("produto_codigo"));
				result.close();
			}
			else
			{
				System.out.println("Estoque não encontrado!\n");
				objE = null;
			}
			
			statement.close();
		}
		
		catch (SQLException e)
		{
			System.out.println("Problemas com o SQL de consulta de Estoque!");
		}
		
		return objE;
	}
	
	public void alterar(Object obj)
	{
		Estoque objE = (Estoque) obj;
		
		try
		{
			Statement statement = getConnection().createStatement();
			
			String alterarSQL = "UPDATE estoque SET quantidade ='" + objE.getQuantidade() + 
					"', preco_venda ='" + objE.getPreco_venda() +
					"', preco_custo ='" + objE.getPreco_custo() +
					"', fabricacao ='" + objE.getFabricacao() +
					"', validade ='" + objE.getValidade() +
					"', produto_codigo ='" + objE.getProduto_codigo() +
					"' WHERE lote ='" + objE.getLote() + "'";
			
			System.out.println("Enviando código SQL: " + getConnection().nativeSQL(alterarSQL));
			
			int result = statement.executeUpdate(alterarSQL);
			
			if (result == 1)
			{
				JOptionPane.showMessageDialog(null, "Estoque alterado corretamente!", "Mensagem de Informação", JOptionPane.INFORMATION_MESSAGE);
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Erro ao alterar estoque!", "Mensagem de Erro", JOptionPane.ERROR_MESSAGE);
				
				objE.setLote("");
				objE.setQuantidade("");
				objE.setPreco_venda("");
				objE.setPreco_custo("");
				objE.setFabricacao("");
				objE.setValidade("");
				objE.setProduto_codigo("");
				
			}
						
			statement.close();
		}
		
		catch (SQLException e)
		{
			System.out.println("Problemas com o SQL de alteração de estoque");
		}
	}
	
	public void excluir(Object obj) 
	{
		Estoque objE = (Estoque) obj;
		
		try
		{
			Statement statement = getConnection().createStatement();
			
			String excluirSQL = "DELETE FROM estoque WHERE lote='" + objE.getLote() + "'";
			
			System.out.println("Enviando código SQL: " + getConnection().nativeSQL(excluirSQL));
			
			int result = statement.executeUpdate(excluirSQL);
			
			if (result == 1)
			{
				JOptionPane.showMessageDialog(null, "Estoque excluído corretamente!", "Mensagem de Informação", JOptionPane.INFORMATION_MESSAGE);
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Erro ao excluir estoque!", "Mensagem de Erro", JOptionPane.ERROR_MESSAGE);
				
				objE.setLote("");
				objE.setQuantidade("");
				objE.setPreco_venda("");
				objE.setPreco_custo("");
				objE.setFabricacao("");
				objE.setValidade("");
				objE.setProduto_codigo("");
			}
						
			statement.close();
		}
		
		catch (SQLException e)
		{
			System.out.println("Problemas com o SQL de exclusão de Estoque");
		}
		
	}
	
	public Estoque buscar(Object obj)
	{
		Estoque objE = (Estoque) obj;
		
		try
		{
			Statement statement = getConnection().createStatement();
			
			String buscarSQL = "SELECT * FROM estoque WHERE lote = '" + objE.getLote() + "'";
			
			System.out.println("Enviando código SQL: " + getConnection().nativeSQL(buscarSQL));
			
			ResultSet result = statement.executeQuery(buscarSQL);
			
			if (result.next())
			{
				System.out.println("Estoque existente!");
				System.out.println("Estoque");
				System.out.println("Lote...............: " + result.getString("lote"));
				System.out.println("Quantidade.........: " + result.getString("quantidade"));
				System.out.println("Preco de Venda.....: " + result.getString("preco_venda"));
				System.out.println("Preco de Custo.....: " + result.getString("preco_custo"));
				System.out.println("Fabricacao.........: " + result.getString("fabricacao"));
				System.out.println("Validade...........: " + result.getString("validade"));
				System.out.println("Codigo do Produto..: " + result.getString("produto_codigo"));
				
				objE.setQuantidade(result.getString("quantidade"));
				objE.setPreco_venda(result.getString("preco_venda"));
				objE.setPreco_custo(result.getString("preco_custo"));
				objE.setFabricacao(result.getString("fabricacao"));
				objE.setValidade(result.getString("validade"));
				objE.setProduto_codigo(result.getString("produto_codigo"));
				result.close();
			}
			else
			{
				System.out.println("Estoque não encontrado!\n");
				objE = null;
			}
			statement.close();
		}
		
		catch (SQLException e)
		{
			System.out.println("Problemas com o SQL de consulta de Estoque!");
		}
		
		return objE;
	}
	
	public String relatorio()
	{
		String resultado = "";
		
		try
		{
			Statement statement = getConnection().createStatement();
			
			String relatorioSQL = "SELECT * FROM estoque;";
					
			System.out.println("Enviando código SQL: " + getConnection().nativeSQL(relatorioSQL));
			
			ResultSet result = statement.executeQuery(relatorioSQL);
			
			if (result.next()) 
			{
				do
				{
					resultado += "Lote: " + result.getString("lote");
					resultado += "\nQuantidade: " + result.getString("quantidade");
					resultado += "\nPreco de Venda: " + result.getString("preco_venda");
					resultado += "\nPreco de Custo: " + result.getString("preco_custo");
					resultado += "\nFabricacao: " + result.getString("fabricacao");
					resultado += "\nValidade: " + result.getString("validade");
					resultado += "\nCodigo do Produto: " + result.getString("produto_codigo");
					resultado += ("\n\n\n");
				} 
				while (result.next());
				
				result.close();
			} 
			else 
			{
				resultado = "Nenhum estoque foi encontrado";
			}
			
			statement.close();

		}
		
		catch (SQLException e)
		{
			System.out.println("Problemas com o SQL de relatorio de Estoque!"); 
		}
		 
		return resultado;
	}
	
}
