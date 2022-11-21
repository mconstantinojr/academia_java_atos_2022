package br.atos.telas;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import br.atos.telas.controletelas.MenuInicialControle;

public class MenuGerenteCoordenador {
	public void apresentarMenuGerenteCoordenador() {
		System.out.println("MenuInicial");
		
		String opcaoMenu = null;
		
		String menuInicialTexto = "Menu Gerente/Coordenador";
		String opcaoUmMenuTexto = "[1] Gerente";
		String opcaoDoisMenuTexto = "[2] Coordenador";
		String opcaoTresMenuTexto = "[3] Encerrar";
		
		JFrame frameMenuInicial = new JFrame();
		frameMenuInicial.setSize(200,200);
		frameMenuInicial.setTitle("Cadastro de Funcionario");
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