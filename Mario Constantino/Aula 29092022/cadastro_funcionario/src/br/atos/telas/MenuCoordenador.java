package br.atos.telas;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import br.atos.telas.controletelas.MenuCoordenadorControle;
import br.atos.telas.controletelas.MenuGerenteControle;

public class MenuCoordenador {
	public void apresentarMenuCoordenador(JFrame frameMenuGerenteCoordenador) {
		System.out.println("Menu Coordenador");
		
		String menuCoordenadorTexto = "Menu Coordenador";
		String opcaoUmMenuTexto = "[1] Cadastro de Coordenador";
		String opcaoDoisMenuTexto = "[2] Listar Coordenador";
		String opcaoTresMenuTexto = "[3] Alterar Coordenador";
		String opcaoQuatroMenuTexto = "[4] Excluir Coordenador";
		String opcaoCincoMenuTexto = "[5] Encerrar";
		
		JFrame frameMenuCoordenador = new JFrame();
		frameMenuCoordenador.setSize(200,200);
		frameMenuCoordenador.setTitle("Cadastro de Coordenador");
		frameMenuCoordenador.setLocation(300,300);
		
		JPanel panelMenuCoordenador = new JPanel();
		
		JLabel menuCoordenadorTextoLabel = new JLabel(menuCoordenadorTexto);
		panelMenuCoordenador.add(menuCoordenadorTextoLabel);
		
		JLabel opcaoUmMenuTextoLabel = new JLabel(opcaoUmMenuTexto);
		panelMenuCoordenador.add(opcaoUmMenuTextoLabel);
		
		JLabel opcaoDoisMenuTextoLabel = new JLabel(opcaoDoisMenuTexto);
		panelMenuCoordenador.add(opcaoDoisMenuTextoLabel);
		
		JLabel opcaoTresTextoLabel = new JLabel(opcaoTresMenuTexto);
		panelMenuCoordenador.add(opcaoTresTextoLabel);

		JLabel opcaoQuatroTextoLabel = new JLabel(opcaoQuatroMenuTexto);
		panelMenuCoordenador.add(opcaoQuatroTextoLabel);
		
		JLabel opcaoCincoTextoLabel = new JLabel(opcaoCincoMenuTexto);
		panelMenuCoordenador.add(opcaoCincoTextoLabel);

		JTextField opcaoMenuJTextField = new JTextField(10);
		panelMenuCoordenador.add(opcaoMenuJTextField);
		
		JButton botaoMenu = new JButton("Enviar");
		panelMenuCoordenador.add(botaoMenu);
		
		JButton botaoVoltar = new JButton("Voltar");
		panelMenuCoordenador.add(botaoVoltar);
		
		frameMenuCoordenador.add(panelMenuCoordenador);
		frameMenuCoordenador.setVisible(true);
		
		MenuCoordenadorControle menuCoordenadorControle = new MenuCoordenadorControle(opcaoMenuJTextField, frameMenuCoordenador, frameMenuGerenteCoordenador );
		botaoMenu.addActionListener(menuCoordenadorControle);
		botaoVoltar.addActionListener(menuCoordenadorControle);
	}
}