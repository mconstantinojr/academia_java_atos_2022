package br.atos.telas.controletelas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import br.atos.model.Endereco;
import br.atos.model.Funcionario;
import br.atos.model.Gerente;
import br.atos.repositorio.RepositorioFuncionario;
import br.atos.repositorio.RepositorioGerente;
import br.atos.telas.validacao.ValidarGerente;


public class TelaAlterarGerenteControle implements ActionListener {
	
	JFrame frameTelaAlterarGerente;
	JFrame frameMenuGerente;
	JTextField nomeTextField;
	JTextField cpfTextField;
	JTextField salarioLiquidoTextField;
	
	JTextField regionalTextField;
	JTextField metaRegionalTextField;
	JTextField enderecoTextField;
	
	RepositorioGerente repositorioGerente;
	Gerente gerenteAtual;
	
	ValidarGerente validaGerente = new ValidarGerente();
	String msgErro = null;
	
	boolean validaAlterar;
	
	public TelaAlterarGerenteControle(JFrame frameTelaAlterarGerente, 
			JFrame frameMenuGerente, JTextField nomeTextField,
			JTextField cpfTextField, JTextField salarioLiquidoTextField, 
			JTextField regionalTextField, JTextField metaRegionalTextField, 
			JTextField enderecoTextField,
			RepositorioGerente repositorioGerente,
			Gerente gerenteAtual) {
		super();
		this.frameTelaAlterarGerente = frameTelaAlterarGerente;
		this.frameMenuGerente = frameMenuGerente;
		this.nomeTextField = nomeTextField;
		this.cpfTextField = cpfTextField;
		this.salarioLiquidoTextField = salarioLiquidoTextField;
		this.repositorioGerente = repositorioGerente;
		this.gerenteAtual = gerenteAtual;
		this.regionalTextField = regionalTextField;
		this.metaRegionalTextField = metaRegionalTextField;
		this.enderecoTextField = enderecoTextField;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Voltar")) {
			frameMenuGerente.setVisible(true);
			frameTelaAlterarGerente.setVisible(false);
		} else {
			if (acionarAlterar()) {
				frameMenuGerente.setVisible(true);
				frameTelaAlterarGerente.setVisible(false);
				
			}
		}
		
		
	}

	private boolean acionarAlterar() {
		Endereco endereco = new Endereco();
		endereco.setEndereco(enderecoTextField.getText());
		
		Gerente gerenteNovo = new Gerente();
	
		gerenteNovo.setNome(nomeTextField.getText());
		gerenteNovo.setCpf(cpfTextField.getText());
		gerenteNovo.setSalarioLiquido(gerenteNovo.calcularSalario(Double.parseDouble(salarioLiquidoTextField.getText())));
		gerenteNovo.setRegional(regionalTextField.getText());
		gerenteNovo.setMetaRegional(Double.parseDouble(metaRegionalTextField.getText()));
		gerenteNovo.setEndereco(endereco);
	
		msgErro = validaGerente.validarGerente(gerenteNovo, repositorioGerente, "Alterar");
		
		if (msgErro == null) {
			validaAlterar = repositorioGerente.alterarGerente(gerenteAtual, gerenteNovo);
			
			
			if(validaAlterar) {
				JOptionPane.showMessageDialog(null,gerenteNovo.getNome() + "Foi Alterado!!");
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
