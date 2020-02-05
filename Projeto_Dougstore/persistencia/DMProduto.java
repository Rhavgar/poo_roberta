package persistencia;

import modelo.Produto;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class DMProduto extends DMGeral
{
	String codigo = null;
	
	public void incluir(Object obj)
	{
		Produto objP = (Produto) obj;
		
		try
		{
			Statement statement = getConnection().createStatement();
			
			String incluirSQL = "INSERT INTO produto(" +
								"codigo, nome_comercial, nome_generico, tarja, tipo, fornecedor_cnpj" +
								") VALUES ('" +
								objP.getCodigo() + "', '" +
								objP.getNome_comercial() + "', '" +
								objP.getNome_generico() + "', '" +
								objP.getTarja() + "', '" +
								objP.getTipo() + "', '" +
								objP.getFornecedor_cnpj() + "')";
			
			System.out.println("Enviando código SQL: " + getConnection().nativeSQL(incluirSQL) + "\n");
			
			int result = statement.executeUpdate(incluirSQL);
			
			if (result == 1)
			{
				JOptionPane.showMessageDialog(null, "Produto cadastrado corretamente!", "Mensagem de Informação", JOptionPane.INFORMATION_MESSAGE);
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Erro ao cadastrar produto!", "Mensagem de Erro", JOptionPane.ERROR_MESSAGE);
				
				objP.setCodigo("");
				objP.setNome_comercial("");
				objP.setNome_generico("");
				objP.setTarja("");
				objP.setTipo("");
				objP.setFornecedor_cnpj("");
			}
			
			statement.close();
		}
		
		catch (SQLException e)
		{
			System.out.println("Problemas com o SQL de inclusão de Produto");
		}
	}
	
	public Object consultar(Object obj)
	{
		Produto objP = (Produto) obj;
		
		try
		{
			Statement statement = getConnection().createStatement();
			
			String consultarSQL = "SELECT * FROM produto WHERE codigo = '" + objP.getCodigo() + "'";
			
			System.out.println("Enviando código SQL: " + getConnection().nativeSQL(consultarSQL));
			
			ResultSet result = statement.executeQuery(consultarSQL);
			
			if (result.next())
			{
				System.out.println("Produto existente!");
				System.out.println("Produto");
				System.out.println("Codigo...........: " + result.getString("codigo"));
				System.out.println("Nome Comercial...: " + result.getString("nome_comercial"));
				System.out.println("Nome Generico....: " + result.getString("nome_generico"));
				System.out.println("Tarja............: " + result.getString("tarja"));
				System.out.println("Tipo.............: " + result.getString("tipo"));
				System.out.println("Fornecedor.......: " + result.getString("fornecedor_cnpj"));
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
	
	public void alterar(Object obj)
	{
		Produto objP = (Produto) obj;
		
		try
		{
			Statement statement = getConnection().createStatement();
			
			String alterarSQL = "UPDATE produto SET nome_comercial ='" + objP.getNome_comercial() + 
					"', nome_generico ='" + objP.getNome_generico() +
					"', tarja ='" + objP.getTarja() +
					"', tipo ='" + objP.getTipo() +
					"', fornecedor_cnpj ='" + objP.getFornecedor_cnpj() +
					"' WHERE cpf ='" + objP.getCodigo() + "'";
			
			System.out.println("Enviando código SQL: " + getConnection().nativeSQL(alterarSQL));
			
			int result = statement.executeUpdate(alterarSQL);
			
			if (result == 1)
			{
				JOptionPane.showMessageDialog(null, "Produto alterado corretamente!", "Mensagem de Informação", JOptionPane.INFORMATION_MESSAGE);
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Erro ao alterar produto!", "Mensagem de Erro", JOptionPane.ERROR_MESSAGE);
				
				objP.setCodigo("");
				objP.setNome_comercial("");
				objP.setNome_generico("");
				objP.setTarja("");
				objP.setTipo("");
				objP.setFornecedor_cnpj("");
			}
						
			statement.close();
		}
		
		catch (SQLException e)
		{
			System.out.println("Problemas com o SQL de alteração de produto");
		}
	}
	
	public void excluir(Object obj) 
	{
		Produto objP = (Produto) obj;
		
		try
		{
			Statement statement = getConnection().createStatement();
			
			String excluirSQL = "DELETE FROM produto WHERE codigo='" + objP.getCodigo() + "'";
			
			System.out.println("Enviando código SQL: " + getConnection().nativeSQL(excluirSQL));
			
			int result = statement.executeUpdate(excluirSQL);
			
			if (result == 1)
			{
				JOptionPane.showMessageDialog(null, "Produto excluído corretamente!", "Mensagem de Informação", JOptionPane.INFORMATION_MESSAGE);
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Erro ao excluir produto!", "Mensagem de Erro", JOptionPane.ERROR_MESSAGE);
				
				objP.setCodigo("");
				objP.setNome_comercial("");
				objP.setNome_generico("");
				objP.setTarja("");
				objP.setTipo("");
				objP.setFornecedor_cnpj("");
			}
						
			statement.close();
		}
		
		catch (SQLException e)
		{
			System.out.println("Problemas com o SQL de exclusão de Produto");
		}
		
	}
	
	public Produto buscar(Object obj)
	{
		Produto objP = (Produto) obj;
		
		try
		{
			Statement statement = getConnection().createStatement();
			
			String buscarSQL = "SELECT * FROM produto WHERE codigo = '" + objP.getCodigo() + "'";
			
			System.out.println("Enviando código SQL: " + getConnection().nativeSQL(buscarSQL));
			
			ResultSet result = statement.executeQuery(buscarSQL);
			
			if (result.next())
			{
				System.out.println("Produto existente!");
				System.out.println("Produto");
				System.out.println("Codigo...........: " + result.getString("codigo"));
				System.out.println("Nome Comercial...: " + result.getString("nome_comercial"));
				System.out.println("Nome Generico....: " + result.getString("nome_generico"));
				System.out.println("Tarja............: " + result.getString("tarja"));
				System.out.println("Tipo.............: " + result.getString("tipo"));
				System.out.println("Fornecedor.......: " + result.getString("fornecedor_cnpj"));
				
				objP.setNome_comercial(result.getString("nome_comercial"));
				objP.setNome_generico(result.getString("nome_generico"));
				objP.setTarja(result.getString("tarja"));
				objP.setTipo(result.getString("tipo"));
				objP.setFornecedor_cnpj(result.getString("fornecedor_cnpj"));
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
	
	public String relatorio()
	{
		String resultado = "";
		
		try
		{
			Statement statement = getConnection().createStatement();
			
			String relatorioSQL = "SELECT * FROM produto;";
					
			System.out.println("Enviando código SQL: " + getConnection().nativeSQL(relatorioSQL));
			
			ResultSet result = statement.executeQuery(relatorioSQL);
			
			if (result.next()) 
			{
				do
				{
					resultado += "Codigo: " + result.getString("codigo");
					resultado += "\nNome Comercial: " + result.getString("nome_comercial");
					resultado += "\nNome Generico: " + result.getString("nome_generico");
					resultado += "\nTarja: " + result.getString("tarja");
					resultado += "\nTipo: " + result.getString("tipo");
					resultado += "\nFornecedor: " + result.getString("fornecedor_cnpj");
					resultado += ("\n\n\n");
				} 
				while (result.next());
				
				result.close();
			} 
			else 
			{
				resultado = "Nenhum produto foi encontrado";
			}
			
			statement.close();

		}
		
		catch (SQLException e)
		{
			System.out.println("Problemas com o SQL de relatorio de Produto!"); 
		}
		 
		return resultado;
	}
	
}
