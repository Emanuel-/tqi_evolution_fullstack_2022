package com.emanuel.bookshopapi.venda_controller;

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

import com.emanuel.bookshopapi.exception.ResourceNotFoundException;
import com.emanuel.bookshopapi.venda_model.VendaLivro;
import com.emanuel.bookshopapi.venda_repository.VendaRepository;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("/livros")
public class VendaController {
	@Autowired
	private VendaRepository vendaRepository;
	
	@GetMapping("/venda")
	public List<VendaLivro> getAllVendas(){
		return vendaRepository.findAll();
	}
	
	// cria venda
	@PostMapping("/venda")
	public VendaLivro createVenda(@Validated @RequestBody VendaLivro venda) {
		return vendaRepository.save(venda);		
	}
	
	//puxa venda pelo id
	@GetMapping("/venda/{id}")
	public ResponseEntity<VendaLivro> getCompraById(@PathVariable(value = "id") Long vendaId)
			throws ResourceNotFoundException {
		VendaLivro venda = vendaRepository.findById(vendaId)
				.orElseThrow(() -> new ResourceNotFoundException("Venda not found for this id :: " + vendaId));
		return ResponseEntity.ok().body(venda);
	}
	
	//update 
	@PutMapping("/venda/{id}")
	public ResponseEntity<VendaLivro> updateVenda(@PathVariable(value = "id") Long vendaId,
			@Validated @RequestBody VendaLivro vendaDetails) throws ResourceNotFoundException {
		VendaLivro venda = vendaRepository.findById(vendaId)
				.orElseThrow(() -> new ResourceNotFoundException("Venda not found for this id :: " + vendaId));
		
		venda.setNomeCliente(vendaDetails.getNomeCliente());
		venda.setCpfCliente(vendaDetails.getCpfCliente());
		venda.setGenero(vendaDetails.getGenero());
		venda.setDadosDaCompra(vendaDetails.getDadosDaCompra());
		venda.setQtdItens(vendaDetails.getQtdItens());
		venda.setPrecoTotal(vendaDetails.getPrecoTotal());
				
				
		final VendaLivro updateVenda = vendaRepository.save(venda);
		return ResponseEntity.ok(updateVenda);
	}
	
	//delete venda by id
	@DeleteMapping("/venda/{id}")
	public Map<String, Boolean> deleteVenda(@PathVariable(value = "id") Long vendaId)
			throws ResourceNotFoundException {
		VendaLivro venda = vendaRepository.findById(vendaId)
				.orElseThrow(() -> new ResourceNotFoundException("Venda not found for this id :: " + vendaId));
			
		vendaRepository.delete(venda);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}

}
