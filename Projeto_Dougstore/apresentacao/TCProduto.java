package apresentacao;

import java.awt.Container;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import modelo.Produto;


public class TCProduto extends JFrame 
{
	public TCProduto()
	{
		this.setTitle("Cadastro de Produto");
		this.setSize(400, 250);
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
		
		JLabel lbcodigo = new JLabel("Codigo..................:");
		JLabel lbnome_comercial = new JLabel("Nome Comercial:");
		JLabel lbnome_generico = new JLabel("Nome Generico..:");
		JLabel lbtarja = new JLabel("Tarja.....................:");
		JLabel lbtipo = new JLabel("Tipo......................:");
		JLabel lbfornecedor_cnpj = new JLabel("Fornecedor........:");
		
		JTextField tfcodigo = new JTextField(25);
		JTextField tfnome_comercial = new JTextField(25);
		JTextField tfnome_generico = new JTextField(25);
		JTextField tftarja = new JTextField(25);
		JTextField tftipo = new JTextField(25);
		JTextField tffornecedor_cnpj = new JTextField(25);
		
		painel.add(lbcodigo);
		painel.add(tfcodigo);
		painel.add(lbnome_comercial);
		painel.add(tfnome_comercial);
		painel.add(lbnome_generico);
		painel.add(tfnome_generico);
		painel.add(lbtarja);
		painel.add(tftarja);
		painel.add(lbtipo);
		painel.add(tftipo);
		painel.add(lbfornecedor_cnpj);
		painel.add(tffornecedor_cnpj);
		
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
				Produto produto = new Produto(tfcodigo.getText(), tfnome_comercial.getText(), tfnome_generico.getText(), tftarja.getText(), tftipo.getText(), tffornecedor_cnpj.getText());
				produto.incluir();
			}
		});
		
		botao2.addActionListener(new ActionListener()
		{ 
			public void actionPerformed(ActionEvent e)
			{ 
				Produto produto = new Produto(tfcodigo.getText());
				produto.buscar();
				tfnome_comercial.setText(produto.getNome_comercial());
				tfnome_generico.setText(produto.getNome_generico());
				tftarja.setText(produto.getTarja());
				tftipo.setText(produto.getTipo());
				tffornecedor_cnpj.setText(produto.getFornecedor_cnpj());
			}
		});
		
		botao3.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				Produto produto = new Produto(tfcodigo.getText(), tfnome_comercial.getText(), tfnome_generico.getText(), tftarja.getText(), tftipo.getText(), tffornecedor_cnpj.getText());
				produto.alterar();
			}
		});
		
		botao4.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				Produto produto = new Produto(tfcodigo.getText());
				produto.excluir();
			}
		});
		
		botao5.addActionListener(new ActionListener()
		{ 
			public void actionPerformed(ActionEvent e)
			{ 
				
				Produto produto = new Produto();
				TelaRelatorio relatorio = new TelaRelatorio(produto.relatorio());
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
