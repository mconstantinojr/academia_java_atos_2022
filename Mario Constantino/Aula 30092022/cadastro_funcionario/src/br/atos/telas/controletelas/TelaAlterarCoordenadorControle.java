package br.atos.telas.controletelas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import br.atos.model.Endereco;
import br.atos.model.Funcionario;
import br.atos.model.Coordenador;
import br.atos.repositorio.RepositorioFuncionario;
import br.atos.repositorio.RepositorioCoordenador;
import br.atos.telas.validacao.ValidarCoordenador;


public class TelaAlterarCoordenadorControle implements ActionListener {
	
	JFrame frameTelaAlterarCoordenador;
	JFrame frameMenuCoordenador;
	JTextField nomeTextField;
	JTextField cpfTextField;
	JTextField salarioLiquidoTextField;
	
	JTextField lojaTextField;
	JTextField metaLojaTextField;
	JTextField enderecoTextField;
	
	RepositorioCoordenador repositorioCoordenador;
	Coordenador coordenadoorAtual;
	
	ValidarCoordenador validaCoordenador = new ValidarCoordenador();
	String msgErro = null;
	
	boolean validaAlterar;
	
	public TelaAlterarCoordenadorControle(JFrame frameTelaAlterarCoordenador, 
			JFrame frameMenuCoordenador, JTextField nomeTextField,
			JTextField cpfTextField, JTextField salarioLiquidoTextField, 
			JTextField lojaTextField, JTextField metaLojaTextField, 
			JTextField enderecoTextField,
			RepositorioCoordenador repositorioCoordenador,
			Coordenador coordenadoorAtual) {
		super();
		this.frameTelaAlterarCoordenador = frameTelaAlterarCoordenador;
		this.frameMenuCoordenador = frameMenuCoordenador;
		this.nomeTextField = nomeTextField;
		this.cpfTextField = cpfTextField;
		this.salarioLiquidoTextField = salarioLiquidoTextField;
		this.repositorioCoordenador = repositorioCoordenador;
		this.coordenadoorAtual = coordenadoorAtual;
		this.lojaTextField = lojaTextField;
		this.metaLojaTextField = metaLojaTextField;
		this.enderecoTextField = enderecoTextField;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Voltar")) {
			frameMenuCoordenador.setVisible(true);
			frameTelaAlterarCoordenador.setVisible(false);
		} else {
			if (acionarAlterar()) {
				frameMenuCoordenador.setVisible(true);
				frameTelaAlterarCoordenador.setVisible(false);
				
			}
		}
		
		
	}

	private boolean acionarAlterar() {
		Endereco endereco = new Endereco();
		endereco.setEndereco(enderecoTextField.getText());
		
		Coordenador coordenadoorNovo = new Coordenador();
	
		coordenadoorNovo.setNome(nomeTextField.getText());
		coordenadoorNovo.setCpf(cpfTextField.getText());
		coordenadoorNovo.setSalarioLiquido(coordenadoorNovo.calcularSalario(Double.parseDouble(salarioLiquidoTextField.getText())));
		coordenadoorNovo.setLoja(lojaTextField.getText());
		coordenadoorNovo.setMetaLoja(Double.parseDouble(metaLojaTextField.getText()));
		coordenadoorNovo.setEndereco(endereco);
	
		msgErro = validaCoordenador.validarCoordenador(coordenadoorNovo, repositorioCoordenador, "Alterar");
		
		if (msgErro == null) {
			validaAlterar = repositorioCoordenador.alterarCoordenador(coordenadoorAtual, coordenadoorNovo);
			
			
			if(validaAlterar) {
				JOptionPane.showMessageDialog(null,coordenadoorNovo.getNome() + "Foi Alterado!!");
				return true;
			}else {
				JOptionPane.showMessageDialog(null,"Erro na Alteração!!");
			}
			
		}  else {
			JOptionPane.showMessageDialog(null, msgErro);
		}
		
		return false;
	
	}
	
	
	
}
