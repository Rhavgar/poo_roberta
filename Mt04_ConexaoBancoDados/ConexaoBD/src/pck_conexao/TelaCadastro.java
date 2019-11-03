package pck_conexao;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

@SuppressWarnings("serial")
public class TelaCadastro extends JFrame {

	public TelaCadastro()
	{ this.setTitle("Tela Cadastro");
	  this.setSize(400, 200);
	  this.setResizable(true);
	  this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = this.getContentPane();
				
		JPanel painel = new JPanel();
		c.add(painel);
			
		 JLabel lbcpf = new JLabel("CPF............:");
		JLabel lbnome = new JLabel("Nome Completo..:");
	   JLabel lbemail = new JLabel("E-mail.........: ");

		
		JTextField tfcpf = new JTextField(25);
		JTextField tfnome = new JTextField(20);
		JTextField tfemail = new JTextField(25);
			
			
		painel.add(lbcpf);
		painel.add(tfcpf);		
		painel.add(lbnome);
		painel.add(tfnome);		
		painel.add(lbemail);
		painel.add(tfemail);	
		
		JButton botao1 = new JButton("Salvar");
		JButton botao2 = new JButton("Limpar");
		JButton botao3 = new JButton("Fechar");
		painel.add(botao1);
		painel.add(botao2);
		painel.add(botao3);
		
		botao1.addActionListener(new ActionListener()
		        { public void actionPerformed(ActionEvent e)
		{ new PFisica(tfcpf.getText(), tfnome.getText(), tfemail.getText() );
			
		}});
		
				
		botao2.addActionListener(new ActionListener()
		{ public void actionPerformed(ActionEvent e)
		{ tfnome.setText("");
 		  tfcpf.setText(""); 
 		  tfemail.setText("");  	 		  
		}});

		botao3.addActionListener(new ActionListener()
		{ public void actionPerformed(ActionEvent e)
		{ System.exit(0); }
		});
		
	
	
	//	painel.setLayout(null);
		painel.repaint();
		
		this.setVisible(true);		
		this.repaint();	
		
	}
}

