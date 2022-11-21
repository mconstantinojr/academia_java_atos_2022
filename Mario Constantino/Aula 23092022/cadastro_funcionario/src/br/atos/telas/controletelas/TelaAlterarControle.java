package br.atos.telas.controletelas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import br.atos.model.Funcionario;
import br.atos.repositorio.RepositorioFuncionario;

public class TelaAlterarControle implements ActionListener {
	
	JFrame frameExcluirFuncionario;
	JFrame frameMenuInicial;
	
	JTextField idParaAlterarJTextField;
	JTextField nomeParaAlterarJTextField;
	JTextField cpfParaAlterarJTextField;
	JTextField cargoParaAlterarJTextField;
	
	RepositorioFuncionario repositorioFuncionario;
	
	boolean validarAlterar = false;

	public TelaAlterarControle(JFrame frameExcluirFuncionario, JFrame frameMenuInicial, 
			JTextField idParaAlterarJTextField, JTextField nomeParaAlterarJTextField, 
			JTextField cpfParaAlterarJTextField, JTextField cargoParaAlterarJTextField, RepositorioFuncionario repositorioFuncionario) {
		super();
		this.frameExcluirFuncionario = frameExcluirFuncionario;
		this.frameMenuInicial = frameMenuInicial;
		this.idParaAlterarJTextField = idParaAlterarJTextField;
		this.nomeParaAlterarJTextField = nomeParaAlterarJTextField;
		this.cpfParaAlterarJTextField = cpfParaAlterarJTextField;
		this.cargoParaAlterarJTextField = cargoParaAlterarJTextField;
		this.repositorioFuncionario = repositorioFuncionario;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("Alteracao Realizada");
		acionarAlterar();
		frameMenuInicial.setVisible(true);
		frameExcluirFuncionario.setVisible(false);
	}
	
	private void acionarAlterar() {
		Funcionario funcionarioParaAlterar = new Funcionario();
		funcionarioParaAlterar.setId(idParaAlterarJTextField.getText());
		funcionarioParaAlterar.setNome(nomeParaAlterarJTextField.getText());
		funcionarioParaAlterar.setCpf(cpfParaAlterarJTextField.getText());
		funcionarioParaAlterar.setCargo(cargoParaAlterarJTextField.getText());
		validarAlterar = repositorioFuncionario.alterarFuncionario(funcionarioParaAlterar);
		if (validarAlterar) {
			System.out.println(idParaAlterarJTextField.getText() + "foi alterado com sucesso");
		}else {
			System.out.println("Erro durante a alteracao");
		}
	}
	
	
}
