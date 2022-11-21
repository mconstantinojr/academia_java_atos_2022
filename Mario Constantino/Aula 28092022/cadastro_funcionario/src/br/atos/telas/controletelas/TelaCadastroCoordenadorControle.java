package br.atos.telas.controletelas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import br.atos.model.Coordenador;
import br.atos.model.Endereco;
import br.atos.repositorio.RepositorioCoordenador;
import br.atos.telas.validacao.ValidarCoordenador;


public class TelaCadastroCoordenadorControle implements ActionListener {
	
	JFrame frameTelaCadastroCoordenador;
	JFrame frameMenuCoordenador;
	
	JTextField nomeTextField;
	JTextField cpfTextField;
	JTextField salarioLiquidoTextField;
	JTextField lojaTextField;
	JTextField metaTextField;
	JTextField enderecoTextField;
	
	RepositorioCoordenador repositorioCoordenador;
	
	boolean validarSalvar = false;
	
	ValidarCoordenador validaCoordenador = new ValidarCoordenador();
	String msgErro = null;

	public TelaCadastroCoordenadorControle(JFrame frameTelaCadastroCoordenador, JFrame frameMenuCoordenador, JTextField nomeTextField,
			JTextField cpfTextField, JTextField salarioLiquidoTextField, JTextField lojaTextField, JTextField metaTextField, JTextField enderecoTextField, RepositorioCoordenador repositorioCoordenador) {
		super();
		this.frameTelaCadastroCoordenador = frameTelaCadastroCoordenador;
		this.frameMenuCoordenador = frameMenuCoordenador;
		this.nomeTextField = nomeTextField;
		this.cpfTextField = cpfTextField;
		this.salarioLiquidoTextField = salarioLiquidoTextField;
		this.lojaTextField = lojaTextField;
		this.metaTextField = metaTextField;
		this.enderecoTextField = enderecoTextField;
		this.repositorioCoordenador = repositorioCoordenador;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Voltar")) {
			frameMenuCoordenador.setVisible(true);
			frameTelaCadastroCoordenador.setVisible(false);
		} else {
			if (acionarSalvar()) {
				frameMenuCoordenador.setVisible(true);
				frameTelaCadastroCoordenador.setVisible(false);
			}
		}
	}
	
	private boolean acionarSalvar() {
		Endereco endereco = new Endereco();
		endereco.setEndereco(enderecoTextField.getText());
		
		Coordenador coordenador = new Coordenador();
		coordenador.setNome(nomeTextField.getText());
		coordenador.setCpf(cpfTextField.getText());
		coordenador.setSalarioLiquido(coordenador.calcularSalario(Double.parseDouble(salarioLiquidoTextField.getText())));
		coordenador.setLoja(lojaTextField.getText());
		coordenador.setMetaLoja(Double.parseDouble(metaTextField.getText()));
		coordenador.setEndereco(endereco);
		
		msgErro = validaCoordenador.validarCoordenador(coordenador, repositorioCoordenador, "Cadastrar");
		
		if (msgErro == null) {
			validarSalvar = repositorioCoordenador.salvarCoordenador(coordenador);
			if (validarSalvar) {
				JOptionPane.showMessageDialog(null, coordenador.getNome() + " Foi Registrado com sucesso!");
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
