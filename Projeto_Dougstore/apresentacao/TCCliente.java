package apresentacao;

import java.awt.Container;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import modelo.Cliente;


public class TCCliente extends JFrame 
{
	public TCCliente()
	{
		this.setTitle("Cadastro de Cliente");
		this.setSize(400, 145);
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
		
		JTextField tfcpf = new JTextField(25);
		JTextField tfnome = new JTextField(25);
		JTextField tfnasc = new JTextField(25);
		
		painel.add(lbcpf);
		painel.add(tfcpf);
		painel.add(lbnome);
		painel.add(tfnome);
		painel.add(lbnasc);
		painel.add(tfnasc);
		
		JButton botao1 = new JButton("Cadastrar");
		JButton botao2 = new JButton("Limpar");
		JButton botao3 = new JButton("Fechar");
		
		painel.add(botao1);
		painel.add(botao2);
		painel.add(botao3);
		
		botao1.addActionListener(new ActionListener()
			{ public void actionPerformed(ActionEvent e)
			{ new Cliente(tfcpf.getText(), tfnome.getText(), tfnasc.getText());
			}});
		
		botao2.addActionListener(new ActionListener()
			{ public void actionPerformed(ActionEvent e)
			{ tfcpf.setText("");
			  tfnome.setText("");
			  tfnasc.setText("");
			}});
		
		botao3.addActionListener(new ActionListener()
				{ public void actionPerformed(ActionEvent e)
				{ dispose();
				}});

	}
}
