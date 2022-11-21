public class MundoEscolar {

	public static void main(String [] args) {
		
		Professor p1 = new Professor("00000000000","Edson","Java");
		p1.setSalario(5000);
	
		System.out.println("#######PROFESSOR###########");
	
		System.out.println("CPF:" + p1.cpf);
		System.out.println("Nome:" + p1.nome);
		System.out.println("Disciplina:" + p1.disciplina);
		System.out.println("Salario:" + p1.getSalario());	
		
		Aluno a1 = new Aluno("11111111111","Joao","3B","contando piada na sala");
		
		System.out.println("#######ALUNO###########");
	
		System.out.println("CPF:" + a1.cpf);
		System.out.println("Nome:" + a1.nome);
		System.out.println("Turma:" + a1.turma);
		System.out.println("Advertencia:" + a1.advertencia);	
	}
}