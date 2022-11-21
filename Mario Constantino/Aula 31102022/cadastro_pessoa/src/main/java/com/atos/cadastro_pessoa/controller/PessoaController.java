package com.atos.cadastro_pessoa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atos.cadastro_pessoa.repository.PessoaRepository;

import com.atos.cadastro_pessoa.model.Pessoa;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class PessoaController {
	
	@Autowired
	PessoaRepository pessoaRepository;
	
	@GetMapping("/pessoas")
	public List<Pessoa> listarPessoa() {
		
		return pessoaRepository.findAll();
	
	}
	
	@PostMapping("/cadastrarPessoa")
	public void cadastrarPessoa(@RequestBody Pessoa pessoa){
		
		pessoaRepository.save(pessoa);
	}
	
	@GetMapping(value = "/pessoa/{id}" )
	public Pessoa buscarPessoa(@PathVariable long id) {
		
		Pessoa pessoa = pessoaRepository.findById(id);
		
		return pessoa;
	}
	
	@DeleteMapping(value = "/pessoaDelete/{id}" )
	public void deletarPessoa(@PathVariable long id) {
		
		Pessoa pessoa = pessoaRepository.findById(id);
		pessoaRepository.delete(pessoa);
		
	}
	
	@PutMapping("/editarPessoa")
	public void editarPessoa(@RequestBody Pessoa pessoa){
		
		pessoaRepository.save(pessoa);
	}	
}
