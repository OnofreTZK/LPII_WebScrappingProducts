package br.imd.ufrn.view;


import java.awt.Container;
import java.awt.Font;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;


public class TelaSobre extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	int codP = 1;
	
	
	// texto
	JLabel firstString = new JLabel("Modo de uso:" + "\n");  
	JLabel secondString = new JLabel("Para usar o programa é necessario que o usuário:");
	JLabel thirdString = new JLabel("- Primeiro vá ao campo de 'Buscar produto' na bara de menu 'Produtos'");
	JLabel fourthString = new JLabel("- Após isso preencher os campos e submeter os valores");


	
	private Font f	= new Font("Courier", Font.PLAIN, 12);
	private Font f3	= new Font("Courier", Font.PLAIN, 14);
	private Font f2	= new Font("Courier", Font.PLAIN, 18);
	
	
	public TelaSobre(String str){
		super(str,false,true);
		
		Container ct = this.getContentPane();
		ct.setLayout(null);
		
		// setando a fonte
		firstString.setFont(f2);
		secondString.setFont(f3);
		thirdString.setFont(f);
		fourthString.setFont(f);

	
		
		// coordenadas
		firstString.setBounds(10,10,205,25);
		secondString.setBounds(10,40,410,25);
		thirdString.setBounds(10, 65, 410, 25);
		fourthString.setBounds(10, 90, 410, 25);
	
		
		// adicionando componentes
		ct.add(firstString);
		ct.add(secondString);
		ct.add(thirdString);
		ct.add(fourthString);

		// especificações do formulário
		setSize(410,210);
		setTitle(str);
				
	}
}

