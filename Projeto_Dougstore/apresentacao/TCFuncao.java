package apresentacao;

import java.awt.Container;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import modelo.Funcao;


public class TCFuncao extends JFrame 
{
	public TCFuncao()
	{
		this.setTitle("Cadastro de Funcao");
		this.setSize(400, 175);
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
		
		JLabel lbcodigo = new JLabel("Codigo.........:");
		JLabel lbdescricao = new JLabel("Descricao....:");
		JLabel lbsalario = new JLabel("Salario.........:");
		
		JTextField tfcodigo = new JTextField(25);
		JTextField tfdescricao = new JTextField(25);
		JTextField tfsalario = new JTextField(25);
		
		painel.add(lbcodigo);
		painel.add(tfcodigo);
		painel.add(lbdescricao);
		painel.add(tfdescricao);
		painel.add(lbsalario);
		painel.add(tfsalario);
		
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
				Funcao funcao = new Funcao(tfcodigo.getText(), tfdescricao.getText(), tfsalario.getText());
				funcao.incluir();
			}
		});
		
		botao2.addActionListener(new ActionListener()
		{ 
			public void actionPerformed(ActionEvent e)
			{ 
				Funcao funcao = new Funcao(tfcodigo.getText());
				funcao.buscar();
				tfdescricao.setText(funcao.getDescricao());
				tfsalario.setText(funcao.getSalario());
			}
		});
		
		botao3.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				Funcao funcao = new Funcao(tfcodigo.getText(), tfdescricao.getText(), tfsalario.getText());
				funcao.alterar();
			}
		});
		
		botao4.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				Funcao funcao = new Funcao(tfcodigo.getText());
				funcao.excluir();
			}
		});
		
		botao5.addActionListener(new ActionListener()
		{ 
			public void actionPerformed(ActionEvent e)
			{ 
				
				Funcao funcao = new Funcao();
				TelaRelatorio relatorio = new TelaRelatorio(funcao.relatorio());
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
