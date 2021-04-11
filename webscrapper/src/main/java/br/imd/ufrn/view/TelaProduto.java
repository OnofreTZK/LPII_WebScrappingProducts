package br.imd.ufrn.view;


import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import br.imd.ufrn.controller.Banco;

public class TelaProduto extends JInternalFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	int codP = 1;
	
	Banco bc;
	
	// rótulos
	JLabel ldescProduto = new JLabel("Nome Produto:"); 
	JLabel title = new JLabel("Buscar Produto");
	
	private Font f	= new Font("Courier", Font.BOLD, 14);
	private Font f2	= new Font("Courier", Font.BOLD, 18);
		
	// campos
	JTextField tdesProduto = new JTextField();
	
	// botões
	JButton btSubmeter = new JButton("Submeter");
	JButton btLimpar = new JButton("Limpar");
	
	// CheckBox
	JCheckBox top10Max = new JCheckBox("Top max");
	JCheckBox top10Min = new JCheckBox("Top min");
	JCheckBox mean = new JCheckBox("Média");
	
	
	
	public TelaProduto(String str){
		super(str,false,true);
		
		Container ct = this.getContentPane();
		ct.setLayout(null);
		
		// setando a fonte
		title.setFont(f2);
		ldescProduto.setFont(f);
		
		// coordenadas
		title.setBounds(200, 30, 150, 30);
		ldescProduto.setBounds(10,100,105,25);
		tdesProduto.setBounds(118,100,300,25);
		
		// idem
		btSubmeter.setBounds(118,240,100,30);
		btLimpar.setBounds(318,240,100,30);
		
		top10Max.setBounds(118, 130, 100, 30);
		top10Min.setBounds(218, 130, 100, 30);
		mean.setBounds(318, 130, 100, 30);
		
		
		// adicionando componentes
		ct.add(title);
		ct.add(ldescProduto);
		ct.add(tdesProduto);
		ct.add(btSubmeter);
		ct.add(btLimpar);
		ct.add(top10Max);
		ct.add(top10Min);
		ct.add(mean);
				
		// evento dos botões
		btSubmeter.addActionListener(this);		
		btLimpar.addActionListener(this);
		
		top10Max.addActionListener(this);
		top10Min.addActionListener(this);
		mean.addActionListener(this);
		
		// especificações do formulário
		setSize(480,310);
		setTitle(str);
				
	}	

	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btSubmeter){
			
			// setar atributos Produto
			
			Banco bc = Banco.getInstance();
			String p = tdesProduto.getText();
			
			
			
			bc.provedor(p);
			
			if(top10Max.isSelected()) {
				bc.ordenaCaros();;
			}
			
			if(top10Min.isSelected()) {
				bc.ordenaBaratos();;
			}
			
			if(mean.isSelected()) {
				bc.calculaMedia();;
			}			
			
			tdesProduto.setText("");
			top10Max.setSelected(false);
			top10Min.setSelected(false);
			mean.setSelected(false);
			tdesProduto.requestFocus();		
		}
		
		
		if(e.getSource() == btLimpar){
			tdesProduto.setText("");
			top10Max.setSelected(false);
			top10Min.setSelected(false);
			mean.setSelected(false);
		}
	}

}

