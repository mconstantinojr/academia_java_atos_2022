package br.atos.telas.controletelas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTextField;

import br.atos.model.Funcionario;
import br.atos.repositorio.RepositorioFuncionario;
import br.atos.telas.AlterarFuncionario;

public class BuscarFuncionarioController implements ActionListener {
	JFrame frameListaFuncionario;
	JFrame frameMenuInicial;
	JTextField idField;
	
	RepositorioFuncionario repositorioFuncionario;
	
	AlterarFuncionario telaAlterar = new AlterarFuncionario();
	
	public BuscarFuncionarioController(JFrame frameListaFuncionario, JFrame frameMenuInicial, JTextField idField,
			RepositorioFuncionario repositorioFuncionario) {
		super();
		this.frameListaFuncionario = frameListaFuncionario;
		this.frameMenuInicial = frameMenuInicial;
		this.idField = idField;
		this.repositorioFuncionario = repositorioFuncionario;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Alterar")) {
			Funcionario funcionarioAtual = new Funcionario();
			
			funcionarioAtual = repositorioFuncionario.buscarFuncionario(idField.getText());
			
			if (!(funcionarioAtual == null)) {
				frameListaFuncionario.setVisible(false);
				telaAlterar.alterarFuncionario(frameMenuInicial, repositorioFuncionario, funcionarioAtual);
			}
			
		} else if (e.getActionCommand().equals("Voltar")) {
			frameListaFuncionario.setVisible(false);
			frameMenuInicial.setVisible(true);
		}
		
	}

}
