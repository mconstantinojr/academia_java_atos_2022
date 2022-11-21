package br.atos.telas.controletelas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import br.atos.model.Funcionario;
import br.atos.repositorio.RepositorioFuncionario;

public class TelaExcluirControle implements ActionListener {
	
	JFrame frameExcluirFuncionario;
	JFrame frameMenuInicial;
	
	JTextField idParaExcluirJTextField;
	
	RepositorioFuncionario repositorioFuncionario;
	
	boolean validarExcluir = false;

	public TelaExcluirControle(JFrame frameExcluirFuncionario, JFrame frameMenuInicial, 
			JTextField idParaExcluirJTextField, RepositorioFuncionario repositorioFuncionario) {
		super();
		this.frameExcluirFuncionario = frameExcluirFuncionario;
		this.frameMenuInicial = frameMenuInicial;
		this.idParaExcluirJTextField = idParaExcluirJTextField;
		this.repositorioFuncionario = repositorioFuncionario;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("Exclusao Realizada");
		acionarExcluir();
		frameMenuInicial.setVisible(true);
		frameExcluirFuncionario.setVisible(false);
	}
	
	private void acionarExcluir() {
		
		validarExcluir = repositorioFuncionario.deletarFuncionario(idParaExcluirJTextField.getText());
		if (validarExcluir) {
			System.out.println(idParaExcluirJTextField.getText() + "foi excluido com sucesso");
		}else {
			System.out.println("Erro durante o exclusao");
		}
	}
	
	
}
