package apresentacao;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.*;


public class TelaRelatorio extends JFrame
{	
	public TelaRelatorio(String resultado)
	{
		this.setTitle("Relatorio");
		this.setSize(500, 500);
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
		
		
		JTextArea textArea = new JTextArea(resultado);
		JScrollPane scrollPane = new JScrollPane(textArea);  
		textArea.setLineWrap(true);  
		textArea.setWrapStyleWord(true);
		scrollPane.setPreferredSize( new Dimension( 485, 485 ) );
		painel.add(scrollPane);
	}
}
