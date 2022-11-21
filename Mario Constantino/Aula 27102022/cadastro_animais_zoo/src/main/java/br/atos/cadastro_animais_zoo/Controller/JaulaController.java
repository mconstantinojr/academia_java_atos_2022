package br.atos.cadastro_animais_zoo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.atos.cadastro_animais_zoo.Model.Cuidador;
import br.atos.cadastro_animais_zoo.Model.Jaula;
import br.atos.cadastro_animais_zoo.repository.CuidadorRepository;
import br.atos.cadastro_animais_zoo.repository.JaulaRepository;


@Controller
public class JaulaController {

	@Autowired
	JaulaRepository jaulaRepository;
	
	@Autowired
	CuidadorRepository cuidadorRepository;

	@RequestMapping(value = "/cadastrarJaula", method=RequestMethod.GET)
	public ModelAndView cadastroJaula() {
		
		ModelAndView cuidadorModelAndView = new ModelAndView("cadastroJaulaHtml"); 
		Iterable<Cuidador> cuidadores= cuidadorRepository.findAll(); 
		cuidadorModelAndView.addObject("cuidadores", cuidadores);
		
		return cuidadorModelAndView;
	}
	
	@RequestMapping(value = "/cadastrarJaula", method=RequestMethod.POST)
	public String cadastroJaula(Jaula jaula) {
		jaulaRepository.save(jaula);
		return "redirect:/jaulasTabela";
	}
	
	@RequestMapping("/jaulasTabela")
	public ModelAndView listarJaulas() {
		ModelAndView jaulaModelAndView = new ModelAndView("listarJaulasHtml"); 
		Iterable<Jaula> jaulas= jaulaRepository.findAll(); 
		jaulaModelAndView.addObject("jaulas", jaulas);
			
			
		return jaulaModelAndView;
			
	}
	
	@RequestMapping(value = "/deletarJaula/{id}", method = RequestMethod.GET)
	public String deletarJaulaMetodo(@PathVariable ("id") long idReq) {
		Jaula jaula = jaulaRepository.findById(idReq);
		jaulaRepository.delete(jaula);
			
		return "redirect:/jaulasTabela";
	}
		
	@RequestMapping(value = "/editarJaula/{id}", method = RequestMethod.GET)
	public ModelAndView editarJaulaMetodo(@PathVariable ("id") long idReq) {
		Jaula jaula = jaulaRepository.findById(idReq);
			
		ModelAndView jaulaModelAndView = new ModelAndView("editarJaula");
		jaulaModelAndView.addObject("jaula", jaula);
		jaulaModelAndView.addObject("cuidadores", jaula.getCuidadores());
			
		return jaulaModelAndView;
	}
		
	@PostMapping(value = "/editarJaula")
	public String atualizarJaula(Jaula jaula) {
		long id = jaula.getIdJaula();
		jaulaRepository.save(jaula);
			
		return "redirect:/jaulasTabela";
			
	}
	

}
