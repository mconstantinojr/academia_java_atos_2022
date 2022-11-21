package br.atos.cadastro_animais_zoo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.atos.cadastro_animais_zoo.Model.Cuidador;
import br.atos.cadastro_animais_zoo.repository.CuidadorRepository;


@Controller
public class CuidadorController {

	@Autowired
	CuidadorRepository cuidadorRepository;
	
	@RequestMapping(value = "/cadastrarCuidador", method=RequestMethod.GET)
	public String cadastroCuidador() {
		
		return "cadastroCuidadorHtml";
	}
	
	@RequestMapping(value = "/cadastrarCuidador", method=RequestMethod.POST)
	public String cadastroCuidador(Cuidador cuidador) {
		Integer maxId = cuidadorRepository.maxIdConsumidor();
		maxId++;
		cuidador.atribuirMatricula(maxId);
		cuidadorRepository.save(cuidador);
		return "redirect:/cuidadoresTabela";
	}
		
	@RequestMapping("/cuidadoresTabela")
	public ModelAndView listarCuidadores() {
		ModelAndView cuidadorModelAndView = new ModelAndView("listarCuidadoresHtml"); 
		Iterable<Cuidador> cuidadores= cuidadorRepository.findAll(); 
		cuidadorModelAndView.addObject("cuidadores", cuidadores);
			
			
		return cuidadorModelAndView;
			
	}
		
	@RequestMapping(value = "/deletarCuidador/{id}", method = RequestMethod.GET)
	public String deletarCuidadorMetodo(@PathVariable ("id") long idReq) {
		Cuidador cuidador = cuidadorRepository.findById(idReq);
		cuidadorRepository.delete(cuidador);
			
		return "redirect:/cuidadoresTabela";
	}
		
	@RequestMapping(value = "/editarCuidador/{id}", method = RequestMethod.GET)
	public ModelAndView editarCuidadorMetodo(@PathVariable ("id") long idReq) {
		Cuidador cuidadores = cuidadorRepository.findById(idReq);
					
		ModelAndView cuidadorModelAndView = new ModelAndView("editarCuidador");
		cuidadorModelAndView.addObject("cuidador", cuidadores);
			
		return cuidadorModelAndView;
	}
		
	@PostMapping(value = "/editar")
	public String atualizarCuidador(Cuidador cuidador) {
		long id = cuidador.getIdCuidador();
		cuidadorRepository.save(cuidador);
			
		return "redirect:/cuidadoresTabela";
			
	}
		
}
