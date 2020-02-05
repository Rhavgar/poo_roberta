package apresentacao;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import modelo.Venda;


public class TCItem_venda extends JFrame 
{
	public TCItem_venda(Venda venda)
	{
		this.setTitle("Itens de Venda");
		this.setSize(400, 425);
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
		
		JLabel lblote = new JLabel("Lote.............:");
		JLabel lbquantidade = new JLabel("Quantidade:");
		
		JTextField tflote = new JTextField(25);
		JTextField tfquantidade = new JTextField(25);

		
		
		
		painel.add(lblote);
		painel.add(tflote);
		painel.add(lbquantidade);
		painel.add(tfquantidade);
		
		JButton botao1 = new JButton("Adicionar Item");
		JButton botao2 = new JButton("Finalizar Venda");
		JButton botao3 = new JButton("Cancelar Venda");
		
		painel.add(botao1);
		painel.add(botao2);
		painel.add(botao3);
		
		JTextArea textArea = new JTextArea();
		JScrollPane scrollPane = new JScrollPane(textArea);  
		textArea.setLineWrap(true);  
		textArea.setWrapStyleWord(true);
		scrollPane.setPreferredSize( new Dimension( 385, 300 ) );
		
		painel.add(scrollPane);
		
		botao1.addActionListener(new ActionListener()
		{ 
			public void actionPerformed(ActionEvent e)
			{ 
				float qtd = Float.parseFloat(tfquantidade.getText());
				venda.adicionarItem(tflote.getText(), qtd);
				textArea.setText(venda.getOverview());
			}
		});
		
		botao2.addActionListener(new ActionListener()
		{ 
			public void actionPerformed(ActionEvent e)
			{ 
				venda.incluir();
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
