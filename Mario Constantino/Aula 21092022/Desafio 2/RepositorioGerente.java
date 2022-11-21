import java.util.List;
import java.util.ArrayList;

public class RepositorioGerente implements GerenteInterface {
	
	private List<Gerente> listaGerente = new ArrayList<>();
	
	public boolean salvarGerente(Gerente gerente) {
		int idContador;
		idContador = listaGerente.size() + 1;
		String id = Integer.toString(idContador);
		gerente.setId(id);
		
		try {
			listaGerente.add(gerente);
		}catch(Exception e) {
			System.out.println("Erro no momento de salvar!!!");
			return false;
		}
		
		return true;
	}
	
	public List<Gerente> listarGerente() {
		return this.listaGerente;
	}
	
	public boolean deletarGerente(String id) {
		boolean resposta = false;
		
		Gerente gerenteRemover = new Gerente();
		
		System.out.println("antes do for");
		for(Gerente gerente : listaGerente) {
			System.out.println("dentro  do for e antes do if");
			System.out.println("id:"+id);
			System.out.println(gerente.getId());
			System.out.println(gerente.getNome());
			if (gerente.getId().equals(id)) {
				System.out.println("dentro  do for e dentrot do if");
				System.out.println("id:"+id);
				
				
				gerenteRemover = gerente;
				System.out.println(gerenteRemover.getId());
				System.out.println(gerenteRemover.getNome());
				
			}
		}	
			
		try{
			System.out.println("dentro  do try");
			listaGerente.remove(gerenteRemover);
			resposta = true;
		}catch(Exception e){	
			System.out.println("Cath: Erro no momento de excluir!!!");
		}
			
		return resposta;
		
	}
	
	public boolean alterarGerente(Gerente gerenteNovo) {
		boolean resposta = false;
		
		Gerente gerenteNovoTemp = new Gerente();
		Gerente gerenteAtualTemp = new Gerente();
		
		for(Gerente gerenteAtual : listaGerente) {
			if (gerenteAtual.getId().equals(gerenteNovo.getId())) {
				gerenteAtualTemp = gerenteAtual;
				gerenteNovoTemp = gerenteNovo;
				break;
			}
		}	
		
		try{
			listaGerente.remove(gerenteAtualTemp);
			listaGerente.add(gerenteNovoTemp);
			resposta = true;
		}catch(Exception e){	
			System.out.println("Cath: Erro no momento de alterar!!!");
		}
			
		
		
		return resposta;
	}
}