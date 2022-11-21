public class Aluno extends Pessoa{

	public String turma;
	public String advertencia;
	
	public Aluno (String _cpf, String _nome, String _turma, String _advertencia) {
		super(_cpf, _nome);
		this.turma = _turma;
		this.advertencia = _advertencia; 
		
	}




}