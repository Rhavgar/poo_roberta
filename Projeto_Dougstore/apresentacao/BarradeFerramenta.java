package apresentacao;

import java.awt.event.ActionEvent;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JToolBar;

public class BarradeFerramenta
{   
	Object gui;

    public JToolBar make()
    {   
    	JToolBar BFerramenta = new JToolBar();
        BFerramenta.setFloatable(true);

        Action botao1Action = new AbstractAction("Venda", new ImageIcon("../Projeto_Dougstore/images/venda-icon.png"))
        {	private static final long serialVersionUID = 1L;
        	public void actionPerformed(ActionEvent e)
            { 
        		chamaMetodo(e,"jVenda"); 
        	}
        };
        
        Action botao2Action = new AbstractAction("Cliente", new ImageIcon("../Projeto_Dougstore/images/client-icon.png"))
        {	private static final long serialVersionUID = 1L;
        	public void actionPerformed(ActionEvent e)
            { 
        		chamaMetodo(e,"jCliente"); 
        	}
        };
        
        Action botao3Action = new AbstractAction("Funcionário", new ImageIcon("../Projeto_Dougstore/images/employee-icon.png"))
        {	private static final long serialVersionUID = 1L;
        	public void actionPerformed(ActionEvent e)
            { 
        		chamaMetodo(e,"jFuncionario"); 
        	}
        };
        
        Action botao4Action = new AbstractAction("Funcao", new ImageIcon("../Projeto_Dougstore/images/funcao-icon.png"))
        {	private static final long serialVersionUID = 1L;
        	public void actionPerformed(ActionEvent e)
            { 
        		chamaMetodo(e,"jFuncao"); 
        	}
        };
        
        Action botao5Action = new AbstractAction("Estoque", new ImageIcon("../Projeto_Dougstore/images/estoque-icon.png"))
        {	private static final long serialVersionUID = 1L;
        	public void actionPerformed(ActionEvent e)
            { 
        		chamaMetodo(e,"jEstoque"); 
        	}
        };
        
        Action botao6Action = new AbstractAction("Produto", new ImageIcon("../Projeto_Dougstore/images/product-icon.png"))
        {	private static final long serialVersionUID = 1L;
        	public void actionPerformed(ActionEvent e)
            { 
        		chamaMetodo(e,"jProduto"); 
        	}
        };
        
        Action botao7Action = new AbstractAction("Fornecedor", new ImageIcon("../Projeto_Dougstore/images/fornecedor-icon.png"))
        {	private static final long serialVersionUID = 1L;
        	public void actionPerformed(ActionEvent e)
            { 
        		chamaMetodo(e,"jFornecedor"); 
        	}
        };

        ToolButton botao1  = new ToolButton(botao1Action);
        ToolButton botao2  = new ToolButton(botao2Action);
        ToolButton botao3  = new ToolButton(botao3Action);
        ToolButton botao4  = new ToolButton(botao4Action);
        ToolButton botao5  = new ToolButton(botao5Action);
        ToolButton botao6  = new ToolButton(botao6Action);
        ToolButton botao7  = new ToolButton(botao7Action);
        
        BFerramenta.add(botao1);
        BFerramenta.add(botao2);
        BFerramenta.add(botao3);
        BFerramenta.add(botao4);
        BFerramenta.add(botao5);
        BFerramenta.add(botao6);
        BFerramenta.add(botao7);
        
        return BFerramenta;
}
    
    public void add(Object gui)
    { 
    	this.gui = gui; 
    }

    private void chamaMetodo(ActionEvent e, String xMetodo)
    {   
    	Method metodo;
        
    	try
        {   
    		metodo = gui.getClass().getMethod(xMetodo,null);
        	//Object t = null;
            metodo.invoke(gui,null);
        }
    	
        catch (NoSuchMethodException nsme)
        { 
        	JOptionPane.showMessageDialog(null, "Metodo não definido para este evento/menu - ERR1"); 
        }
        
    	catch (IllegalAccessException iae)
        { 
    		JOptionPane.showMessageDialog(null, "Metodo não definido para este evento/menu2 - ERR2"); 
    	}
        
    	catch (InvocationTargetException ite)
        {   
    		ite.getTargetException().printStackTrace();
            JOptionPane.showMessageDialog(null, "Metodo não definido para este evento/menu - ERR3");
        }
  }
}