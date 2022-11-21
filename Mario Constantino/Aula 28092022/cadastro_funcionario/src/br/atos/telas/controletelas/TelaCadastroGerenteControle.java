package br.atos.telas.controletelas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import br.atos.model.Endereco;
import br.atos.model.Gerente;
import br.atos.repositorio.RepositorioGerente;
import br.atos.telas.validacao.ValidarGerente;


public class TelaCadastroGerenteControle implements ActionListener {
	
	JFrame frameTelaCadastroGerente;
	JFrame frameMenuGerente;
	
	JTextField nomeTextField;
	JTextField cpfTextField;
	JTextField salarioLiquidoTextField;
	JTextField regionalTextField;
	JTextField metaTextField;
	JTextField enderecoTextField;
	
	RepositorioGerente repositorioGerente;
	
	boolean validarSalvar = false;
	
	ValidarGerente validaGerente = new ValidarGerente();
	String msgErro = null;

	public TelaCadastroGerenteControle(JFrame frameTelaCadastroGerente, JFrame frameMenuGerente, JTextField nomeTextField,
			JTextField cpfTextField, JTextField salarioLiquidoTextField, JTextField regionalTextField, JTextField metaTextField, JTextField enderecoTextField, RepositorioGerente repositorioGerente) {
		super();
		this.frameTelaCadastroGerente = frameTelaCadastroGerente;
		this.frameMenuGerente = frameMenuGerente;
		this.nomeTextField = nomeTextField;
		this.cpfTextField = cpfTextField;
		this.salarioLiquidoTextField = salarioLiquidoTextField;
		this.regionalTextField = regionalTextField;
		this.metaTextField = metaTextField;
		this.enderecoTextField = enderecoTextField;
		this.repositorioGerente = repositorioGerente;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Voltar")) {
			frameMenuGerente.setVisible(true);
			frameTelaCadastroGerente.setVisible(false);
		} else {
			if (acionarSalvar()) {
				frameMenuGerente.setVisible(true);
				frameTelaCadastroGerente.setVisible(false);
			}
		}
	}
	
	private boolean acionarSalvar() {
		Endereco endereco = new Endereco();
		endereco.setEndereco(enderecoTextField.getText());
		
		Gerente gerente = new Gerente();
		gerente.setNome(nomeTextField.getText());
		gerente.setCpf(cpfTextField.getText());
		gerente.setSalarioLiquido(gerente.calcularSalario(Double.parseDouble(salarioLiquidoTextField.getText())));
		gerente.setRegional(regionalTextField.getText());
		gerente.setMetaRegional(Double.parseDouble(metaTextField.getText()));
		gerente.setEndereco(endereco);
		
		msgErro = validaGerente.validarGerente(gerente, repositorioGerente, "Cadastrar");
		
		if (msgErro == null) {
			validarSalvar = repositorioGerente.salvarGerente(gerente);
			if (validarSalvar) {
				JOptionPane.showMessageDialog(null, gerente.getNome() + " Foi Registrado com sucesso!");
				return true;
			}else {
				System.out.println("Erro durante o cadastro");
				JOptionPane.showMessageDialog(null, "Erro ao Cadastrar");
			}
		} else {
			JOptionPane.showMessageDialog(null, msgErro);
		}
		
		return false;
	}
	
	
}
