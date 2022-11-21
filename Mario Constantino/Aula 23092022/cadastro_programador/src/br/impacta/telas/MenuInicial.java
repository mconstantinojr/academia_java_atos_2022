package br.impacta.telas;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import br.impacta.telas.controleTelas.MenuInicialControle;

public class MenuInicial {
	
	public void apresentarMenuInicial() {
		System.out.println("MenuInicial");
		
		String opcaoMenu = null;
		
		String menuInicialTexto = "Menu Inicial";
		String opcaoUmMenuTexto = "[1] Cadastro de Programador";
		String opcaoDoisMenuTexto = "[2] Listar Programador";
		String opcaoTresMenuTexto = "[3] Encerrar";
		String opcaoQuatroMenuTexto = "[4] Excluir";
		String opcaoCincoMenuTexto = "[5] Alterar";
		
		JFrame frameMenuInicial = new JFrame();
		frameMenuInicial.setSize(200,200);
		frameMenuInicial.setTitle("Cadastro de Programador");
		frameMenuInicial.setLocation(300,300);
		
		JPanel panelMenuInicial = new JPanel();
		
		JLabel menuInicialTextoLabel = new JLabel(menuInicialTexto);
		panelMenuInicial.add(menuInicialTextoLabel);
		
		JLabel opcaoUmMenuTextoLabel = new JLabel(opcaoUmMenuTexto);
		panelMenuInicial.add(opcaoUmMenuTextoLabel);
		
		JLabel opcaoDoisMenuTextoLabel = new JLabel(opcaoDoisMenuTexto);
		panelMenuInicial.add(opcaoDoisMenuTextoLabel);
		
		JLabel opcaoTresTextoLabel = new JLabel(opcaoTresMenuTexto);
		panelMenuInicial.add(opcaoTresTextoLabel);
		
		JLabel opcaoQuatroTextoLabel = new JLabel(opcaoQuatroMenuTexto);
		panelMenuInicial.add(opcaoQuatroTextoLabel);
		
		JLabel opcaoCincoTextoLabel = new JLabel(opcaoCincoMenuTexto);
		panelMenuInicial.add(opcaoCincoTextoLabel);
		
		JTextField opcaoMenuJTextField = new JTextField(10);
		panelMenuInicial.add(opcaoMenuJTextField);
		
		JButton botaoMenu = new JButton("Enviar");
		panelMenuInicial.add(botaoMenu);
		
		
		frameMenuInicial.add(panelMenuInicial);
		frameMenuInicial.setVisible(true);
		
		MenuInicialControle menuInicialControle = new MenuInicialControle(opcaoMenuJTextField, frameMenuInicial);
		botaoMenu.addActionListener(menuInicialControle);
	}
}
