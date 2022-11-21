package br.atos.telas;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import br.atos.model.Coordenador;
import br.atos.model.Gerente;
import br.atos.repositorio.RepositorioCoordenador;
import br.atos.repositorio.RepositorioGerente;
import br.atos.telas.controletelas.TelaAlterarCoordenadorControle;
import br.atos.telas.controletelas.TelaAlterarGerenteControle;

public class TelaAlterarCoordenador {
	public void alterarCoordenador(JFrame frameMenuCoordenador, RepositorioCoordenador repositorioCoordenador, Coordenador coordenadorAtual) {
		
		
		// Strings que serão usadas na Label
		String nomeTexto = "Digite o nome do coordenador:";
		String cpfTexto = "Digite o CPF:";
		String salarioLiquidoTexto = "Digite o salario liquido:";
				
		String lojaTexto = "Digite a loja:";
		String metaLojaTexto = "Digite a meta loja:";
		String enderecoTexto = "Digite o endereco:";
				
				
		// Criação do Frame (Janela)
		JFrame frameTelaAlterarCoordenador = new JFrame();
		frameTelaAlterarCoordenador.setSize(200, 300);
		frameTelaAlterarCoordenador.setTitle("Inserir Coordenador");
		frameTelaAlterarCoordenador.setLocation(300,300);
				
		//Criação do painel
		JPanel painelTelaAlterarCoordenador = new JPanel();
				
		//Criação da Labels
		JLabel nomeTextoLabel = new JLabel(nomeTexto );
		painelTelaAlterarCoordenador.add(nomeTextoLabel);
				
		//Criação da Caixa de texto
		JTextField nomeTextField = new JTextField(10);
		nomeTextField.setText(coordenadorAtual.getNome()); // Adiciona na caixa de texto os valores do programador que será alterado
		painelTelaAlterarCoordenador.add(nomeTextField);
				
		JLabel cpfTextoLabel = new JLabel(cpfTexto);
		painelTelaAlterarCoordenador.add(cpfTextoLabel);
				
		JTextField cpfTextField = new JTextField(10);
		cpfTextField.setText(coordenadorAtual.getCpf());
		painelTelaAlterarCoordenador.add(cpfTextField);
				
		JLabel salarioLiquidoTextoLabel = new JLabel(salarioLiquidoTexto);
		painelTelaAlterarCoordenador.add(salarioLiquidoTextoLabel);
				
		JTextField salarioLiquidoTextField = new JTextField(10);
		salarioLiquidoTextField.setText(coordenadorAtual.getSalarioLiquido().toString());
		painelTelaAlterarCoordenador.add(salarioLiquidoTextField);
				
		JLabel lojaTextoLabel = new JLabel(lojaTexto);
		painelTelaAlterarCoordenador.add(lojaTextoLabel);
				
		JTextField lojaTextoField = new JTextField(10);
		lojaTextoField.setText(coordenadorAtual.getLoja());
		painelTelaAlterarCoordenador.add(lojaTextoField);
				
		JLabel metaLojaTextoLabel = new JLabel(metaLojaTexto);
		painelTelaAlterarCoordenador.add(metaLojaTextoLabel);
				
		JTextField metaLojaTextoField = new JTextField(10);
		metaLojaTextoField.setText(coordenadorAtual.getMetaLoja().toString());
		painelTelaAlterarCoordenador.add(metaLojaTextoField);
			
		JLabel enderecoTextoLabel = new JLabel(enderecoTexto);
		painelTelaAlterarCoordenador.add(enderecoTextoLabel);
				
		JTextField enderecoTextoField = new JTextField(10);
		enderecoTextoField.setText(coordenadorAtual.getEndereco().getEndereco());
		painelTelaAlterarCoordenador.add(enderecoTextoField);
		
		//Criação do botão
		JButton botaoAlterar = new JButton("Alterar");
		painelTelaAlterarCoordenador.add(botaoAlterar);

		JButton botaoVoltar = new JButton("Voltar");
		painelTelaAlterarCoordenador.add(botaoVoltar);

		// Adiciona o painel "dentro" do frame(janela)
		frameTelaAlterarCoordenador.add(painelTelaAlterarCoordenador);
				
		//Habilitar visibilidade do frame(janela)
		frameTelaAlterarCoordenador.setVisible(true);
				
		TelaAlterarCoordenadorControle alterarCoordenadorControle = new TelaAlterarCoordenadorControle(frameTelaAlterarCoordenador, frameMenuCoordenador, nomeTextField, cpfTextField, salarioLiquidoTextField, lojaTextoField, metaLojaTextoField, enderecoTextoField, repositorioCoordenador, coordenadorAtual);
		botaoAlterar.addActionListener(alterarCoordenadorControle);
		botaoVoltar.addActionListener(alterarCoordenadorControle);
	}
}
