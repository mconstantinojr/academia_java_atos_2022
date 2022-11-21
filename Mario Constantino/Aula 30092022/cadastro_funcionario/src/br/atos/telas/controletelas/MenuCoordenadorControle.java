package br.atos.telas.controletelas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTextField;

import br.atos.repositorio.RepositorioCoordenador;
import br.atos.repositorio.RepositorioCoordenador;
import br.atos.telas.TelaBuscarCoordenadorEditar;
import br.atos.telas.TelaBuscarCoordenadorEditar;
import br.atos.telas.TelaCadastroCoordenador;
import br.atos.telas.TelaCadastroCoordenador;
import br.atos.telas.TelaDeletarCoordenador;
import br.atos.telas.TelaListarCoordenador;
import br.atos.telas.TelaListarCoordenador;

public class MenuCoordenadorControle implements ActionListener {

	JTextField opcaoMenuJTextField;
	JFrame frameMenuCoordenador;
	JFrame frameMenuCoordenadorCoordenador;
	
	TelaCadastroCoordenador telaCadastroCoordenador = new TelaCadastroCoordenador();
	
	TelaListarCoordenador telaListarCoordenador = new TelaListarCoordenador();
	
	TelaBuscarCoordenadorEditar telaBuscarCoordenadorEditar = new TelaBuscarCoordenadorEditar();
	
	TelaDeletarCoordenador telaDeletarCoordenador = new TelaDeletarCoordenador();
	
	RepositorioCoordenador repositorioCoordenador = new RepositorioCoordenador();
	
	public MenuCoordenadorControle() {
		
	}
	
	public MenuCoordenadorControle(JTextField opcaoMenuJTextFieldCr, JFrame frameMenuCoordenador, JFrame frameMenuCoordenadorCoordenador) {
		this.opcaoMenuJTextField = opcaoMenuJTextFieldCr;
		this.frameMenuCoordenador = frameMenuCoordenador;
		this.frameMenuCoordenadorCoordenador = frameMenuCoordenadorCoordenador;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Voltar")) {
			frameMenuCoordenador.setVisible(false);
			frameMenuCoordenadorCoordenador.setVisible(true);
		} else {
			if (opcaoMenuJTextField.getText().equals("1") || opcaoMenuJTextField.getText().equals("2") || opcaoMenuJTextField.getText().equals("3") || opcaoMenuJTextField.getText().equals("4") || opcaoMenuJTextField.getText().equals("5")) {
				
				frameMenuCoordenador.setVisible(false);
				switch (opcaoMenuJTextField.getText()) { 
				case "1":
					System.out.println("Cadastre o Coordenador!");
					telaCadastroCoordenador.registrarCoordenador(opcaoMenuJTextField, frameMenuCoordenador, repositorioCoordenador);
				break;
				
				case "2":
					System.out.println("Liste o Coordenador!");
					telaListarCoordenador.apresentarLista(repositorioCoordenador, frameMenuCoordenador);
				break;

				case "3":
					telaBuscarCoordenadorEditar.buscarCoordenador(frameMenuCoordenador, repositorioCoordenador);
					System.out.println("Altere um Funcionário!");
				break;

				case "4":
					telaDeletarCoordenador.deletarCoordenador(frameMenuCoordenador, repositorioCoordenador); 
					System.out.println("Excluir um Funcionário!");
				break;

				case "5":
					System.out.println("Encerrar!");
				break;
				}	
			} else {
				System.out.println("Opcao Invalida");
			}
			
		}
		
	}

}
