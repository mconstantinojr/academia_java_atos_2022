package br.impacta.telas;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import br.impacta.model.Programador;
import br.impacta.repositorio.RepositorioProgramador;
import br.impacta.telas.controleTelas.TelaDeletarControle;

public class TelaDeletar {
	
	public void deletarProgramador(JFrame menuInicialFrame, RepositorioProgramador repositorioProgramador) {
		int quantidadeDeLinhas = repositorioProgramador.listarProgramador().size();
		
		String stringTextoDeletar = "Digite o cpf que deseja deletar:";
		
		String [][] tabelaString = new String [quantidadeDeLinhas][3];
		
		int posicaoLinha = 0;
		int posicaoColuna = 0;
		for (Programador programador: repositorioProgramador.listarProgramador()) {
			
			tabelaString [posicaoLinha][posicaoColuna] = programador.getNome();
			posicaoColuna++;
			
			tabelaString [posicaoLinha][posicaoColuna] = programador.getCpf();
			posicaoColuna++;
			
			tabelaString [posicaoLinha][posicaoColuna] = programador.getEstado();
			posicaoColuna = 0;
			posicaoLinha++;
		}
		
		String colunasTitulos[] = {"Nome", "Cpf", "Estado"};
		JFrame frameListarProgramador = new JFrame();
		frameListarProgramador.setSize(500, 600);
		
		JTable tabelaProgramador = new JTable(tabelaString, colunasTitulos);
		tabelaProgramador.setBounds(30, 40, 200, 300);
		
		JPanel panelListarProgramador = new JPanel();
		
		JLabel stringTextoDeletarLabel = new JLabel(stringTextoDeletar);
		panelListarProgramador.add(stringTextoDeletarLabel);
		
		JTextField opcaoCpfJTextField = new JTextField(10);
		panelListarProgramador.add(opcaoCpfJTextField);
		
		JButton botaoDeletar = new JButton("Deletar");
		panelListarProgramador.add(botaoDeletar);
		
		JScrollPane scrollPaneTabela = new JScrollPane(tabelaProgramador);
		
		
		panelListarProgramador.add(scrollPaneTabela);
		
		frameListarProgramador.add(panelListarProgramador);
		frameListarProgramador.setVisible(true);
		
		TelaDeletarControle telaDeletarControle = new TelaDeletarControle(frameListarProgramador, menuInicialFrame, opcaoCpfJTextField, repositorioProgramador);
		botaoDeletar.addActionListener(telaDeletarControle);
		
	}
}
