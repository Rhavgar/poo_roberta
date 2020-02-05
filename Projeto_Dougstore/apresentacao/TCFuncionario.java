package apresentacao;

import java.awt.Container;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import modelo.Funcionario;


public class TCFuncionario extends JFrame
{
	public TCFuncionario()
	{
		this.setTitle("Cadastro de Funcionário");
		this.setSize(400, 225);
		this.setResizable(false);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		Toolkit tk = Toolkit.getDefaultToolkit();
		Image img = tk.getImage("../Projeto_Dougstore/images/drugstore-icon.png");
		this.setIconImage(img);
		
		Container c = this.getContentPane();
		
		JPanel painel = new JPanel();
		c.add(painel);
		
		JLabel lbcpf = new JLabel("CPF..................:");
		JLabel lbnome = new JLabel("Nome...............:");
		JLabel lbnasc = new JLabel("Nascimento....:");
		JLabel lbsup = new JLabel("Supervisor.....:");
		JLabel lbfuncao = new JLabel("Funcao...........:");
		
		JTextField tfcpf = new JTextField(25);
		JTextField tfnome = new JTextField(25);
		JTextField tfnasc = new JTextField(25);
		JTextField tfsup = new JTextField(25);
		JTextField tffuncao = new JTextField(25);
		
		painel.add(lbcpf);
		painel.add(tfcpf);
		painel.add(lbnome);
		painel.add(tfnome);
		painel.add(lbnasc);
		painel.add(tfnasc);
		painel.add(lbsup);
		painel.add(tfsup);
		painel.add(lbfuncao);
		painel.add(tffuncao);
		
		JButton botao1 = new JButton("Cadastrar");
		JButton botao2 = new JButton("Buscar");
		JButton botao3 = new JButton("Alterar");
		JButton botao4 = new JButton("Excluir");
		JButton botao5 = new JButton("Relatorio");
		JButton botao6 = new JButton("Fechar");
		
		painel.add(botao1);
		painel.add(botao2);
		painel.add(botao3);
		painel.add(botao4);
		painel.add(botao5);
		painel.add(botao6);
		
		botao1.addActionListener(new ActionListener()
		{ 
			public void actionPerformed(ActionEvent e)
			{ 
				Funcionario funcionario = new Funcionario(tfcpf.getText(), tfnome.getText(), tfnasc.getText(), tfsup.getText(), tffuncao.getText());
				funcionario.incluir();
			}
		});
		
		botao2.addActionListener(new ActionListener()
		{ 
			public void actionPerformed(ActionEvent e)
			{ 
				Funcionario funcionario = new Funcionario(tfcpf.getText());
				funcionario.buscar();
				tfnome.setText(funcionario.getNome());
				tfnasc.setText(funcionario.getNascimento());
				tfsup.setText(funcionario.getSup());
				tffuncao.setText(funcionario.getFuncao());
			}
		});
		
		botao3.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				Funcionario funcionario = new Funcionario(tfcpf.getText(), tfnome.getText(), tfnasc.getText(), tfsup.getText(), tffuncao.getText());
				funcionario.alterar();
			}
		});
		
		botao4.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				Funcionario funcionario = new Funcionario(tfcpf.getText());
				funcionario.excluir();
			}
		});
		
		botao5.addActionListener(new ActionListener()
		{ 
			public void actionPerformed(ActionEvent e)
			{ 
				
				Funcionario funcionario = new Funcionario();
				TelaRelatorio relatorio = new TelaRelatorio(funcionario.relatorio());
			}
		});
		
		botao6.addActionListener(new ActionListener()
		{ 
			public void actionPerformed(ActionEvent e)
			{ 
				dispose();
			}
		});

	}
}
