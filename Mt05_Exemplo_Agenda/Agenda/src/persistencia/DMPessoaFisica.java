package persistencia;

import modelo.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class DMPessoaFisica extends DMGeral
{
    String cpf = null;
    
     
    //método incluir
    public void incluir(Object obj)
    {   PessoaFisica objPF = (PessoaFisica) obj;
        try
        {   Statement statement = getConnection().createStatement();
            
            String incluirSQL = "INSERT INTO pfisicas (" +
                                "cpf,nome,dataNascimento," +
                                "rua,numero,complemento,bairro,cidade,cep,estado," +
                                "ddi,ddd,numerotel,tipo,operadora" +
                                ") VALUES ('" +
                                objPF.getCpf() + "', '" +
                                objPF.getNome() + "', '" +
                                objPF.getDataNascimento() + "', '" +
                                objPF.getAtRefEndereco().getRua() + "', '" +
                                objPF.getAtRefEndereco().getNumero() + "', '" +
                                objPF.getAtRefEndereco().getComplemento() + "', '" +
                                objPF.getAtRefEndereco().getBairro() + "', '" +
                                objPF.getAtRefEndereco().getCidade() + "', '" +
                                objPF.getAtRefEndereco().getCep() + "', '" +
                                objPF.getAtRefEndereco().getEstado() + "', '" +
                                objPF.getAtRefTelefone().getDdi() + "', '" +
                                objPF.getAtRefTelefone().getDdd() + "', '" +
                                objPF.getAtRefTelefone().getNumero() + "', '" +
                                objPF.getAtRefTelefone().getTipo() + "', '" +
                                objPF.getAtRefTelefone().getOperadora() + "')";
            
            System.out.println("Enviando código SQL: " + getConnection().nativeSQL(incluirSQL) + "\n");
            
            int result = statement.executeUpdate(incluirSQL);
            if (result == 1)
            {   JOptionPane.showMessageDialog(null,"Pessoa Fisica cadastrada corretamente !","Mensagem de Informação",JOptionPane.INFORMATION_MESSAGE);}
            else
            {   JOptionPane.showMessageDialog(null,"Erro ao cadastrar pessoa física !","Mensagem de Erro",JOptionPane.ERROR_MESSAGE);
            	objPF.setCpf("");    
            	objPF.setNome("");
            	objPF.setDataNascimento("");
            	objPF.setAtRefEndereco(null);
            	objPF.setAtRefTelefone(null);
            }
            statement.close();
        }
        catch (SQLException e)
        { System.out.println("Problemas com o SQL de inclusão de pessoa física!"); }
    }

    //método consultar
    public Object consultar(Object obj)
    {   
    	PessoaFisica objPF = (PessoaFisica) obj;
        try
        {   Statement statement = getConnection().createStatement();
            String consultarSQL = "SELECT * FROM pfisicas WHERE (cpf = '"+objPF.getCpf()+"')";
            System.out.println("Enviando código SQL: " + getConnection().nativeSQL(consultarSQL));
            ResultSet result = statement.executeQuery(consultarSQL);
            if (result.next())
            {   System.out.println("Pessoa Física existente !" );
                System.out.println("Pessoa Física");
                System.out.println("Cpf.............: "+ result.getString("cpf"));
                System.out.println("Nome...............: "+ result.getString("nome"));
                System.out.println("Data de Nascimento.: "+ result.getString("dataNascimento"));
                result.close();
            }
            else
            {   System.out.println( "Pessoa Física não encontrada !\n" );
                objPF = null;
            }
            statement.close();
        }
        catch (SQLException e)
        { System.out.println("Problemas com o SQL de consulta de Pessoa Física !"); }
        return objPF;
    }

    //método excluir
    public void excluir(Object obj)
    {   
    	/*Cliente objCliente = (Cliente) obj;
        try
        {   Statement statement = getConnection().createStatement();
            String excluirSQL = "DELETE FROM clientes WHERE (nome = '"+objCliente.getNome()+"')";
            System.out.println("Enviando código SQL: " + getConnection().nativeSQL(excluirSQL) + "\n");
            int result = statement.executeUpdate(excluirSQL);
            if (result == 1)
            {   JOptionPane.showMessageDialog(null,"Cliente excluído corretamente !","Mensagem de Informação",JOptionPane.INFORMATION_MESSAGE); }
            else
            {   System.out.println( "\nErro ao excluir cliente !\n" );
                objCliente.setNome("");
            }
           statement.close();
        }
        catch (SQLException e)
        { System.out.println("Problemas com o SQL de exclusão do cliente !"); }
        */
    }

    //método alterar
    public void alterar(Object obj)
    {   /*
    	Cliente objCliente = (Cliente) obj;
        try
        {   Statement statement = getConnection().createStatement();
            String alterarSQL = "UPDATE clientes SET sexo = '"+objCliente.getSexo()+"' ,"+
                                "tipo = '"+objCliente.getTipo()+"' ,"+
                                "dtnasc = '"+objCliente.getDtNascimento()+"'"+
                                "email = '"+objCliente.getEmail()+"'"+
                                "WHERE (nome = '"+objCliente.getNome()+"')";
            int result = statement.executeUpdate(alterarSQL);
            if (result == 1)
            { System.out.println( "Cliente alterado corretamente !"); }
            else
            {   System.out.println( "\nErro ao alterar cliente !\n" );
                objCliente.setNome("");
            }
        }
        catch (SQLException e)
        { System.out.println("Problemas com o SQL de atualização do cliente !"); }
        */
    }

    public void shutDown()
    {   try
        { getConnection().close(); }
        catch (SQLException sqlex)
        {   System.err.println("Problemas ao desconectar !");
            sqlex.printStackTrace();
        }
    }
}