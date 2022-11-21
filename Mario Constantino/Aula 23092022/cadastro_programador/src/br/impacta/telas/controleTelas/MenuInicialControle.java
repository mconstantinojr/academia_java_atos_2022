package br.impacta.telas.controleTelas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTextField;

import br.impacta.repositorio.RepositorioProgramador;
import br.impacta.telas.AlterarProgramador;
import br.impacta.telas.ListarProgramador;
import br.impacta.telas.TelaDeletar;
import br.impacta.telas.TelaRegistro;

public class MenuInicialControle implements ActionListener {

	JTextField opcaoMenuJTextField;
	JFrame frameMenuInicial;
	
	TelaRegistro telaRegistro = new TelaRegistro();
	
	ListarProgramador listarProgramador = new ListarProgramador();
	
	TelaDeletar telaDeletar = new TelaDeletar();
	
	AlterarProgramador alterarProgramador = new AlterarProgramador();
	
	RepositorioProgramador repositorioProgramador = new RepositorioProgramador();
	
	public MenuInicialControle() {
		
	}
	
	public MenuInicialControle(JTextField opcaoMenuJTextFieldCr, JFrame frameMenuInicialCr) {
		this.opcaoMenuJTextField = opcaoMenuJTextFieldCr;
		this.frameMenuInicial = frameMenuInicialCr;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (opcaoMenuJTextField.getText().equals("1") || opcaoMenuJTextField.getText().equals("2") || opcaoMenuJTextField.getText().equals("3") || opcaoMenuJTextField.getText().equals("4") || opcaoMenuJTextField.getText().equals("5")) {
			
			frameMenuInicial.setVisible(false);
			switch (opcaoMenuJTextField.getText()) { 
			case "1":
				System.out.println("Cadastre o Programador!");
				telaRegistro.registrarProgramador(opcaoMenuJTextField, frameMenuInicial, repositorioProgramador);
				break;
			
			case "2":
				listarProgramador.apresentarLista(repositorioProgramador.listarProgramador(), frameMenuInicial);
				System.out.println("Cadastre o Programador!");
				break;
			
			case "3":
				System.out.println("Cadastre o Programador!");
				break;
			
			case "4":
				telaDeletar.deletarProgramador(frameMenuInicial, repositorioProgramador);
				break;

			case "5":
				alterarProgramador.alterarProgramador(frameMenuInicial, repositorioProgramador);
				break;


			}	


		} else {
			System.out.println("Opcao Invalida");
		}
	}

}
