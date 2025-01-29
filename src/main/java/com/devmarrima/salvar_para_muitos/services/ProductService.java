package com.devmarrima.salvar_para_muitos.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devmarrima.salvar_para_muitos.dto.CategoryDTO;
import com.devmarrima.salvar_para_muitos.dto.ProductDTO;
import com.devmarrima.salvar_para_muitos.entities.Category;
import com.devmarrima.salvar_para_muitos.entities.Product;
import com.devmarrima.salvar_para_muitos.repositories.CategoryRepository;
import com.devmarrima.salvar_para_muitos.repositories.ProductRepository;

@Service
public class ProductService {
	@Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    public ProductDTO insert (ProductDTO dto){

        Product entity = new Product();
        entity.setName(dto.getName());
        entity.setPrice(dto.getPrice());

        for (CategoryDTO catDto : dto.getCategories()){
            Category category = categoryRepository.getReferenceById(catDto.getId());
            //category.setId(catDto.getId());
            entity.getCategories().add(category);
        }
        entity = productRepository.save(entity);
        return new ProductDTO(entity);
    }
}
