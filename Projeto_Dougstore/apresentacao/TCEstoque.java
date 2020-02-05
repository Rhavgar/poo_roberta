package apresentacao;

import java.awt.Container;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import modelo.Estoque;


public class TCEstoque extends JFrame 
{
	public TCEstoque()
	{
		this.setTitle("Cadastro de Estoque");
		this.setSize(400, 280);
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
		
		JLabel lblote = new JLabel("Lote....................:");
		JLabel lbquantidade = new JLabel("Quantidade.......:");
		JLabel lbpreco_venda = new JLabel("Preco de Venda:");
		JLabel lbpreco_custo = new JLabel("Preco de Custo:");
		JLabel lbfabricacao = new JLabel("Fabricacao........:");
		JLabel lbvalidade = new JLabel("Validade............:");
		JLabel lbproduto_codigo = new JLabel("Cod. Produto....:");	
		
		JTextField tflote = new JTextField(25);
		JTextField tfquantidade = new JTextField(25);
		JTextField tfpreco_venda = new JTextField(25);
		JTextField tfpreco_custo = new JTextField(25);
		JTextField tffabricacao = new JTextField(25);
		JTextField tfvalidade = new JTextField(25);
		JTextField tfproduto_codigo = new JTextField(25);
		
		painel.add(lblote);
		painel.add(tflote);
		painel.add(lbquantidade);
		painel.add(tfquantidade);
		painel.add(lbpreco_venda);
		painel.add(tfpreco_venda);
		painel.add(lbpreco_custo);
		painel.add(tfpreco_custo);
		painel.add(lbfabricacao);
		painel.add(tffabricacao);
		painel.add(lbvalidade);
		painel.add(tfvalidade);
		painel.add(lbproduto_codigo);
		painel.add(tfproduto_codigo);
		
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
				Estoque estoque = new Estoque(tflote.getText(), tfquantidade.getText(), tfpreco_venda.getText(), tfpreco_custo.getText(), tffabricacao.getText(), tfvalidade.getText(), tfproduto_codigo.getText());
				estoque.incluir();
			}
		});
		
		botao2.addActionListener(new ActionListener()
		{ 
			public void actionPerformed(ActionEvent e)
			{ 
				Estoque estoque = new Estoque(tflote.getText());
				estoque.buscar();
				tfquantidade.setText(estoque.getQuantidade());
				tfpreco_venda.setText(estoque.getPreco_venda());
				tfpreco_custo.setText(estoque.getPreco_custo());
				tffabricacao.setText(estoque.getFabricacao());
				tfvalidade.setText(estoque.getValidade());
				tfproduto_codigo.setText(estoque.getProduto_codigo());
			}
		});
		
		botao3.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				Estoque estoque = new Estoque(tflote.getText(), tfquantidade.getText(), tfpreco_venda.getText(), tfpreco_custo.getText(), tffabricacao.getText(), tfvalidade.getText(), tfproduto_codigo.getText());
				estoque.alterar();
			}
		});
		
		botao4.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				Estoque estoque = new Estoque(tflote.getText());
				estoque.excluir();
			}
		});
		
		botao5.addActionListener(new ActionListener()
		{ 
			public void actionPerformed(ActionEvent e)
			{ 
				
				Estoque estoque = new Estoque();
				TelaRelatorio relatorio = new TelaRelatorio(estoque.relatorio());
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
