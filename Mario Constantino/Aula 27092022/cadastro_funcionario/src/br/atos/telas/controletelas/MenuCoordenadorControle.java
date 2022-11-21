package br.atos.telas.controletelas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTextField;

import br.atos.repositorio.RepositorioGerente;
import br.atos.telas.TelaBuscarGerenteEditar;
import br.atos.telas.TelaCadastroGerente;
import br.atos.telas.TelaDeletarGerente;
import br.atos.telas.TelaListarGerente;

public class MenuCoordenadorControle implements ActionListener {

	JTextField opcaoMenuJTextField;
	JFrame frameMenuGerente;
	JFrame frameMenuGerenteCoordenador;
	
	TelaCadastroGerente telaCadastroGerente = new TelaCadastroGerente();
	
	TelaListarGerente telaListarGerente = new TelaListarGerente();
	
	TelaBuscarGerenteEditar telaBuscarGerenteEditar = new TelaBuscarGerenteEditar();
	
	TelaDeletarGerente telaDeletarGerente = new TelaDeletarGerente();
	
	RepositorioGerente repositorioGerente = new RepositorioGerente();
	
	public MenuCoordenadorControle() {
		
	}
	
	public MenuCoordenadorControle(JTextField opcaoMenuJTextFieldCr, JFrame frameMenuGerente, JFrame frameMenuGerenteCoordenador) {
		this.opcaoMenuJTextField = opcaoMenuJTextFieldCr;
		this.frameMenuGerente = frameMenuGerente;
		this.frameMenuGerenteCoordenador = frameMenuGerenteCoordenador;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Voltar")) {
			frameMenuGerente.setVisible(false);
			frameMenuGerenteCoordenador.setVisible(true);
		} else {
			if (opcaoMenuJTextField.getText().equals("1") || opcaoMenuJTextField.getText().equals("2") || opcaoMenuJTextField.getText().equals("3") || opcaoMenuJTextField.getText().equals("4") || opcaoMenuJTextField.getText().equals("5")) {
				
				frameMenuGerente.setVisible(false);
				switch (opcaoMenuJTextField.getText()) { 
				case "1":
					System.out.println("Cadastre o Gerente!");
					telaCadastroGerente.registrarGerente(opcaoMenuJTextField, frameMenuGerente, repositorioGerente);
				break;
				
				case "2":
					System.out.println("Liste o Gerente!");
					telaListarGerente.apresentarLista(repositorioGerente, frameMenuGerente);
				break;

				case "3":
					telaBuscarGerenteEditar.buscarGerente(frameMenuGerente, repositorioGerente);
					System.out.println("Altere um Funcionário!");
				break;

				case "4":
					telaDeletarGerente.deletarGerente(frameMenuGerente, repositorioGerente); 
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
