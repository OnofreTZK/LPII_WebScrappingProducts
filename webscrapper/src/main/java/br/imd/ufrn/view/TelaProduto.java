package br.imd.ufrn.view;


import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import br.imd.ufrn.controller.Banco;
import br.imd.ufrn.model.Produto;

public class TelaProduto extends JInternalFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	int codP = 1;
	
	Banco bc;
	
	// rótulos
	JLabel ldescProduto = new JLabel("Nome Produto:");  
	JLabel lvlrProduto  = new JLabel("Fornecedor Produto.:"); 
	
	private Font f	= new Font("Courier", Font.PLAIN, 12);
	
	// campos
	JTextField tdesProduto = new JTextField();
	JTextField tvlrProduto = new JTextField();
	
	// botões
	JButton btSubmeter = new JButton("Submeter");
	JButton btLimpar = new JButton("Limpar");
	
	public TelaProduto(String str){
		super(str,false,true);
		
		Container ct = this.getContentPane();
		ct.setLayout(null);
		
		// setando a fonte
		ldescProduto.setFont(f);
		lvlrProduto.setFont(f);
		
		// coordenadas
		ldescProduto.setBounds(10,10,105,25);
		tdesProduto.setBounds(118,10,265,25);
				
		
		lvlrProduto.setBounds(10,70,105,25);
		tvlrProduto.setBounds(118,70,100,25);
		
		// idem
		btSubmeter.setBounds(50,140,100,30);
		btLimpar.setBounds(230,140,100,30);
		
		// adicionando componentes
		ct.add(ldescProduto);
		ct.add(tdesProduto);
		ct.add(lvlrProduto);
		ct.add(tvlrProduto);
		ct.add(btSubmeter);
		ct.add(btLimpar);
				
		// evento dos botões
		btSubmeter.addActionListener(this);		
		btLimpar.addActionListener(this);
		
		// especificações do formulário
		setSize(410,210);
		setTitle(str);
				
		bc = Banco.getInstance();
	}	

	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btSubmeter){
			
			// setar atributos Produto
			Produto p = new Produto();
			
			
			p.setNomeProduto(tdesProduto.getText());
			p.setValorProduto(Double.parseDouble(tvlrProduto.getText()));
			
			// persistir dados
			bc.inserirProduto(p);
			System.out.println(codP);
			
			tdesProduto.setText("");
			tvlrProduto.setText("");
			
			tdesProduto.requestFocus();
						
		}
		if(e.getSource() == btLimpar){
			tdesProduto.setText("");
			tvlrProduto.setText("");
		}
	}

}

