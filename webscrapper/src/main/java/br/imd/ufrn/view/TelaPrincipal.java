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

	
	JMenu menuBuscar = new JMenu("Produtos");
	JMenu menuAjud = new JMenu("Ajuda");
	
	
	JMenuItem mItem1 = new JMenuItem("Buscar Produtos");	
	JMenuItem mItem2 = new JMenuItem("Top 10 mais caros");
	JMenuItem mItem3 = new JMenuItem("Top 10 mais baratos");
	JMenuItem mItem4 = new JMenuItem("Média de preço");		

	JMenuItem mItem5 = new JMenuItem("Sobre");
	JMenuItem mItem6 = new JMenuItem("Sair");	
	
		 		
	public TelaPrincipal(){
		Container ct = this.getContentPane();
		ct.setLayout(new BorderLayout());
		
		setJMenuBar(mnbar);
		mnbar.add(menuBuscar);
		mnbar.add(menuAjud);

		menuBuscar.add(mItem1);
		menuBuscar.addSeparator();
		menuBuscar.add(mItem2);
		menuBuscar.add(mItem3);
		menuBuscar.add(mItem4);

		
		menuAjud.add(mItem5);
		menuAjud.addSeparator();
		menuAjud.add(mItem6);
		
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
	}
	

	public void actionPerformed(ActionEvent e) {
		Banco bc = Banco.getInstance();
		
		if (e.getSource() == mItem1){
			TelaProduto tlProduto = new TelaProduto("Produtos");
			dtp.add(tlProduto);
			tlProduto.setVisible(true);
		}
		
		if(e.getSource() == mItem2) {
			bc.ordenaCaros();
		}
		
		if(e.getSource() == mItem3) {
			bc.ordenaBaratos();
		}
		
		if(e.getSource() == mItem4) {
			bc.calculaMedia();
		}
		
		if (e.getSource() == mItem5) {
			TelaSobre tlSobre = new TelaSobre("Sobre");
			dtp.add(tlSobre);
			tlSobre.setVisible(true);
		}
		
		if (e.getSource() == mItem6) {
			System.exit(0);
		}
	}
	
	public static void main(String[] args) {
		TelaPrincipal telaPai = new TelaPrincipal();
		telaPai.setVisible(true);
	}
}
