package apresentacao;

import modelo.*;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class TelaPessoaFisica extends JFrame
{	
	//atributos
	private JLabel lNome, lCpf, lDataNascimento, lRua, lNumero, lComplemento, lBairro, lCidade, lCep, lEstado, lDdi, lDdd, lTel, lTipo, lOperadora;
	private JTextField tNome, tCpf, tDataNascimento, tRua, tNumero, tComplemento, tBairro, tCidade, tCep, tEstado, tDdi, tDdd, tTel, tTipo, tOperadora;
	private JButton bSalvar, bLimpar, bListar, bBuscar, bExcluir, bEditar, bFechar;
	private JPanel pFisica, pEndereco, pTelefone;

	//variáveis locais para armazenar o que for digitado
	String cpf,nome,datanascimento,rua,numero,complemento,bairro,cidade,cep,estado,ddi,ddd,tel,tipo,operadora;
	
	//atributos de referência
	PessoaFisica pf;	
	Endereco end;
	Telefone fone;
		
	//método construtor
	public TelaPessoaFisica()
	{
		//configurações da janela
		this.setSize(690,430);
		this.setTitle("Tela de Gerenciamento de Pessoa Física");
		this.setResizable(false);
		this.setLayout(null);
		this.setVisible(true);
		this.setLocationRelativeTo(null); //centraliza a janela na abertura
		//this.setDefaultCloseOperation(EXIT_ON_CLOSE); 
		
		Toolkit tk = Toolkit.getDefaultToolkit();
		Image img = tk.getImage("../Agenda/src/images/executar.gif");
		this.setIconImage(img);
		
		//criando os panels para estruturar as áreas na tela 
		pFisica = new JPanel();
		pFisica.setSize(660,90);
		pFisica.setLocation(10,10);
		pFisica.setBorder(BorderFactory.createTitledBorder("DADOS DA PESSOA FÍSICA:"));
		pFisica.setLayout(null);
		
		pEndereco = new JPanel();
		pEndereco.setSize(660,120);
		pEndereco.setLocation(10,110);
		pEndereco.setBorder(BorderFactory.createTitledBorder("ENDEREÇO COMPLETO:"));
		pEndereco.setLayout(null);
		
		pTelefone = new JPanel();
		pTelefone.setSize(660,90);
		pTelefone.setLocation(10,240);	
		pTelefone.setBorder(BorderFactory.createTitledBorder("TELEFONE DE CONTATO:"));
		pTelefone.setLayout(null);
		
		//adicionando os labels	e text fields
		
		//pessoal
		lCpf = new JLabel("Número do Cadastro de Pessoa Física - CPF: ");
		lCpf.setSize(260,30);
		lCpf.setLocation(20,20);
		
		tCpf = new JTextField();
		tCpf.setSize(120,20);
		tCpf.setLocation(280,25);

		lDataNascimento = new JLabel("Data de Nascimento:");
		lDataNascimento.setSize(120,30);
		lDataNascimento.setLocation(420,20);
		
		tDataNascimento = new JTextField();
		tDataNascimento.setSize(90,20);
		tDataNascimento.setLocation(550,25);
		tDataNascimento.setText("dd/mm/aaaa");
		
		lNome = new JLabel("Nome Completo: ");
		lNome.setSize(120,30);
		lNome.setLocation(20,50);
		
		tNome = new JTextField();
		tNome.setSize(510,20);
		tNome.setLocation(130,55);
		
		//endereço
		lRua = new JLabel("Logradouro:");
		lRua.setSize(120,30);
		lRua.setLocation(20,20);
		
		tRua = new JTextField();
		tRua.setSize(540,20);
		tRua.setLocation(100,25);
		
		lNumero = new JLabel("Número:");
		lNumero.setSize(120,30);
		lNumero.setLocation(20,50);
		
		tNumero = new JTextField();
		tNumero.setSize(70,20);
		tNumero.setLocation(80,55);
		
		lComplemento = new JLabel("Complemento:");
		lComplemento.setSize(120,30);
		lComplemento.setLocation(160,50);
		
		tComplemento = new JTextField();
		tComplemento.setSize(100,20);
		tComplemento.setLocation(250,55);
		
		lBairro = new JLabel("Bairro: ");
		lBairro.setSize(120,30);
		lBairro.setLocation(370,50);
		
		tBairro = new JTextField();
		tBairro.setSize(220,20);
		tBairro.setLocation(420,55);
		
		lCidade = new JLabel("Cidade: ");
		lCidade.setSize(120,30);
		lCidade.setLocation(20,80);
		
		tCidade = new JTextField();
		tCidade.setSize(270,20);
		tCidade.setLocation(80,85);
		
		lCep = new JLabel("CEP:");
		lCep.setSize(60,30);
		lCep.setLocation(370,80);
		
		tCep = new JTextField();
		tCep.setSize(70,20);
		tCep.setText("00000-000");
		tCep.setLocation(410,85);
		
		lEstado = new JLabel("Estado:");
		lEstado.setSize(120,30);
		lEstado.setLocation(500,80);
		
		tEstado = new JTextField();
		tEstado.setSize(80,20);
		tEstado.setLocation(560,85);
		
		//telefone
		lDdi = new JLabel("Código Internacional DDI:");
		lDdi.setSize(160,30);
		lDdi.setLocation(20,20);
		
		tDdi = new JTextField();
		tDdi.setSize(30,20);
		tDdi.setText("+55");
		tDdi.setLocation(180,25);
		
		lDdd = new JLabel("Código Local DDD:");
		lDdd.setSize(120,30);
		lDdd.setLocation(250,20);
		
		tDdd = new JTextField();
		tDdd.setSize(30,20);
		tDdd.setText("22");
		tDdd.setLocation(370,25);
		
		lTel = new JLabel("Número: ");
		lTel.setSize(80,30);
		lTel.setLocation(435,20);
		
		tTel = new JTextField();
		tTel.setSize(140,20);
		tTel.setLocation(500,25);
		
		lTipo = new JLabel("Tipo do Telefone:");
		lTipo.setSize(100,30);
		lTipo.setLocation(20,50);
		
		tTipo = new JTextField();
		tTipo.setSize(180,20);
		tTipo.setLocation(130,55);
		
		lOperadora = new JLabel("Operadora de Telefonia: ");
		lOperadora.setSize(150,30);
		lOperadora.setLocation(350,50);
				
		tOperadora = new JTextField();
		tOperadora.setSize(140,20);
		tOperadora.setLocation(500,55);
		
		//criando classe interna para funcionar como ouvinte dos eventos de mouse
		class BatSinal extends MouseAdapter {
			public void mouseClicked(MouseEvent e) {
				if (e.getSource() == bSalvar) {
						
					//endereco
					rua = tRua.getText();
					numero = tNumero.getText();
					complemento = tComplemento.getText();
					bairro = tBairro.getText();
					cidade = tCidade.getText();
					cep = tCep.getText();
					estado = tEstado.getText();
					end = new Endereco(rua,numero,complemento,bairro,cidade,cep,estado);

					//telefone
					ddi = tDdi.getText();
					ddd = tDdd.getText();
					tel = tTel.getText();
					tipo = tTipo.getText();
					operadora = tOperadora.getText();
					fone = new Telefone(ddi,ddd,tel,tipo,operadora);
					
					//pessoal
					nome = tNome.getText();
					cpf = tCpf.getText();
					datanascimento = tDataNascimento.getText();
					pf = new PessoaFisica(nome,cpf,datanascimento,end,fone);			
				}
				
				if (e.getSource() == bLimpar) {
					tNome.setText("");
					tCpf.setText("");
					tDataNascimento.setText("");
					tRua.setText("");
					tNumero.setText("");
					tComplemento.setText("");
					tBairro.setText("");
					tCidade.setText("");
					tCep.setText("");
					tEstado.setText("");
					tDdi.setText("");
					tDdd.setText("");
					tTel.setText("");
					tTipo.setText("");
					tOperadora.setText("");
				}
				
				if (e.getSource() == bListar)
				{	pf.imprimir();
					JOptionPane.showMessageDialog(null,"ENDEREÇO COMPLETO:\n\n"+end.getRua()+", "+end.getNumero()+" - "+end.getComplemento()+" - "+end.getBairro()+" - "+end.getCidade()+"/"+end.getEstado()+" - CEP: "+end.getCep());
					JOptionPane.showMessageDialog(null,"TELEFONE COMPLETO:\n\n"+fone.getDdi()+" ("+fone.getDdd()+") "+fone.getNumero()+" - "+fone.getTipo()+" - "+fone.getOperadora());
				}
				
				if (e.getSource() == bFechar) {
					dispose();
					//System.exit(0);  
				}
			}	
		}
		
		//adicionando ouvinte para os botões
		BatSinal batman = new BatSinal();
				
		//adicionando os buttons
		bSalvar = new JButton("Salvar");
		bSalvar.setSize(75,30);
		bSalvar.setLocation(10,350);
		bSalvar.setForeground(Color.white);
		bSalvar.setBackground(Color.blue);
		bSalvar.addMouseListener(batman);
		
		bLimpar = new JButton("Limpar");
		bLimpar.setSize(75,30);
		bLimpar.setLocation(108,350);
		bLimpar.setForeground(Color.white);
		bLimpar.setBackground(Color.gray);
		bLimpar.addMouseListener(batman);
		
		bListar = new JButton("Listar");
		bListar.setSize(75,30);
		bListar.setLocation(206,350);
		bListar.setForeground(Color.white);
		bListar.setBackground(Color.green);
		bListar.addMouseListener(batman);
				
		bBuscar = new JButton("Buscar");
		bBuscar.setSize(75,30);
		bBuscar.setLocation(304,350);
		bBuscar.setForeground(Color.white);
		bBuscar.setBackground(Color.magenta);
		bBuscar.addMouseListener(batman);

		bExcluir = new JButton("Excluir");
		bExcluir.setSize(75,30);
		bExcluir.setLocation(402,350);
		bExcluir.setForeground(Color.white);
		bExcluir.setBackground(Color.orange);
		bExcluir.addMouseListener(batman);
		
		bEditar = new JButton("Editar");
		bEditar.setSize(75,30);
		bEditar.setLocation(500,350);
		bEditar.setForeground(Color.white);
		bEditar.setBackground(Color.pink);
		bEditar.addMouseListener(batman);
		
		bFechar = new JButton("Fechar");
		bFechar.setSize(75,30);
		bFechar.setLocation(596,350);
		bFechar.setForeground(Color.white);
		bFechar.setBackground(Color.red);
		bFechar.addMouseListener(batman);
		
		//acrescentando os componentes à tela
		this.add(pFisica);
		pFisica.add(lNome);
		pFisica.add(lCpf);
		pFisica.add(lDataNascimento);	
		pFisica.add(tNome);
		pFisica.add(tCpf);
		pFisica.add(tDataNascimento);
		
		this.add(pEndereco);
		pEndereco.add(lRua);
		pEndereco.add(lNumero);
		pEndereco.add(lComplemento);
		pEndereco.add(lBairro);
		pEndereco.add(lCidade);
		pEndereco.add(lCep);
		pEndereco.add(lEstado);
		pEndereco.add(tRua);
		pEndereco.add(tNumero);
		pEndereco.add(tComplemento);
		pEndereco.add(tBairro);
		pEndereco.add(tCidade);		
		pEndereco.add(tCep);
		pEndereco.add(tEstado);
		
		this.add(pTelefone);
		pTelefone.add(lDdi);
		pTelefone.add(lDdd);
		pTelefone.add(lTel);
		pTelefone.add(lTipo);
		pTelefone.add(lOperadora);
		pTelefone.add(tDdi);
		pTelefone.add(tDdd);
		pTelefone.add(tTel);
		pTelefone.add(tTipo);
		pTelefone.add(tOperadora);
		
		this.add(bSalvar);
		this.add(bLimpar);
		this.add(bListar);
		this.add(bBuscar);
		this.add(bExcluir);
		this.add(bEditar);
		this.add(bFechar);
		this.repaint();					
	}	
}