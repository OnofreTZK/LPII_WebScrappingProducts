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
	JLabel ldescProduto = new JLabel("Desc. Produto:"); 
	JLabel luniProduto  = new JLabel("Un. Produto..:"); 
	JLabel lvlrProduto  = new JLabel("Vlr. Produto.:"); 
	
	private Font f	= new Font("Courier", Font.PLAIN, 12);
	
	// campos
	JTextField tdesProduto = new JTextField();
	JTextField tuniProduto = new JTextField();
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
		luniProduto.setFont(f);
		lvlrProduto.setFont(f);
		
		// coordenadas
		ldescProduto.setBounds(10,10,105,25);
		tdesProduto.setBounds(118,10,265,25);
				
		luniProduto.setBounds(10,40,105,25);
		tuniProduto.setBounds(118,40,22,25);
		
		lvlrProduto.setBounds(10,70,105,25);
		tvlrProduto.setBounds(118,70,100,25);
		
		// idem
		btSubmeter.setBounds(50,140,100,30);
		btLimpar.setBounds(230,140,100,30);
		
		// adicionando componentes
		ct.add(ldescProduto);
		ct.add(tdesProduto);
		ct.add(luniProduto);
		ct.add(tuniProduto);
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

	@Override
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
			tuniProduto.setText("");
			tvlrProduto.setText("");
			
			tdesProduto.requestFocus();
						
		}
		if(e.getSource() == btLimpar){
			tdesProduto.setText("");
			tuniProduto.setText("");
			tvlrProduto.setText("");
		}
	}

}

