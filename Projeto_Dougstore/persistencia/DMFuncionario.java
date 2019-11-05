package persistencia;

import modelo.Funcionario;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class DMFuncionario extends DMGeral
{
	String cpf = null;
	
	// implementação do método incluir
	public void incluir(Object obj)
	{
		Funcionario objF = (Funcionario) obj;
		
		try
		{
			Statement statement = getConnection().createStatement();
			
			// montagem da String SQL de inclusão na tabela
			String incluirSQL = "INSERT INTO funcionario(" +
								"cpf, nome, nasc " +
								") VALUES ('" +
								objF.getCpf() + "', '" +
								objF.getNome() + "', '" +
								objF.getNasc() + "')";
			
			System.out.println("Enviando código SQL: " + getConnection().nativeSQL(incluirSQL) + "\n");
			
			int result = statement.executeUpdate(incluirSQL);
			
			if (result == 1)
			{
				JOptionPane.showMessageDialog(null, "Funcionário cadastrado corretamente!", "Mensagem de Informação", JOptionPane.INFORMATION_MESSAGE);
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Erro ao cadastrar funcionário!", "Mensagem de Erro", JOptionPane.ERROR_MESSAGE);
				
				objF.setCpf("");
				objF.setNome("");
				objF.setNasc("");
			}
			statement.close();
		}
		catch (SQLException e)
		{
			System.out.println("Problemas com o SQL de inclusão de funcionário");
		}
	}
	
	// implementação do método consultar
	public Object consultar(Object obj)
	{
		Funcionario objF = (Funcionario) obj;
		
		try
		{
			Statement statement = getConnection().createStatement();
			
			//montagem da String SQL de consulta na tabela
			String consultarSQL = "SELECT * FROM funcionario WHERE (cpf = '" + objF.getCpf() + "')";
			System.out.println("Enviando código SQL: " + getConnection().nativeSQL(consultarSQL));
			
			ResultSet result = statement.executeQuery(consultarSQL);
			
			if (result.next())
			{
				System.out.println("Funcionário existente!");
				System.out.println("Funcionário");
				System.out.println("CPF........: " + result.getString("cpf"));
				System.out.println("Nome.......: " + result.getString("nome"));
				System.out.println("Nascimento.: " + result.getString("nasc"));
				result.close();
			}
			else
			{
				System.out.println("Funcionário não encontrado!\n");
				objF = null;
			}
			statement.close();
		}
		catch (SQLException e)
		{
			System.out.println("Problemas com o SQL de consulta de Funcionário!");
		}
		
		return objF;
	}
	
	public Funcionario buscar(String cpf)
	{
		Funcionario objF = new Funcionario();
		
		try
		{
			Statement statement = getConnection().createStatement();
			
			//montagem da String SQL de consulta na tabela
			String consultarSQL = "SELECT * FROM funcionario WHERE (cpf = '" + cpf + "')";
			System.out.println("Enviando código SQL: " + getConnection().nativeSQL(consultarSQL));
			
			ResultSet result = statement.executeQuery(consultarSQL);
			
			if (result.next())
			{
				System.out.println("Funcionário existente!");
				System.out.println("Funcionário");
				System.out.println("CPF........: " + result.getString("cpf"));
				System.out.println("Nome.......: " + result.getString("nome"));
				System.out.println("Nascimento.: " + result.getString("nasc"));
				
				objF.setCpf(cpf);
				objF.setNome(result.getString("nome"));
				JOptionPane.showMessageDialog(null, objF.getNome());
				result.close();
			}
			else
			{
				System.out.println("Funcionário não encontrado!\n");
				objF = null;
			}
			statement.close();
		}
		catch (SQLException e)
		{
			System.out.println("Problemas com o SQL de consulta de Funcionário!");
		}
		
		return objF;
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
