package apresentacao;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.reflect.*;

public class BarradeMenu
{
    Object gui;

    public JMenuBar make()
    {           
        JMenuBar BMenu = new JMenuBar();

        // Cria o Menu Gerenciamentos Básicos na Barra de Menu
        JMenu menu1 = new JMenu("Gerenciamentos Básicos");
        menu1.setMnemonic(KeyEvent.VK_G); // Sublinha a letra C do Menu Cadastros Básicos
        menu1.setFont(new Font ("Arial",Font.PLAIN,11));

        // Opções do Menu Gerenciamentos Básicos
        // Opção 1 - Pessoa Física
        JMenuItem menu1Item1 = new JMenuItem("Pessoa Física...",new ImageIcon("../Agenda/src/images/cliente.gif"));
        menu1Item1.setFont(new Font ("Arial",Font.PLAIN,11));
        menu1Item1.setMnemonic(KeyEvent.VK_F);
        menu1Item1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F,InputEvent.CTRL_MASK));
        menu1Item1.addActionListener(new ActionListener()
        { public void actionPerformed(ActionEvent e)
            { chamaMetodo(e,"jPFisica"); }
        });

        // Opções do Menu Cadastros Básicos
        // Opção 2 - Pessoa Jurídica
        JMenuItem menu1Item2 = new JMenuItem("Pessoa Jurídica...",new ImageIcon("../Agenda/src/images/home.gif"));
        menu1Item2.setFont(new Font ("Arial",Font.PLAIN,11));
        menu1Item2.setMnemonic(KeyEvent.VK_J);
        menu1Item2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_J,InputEvent.CTRL_MASK));
        menu1Item2.addActionListener(new ActionListener()
        { public void actionPerformed(ActionEvent e)
            { chamaMetodo(e,"jPJuridica"); }
        });
 
        // Opções do Menu Cadastros Básicos
        // Opção 3 - Sair
        JMenuItem menu1Item3 = new JMenuItem("Sair",new ImageIcon("../Agenda/src/images/sair.gif"));
        menu1Item3.setFont(new Font ("Arial",Font.PLAIN,11));
        menu1Item3.setMnemonic(KeyEvent.VK_S);
        menu1Item3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,InputEvent.CTRL_MASK));
        menu1Item3.addActionListener(new ActionListener()
        { public void actionPerformed(ActionEvent e)
            { chamaMetodo(e,"jSair"); }
        });

        // Adiciona os itens criados ao Menu Cadastros Básicos
        menu1.add(menu1Item1);  // Item Pessoa Física
        menu1.add(menu1Item2);  // Item Pessoa Jurídica
        menu1.addSeparator();   // Separador
        menu1.add(menu1Item3); // Item Sair


      // Cria o Menu Ajuda na Barra de Menu
      JMenu menu2 = new JMenu("Ajuda");
      menu2.setMnemonic(KeyEvent.VK_U);
      menu2.setFont(new Font ("Arial",Font.PLAIN,11));

      // Opçoes do Menu Ajuda
      // Opção 1 - Sobre
      JMenuItem menu2Item1 = new JMenuItem("Sobre",new ImageIcon("../Agenda/src/images/ajuda.gif"));
      menu2Item1.setFont(new Font ("Arial",Font.PLAIN,11));
      menu2Item1.setMnemonic(KeyEvent.VK_S);
      menu2Item1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,InputEvent.CTRL_MASK));
      menu2Item1.addActionListener(new ActionListener()
      { public void actionPerformed(ActionEvent e)
        { chamaMetodo(e,"jSobre"); }
      });
     
      // Adiciona os itens criados ao Menu Ajuda
      menu2.add(menu2Item1); // Item Sobre

      // Adiciona os Menus à Barra de Menu
      BMenu.add(menu1); // Cadastros Básicos
      BMenu.add(menu2); // Ajuda

      return BMenu;
    }




//********************************************
//Método genérico para chamada automática dos
//métodos vinculados aos itens de menu
//********************************************
    public void add(Object gui)
    { this.gui  = gui; }

    private void chamaMetodo(ActionEvent e, String xMetodo)
    {   Method metodo;
        try
        {   metodo = gui.getClass().getMethod(xMetodo, null);
            metodo.invoke(gui, null);
        }
        catch (NoSuchMethodException nsme)
        { JOptionPane.showMessageDialog(null, "Metodo não definido para este evento/menu - ERR1"); }
        catch (IllegalAccessException iae)
        {JOptionPane.showMessageDialog(null, "Metodo não definido para este evento/menu - ERR2"); }
        catch (InvocationTargetException ite)
        {   ite.getTargetException().printStackTrace();
            JOptionPane.showMessageDialog(null, "Metodo não definido para este evento/menu - ERR3");
        }
    }
}