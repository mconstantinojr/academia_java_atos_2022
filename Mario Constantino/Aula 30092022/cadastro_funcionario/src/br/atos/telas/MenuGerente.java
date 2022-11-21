package br.atos.telas;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import br.atos.telas.controletelas.MenuGerenteControle;

public class MenuGerente {
	public void apresentarMenuGerente(JFrame frameMenuGerenteCoordenador) {
		System.out.println("Menu Gerente");
		
		String menuGerenteTexto = "Menu Gerente";
		String opcaoUmMenuTexto = "[1] Cadastro de Gerente";
		String opcaoDoisMenuTexto = "[2] Listar Gerente";
		String opcaoTresMenuTexto = "[3] Alterar Gerente";
		String opcaoQuatroMenuTexto = "[4] Excluir Gerente";
		String opcaoCincoMenuTexto = "[5] Encerrar";
		
		JFrame frameMenuGerente = new JFrame();
		frameMenuGerente.setSize(200,200);
		frameMenuGerente.setTitle("Cadastro de Gerente");
		frameMenuGerente.setLocation(300,300);
		
		JPanel panelMenuGerente = new JPanel();
		
		JLabel menuGerenteTextoLabel = new JLabel(menuGerenteTexto);
		panelMenuGerente.add(menuGerenteTextoLabel);
		
		JLabel opcaoUmMenuTextoLabel = new JLabel(opcaoUmMenuTexto);
		panelMenuGerente.add(opcaoUmMenuTextoLabel);
		
		JLabel opcaoDoisMenuTextoLabel = new JLabel(opcaoDoisMenuTexto);
		panelMenuGerente.add(opcaoDoisMenuTextoLabel);
		
		JLabel opcaoTresTextoLabel = new JLabel(opcaoTresMenuTexto);
		panelMenuGerente.add(opcaoTresTextoLabel);

		JLabel opcaoQuatroTextoLabel = new JLabel(opcaoQuatroMenuTexto);
		panelMenuGerente.add(opcaoQuatroTextoLabel);
		
		JLabel opcaoCincoTextoLabel = new JLabel(opcaoCincoMenuTexto);
		panelMenuGerente.add(opcaoCincoTextoLabel);

		JTextField opcaoMenuJTextField = new JTextField(10);
		panelMenuGerente.add(opcaoMenuJTextField);
		
		JButton botaoMenu = new JButton("Enviar");
		panelMenuGerente.add(botaoMenu);
		
		JButton botaoVoltar = new JButton("Voltar");
		panelMenuGerente.add(botaoVoltar);
		
		frameMenuGerente.add(panelMenuGerente);
		frameMenuGerente.setVisible(true);
		
		MenuGerenteControle menuGerenteControle = new MenuGerenteControle(opcaoMenuJTextField, frameMenuGerente, frameMenuGerenteCoordenador );
		botaoMenu.addActionListener(menuGerenteControle);
		botaoVoltar.addActionListener(menuGerenteControle);
	}
}