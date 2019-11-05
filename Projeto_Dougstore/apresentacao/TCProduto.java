package apresentacao;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import modelo.Produto;


public class TCProduto extends JFrame 
{
	public TCProduto()
	{
		this.setTitle("Cadastro de Produto");
		this.setSize(400, 400);
		this.setResizable(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = this.getContentPane();
		
		JPanel painel = new JPanel();
		c.add(painel);
		
		JLabel lbcodigo = new JLabel("Codigo.......................:");
		JLabel lbfabricacao = new JLabel("Fabricação...................:");
		JLabel lbvalidade = new JLabel("Validade.....................:");
		JLabel lbquantidade = new JLabel("Quantidade...................:");
		JLabel lbpreco_venda = new JLabel("Preço de venda...............:");
		JLabel lbpreco_custo = new JLabel("Preço de custo...............:");
		
		JTextField tfcodigo = new JTextField(25);
		JTextField tffabricacao = new JTextField(25);
		JTextField tfvalidade = new JTextField(25);
		JTextField tfquantidade = new JTextField(25);
		JTextField tfpreco_venda = new JTextField(25);
		JTextField tfpreco_custo = new JTextField(25);
		
		painel.add(lbcodigo);
		painel.add(tfcodigo);
		painel.add(lbfabricacao);
		painel.add(tffabricacao);
		painel.add(lbvalidade);
		painel.add(tfvalidade);
		painel.add(lbquantidade);
		painel.add(tfquantidade);
		painel.add(lbpreco_venda);
		painel.add(tfpreco_venda);
		painel.add(lbpreco_custo);
		painel.add(tfpreco_custo);
		
		JButton botao1 = new JButton("Salvar");
		JButton botao2 = new JButton("Limpar");
		JButton botao3 = new JButton("Fechar");
		
		painel.add(botao1);
		painel.add(botao2);
		painel.add(botao3);
		
		botao1.addActionListener(new ActionListener()
			{ public void actionPerformed(ActionEvent e)
			{ new Produto(tfcodigo.getText(), tffabricacao.getText(), tfvalidade.getText(), tfquantidade.getText(), tfpreco_venda.getText(), tfpreco_custo.getText());
			}});
		
		botao2.addActionListener(new ActionListener()
			{ public void actionPerformed(ActionEvent e)
			{ tfcodigo.setText("");
			  tffabricacao.setText("");
			  tfvalidade.setText("");
			  tfquantidade.setText("");
			  tfpreco_venda.setText("");
			  tfpreco_custo.setText("");
			}});
		
		botao3.addActionListener(new ActionListener()
				{ public void actionPerformed(ActionEvent e)
				{ System.exit(0);
				}});
		
		//painel.setLayout(null);
		painel.repaint();
		
		this.setVisible(true);
		this.repaint();
	}
}
