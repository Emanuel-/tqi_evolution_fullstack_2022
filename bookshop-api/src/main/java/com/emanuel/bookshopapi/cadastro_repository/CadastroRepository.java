package com.emanuel.bookshopapi.cadastro_repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.emanuel.bookshopapi.cadastro_model.CadastroLivro;

@Repository
public interface CadastroRepository extends JpaRepository<CadastroLivro, Long>{

}
