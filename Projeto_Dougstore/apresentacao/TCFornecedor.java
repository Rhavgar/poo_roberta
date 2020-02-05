package apresentacao;

import java.awt.Container;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import modelo.Fornecedor;


public class TCFornecedor extends JFrame 
{
	public TCFornecedor()
	{
		this.setTitle("Cadastro de Fornecedor");
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
		
		JLabel lbcnpj = new JLabel("CNPJ...................:");
		JLabel lbnome_fantasia = new JLabel("Nome Fantasia..:");
		JLabel lbcontato = new JLabel("Contato...............:");
		
		JTextField tfcnpj = new JTextField(25);
		JTextField tfnome_fantasia = new JTextField(25);
		JTextField tfcontato = new JTextField(25);
		
		painel.add(lbcnpj);
		painel.add(tfcnpj);
		painel.add(lbnome_fantasia);
		painel.add(tfnome_fantasia);
		painel.add(lbcontato);
		painel.add(tfcontato);
		
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
				Fornecedor fornecedor = new Fornecedor(tfcnpj.getText(), tfnome_fantasia.getText(), tfcontato.getText());
				fornecedor.incluir();
			}
		});
		
		botao2.addActionListener(new ActionListener()
		{ 
			public void actionPerformed(ActionEvent e)
			{ 
				Fornecedor fornecedor = new Fornecedor(tfcnpj.getText());
				fornecedor.buscar();
				tfnome_fantasia.setText(fornecedor.getNome_fantasia());
				tfcontato.setText(fornecedor.getContato());
			}
		});
		
		botao3.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				Fornecedor fornecedor = new Fornecedor(tfcnpj.getText(), tfnome_fantasia.getText(), tfcontato.getText());
				fornecedor.alterar();
			}
		});
		
		botao4.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				Fornecedor fornecedor = new Fornecedor(tfcnpj.getText());
				fornecedor.excluir();
			}
		});
		
		botao5.addActionListener(new ActionListener()
		{ 
			public void actionPerformed(ActionEvent e)
			{ 
				
				Fornecedor fornecedor = new Fornecedor();
				TelaRelatorio relatorio = new TelaRelatorio(fornecedor.relatorio());
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
