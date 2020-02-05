package apresentacao;

import java.awt.Container;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import modelo.Venda;


public class TCVenda extends JFrame 
{
	public TCVenda()
	{
		this.setTitle("Abertura de Venda");
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
		
		JLabel lbfuncionario = new JLabel("Funcionario..:");
		JLabel lbcliente = new JLabel("Cliente...........:");
		JLabel lbforma_pag = new JLabel("Pagamento...:");
		JLabel lbid = new JLabel("ID VENDA.......:");
		
		JTextField tffuncionario = new JTextField(25);
		JTextField tfcliente = new JTextField(25);
		JTextField tfforma_pag = new JTextField(25);
		JTextField tfid = new JTextField(25);
		
		painel.add(lbfuncionario);
		painel.add(tffuncionario);
		painel.add(lbcliente);
		painel.add(tfcliente);
		painel.add(lbforma_pag);
		painel.add(tfforma_pag);
		painel.add(lbid);
		painel.add(tfid);
		
		JButton botao1 = new JButton("Abrir Venda");
		JButton botao2 = new JButton("Relatorio");
		JButton botao3 = new JButton("Fechar");
		
		painel.add(botao1);
		painel.add(botao2);
		painel.add(botao3);
		
		botao1.addActionListener(new ActionListener()
		{ 
			public void actionPerformed(ActionEvent e)
			{ 
				Venda venda = new Venda(tfid.getText(), tfforma_pag.getText(), tffuncionario.getText(), tfcliente.getText());
				TCItem_venda item_venda = new TCItem_venda(venda);
			}
		});
		
		botao2.addActionListener(new ActionListener()
		{ 
			public void actionPerformed(ActionEvent e)
			{ 
				
				Venda venda = new Venda();
				TelaRelatorio relatorio = new TelaRelatorio(venda.relatorio());
			}
		});
		
		botao3.addActionListener(new ActionListener()
		{ 
			public void actionPerformed(ActionEvent e)
			{ 
				dispose();
			}
		});

	}
}
