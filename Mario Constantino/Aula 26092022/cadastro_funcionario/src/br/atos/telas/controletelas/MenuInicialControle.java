package br.atos.telas.controletelas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTextField;

import br.atos.repositorio.RepositorioFuncionario;
import br.atos.telas.AlterarFuncionario;
import br.atos.telas.BuscarFuncionarioEditar;
import br.atos.telas.ExcluirFuncionario;
import br.atos.telas.ListarFuncionario;
import br.atos.telas.TelaRegistro;

public class MenuInicialControle implements ActionListener {

	JTextField opcaoMenuJTextField;
	JFrame frameMenuInicial;
	
	TelaRegistro telaRegistro = new TelaRegistro();
	
	ListarFuncionario listarFuncionario = new ListarFuncionario();
	
	ExcluirFuncionario excluirFuncionario = new ExcluirFuncionario();
	
	AlterarFuncionario alterarFuncionario = new AlterarFuncionario();
	
	BuscarFuncionarioEditar buscarFuncionarioEditar = new BuscarFuncionarioEditar();
	
	RepositorioFuncionario repositorioFuncionario = new RepositorioFuncionario();
	
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
				System.out.println("Cadastre o Funcionario!");
				telaRegistro.registrarProgramador(opcaoMenuJTextField, frameMenuInicial, repositorioFuncionario);
			break;
			
			case "2":
				listarFuncionario.apresentarLista(repositorioFuncionario.listarFuncionario(), frameMenuInicial);
				System.out.println("Liste o Funcionario!");
			break;

			case "3":
				buscarFuncionarioEditar.buscarFuncionarioEditar(repositorioFuncionario, frameMenuInicial);
				System.out.println("Altere um Funcionário!");
			break;

			case "4":
				excluirFuncionario.apresentarLista(repositorioFuncionario.listarFuncionario(), frameMenuInicial, repositorioFuncionario);
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
