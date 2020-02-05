package persistencia;

import modelo.Funcionario;
import modelo.Funcionario;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class DMFuncionario extends DMGeral
{
	String cpf = null;
	
	public void incluir(Object obj)
	{
		Funcionario objF = (Funcionario) obj;
		
		try
		{
			Statement statement = getConnection().createStatement();
			
			String incluirSQL = "INSERT INTO funcionario(" +
								"cpf, nome, nascimento, supervisor_cpf, funcao_codigo " +
								") VALUES ('" +
								objF.getCpf() + "', '" +
								objF.getNome() + "', '" +
								objF.getNascimento() + "'," +
								objF.getSup() + "'," +
								objF.getFuncao() + "')";
			
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
				objF.setNascimento("");
				objF.setSup("");
				objF.setFuncao("");
			}
			statement.close();
		}
		
		catch (SQLException e)
		{
			System.out.println("Problemas com o SQL de inclusão de funcionário");
		}
	}
	
	public Object consultar(Object obj)
	{
		Funcionario objF = (Funcionario) obj;
		
		try
		{
			Statement statement = getConnection().createStatement();
			
			String consultarSQL = "SELECT * FROM funcionario WHERE (cpf = '" + objF.getCpf() + "')";
			System.out.println("Enviando código SQL: " + getConnection().nativeSQL(consultarSQL));
			
			ResultSet result = statement.executeQuery(consultarSQL);
			
			if (result.next())
			{
				System.out.println("Funcionário existente!");
				System.out.println("Funcionário");
				System.out.println("CPF........: " + result.getString("cpf"));
				System.out.println("Nome.......: " + result.getString("nome"));
				System.out.println("Nascimento.: " + result.getString("nascimento"));
				System.out.println("Supervisor.: " + result.getString("supervisor_cpf"));
				System.out.println("Funcao.....: " + result.getString("funcao"));
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
	
	public void alterar(Object obj)
	{
		Funcionario objF = (Funcionario) obj;
		
		try
		{
			Statement statement = getConnection().createStatement();
			
			String alterarSQL = "UPDATE funcionario SET nome ='" + objF.getNome() + "', nascimento ='" + objF.getNascimento() +
					"', supervisor_cpf ='" + objF.getSup() + "', funcao_codigo ='" + objF.getFuncao() + "' WHERE cpf ='" + objF.getCpf() + "'";
			
			System.out.println("Enviando código SQL: " + getConnection().nativeSQL(alterarSQL));
			
			int result = statement.executeUpdate(alterarSQL);
			
			if (result == 1)
			{
				JOptionPane.showMessageDialog(null, "Funcionario alterado corretamente!", "Mensagem de Informação", JOptionPane.INFORMATION_MESSAGE);
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Erro ao alterar funcionario!", "Mensagem de Erro", JOptionPane.ERROR_MESSAGE);
				
				objF.setCpf("");
				objF.setNome("");
				objF.setNascimento("");
				objF.setSup("");
				objF.setFuncao("");
			}
						
			statement.close();
		}
		
		catch (SQLException e)
		{
			System.out.println("Problemas com o SQL de alteração de Funcionario");
		}
	}
	
	public void excluir(Object obj) 
	{
		Funcionario objF = (Funcionario) obj;
		
		try
		{
			Statement statement = getConnection().createStatement();
			
			String excluirSQL = "DELETE FROM funcionario WHERE cpf='" + objF.getCpf() + "'";
			
			System.out.println("Enviando código SQL: " + getConnection().nativeSQL(excluirSQL));
			
			int result = statement.executeUpdate(excluirSQL);
			
			if (result == 1)
			{
				JOptionPane.showMessageDialog(null, "Funcionario excluído corretamente!", "Mensagem de Informação", JOptionPane.INFORMATION_MESSAGE);
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Erro ao excluir funcionario!", "Mensagem de Erro", JOptionPane.ERROR_MESSAGE);
				
				objF.setCpf("");
				objF.setNome("");
				objF.setNascimento("");
				objF.setSup("");
				objF.setFuncao("");
			}
						
			statement.close();
		}
		
		catch (SQLException e)
		{
			System.out.println("Problemas com o SQL de exclusão de Funcionario");
		}
		
	}
	
	public Funcionario buscar(Object obj)
	{
		Funcionario objF = (Funcionario) obj;
		
		try
		{
			Statement statement = getConnection().createStatement();
			
			String buscarSQL = "SELECT * FROM funcionario WHERE cpf = '" + objF.getCpf() + "'";
			
			System.out.println("Enviando código SQL: " + getConnection().nativeSQL(buscarSQL));
			
			ResultSet result = statement.executeQuery(buscarSQL);
			
			if (result.next())
			{
				System.out.println("Funcionário existente!");
				System.out.println("Funcionário");
				System.out.println("CPF........: " + result.getString("cpf"));
				System.out.println("Nome.......: " + result.getString("nome"));
				System.out.println("Nascimento.: " + result.getString("nascimento"));
				System.out.println("Supervisor.: " + result.getString("supervisor_cpf"));
				System.out.println("Funcao.....: " + result.getString("funcao"));
				
				objF.setNome(result.getString("nome"));
				objF.setNascimento(result.getString("nascimento"));
				objF.setSup(result.getString("supervisor_cpf"));
				objF.setFuncao(result.getString("funcao"));
				result.close();
			}
			else
			{
				System.out.println("Funcionario não encontrado!\n");
				objF = null;
			}
			statement.close();
		}
		
		catch (SQLException e)
		{
			System.out.println("Problemas com o SQL de consulta de Funcionario!");
		}
		
		return objF;
	}
	
	public String relatorio()
	{
		String resultado = "";
		
		try
		{
			Statement statement = getConnection().createStatement();
			
			String relatorioSQL = "SELECT * FROM funcionario;";
					
			System.out.println("Enviando código SQL: " + getConnection().nativeSQL(relatorioSQL));
			
			ResultSet result = statement.executeQuery(relatorioSQL);
			
			if (result.next()) 
			{
				do
				{
					resultado += "Nome: " + result.getString("nome");
					resultado += "\nCPF: " + result.getString("cpf");
					resultado += "\nData de Nascimento: " + result.getString("nascimento");
					resultado += "\nSupervisor: " + result.getString("supervisor_cpf");
					resultado += "\nFuncao: " + result.getString("funcao_codigo");
					resultado += ("\n\n\n");
				} 
				while (result.next());
				
				result.close();
			} 
			else 
			{
				resultado = "Nenhum funcionario foi encontrado";
			}
			
			statement.close();

		}
		
		catch (SQLException e)
		{
			System.out.println("Problemas com o SQL de relatorio de Funcionario!"); 
		}
		 
		return resultado;
	}
	
}
