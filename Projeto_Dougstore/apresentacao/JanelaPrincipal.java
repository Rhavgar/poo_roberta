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
    private BarradeFerramenta FerramentaB;
    private BarradeStatus StatusB;
    private int screenHeight;
    private int screenWidth;
    private Image wallpaper;

	public JanelaPrincipal()
    {   
    	this.setTitle("Farmácia Dougstore");
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension d = tk.getScreenSize();
        screenHeight = d.height;
        screenWidth = d.width;
        this.setSize(screenWidth,screenHeight);
        this.setResizable(true);
        Image img = tk.getImage("../Projeto_Dougstore/images/drugstore-icon.png");
        this.setIconImage(img);
        this.addWindowListener(new WindowAdapter()
        { public void windowClosing(WindowEvent e)
        { System.exit(0); 
        }});

        //Imagem fundo
        wallpaper = Toolkit.getDefaultToolkit().createImage("../Projeto_Dougstore/images/drugstore-wallpaper.jpg");
        JPanel fundo = new NewContentPane();
        
        Container contentPane = getContentPane();
        BorderLayout layout = new BorderLayout(5,5);
        contentPane.setLayout(layout);
        
        //Barra de Ferramenta
        FerramentaB = new BarradeFerramenta();
        FerramentaB.add(this);
        contentPane.add(FerramentaB.make(),BorderLayout.NORTH);
        
        //Barra de Status
        StatusB = new BarradeStatus();
        contentPane.add(StatusB,BorderLayout.SOUTH);

        
        //Janela Central
        theDesktop = new JDesktopPane();
        theDesktop.setSize(screenWidth/3,screenHeight);
        super.add(fundo, BorderLayout.CENTER);
        this.show();
        
    }
    
    private class NewContentPane extends JPanel
    {	
    	protected void paintComponent(final Graphics g)
      	{	
    		super.paintComponent(g);
            g.drawImage(wallpaper,0,0,screenWidth,screenHeight,this);
        }
    }
    
    public void jCliente()
    {
    	TCCliente objTCC = new TCCliente();
    }
    
    public void jFuncao()
    {
    	TCFuncao objTCFa = new TCFuncao();
    }
    
    public void jFuncionario()
    {  	
    	TCFuncionario objTCF = new TCFuncionario();	
    }

    public void jProduto()
    {
    	TCProduto objTCP = new TCProduto();
    }
    
    public void jFornecedor()
    {
    	TCFornecedor objTCFo = new TCFornecedor();
    }
    
    public void jEstoque()
    {
    	TCEstoque objTCE = new TCEstoque();
    }
    
    public void jVenda()
    {
    	TCVenda objTCV = new TCVenda();
    }

   public void jSair()
   { 
	   this.dispose();
   }

}
