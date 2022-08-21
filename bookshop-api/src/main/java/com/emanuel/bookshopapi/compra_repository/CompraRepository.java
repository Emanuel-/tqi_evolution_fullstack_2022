package com.emanuel.bookshopapi.compra_repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.emanuel.bookshopapi.compra_model.CompraLivro;

@Repository
public interface CompraRepository extends JpaRepository<CompraLivro, Long>{

}


