package com.emanuel.bookshopapi.venda_repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.emanuel.bookshopapi.venda_model.VendaLivro;

@Repository
public interface VendaRepository extends JpaRepository<VendaLivro, Long>{

}

