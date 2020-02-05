package persistencia;

import modelo.Venda;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class DMVenda extends DMGeral 
{
	String id = null;
	
	public void incluir(Object obj)
	{
		Venda objV = (Venda) obj;
		
		try
		{
			Statement statement = getConnection().createStatement();
			
			String incluirSQL = "INSERT INTO venda(" +
								"id_venda, data_venda, valor, forma_pag, funcionario_cpf, cliente_cpf" +
								") VALUES (" +
								objV.getId() + ", " +
								"NOW(), " +
								objV.getValor() + ", '" +
								objV.getForma_pag() + "', '" +
								objV.getFuncionario_cpf() + "', '" +
								objV.getCliente_cpf() + "')";
			
			System.out.println("Enviando código SQL: " + getConnection().nativeSQL(incluirSQL) + "\n");
			
			int result = statement.executeUpdate(incluirSQL);
			
			if (result == 1)
			{
				JOptionPane.showMessageDialog(null, "Venda registrada corretamente!", "Mensagem de Informação", JOptionPane.INFORMATION_MESSAGE);
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Erro ao registrar venda!", "Mensagem de Erro", JOptionPane.ERROR_MESSAGE);
			}
			
			statement.close();
		}
		
		catch (SQLException e)
		{
			System.out.println("Problemas com o SQL de registro de Venda");
		}
	}
	
	public void incluirItem(Object obj)
	{
		Venda objV = (Venda) obj;
		
		try
		{
			Statement statement = getConnection().createStatement();
			
			String incluirSQL = objV.getItem();
			
			System.out.println("Enviando código SQL: " + getConnection().nativeSQL(incluirSQL) + "\n");
			
			int result = statement.executeUpdate(incluirSQL);
			
			if (result == 1)
			{
				JOptionPane.showMessageDialog(null, "Item registrada corretamente!", "Mensagem de Informação", JOptionPane.INFORMATION_MESSAGE);
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Erro ao registrar item!", "Mensagem de Erro", JOptionPane.ERROR_MESSAGE);
			}
			
			statement.close();
		}
		
		catch (SQLException e)
		{
			System.out.println("Problemas com o SQL de registro de Item");
		}
	}
	
	public String relatorio()
	{
		String resultado = "";
		
		try
		{
			Statement statement = getConnection().createStatement();
			
			String relatorioSQL = "SELECT venda_id, quantidade, valor_total, valor " + 
					"FROM item_venda " + 
					"JOIN venda ON id_venda = venda_id;";
					
			System.out.println("Enviando código SQL: " + getConnection().nativeSQL(relatorioSQL));
			
			ResultSet result = statement.executeQuery(relatorioSQL);
			
			if (result.next()) 
			{
				do
				{
					resultado += "ID Venda: " + result.getString("venda_id");
					resultado += "\nQuantidade: " + result.getString("quantidade");
					resultado += "\nTotal Item: " + result.getString("valor_total");
					resultado += "\nTotal Venda: " + result.getString("valor");
					resultado += ("\n\n\n");
				} 
				while (result.next());
				
				result.close();
			} 
			else 
			{
				resultado = "Nenhum venda foi encontrada";
			}
			
			statement.close();

		}
		
		catch (SQLException e)
		{
			System.out.println("Problemas com o SQL de relatorio de Venda!"); 
		}
		 
		return resultado;
	}
	
	public float total_item(String lote, float qtd)
	{
		try
		{
			Statement statement = getConnection().createStatement();
			
			String totalSQL = "SELECT preco_venda FROM estoque WHERE (lote=" + lote + ")";
			
			System.out.println("Enviando código SQL: " + getConnection().nativeSQL(totalSQL));
			
			ResultSet result = statement.executeQuery(totalSQL);
			
			if (result.next())
			{
				return result.getFloat("preco_venda") * qtd;
			}
			else
			{
				System.out.println("Estoque não encontrado!\n");
			}
			
			statement.close();
		}
		
		catch (SQLException e)
		{
			System.out.println("Problemas com o SQL de consulta de Estoque");
		}
		
		return 0;

	}
	
	public String nome_item(String lote)
	{
		try
		{
			Statement statement = getConnection().createStatement();
			
			String totalSQL = "SELECT nome_comercial FROM estoque JOIN produto ON estoque.produto_codigo = produto.codigo WHERE (estoque.lote=" + lote + ")";
			
			System.out.println("Enviando código SQL: " + getConnection().nativeSQL(totalSQL));
			
			ResultSet result = statement.executeQuery(totalSQL);
			
			if (result.next())
			{
				return result.getString("nome_comercial");
			}
			else
			{
				System.out.println("Produto não encontrado!\n");
			}
			
			statement.close();
		}
		
		catch (SQLException e)
		{
			System.out.println("Problemas com o SQL de consulta de Estoque");
		}
		
		return null;

	}

	@Override
	public Object consultar(Object obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void alterar(Object obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void excluir(Object obj) {
		// TODO Auto-generated method stub
		
	}

}
