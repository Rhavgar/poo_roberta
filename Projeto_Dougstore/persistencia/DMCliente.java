package persistencia;

import modelo.Cliente;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class DMCliente extends DMGeral
{
	String cpf = null;
	
	public void incluir(Object obj)
	{
		Cliente objC = (Cliente) obj;
		
		try
		{
			Statement statement = getConnection().createStatement();
			
			String incluirSQL = "INSERT INTO cliente(" +
								"cpf, nome, nascimento " +
								") VALUES ('" +
								objC.getCpf() + "', '" +
								objC.getNome() + "', '" +
								objC.getNascimento() + "')";
			
			System.out.println("Enviando código SQL: " + getConnection().nativeSQL(incluirSQL) + "\n");
			
			int result = statement.executeUpdate(incluirSQL);
			
			if (result == 1)
			{
				JOptionPane.showMessageDialog(null, "Cliente cadastrado corretamente!", "Mensagem de Informação", JOptionPane.INFORMATION_MESSAGE);
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Erro ao cadastrar cliente!", "Mensagem de Erro", JOptionPane.ERROR_MESSAGE);
				
				objC.setCpf("");
				objC.setNome("");
				objC.setNascimento("");
			}
			
			statement.close();
		}
		
		catch (SQLException e)
		{
			System.out.println("Problemas com o SQL de inclusão de Cliente");
		}
	}
	
	public Object consultar(Object obj)
	{
		Cliente objC = (Cliente) obj;
		
		try
		{
			Statement statement = getConnection().createStatement();
			
			String consultarSQL = "SELECT * FROM cliente WHERE cpf = '" + objC.getCpf() + "'";
			
			System.out.println("Enviando código SQL: " + getConnection().nativeSQL(consultarSQL));
			
			ResultSet result = statement.executeQuery(consultarSQL);
			
			if (result.next())
			{
				System.out.println("Cliente existente!");
				System.out.println("Cliente");
				System.out.println("CPF........: " + result.getString("cpf"));
				System.out.println("Nome.......: " + result.getString("nome"));
				System.out.println("Nascimento.: " + result.getString("nascimento"));
				result.close();
			}
			else
			{
				System.out.println("Cliente não encontrado!\n");
				objC = null;
			}
			
			statement.close();
		}
		
		catch (SQLException e)
		{
			System.out.println("Problemas com o SQL de consulta de Cliente!");
		}
		
		return objC;
	}
	
	public void alterar(Object obj)
	{
		Cliente objC = (Cliente) obj;
		
		try
		{
			Statement statement = getConnection().createStatement();
			
			String alterarSQL = "UPDATE cliente SET nome ='" + objC.getNome() + "', nascimento ='" + objC.getNascimento() + "' WHERE cpf ='" + objC.getCpf() + "'";
			
			System.out.println("Enviando código SQL: " + getConnection().nativeSQL(alterarSQL));
			
			int result = statement.executeUpdate(alterarSQL);
			
			if (result == 1)
			{
				JOptionPane.showMessageDialog(null, "Cliente alterado corretamente!", "Mensagem de Informação", JOptionPane.INFORMATION_MESSAGE);
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Erro ao alterar cliente!", "Mensagem de Erro", JOptionPane.ERROR_MESSAGE);
				
				objC.setCpf("");
				objC.setNome("");
				objC.setNascimento("");
			}
						
			statement.close();
		}
		
		catch (SQLException e)
		{
			System.out.println("Problemas com o SQL de alteração de cliente");
		}
	}
	
	public void excluir(Object obj) 
	{
		Cliente objC = (Cliente) obj;
		
		try
		{
			Statement statement = getConnection().createStatement();
			
			String excluirSQL = "DELETE FROM cliente WHERE cpf='" + objC.getCpf() + "'";
			
			System.out.println("Enviando código SQL: " + getConnection().nativeSQL(excluirSQL));
			
			int result = statement.executeUpdate(excluirSQL);
			
			if (result == 1)
			{
				JOptionPane.showMessageDialog(null, "Cliente excluído corretamente!", "Mensagem de Informação", JOptionPane.INFORMATION_MESSAGE);
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Erro ao excluir cliente!", "Mensagem de Erro", JOptionPane.ERROR_MESSAGE);
				
				objC.setCpf("");
				objC.setNome("");
				objC.setNascimento("");
			}
						
			statement.close();
		}
		
		catch (SQLException e)
		{
			System.out.println("Problemas com o SQL de exclusão de Cliente");
		}
		
	}
	
	public Cliente buscar(Object obj)
	{
		Cliente objC = (Cliente) obj;
		
		try
		{
			Statement statement = getConnection().createStatement();
			
			String buscarSQL = "SELECT * FROM cliente WHERE cpf = '" + objC.getCpf() + "'";
			
			System.out.println("Enviando código SQL: " + getConnection().nativeSQL(buscarSQL));
			
			ResultSet result = statement.executeQuery(buscarSQL);
			
			if (result.next())
			{
				System.out.println("Cliente existente!");
				System.out.println("Cliente");
				System.out.println("CPF........: " + result.getString("cpf"));
				System.out.println("Nome.......: " + result.getString("nome"));
				System.out.println("Nascimento.: " + result.getString("nascimento"));
				
				objC.setNome(result.getString("nome"));
				objC.setNascimento(result.getString("nascimento"));
				result.close();
			}
			else
			{
				System.out.println("Cliente não encontrado!\n");
				objC = null;
			}
			statement.close();
		}
		
		catch (SQLException e)
		{
			System.out.println("Problemas com o SQL de consulta de Cliente!");
		}
		
		return objC;
	}
	
	public String relatorio()
	{
		String resultado = "";
		
		try
		{
			Statement statement = getConnection().createStatement();
			
			String relatorioSQL = "SELECT * FROM cliente;";
					
			System.out.println("Enviando código SQL: " + getConnection().nativeSQL(relatorioSQL));
			
			ResultSet result = statement.executeQuery(relatorioSQL);
			
			if (result.next()) 
			{
				do
				{
					resultado += "Nome: " + result.getString("nome");
					resultado += "\nCPF: " + result.getString("cpf");
					resultado += "\nData de Nascimento: " + result.getString("nascimento");
					resultado += ("\n\n\n");
				} 
				while (result.next());
				
				result.close();
			} 
			else 
			{
				resultado = "Nenhum cliente foi encontrado";
			}
			
			statement.close();

		}
		
		catch (SQLException e)
		{
			System.out.println("Problemas com o SQL de relatorio de Cliente!"); 
		}
		 
		return resultado;
	}
	
}
