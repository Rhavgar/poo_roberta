package persistencia;

import modelo.Cliente;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class DMCliente extends DMGeral
{
	String cpf = null;
	
	// implementação do método incluir
	public void incluir(Object obj)
	{
		Cliente objC = (Cliente) obj;
		
		try
		{
			Statement statement = getConnection().createStatement();
			
			// montagem da String SQL de inclusão na tabela
			String incluirSQL = "INSERT INTO cliente(" +
								"cpf, nome, nasc " +
								") VALUES ('" +
								objC.getCpf() + "', '" +
								objC.getNome() + "', '" +
								objC.getNasc() + "')";
			
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
				objC.setNasc("");
			}
			statement.close();
		}
		catch (SQLException e)
		{
			System.out.println("Problemas com o SQL de inclusão de cliente");
		}
	}
	
	// implementação do método consultar
	public Object consultar(Object obj)
	{
		Cliente objC = (Cliente) obj;
		
		try
		{
			Statement statement = getConnection().createStatement();
			
			//montagem da String SQL de consulta na tabela
			String consultarSQL = "SELECT * FROM cliente WHERE (cpf = '" + objC.getCpf() + "')";
			System.out.println("Enviando código SQL: " + getConnection().nativeSQL(consultarSQL));
			
			ResultSet result = statement.executeQuery(consultarSQL);
			
			if (result.next())
			{
				System.out.println("Cliente existente!");
				System.out.println("Cliente");
				System.out.println("CPF........: " + result.getString("cpf"));
				System.out.println("Nome.......: " + result.getString("nome"));
				System.out.println("Nascimento.: " + result.getString("nasc"));
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
	
	public Cliente buscar(String cpf)
	{
		Cliente objC = new Cliente();
		
		try
		{
			Statement statement = getConnection().createStatement();
			
			//montagem da String SQL de consulta na tabela
			String consultarSQL = "SELECT * FROM cliente WHERE (cpf = '" + cpf + "')";
			System.out.println("Enviando código SQL: " + getConnection().nativeSQL(consultarSQL));
			
			ResultSet result = statement.executeQuery(consultarSQL);
			
			if (result.next())
			{
				System.out.println("Cliente existente!");
				System.out.println("Cliente");
				System.out.println("CPF........: " + result.getString("cpf"));
				System.out.println("Nome.......: " + result.getString("nome"));
				System.out.println("Nascimento.: " + result.getString("nasc"));
				
				objC.setCpf(cpf);
				objC.setNome(result.getString("nome"));
				JOptionPane.showMessageDialog(null, objC.getNome());
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

	@Override
	public void excluir(Object obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void alterar(Object obj) {
		// TODO Auto-generated method stub
		
	}
}
