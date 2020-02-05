package persistencia;

import modelo.Fornecedor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class DMFornecedor extends DMGeral
{
	String cnpj = null;
	
	public void incluir(Object obj)
	{
		Fornecedor objFo = (Fornecedor) obj;
		
		try
		{
			Statement statement = getConnection().createStatement();
			
			String incluirSQL = "INSERT INTO fornecedor(" +
								"cnpj, nome_fantasia, contato " +
								") VALUES ('" +
								objFo.getCnpj() + "', '" +
								objFo.getNome_fantasia() + "', '" +
								objFo.getContato() + "')";
			
			System.out.println("Enviando código SQL: " + getConnection().nativeSQL(incluirSQL) + "\n");
			
			int result = statement.executeUpdate(incluirSQL);
			
			if (result == 1)
			{
				JOptionPane.showMessageDialog(null, "Fornecedor cadastrado corretamente!", "Mensagem de Informação", JOptionPane.INFORMATION_MESSAGE);
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Erro ao cadastrar fornecedor!", "Mensagem de Erro", JOptionPane.ERROR_MESSAGE);
				
				objFo.setCnpj("");
				objFo.setNome_fantasia("");
				objFo.setContato("");
			}
			
			statement.close();
		}
		
		catch (SQLException e)
		{
			System.out.println("Problemas com o SQL de inclusão de Fornecedor");
		}
	}
	
	public Object consultar(Object obj)
	{
		Fornecedor objFo = (Fornecedor) obj;
		
		try
		{
			Statement statement = getConnection().createStatement();
			
			String consultarSQL = "SELECT * FROM fornecedor WHERE cnpj = '" + objFo.getCnpj() + "'";
			
			System.out.println("Enviando código SQL: " + getConnection().nativeSQL(consultarSQL));
			
			ResultSet result = statement.executeQuery(consultarSQL);
			
			if (result.next())
			{
				System.out.println("Fornecedor existente!");
				System.out.println("Fornecedor");
				System.out.println("CNPJ...........: " + result.getString("cnpj"));
				System.out.println("Nome Fantasia..: " + result.getString("nome_fantasia"));
				System.out.println("Contato........: " + result.getString("contato"));
				result.close();
			}
			else
			{
				System.out.println("Fornecedor não encontrado!\n");
				objFo = null;
			}
			
			statement.close();
		}
		
		catch (SQLException e)
		{
			System.out.println("Problemas com o SQL de consulta de Fornecedor!");
		}
		
		return objFo;
	}
	
	public void alterar(Object obj)
	{
		Fornecedor objFo = (Fornecedor) obj;
		
		try
		{
			Statement statement = getConnection().createStatement();
			
			String alterarSQL = "UPDATE fornecedor SET nome_fantasia ='" + objFo.getNome_fantasia() +
								"', contato ='" + objFo.getContato() + "' WHERE cnpj ='" + objFo.getCnpj() + "'";
			
			System.out.println("Enviando código SQL: " + getConnection().nativeSQL(alterarSQL));
			
			int result = statement.executeUpdate(alterarSQL);
			
			if (result == 1)
			{
				JOptionPane.showMessageDialog(null, "Fornecedor alterado corretamente!", "Mensagem de Informação", JOptionPane.INFORMATION_MESSAGE);
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Erro ao alterar fornecedor!", "Mensagem de Erro", JOptionPane.ERROR_MESSAGE);
				
				objFo.setCnpj("");
				objFo.setNome_fantasia("");
				objFo.setContato("");
			}
						
			statement.close();
		}
		
		catch (SQLException e)
		{
			System.out.println("Problemas com o SQL de alteração de fornecedor");
		}
	}
	
	public void excluir(Object obj) 
	{
		Fornecedor objFo = (Fornecedor) obj;
		
		try
		{
			Statement statement = getConnection().createStatement();
			
			String excluirSQL = "DELETE FROM fornecedor WHERE cnpj='" + objFo.getCnpj() + "'";
			
			System.out.println("Enviando código SQL: " + getConnection().nativeSQL(excluirSQL));
			
			int result = statement.executeUpdate(excluirSQL);
			
			if (result == 1)
			{
				JOptionPane.showMessageDialog(null, "Fornecedor excluído corretamente!", "Mensagem de Informação", JOptionPane.INFORMATION_MESSAGE);
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Erro ao excluir fornecedor!", "Mensagem de Erro", JOptionPane.ERROR_MESSAGE);
				
				objFo.setCnpj("");
				objFo.setNome_fantasia("");
				objFo.setContato("");
			}
						
			statement.close();
		}
		
		catch (SQLException e)
		{
			System.out.println("Problemas com o SQL de exclusão de Fornecedor");
		}
		
	}
	
	public Fornecedor buscar(Object obj)
	{
		Fornecedor objFo = (Fornecedor) obj;
		
		try
		{
			Statement statement = getConnection().createStatement();
			
			String buscarSQL = "SELECT * FROM fornecedor WHERE cnpj = '" + objFo.getCnpj() + "'";
			
			System.out.println("Enviando código SQL: " + getConnection().nativeSQL(buscarSQL));
			
			ResultSet result = statement.executeQuery(buscarSQL);
			
			if (result.next())
			{
				System.out.println("Fornecedor existente!");
				System.out.println("Fornecedor");
				System.out.println("CNPJ...........: " + result.getString("cnpj"));
				System.out.println("Nome Fantasia..: " + result.getString("nome_fantasia"));
				System.out.println("Contato........: " + result.getString("contato"));
				
				objFo.setNome_fantasia(result.getString("nome_fantasia"));
				objFo.setContato(result.getString("contato"));
				result.close();
			}
			else
			{
				System.out.println("Fornecedor não encontrado!\n");
				objFo = null;
			}
			statement.close();
		}
		
		catch (SQLException e)
		{
			System.out.println("Problemas com o SQL de consulta de Fornecedor!");
		}
		
		return objFo;
	}
	
	public String relatorio()
	{
		String resultado = "";
		
		try
		{
			Statement statement = getConnection().createStatement();
			
			String relatorioSQL = "SELECT * FROM fornecedor;";
					
			System.out.println("Enviando código SQL: " + getConnection().nativeSQL(relatorioSQL));
			
			ResultSet result = statement.executeQuery(relatorioSQL);
			
			if (result.next()) 
			{
				do
				{
					resultado += "Nome Fantasia: " + result.getString("nome_fantasia");
					resultado += "\nCNPJ: " + result.getString("cnpj");
					resultado += "\nContato: " + result.getString("contato");
					resultado += ("\n\n\n");
				} 
				while (result.next());
				
				result.close();
			} 
			else 
			{
				resultado = "Nenhum fornecedor foi encontrado";
			}
			
			statement.close();

		}
		
		catch (SQLException e)
		{
			System.out.println("Problemas com o SQL de relatorio de Fornecedor!"); 
		}
		 
		return resultado;
	}
	
}
