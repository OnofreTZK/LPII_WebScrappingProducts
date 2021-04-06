package br.imd.ufrn.view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import br.imd.ufrn.controller.Banco;

public class TelaPrincipal extends JFrame implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	
	Banco bc;

	JDesktopPane dtp = new JDesktopPane();
	
	JMenuBar mnbar = new JMenuBar();	
	JMenu menuCada = new JMenu("Cadastros");
	JMenu menuRela = new JMenu("Relatórios");
	JMenu menuAjud = new JMenu("Ajuda");
	
	JMenuItem mItem1 = new JMenuItem("Clientes");
	JMenuItem mItem2 = new JMenuItem("Fornecedores");
	JMenuItem mItem3 = new JMenuItem("Produtos");
	
	JMenuItem mItem4 = new JMenuItem("Lista Clientes");
	JMenuItem mItem5 = new JMenuItem("Lista Fornecedores");
	JMenuItem mItem6 = new JMenuItem("Lista Produtos");
	
	JMenuItem mItem7 = new JMenuItem("Sobre");
	JMenuItem mItem8 = new JMenuItem("Sair");
		 		
	public TelaPrincipal(){
		Container ct = this.getContentPane();
		ct.setLayout(new BorderLayout());
		
		setJMenuBar(mnbar);
		mnbar.add(menuCada);
		mnbar.add(menuRela);
		mnbar.add(menuAjud);

		menuCada.add(mItem1);
		menuCada.add(mItem2);
		menuCada.add(mItem3);
		
		menuRela.add(mItem4);
		menuRela.add(mItem5);
		menuRela.add(mItem6);
		
		menuAjud.add(mItem7);
		menuAjud.addSeparator();
		menuAjud.add(mItem8);
		
		ct.add(BorderLayout.CENTER, dtp);
		
		setSize(900,700);
		setResizable(false);
		setTitle("Sistema de Controle de Vendas");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		// eventos
		mItem1.addActionListener(this);	
		mItem2.addActionListener(this);
		mItem3.addActionListener(this);
		
		mItem4.addActionListener(this);
		mItem5.addActionListener(this);
		mItem6.addActionListener(this);
		
		mItem8.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == mItem3){
			TelaProduto tlProduto = new TelaProduto("Produtos");
			dtp.add(tlProduto);
			tlProduto.setVisible(true);
		}
		if (e.getSource() == mItem8) {
			System.out.println("Fechando o sistema!!!");
			System.exit(0);
		}
	}
	
	public static void main(String[] args) {
		TelaPrincipal telaPai = new TelaPrincipal();
		telaPai.setVisible(true);
	}
}
