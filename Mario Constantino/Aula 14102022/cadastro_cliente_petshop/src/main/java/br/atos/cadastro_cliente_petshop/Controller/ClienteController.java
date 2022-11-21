package br.atos.cadastro_cliente_petshop.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.atos.cadastro_cliente_petshop.model.Cliente;
import br.atos.cadastro_cliente_petshop.model.Endereco;
import br.atos.cadastro_cliente_petshop.model.Pet;
import br.atos.cadastro_cliente_petshop.repository.ClienteRepository;
import br.atos.cadastro_cliente_petshop.repository.PetRepository;


@Controller
public class ClienteController {

	@Autowired
	ClienteRepository clienteRepository;
	
	@Autowired
	PetRepository petRepository;
	
	@RequestMapping(value = "/cadastrarCliente", method=RequestMethod.GET)
	public String cadastroCliente() {
		
		return "cadastroClienteHtml";
	}
	
	@RequestMapping(value = "/cadastrarCliente", method=RequestMethod.POST)
	public String cadastroCliente(Cliente cliente) {
		clienteRepository.save(cliente);
		return "redirect:/clientesTabela";
	}
		
	@RequestMapping("/clientesTabela")
	public ModelAndView listarClientes() {
		ModelAndView clienteModelAndView = new ModelAndView("listarClientesHtml"); 
		Iterable<Cliente> clientes= clienteRepository.findAll(); 
		clienteModelAndView.addObject("clientes", clientes);
			
			
		return clienteModelAndView;
			
	}
		
	@RequestMapping(value = "/deletarCliente/{id}", method = RequestMethod.GET)
	public String deletarClienteMetodo(@PathVariable ("id") long idReq) {
		Cliente cliente = clienteRepository.findById(idReq);
		clienteRepository.delete(cliente);
			
		return "redirect:/clientesTabela";
	}
		
	@RequestMapping(value = "/editarCliente/{id}", method = RequestMethod.GET)
	public ModelAndView editarClienteMetodo(@PathVariable ("id") long idReq) {
		Cliente cliente = clienteRepository.findById(idReq);
		if (cliente.getEndereco() == null) {
			cliente.setEndereco(new Endereco());
		}
			
		ModelAndView clienteAndView = new ModelAndView("editarCliente");
		clienteAndView.addObject("cliente", cliente);
			
		return clienteAndView;
	}
		
	@PostMapping(value = "/editar")
	public String atualizarCliente(Cliente cliente) {
		long id = cliente.getId();
		clienteRepository.save(cliente);
			
		return "redirect:/clientesTabela";
			
	}
		
	@RequestMapping(value = "/adicionarPet/{id}", method = RequestMethod.GET)
	public ModelAndView adicionatPetMetodo(@PathVariable("id") long idReq) {
		Cliente cliente = clienteRepository.findById(idReq);
		ModelAndView clienteAndView = new ModelAndView("adicionarPet");
		clienteAndView.addObject("cliente", cliente);
			
		Iterable<Pet> pets = petRepository.findByCliente(cliente);
		clienteAndView.addObject("pets", pets);
			
		return clienteAndView;
			
	}
		
	@RequestMapping(value = "/adicionarPet/{id}", method = RequestMethod.POST)
	public String adicionaPet(@PathVariable("id") long idReq, Pet pet) {
			
		Cliente cliente = clienteRepository.findById(idReq);
		pet.setCliente(cliente);
		petRepository.save(pet);
			
		return "redirect:/adicionarPet/{id}";
			
	}
		
}
