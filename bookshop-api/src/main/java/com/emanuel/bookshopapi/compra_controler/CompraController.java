package com.emanuel.bookshopapi.compra_controler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emanuel.bookshopapi.compra_model.CompraLivro;
import com.emanuel.bookshopapi.compra_repository.CompraRepository;
import com.emanuel.bookshopapi.exception.ResourceNotFoundException;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("/livros")
public class CompraController {
	
	@Autowired
	private CompraRepository compraRepository;
	
	@GetMapping("/compra")
	public List<CompraLivro> getAllCompras(){
		return compraRepository.findAll();
	}
	
	// cria compra
	@PostMapping("/compra")
	public CompraLivro createCompra(@Validated @RequestBody CompraLivro compra) {
		return compraRepository.save(compra);		
	}
	
	//puxa compra pelo id
	@GetMapping("/compra/{id}")
	public ResponseEntity<CompraLivro> getCompraById(@PathVariable(value = "id") Long compraId)
			throws ResourceNotFoundException {
		CompraLivro compra = compraRepository.findById(compraId)
				.orElseThrow(() -> new ResourceNotFoundException("Compra not found for this id :: " + compraId));
		return ResponseEntity.ok().body(compra);
	}
	
	//update 
	@PutMapping("/compra/{id}")
	public ResponseEntity<CompraLivro> updateCompra(@PathVariable(value = "id") Long compraId,
			@Validated @RequestBody CompraLivro compraDetails) throws ResourceNotFoundException {
		CompraLivro compra = compraRepository.findById(compraId)
				.orElseThrow(() -> new ResourceNotFoundException("Compra not found for this id :: " + compraId));
		
		compra.setCodLivro(compraDetails.getCodLivro());
		compra.setQtdLivros(compraDetails.getQtdLivros());
		compra.setValUnit(compraDetails.getValUnit());
		
			
		final CompraLivro updateCompra = compraRepository.save(compra);
		return ResponseEntity.ok(updateCompra);
	}
	
	//delete compra by id
	@DeleteMapping("/compra/{id}")
	public Map<String, Boolean> deleteCompra(@PathVariable(value = "id") Long compraId)
			throws ResourceNotFoundException {
		CompraLivro compra = compraRepository.findById(compraId)
				.orElseThrow(() -> new ResourceNotFoundException("Compra not found for this id :: " + compraId));
		
		compraRepository.delete(compra);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}

}
