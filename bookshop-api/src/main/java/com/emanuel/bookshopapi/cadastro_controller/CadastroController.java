package com.emanuel.bookshopapi.cadastro_controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emanuel.bookshopapi.cadastro_model.CadastroLivro;
import com.emanuel.bookshopapi.cadastro_repository.CadastroRepository;
import com.emanuel.bookshopapi.exception.ResourceNotFoundException;




@RestController
@CrossOrigin(origins="*") //Caso queira dar autorização para alguma porta em específico, substituir o asterisco
@RequestMapping("/livros")
public class CadastroController {
	@Autowired
	private CadastroRepository cadastroRepository;
	
	@GetMapping("/cadastro")
	public List<CadastroLivro> getAllCadastros(){
		return cadastroRepository.findAll();
	}
	
	// cria cadastro
	@PostMapping("/cadastro")
	public CadastroLivro createCadastro(@Validated @RequestBody CadastroLivro cadastro) {
		return cadastroRepository.save(cadastro);		
	}
	
	//puxa cadastros pelo id
	@GetMapping("/cadastro/{id}")
	public ResponseEntity<CadastroLivro> getCadastroById(@PathVariable(value = "id") Long cadastroId)
			throws ResourceNotFoundException {
		CadastroLivro cadastro = cadastroRepository.findById(cadastroId)
				.orElseThrow(() -> new ResourceNotFoundException("Cadastro not found for this id :: " + cadastroId));
		return ResponseEntity.ok().body(cadastro);
	}
	
	//update 
	@PutMapping("/cadastro/{id}")
	public ResponseEntity<CadastroLivro> updateCadastro(@PathVariable(value = "id") Long cadastroId,
			@Validated @RequestBody CadastroLivro cadastroDetails) throws ResourceNotFoundException {
		CadastroLivro cadastro = cadastroRepository.findById(cadastroId)
				.orElseThrow(() -> new ResourceNotFoundException("Cadastro not found for this id :: " + cadastroId));
		
		cadastro.setCodLivro(cadastroDetails.getCodLivro());
		cadastro.setTitulo(cadastroDetails.getTitulo());
		cadastro.setAutor(cadastroDetails.getAutor());
		cadastro.setEditora(cadastroDetails.getEditora());
		cadastro.setAnoPub(cadastroDetails.getAnoPub());
		cadastro.setImgLivro(cadastroDetails.getImgLivro());
		
		
		final CadastroLivro updateCadastro = cadastroRepository.save(cadastro);
		return ResponseEntity.ok(updateCadastro);
	}
	
	//delete cadastro by id
	@DeleteMapping("/cadastro/{id}")
	public Map<String, Boolean> deleteCadastro(@PathVariable(value = "id") Long cadastroId)
			throws ResourceNotFoundException {
		CadastroLivro cadastro = cadastroRepository.findById(cadastroId)
				.orElseThrow(() -> new ResourceNotFoundException("Cadastro not found for this id :: " + cadastroId));
	
		cadastroRepository.delete(cadastro);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
	
	

}
