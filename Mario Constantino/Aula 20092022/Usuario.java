public class Usuario {
	
	private String nome;
	private String senha;
	
	//Metodos de acesso das variaveis privadas
	public String getNome() {
		nome = "UsuarioAtos";
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	//Metodos de acesso das variaveis privadas
	public String getSenha() {
		senha = "Atos123";
		return senha;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
}