package apresentacao;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.Graphics;


@SuppressWarnings("serial")
public class JanelaPrincipal extends JFrame
{
    private JDesktopPane theDesktop;
    private BarradeMenu MenuB;
    private BarradeFerramenta FerramentaB;
    private BarradeStatus StatusB;
    private int screenHeight;
    private int screenWidth;
    private Image wallpaper;

    //CONSTRUTOR DA CLASSE
    public JanelaPrincipal()
    {   this.setTitle("APLICAÇÃO JAVA COM BANCO DE DADOS - Agenda de Contatos");
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension d = tk.getScreenSize();
        screenHeight = d.height;
        screenWidth = d.width;
        this.setSize(screenWidth,screenHeight);
        this.setResizable(false);
        Image img = tk.getImage("../Agenda/src/images/executar.gif");
        this.setIconImage(img);
        this.addWindowListener(new WindowAdapter()
        { public void windowClosing(WindowEvent e)
            { System.exit(0); }
        });

      //Imagem fundo
        wallpaper = Toolkit.getDefaultToolkit().createImage("../Agenda/src/images/wallPaper0.png");
        JPanel fundo = new NewContentPane();
        
        Container contentPane = getContentPane();
        BorderLayout layout = new BorderLayout(5,5);
        contentPane.setLayout(layout);

        // Barra de Menu
        MenuB = new BarradeMenu();
        MenuB.add(this);
        this.setJMenuBar(MenuB.make());

        //Barra de Ferramenta
        FerramentaB = new BarradeFerramenta();
        FerramentaB.add(this);
        contentPane.add(FerramentaB.make(),BorderLayout.NORTH);

        //Barra de Status
        StatusB = new BarradeStatus();
        contentPane.add(StatusB,BorderLayout.SOUTH);

        //Janela Central
        //theDesktop = new JDesktopPane();
        //theDesktop.setSize(screenWidth/3,screenHeight);
        //contentPane.add(theDesktop,BorderLayout.CENTER);
        
        //Janela Central
        theDesktop = new JDesktopPane();
        theDesktop.setSize(screenWidth/3,screenHeight);
        super.add(fundo, BorderLayout.CENTER);
        this.show();
        
    }
    
    private class NewContentPane extends JPanel
    {	protected void paintComponent(final Graphics g)
      	{	super.paintComponent(g);
            g.drawImage(wallpaper,0,0,screenWidth,screenHeight,this);
        }
    }
    

// ********************************
// Início da Definição dos Métodos
// ********************************

// Método Janela Nova Pessoa Física

    public void jPFisica()
    {  	TelaPessoaFisica objTPF = new TelaPessoaFisica();	}

    public void jPJuridica()
    {   }

    
// Método Janela Sobre
   public void jSobre()
   { JOptionPane.showMessageDialog(null,"Instituto Federal Fluminense - IFF Campos (Campus Centro)\nDisciplina de Programaçao Orientada a Objetos\nAplicação em Java usando Banco de Dados - versão 1.0\nCopyright - Todos os direitos reservados\nInformações: galmeida@iff.edu.br","Sobre a APLICAÇÃO",JOptionPane.INFORMATION_MESSAGE,new ImageIcon("../Agenda/src/images/ajuda.gif")); }


// Método Janela Sair
   public void jSair()
   { this.dispose(); }

}