package br.atos.telas.controletelas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import br.atos.model.Funcionario;
import br.atos.repositorio.RepositorioFuncionario;

public class TelaAlterarControle implements ActionListener {
	
	JFrame frameTelaAlterarFuncionario;
	JFrame frameMenuInicial;
	
	JTextField idParaAlterarJTextField;
	JTextField nomeParaAlterarJTextField;
	JTextField cpfParaAlterarJTextField;
	JTextField cargoParaAlterarJTextField;
	
	RepositorioFuncionario repositorioFuncionario;
	Funcionario funcionarioAtual;
	
	boolean validarAlterar = false;

	public TelaAlterarControle(JFrame frameTelaAlterarFuncionario, JFrame frameMenuInicial, 
			JTextField idParaAlterarJTextField, JTextField nomeParaAlterarJTextField, 
			JTextField cpfParaAlterarJTextField, JTextField cargoParaAlterarJTextField, RepositorioFuncionario repositorioFuncionario,
			Funcionario funcionarioAtual) {
		super();
		this.frameTelaAlterarFuncionario = frameTelaAlterarFuncionario;
		this.frameMenuInicial = frameMenuInicial;
		this.idParaAlterarJTextField = idParaAlterarJTextField;
		this.nomeParaAlterarJTextField = nomeParaAlterarJTextField;
		this.cpfParaAlterarJTextField = cpfParaAlterarJTextField;
		this.cargoParaAlterarJTextField = cargoParaAlterarJTextField;
		this.repositorioFuncionario = repositorioFuncionario;
		this.funcionarioAtual = funcionarioAtual;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(e.getActionCommand());
		if (e.getActionCommand().equals("Voltar")) {
			frameMenuInicial.setVisible(true);
			frameTelaAlterarFuncionario.setVisible(false);
		} else if (e.getActionCommand().equals("Alterar")) {
			acionarAlterar();
			frameMenuInicial.setVisible(true);
			frameTelaAlterarFuncionario.setVisible(false);
		}
	}
	
	private void acionarAlterar() {
		Funcionario funcionarioParaAlterar = new Funcionario();
		funcionarioParaAlterar.setId(idParaAlterarJTextField.getText());
		funcionarioParaAlterar.setNome(nomeParaAlterarJTextField.getText());
		funcionarioParaAlterar.setCpf(cpfParaAlterarJTextField.getText());
		funcionarioParaAlterar.setCargo(cargoParaAlterarJTextField.getText());
		validarAlterar = repositorioFuncionario.alterarFuncionario(funcionarioAtual, funcionarioParaAlterar);
		if (validarAlterar) {
			JOptionPane.showMessageDialog(null, "Funcionario alterado com Sucesso");
		}else {
			JOptionPane.showMessageDialog(null, "Funcionario não alterado");
		}
	}
	
	
}
