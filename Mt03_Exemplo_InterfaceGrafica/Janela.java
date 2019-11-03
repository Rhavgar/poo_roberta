package testeJFrame;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Janela extends JFrame
{
	public Janela()
	{
		this.setTitle("Tela de Acesso ao Sistema");
		this.setSize(500,300);
		this.setVisible(true);
		this.setResizable(false);
		
		Container c = this.getContentPane();
		JPanel painel = new JPanel();
		c.add(painel);
		
		
		JLabel rotulo1 = new JLabel("Informe o nome do usuário: ");
		rotulo1.setToolTipText("username");
		rotulo1.setLocation(100,200);
		painel.add(rotulo1);
		
		JTextField caixa1 = new JTextField(25);
		painel.add(caixa1);		
		
		JLabel rotulo2 = new JLabel("Informe a senha de acesso: ");
		rotulo2.setToolTipText("password");
		painel.add(rotulo2);
		
		JPasswordField senha = new JPasswordField(25);
		painel.add(senha);
		
		JLabel rotulo3 = new JLabel("É obrigatório selecionar o(s) perfil(is) desejado(s) para acesso aos sistemas: ");
		rotulo3.setToolTipText("perfil de acesso");
		painel.add(rotulo3);
		/*
		JCheckBox escolha1 = new JCheckBox("Administrador",false);
		JCheckBox escolha2 = new JCheckBox("Programador",false);
		JCheckBox escolha3 = new JCheckBox("DBA",false);
		JCheckBox escolha4 = new JCheckBox("Usuário Final",true);
		JCheckBox escolha5 = new JCheckBox("Testador",false);
		painel.add(escolha1);
		painel.add(escolha2);
		painel.add(escolha3);
		painel.add(escolha4);
		painel.add(escolha5);
		
		JRadioButton radio1 = new JRadioButton("Administrador",false);
		JRadioButton radio2 = new JRadioButton("Programador",false);
		JRadioButton radio3 = new JRadioButton("DBA",false);
		JRadioButton radio4 = new JRadioButton("Usuário Final",true);
		JRadioButton radio5 = new JRadioButton("Testador",false);
		ButtonGroup grupo = new ButtonGroup();
		grupo.add(radio1);
		grupo.add(radio2);
		grupo.add(radio3);
		grupo.add(radio4);
		grupo.add(radio5);
		painel.add(radio1);
		painel.add(radio2);
		painel.add(radio3);
		painel.add(radio4);
		painel.add(radio5);
		
		String[] perfil = {"Administrador","Programador","DBA","Usuário Final","Testador"};
		JComboBox combo = new JComboBox(perfil);
		combo.setMaximumRowCount(4);
		combo.setEditable(false);
		painel.add(combo);
		*/
		
		String[] list = {"Administrador","Programador","DBA","Usuário Final","Testador"};
		JList lista = new JList (list);
		lista.setVisibleRowCount(5);	lista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		lista.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		painel.add(lista);

		JButton botao1 = new JButton("Entrar");
		JButton botao2 = new JButton("Limpar");
		JButton botao3 = new JButton("Fechar");
		painel.add(botao1);
		painel.add(botao2);
		painel.add(botao3);
		
		botao1.addActionListener(new ActionListener()
		{	public void actionPerformed(ActionEvent e)
			{	JOptionPane.showMessageDialog(null,"USUÁRIO: "+caixa1.getText()+"\nSENHA: "+senha.getText());	}
		});
		
		botao2.addActionListener(new ActionListener()
		{	public void actionPerformed(ActionEvent e)
			{	caixa1.setText("");
                senha.setText("");
            }
		});
		
		botao3.addActionListener(new ActionListener()
		{	public void actionPerformed(ActionEvent e)
			{	System.exit(0);	}
		});
		
		
		
		this.show();
	}
}