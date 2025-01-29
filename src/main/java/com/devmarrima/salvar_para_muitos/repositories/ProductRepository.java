package com.devmarrima.salvar_para_muitos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devmarrima.salvar_para_muitos.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
