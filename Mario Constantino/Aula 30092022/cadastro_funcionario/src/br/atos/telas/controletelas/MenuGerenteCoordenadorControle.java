package br.atos.telas.controletelas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTextField;

import br.atos.repositorio.RepositorioFuncionario;
import br.atos.telas.MenuCoordenador;
import br.atos.telas.MenuGerente;

public class MenuGerenteCoordenadorControle implements ActionListener {

	JTextField opcaoMenuJTextField;
	JFrame frameGerenteCoordenador;
	
	MenuGerente  menuGerente = new MenuGerente();
	
	MenuCoordenador menuCoordenador = new MenuCoordenador();
	
	RepositorioFuncionario repositorioFuncionario = new RepositorioFuncionario();
	
	public MenuGerenteCoordenadorControle() {
		
	}
	
	public MenuGerenteCoordenadorControle(JTextField opcaoMenuJTextFieldCr, JFrame frameGerenteCoordenador) {
		this.opcaoMenuJTextField = opcaoMenuJTextFieldCr;
		this.frameGerenteCoordenador = frameGerenteCoordenador;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {

		if (opcaoMenuJTextField.getText().equals("1") || opcaoMenuJTextField.getText().equals("2") || opcaoMenuJTextField.getText().equals("3")) {
			
			frameGerenteCoordenador.setVisible(false);
			switch (opcaoMenuJTextField.getText()) { 
			case "1":
				System.out.println("Menu Gerente!");
				menuGerente.apresentarMenuGerente(frameGerenteCoordenador);
				//telaRegistro.registrarProgramador(opcaoMenuJTextField, frameGerenteCoordenador, repositorioFuncionario);
			break;
			
			case "2":
				System.out.println("Menu Coordenador!");
				menuCoordenador.apresentarMenuCoordenador(frameGerenteCoordenador);
				//listarFuncionario.apresentarLista(repositorioFuncionario.listarFuncionario(), frameGerenteCoordenador);
			break;

			case "3":
				System.out.println("Encerrar!");
				System.exit(-1);
			break;

			}	
		} else {
			System.out.println("Opcao Invalida");
		}
		
	}

}
