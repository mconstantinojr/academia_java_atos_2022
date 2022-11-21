package br.atos.telas.controletelas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import br.atos.model.Funcionario;
import br.atos.repositorio.RepositorioFuncionario;

public class TelaRegistroControle implements ActionListener {
	
	JFrame frameTelaRegistro;
	JFrame frameMenuInicial;
	
	JTextField nomeTextField;
	JTextField cpfTextField;
	JTextField cargoTextField;
	
	RepositorioFuncionario repositorioFuncionario;
	
	boolean validarSalvar = false;

	public TelaRegistroControle(JFrame frameTelaRegistro, JFrame frameMenuInicial, JTextField nomeTextField,
			JTextField cpfTextField, JTextField cargoTextField, RepositorioFuncionario repositorioFuncionario) {
		super();
		this.frameTelaRegistro = frameTelaRegistro;
		this.frameMenuInicial = frameMenuInicial;
		this.nomeTextField = nomeTextField;
		this.cpfTextField = cpfTextField;
		this.cargoTextField = cargoTextField;
		this.repositorioFuncionario = repositorioFuncionario;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("Cadastro Realizado");
		acionarSalvar();
		frameMenuInicial.setVisible(true);
		frameTelaRegistro.setVisible(false);
	}
	
	private void acionarSalvar() {
		Funcionario funcionario = new Funcionario();
		funcionario.setNome(nomeTextField.getText());
		funcionario.setCpf(cpfTextField.getText());
		funcionario.setCargo(cargoTextField.getText());
		
		validarSalvar = repositorioFuncionario.salvarFuncionario(funcionario);
		if (validarSalvar) {
			System.out.println(funcionario.getNome() + "foi registrado com sucesso");
		}else {
			System.out.println("Erro durante o cadastro");
		}
	}
	
	
}
