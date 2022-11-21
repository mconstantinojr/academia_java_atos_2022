import java.util.List;
import java.util.ArrayList;

public interface GerenteInterface {
	
	public boolean salvarGerente(Gerente gerente);
	public List<Gerente> listarGerente();
	public boolean deletarGerente(String id);
	public boolean alterarGerente(Gerente gerenteNovo);
}