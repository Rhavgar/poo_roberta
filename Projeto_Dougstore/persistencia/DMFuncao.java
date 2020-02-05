package persistencia;

import modelo.Funcao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class DMFuncao extends DMGeral
{
	String codigo = null;
	
	public void incluir(Object obj)
	{
		 Funcao objF = (Funcao) obj;
		
		try
		{
			Statement statement = getConnection().createStatement();
			
			String incluirSQL = "INSERT INTO funcao(" +
								"codigo, descricao, salario " +
								") VALUES ('" +
								objF.getCodigo() + "', '" +
								objF.getDescricao() + "', '" +
								objF.getSalario() + "')";
			
			System.out.println("Enviando código SQL: " + getConnection().nativeSQL(incluirSQL) + "\n");
			
			int result = statement.executeUpdate(incluirSQL);
			
			if (result == 1)
			{
				JOptionPane.showMessageDialog(null, "Funcao cadastrada corretamente!", "Mensagem de Informação", JOptionPane.INFORMATION_MESSAGE);
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Erro ao cadastrar funcao!", "Mensagem de Erro", JOptionPane.ERROR_MESSAGE);
				
				objF.setCodigo("");
				objF.setDescricao("");
				objF.setSalario("");
			}
			
			statement.close();
		}
		
		catch (SQLException e)
		{
			System.out.println("Problemas com o SQL de inclusão de Funcao");
		}
	}
	
	public Object consultar(Object obj)
	{
		Funcao objF = (Funcao) obj;
		
		try
		{
			Statement statement = getConnection().createStatement();
			
			String consultarSQL = "SELECT * FROM funcao WHERE codigo = '" + objF.getCodigo() + "'";
			
			System.out.println("Enviando código SQL: " + getConnection().nativeSQL(consultarSQL));
			
			ResultSet result = statement.executeQuery(consultarSQL);
			
			if (result.next())
			{
				System.out.println("Funcao existente!");
				System.out.println("Funcao");
				System.out.println("Codigo........: " + result.getString("codigo"));
				System.out.println("Descricao.....: " + result.getString("descricao"));
				System.out.println("Salario.......: " + result.getString("salario"));
				result.close();
			}
			else
			{
				System.out.println("Funcao não encontrada!\n");
				objF = null;
			}
			
			statement.close();
		}
		
		catch (SQLException e)
		{
			System.out.println("Problemas com o SQL de consulta de Funcao!");
		}
		
		return objF;
	}
	
	public void alterar(Object obj)
	{
		Funcao objF = (Funcao) obj;
		
		try
		{
			Statement statement = getConnection().createStatement();
			
			String alterarSQL = "UPDATE funcao SET descricao ='" + objF.getDescricao() + "', salario ='" + objF.getSalario() + "' WHERE codigo ='" + objF.getCodigo() + "'";
			
			System.out.println("Enviando código SQL: " + getConnection().nativeSQL(alterarSQL));
			
			int result = statement.executeUpdate(alterarSQL);
			
			if (result == 1)
			{
				JOptionPane.showMessageDialog(null, "Funcao alterada corretamente!", "Mensagem de Informação", JOptionPane.INFORMATION_MESSAGE);
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Erro ao alterar funcao!", "Mensagem de Erro", JOptionPane.ERROR_MESSAGE);
				
				objF.setCodigo("");
				objF.setDescricao("");
				objF.setSalario("");
			}
						
			statement.close();
		}
		
		catch (SQLException e)
		{
			System.out.println("Problemas com o SQL de alteração de Funcao");
		}
	}
	
	public void excluir(Object obj) 
	{
		Funcao objF = (Funcao) obj;
		
		try
		{
			Statement statement = getConnection().createStatement();
			
			String excluirSQL = "DELETE FROM funcao WHERE codigo='" + objF.getCodigo() + "'";
			
			System.out.println("Enviando código SQL: " + getConnection().nativeSQL(excluirSQL));
			
			int result = statement.executeUpdate(excluirSQL);
			
			if (result == 1)
			{
				JOptionPane.showMessageDialog(null, "Funcao excluída corretamente!", "Mensagem de Informação", JOptionPane.INFORMATION_MESSAGE);
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Erro ao excluir funcao!", "Mensagem de Erro", JOptionPane.ERROR_MESSAGE);
				
				objF.setCodigo("");
				objF.setDescricao("");
				objF.setSalario("");
			}
						
			statement.close();
		}
		
		catch (SQLException e)
		{
			System.out.println("Problemas com o SQL de exclusão de Funcao");
		}
		
	}
	
	public Funcao buscar(Object obj)
	{
		Funcao objF = (Funcao) obj;
		
		try
		{
			Statement statement = getConnection().createStatement();
			
			String buscarSQL = "SELECT * FROM funcao WHERE codigo = '" + objF.getCodigo() + "'";
			
			System.out.println("Enviando código SQL: " + getConnection().nativeSQL(buscarSQL));
			
			ResultSet result = statement.executeQuery(buscarSQL);
			
			if (result.next())
			{
				System.out.println("Funcao existente!");
				System.out.println("Funcao");
				System.out.println("Codigo........: " + result.getString("codigo"));
				System.out.println("Descricao.....: " + result.getString("descricao"));
				System.out.println("Salario.......: " + result.getString("salario"));
				
				objF.setDescricao(result.getString("descricao"));
				objF.setSalario(result.getString("salario"));
				result.close();
			}
			else
			{
				System.out.println("Funcao não encontrada!\n");
				objF = null;
			}
			statement.close();
		}
		
		catch (SQLException e)
		{
			System.out.println("Problemas com o SQL de consulta de Funcao!");
		}
		
		return objF;
	}
	
	public String relatorio()
	{
		String resultado = "";
		
		try
		{
			Statement statement = getConnection().createStatement();
			
			String relatorioSQL = "SELECT * FROM funcao;";
					
			System.out.println("Enviando código SQL: " + getConnection().nativeSQL(relatorioSQL));
			
			ResultSet result = statement.executeQuery(relatorioSQL);
			
			if (result.next()) 
			{
				do
				{
					resultado += "Codigo: " + result.getString("codigo");
					resultado += "\nDescricao: " + result.getString("descricao");
					resultado += "\nSalario: " + result.getString("salario");
					resultado += ("\n\n\n");
				} 
				while (result.next());
				
				result.close();
			} 
			else 
			{
				resultado = "Nenhuma funcao foi encontrada";
			}
			
			statement.close();

		}
		
		catch (SQLException e)
		{
			System.out.println("Problemas com o SQL de relatorio de Funcao!"); 
		}
		 
		return resultado;
	}
	
}
