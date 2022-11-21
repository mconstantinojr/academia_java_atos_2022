import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Inicio {
	
	public static void main(String args[]) {
		
		Usuario usuario = new Usuario();
		String nomeDigitado;
		String senhaDigitada;
		
		String opcaoMenu = null;
		String opcaoSubMenu = null;
		
		Scanner entradaDados = new Scanner(System.in); //objeto criado para receber dados atraves do console
			
		List<Gerente> gerentes = new ArrayList<>();
		List<Coordenador> coordenadores = new ArrayList<>();
		
		//System.out.println(usuario.getNome());
		//System.out.println(usuario.getSenha());
		
		System.out.println("Digite o Usuario:");
		nomeDigitado = entradaDados.next();
		System.out.println("Digite a sua Senha:");
		senhaDigitada = entradaDados.next();
		
		boolean continuar = true;
		
		//System.out.println(nomeDigitado);
		//System.out.println(senhaDigitada);
		
		if (nomeDigitado.equals(usuario.getNome()) && senhaDigitada.equals(usuario.getSenha())) {
			while(continuar) {
				System.out.println("Login realizado com sucesso!!!");
				System.out.println("Digite 1 para o menu GERENTE:");
				System.out.println("Digite 2 para o menu COORDENADOR:");
				System.out.println("Digite 3 para Encerrar:");
				opcaoMenu = entradaDados.next();
				
				if (opcaoMenu.equals("1") || opcaoMenu.equals("2") || opcaoMenu.equals("3")) {
					System.out.println("Opcao correta!!");
					
					switch(opcaoMenu) {
						case "1":
							Gerente gerente = new Gerente();
		
							//estou recebendo os dados atraves do console e armazenando no objeto gerente
							System.out.println("Digite o nome:");
							gerente.setNome(entradaDados.next());
							System.out.println("Digite o cpf:");
							gerente.setCpf(entradaDados.next());
							System.out.println("Digite a hora Trabalhada:");
							gerente.setSalarioLiquido(gerente.calcularSalario(Double.parseDouble(entradaDados.next())));
							System.out.println("Digite a regional:");
							gerente.setRegional(entradaDados.next());
							System.out.println("Digite o valor da meta regional:");
							gerente.setMetaRegional(Double.parseDouble(entradaDados.next()));
							
							gerentes.add(gerente);
							
							System.out.println("Digite 1 para cadastrar outro GERENTE:");
							System.out.println("Digite 2 para Listar os gerentes:");
							System.out.println("Digite 3 para Encerrar:");
				
							opcaoSubMenu = entradaDados.next();
							
							if(opcaoSubMenu.equals("1") || opcaoSubMenu.equals("2") || opcaoSubMenu.equals("3")) {
								switch(opcaoSubMenu){
									case "1":
										System.out.println("Cadastre Outro Gerente");
									break;
									case "2":
										System.out.println("Listar gerentes");
										for(Gerente gerenteItem:gerentes) {
											//Apresenta os dados no console
											System.out.println("Apresenta os dados do gerente no console!!");
											System.out.println("Nome do Gerente:" + gerenteItem.getNome());
											System.out.println("CPF do Gerente:" + gerenteItem.getCpf());
											System.out.println("Salario do Gerente:" + gerenteItem.getSalarioLiquido());
											System.out.println("Regional do Gerente:" + gerenteItem.getRegional());
											System.out.println("Meta da Regional:" + gerenteItem.getMetaRegional());
											System.out.println("########################3333");
										}
									break;
							
									case "3":
										continuar = false;
										System.out.println("Programa Encerrado");
									break;
							
								}
							}else{
								System.out.println("Opcao invalida!!!");
							}
							//Apresenta os dados no console
							/*System.out.println("Apresenta os dados do gerente no console!!");
							System.out.println("Nome do Gerente:" + gerente.getNome());
							System.out.println("CPF do Gerente:" + gerente.getCpf());
							System.out.println("Salario do Gerente:" + gerente.getSalarioLiquido());
							System.out.println("Regional do Gerente:" + gerente.getRegional());
							System.out.println("Meta da Regional:" + gerente.getMetaRegional());
							*/
							
						break;
							
						
						case "2":
						
							Coordenador coordenador = new Coordenador();
						
							//estou recebendo os dados atraves do console e armazenando no objeto coordenador
							System.out.println("Digite o nome:");
							coordenador.setNome(entradaDados.next());
							System.out.println("Digite o cpf:");
							coordenador.setCpf(entradaDados.next());
							System.out.println("Digite a hora Trabalhada:");
							coordenador.setSalarioLiquido(coordenador.calcularSalario(Double.parseDouble(entradaDados.next())));
							System.out.println("Digite a loja:");
							coordenador.setLoja(entradaDados.next());
							System.out.println("Digite o valor da meta loja:");
							coordenador.setMetaLoja(Double.parseDouble(entradaDados.next()));
							
							coordenadores.add(coordenador);
							
							System.out.println("Digite 1 para cadastrar outro COORDENADOR:");
							System.out.println("Digite 2 para Listar os coordenadores:");
							System.out.println("Digite 3 para Encerrar:");
				
							opcaoSubMenu = entradaDados.next();
							
							if(opcaoSubMenu.equals("1") || opcaoSubMenu.equals("2") || opcaoSubMenu.equals("3")) {
								switch(opcaoSubMenu){
									case "1":
										System.out.println("Cadastre Outro Coordenador");
									break;
									case "2":
										System.out.println("Listar coordenadores");
										for(Coordenador coordenadorItem:coordenadores) {
											//Apresenta os dados no console
											System.out.println("Apresenta os dados do coordenador no console!!");
											System.out.println("Nome do Coordenador:" + coordenadorItem.getNome());
											System.out.println("CPF do Coordenador:" + coordenadorItem.getCpf());
											System.out.println("Salario do Coordenador:" + coordenadorItem.getSalarioLiquido());
											System.out.println("Loja do Coordenador:" + coordenadorItem.getLoja());
											System.out.println("Meta da loja:" + coordenadorItem.getMetaLoja());
											System.out.println("########################3333");
										}
									break;
							
									case "3":
										continuar = false;
										System.out.println("Programa Encerrado");
									break;
							
								}
							}else{
								System.out.println("Opcao invalida!!!");
							}
						
							//Apresenta os dados no console
							/*System.out.println("Apresenta os dados do coordenador no console!!");
							System.out.println("Nome do Coordenador:" + coordenador.getNome());
							System.out.println("CPF do Coordenador:" + coordenador.getCpf());
							System.out.println("Salario do Coordenador:" + coordenador.getSalarioLiquido());
							System.out.println("Loja do Coordenador:" + coordenador.getLoja());
							System.out.println("Meta da loja:" + coordenador.getMetaLoja());*/
						
						
						break;
						
						case "3":
							continuar = false;
							System.out.println("Programa Encerrado");
						
						break;
					}
				} else {
					System.out.println("Opcao incorreta!!");
				}

			}
			
		} else {
			//System.out.println("Login Incorreto!!!");
			if (nomeDigitado.equals(usuario.getNome()) || senhaDigitada.equals(usuario.getSenha())) {
					if (nomeDigitado.equals(usuario.getNome())) {
						System.out.println("Nome esta correto mas a senha esta incorreta!!");
					}

					if (senhaDigitada.equals(usuario.getSenha())) {
						System.out.println("Senha esta correta mas o nome esta incorreto!!");
					}	
			} else {
				System.out.println("Nome e Senha incorretos!!!");
			}
		}
	}
}	
	
	