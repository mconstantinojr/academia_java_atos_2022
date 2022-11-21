public class Professor extends Pessoa{

	public String disciplina;
	private int salario;
	
	public Professor (String _cpf, String _nome, String _disciplina) {
		super(_cpf, _nome);
		this.disciplina = _disciplina;
	}

	public Integer getSalario(){
		return salario;
	}

	public void setSalario(int salarioChegando){
		this.salario = salarioChegando;
	}



}