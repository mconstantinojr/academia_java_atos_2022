package br.atos.cadastro_animais_zoo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.atos.cadastro_animais_zoo.Model.Animal;
import br.atos.cadastro_animais_zoo.Model.Jaula;
import br.atos.cadastro_animais_zoo.repository.AnimalRepository;
import br.atos.cadastro_animais_zoo.repository.JaulaRepository;


@Controller
public class AnimalController {

	@Autowired
	JaulaRepository jaulaRepository;
	
	@Autowired
	AnimalRepository animalRepository;

	@RequestMapping(value = "/cadastrarAnimal", method=RequestMethod.GET)
	public ModelAndView cadastroAnimal() {
		
		ModelAndView animalModelAndView = new ModelAndView("cadastroAnimalHtml"); 
		Iterable<Jaula> jaulas = jaulaRepository.findAll(); 
		animalModelAndView.addObject("jaulas", jaulas);
		
		return animalModelAndView;
	}
	
	@RequestMapping(value = "/cadastrarAnimal", method=RequestMethod.POST)
	public String cadastroAnimal(Animal animal) {
		animalRepository.save(animal);
		return "redirect:/animaisTabela";
	}
	
	@RequestMapping("/index")
	public String index() {
		return "index";
	}
	
	@RequestMapping("/animaisTabela")
	public ModelAndView listarAnimais() {
		ModelAndView animalModelAndView = new ModelAndView("listarAnimaisHtml"); 
		Iterable<Animal> animais= animalRepository.findAll(); 
		animalModelAndView.addObject("animais", animais);
			
			
		return animalModelAndView;
			
	}
	
	@RequestMapping(value = "/deletarAnimal/{id}", method = RequestMethod.GET)
	public String deletarAnimalMetodo(@PathVariable ("id") long idReq) {
		Animal animal = animalRepository.findById(idReq);
		animalRepository.delete(animal);
			
		return "redirect:/animaisTabela";
	}
		
	@RequestMapping(value = "/editarAnimal/{id}", method = RequestMethod.GET)
	public ModelAndView editarAnimalMetodo(@PathVariable ("id") long idReq) {
		Animal animal = animalRepository.findById(idReq);
			
		ModelAndView animalModelAndView = new ModelAndView("editarAnimal");
		animalModelAndView.addObject("animal", animal);
		animalModelAndView.addObject("jaula", animal.getJaula());
			
		return animalModelAndView;
	}
		
	@PostMapping(value = "/editarAnimal")
	public String atualizarAnimal(Animal animal) {
		long id = animal.getIdAnimal();
		animalRepository.save(animal);
			
		return "redirect:/animaisTabela";
			
	}
}
