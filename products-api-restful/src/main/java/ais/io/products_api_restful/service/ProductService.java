package ais.io.products_api_restful.service;

import ais.io.products_api_restful.dto.CategoryDTO;
import ais.io.products_api_restful.dto.ProductDTO;
import ais.io.products_api_restful.entity.Category;
import ais.io.products_api_restful.entity.Product;
import ais.io.products_api_restful.repository.CategoryRepository;
import ais.io.products_api_restful.repository.ProductRepository;
import ais.io.products_api_restful.service.exceptions.DatabaseException;
import ais.io.products_api_restful.service.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProductService {

    @Autowired
    public ProductRepository productRepository;
    // Posso fazer dessa maneira com o @Autowired, ou posso fazer o construtor
    @Autowired
    private CategoryRepository categoryRepository;

    @Transactional
    public ProductDTO insert(ProductDTO productDTO) {
        Product productEntity = new Product();
        copyDtoToEntity(productDTO, productEntity);
        productEntity = productRepository.save(productEntity);
        return new ProductDTO(productEntity);
    }

    @Transactional
    public List<ProductDTO> findAll() {
        List<Product> result = productRepository.findAll();
        return result.stream().map(product -> new ProductDTO(product)).toList();
    }

    @Transactional
    public ProductDTO findById(UUID id) {
        Product productResult = productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Produto não encontrado"));
        return new ProductDTO(productResult);
    }

    @Transactional
    public void deleteById(UUID id) {
        if (!productRepository.existsById(id)) {
            throw new ResourceNotFoundException("Produto não encontrado!");
        }
        try {
            productRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Falha de integridade referencial");
        }
    }

    @Transactional
    public ProductDTO update(UUID id, ProductDTO productDTO) {
        try {
            Product productEntity = productRepository.getReferenceById(id);
            copyDtoToEntity(productDTO, productEntity);
            productEntity = productRepository.save(productEntity);
            return new ProductDTO(productEntity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Produto não encontrado");
        }
    }


    private void copyDtoToEntity(ProductDTO dto, Product entity) {
        entity.setName(dto.getName());
        entity.setValue(dto.getValue());
        entity.setDescription(dto.getDescription());
        entity.setImgUrl(dto.getImgUrl());

        entity.getCategories().clear(); // Boa prática: limpar antes de adicionar

        for (CategoryDTO categoryDTO : dto.getCategories()) {
            Category category = categoryRepository.findById(categoryDTO.getId())
                    .orElseThrow(() -> new RuntimeException("Categoria não encontrada com ID: " + categoryDTO.getId()));
            entity.getCategories().add(category);
        }
    }

//    private void copyDtoToEntity(ProductDTO dto, Product entity) {
//        entity.setName(dto.getName());
//        entity.setValue(dto.getValue());
//        entity.setDescription(dto.getDescription());
//        entity.setImgUrl(dto.getImgUrl());
//        for (CategoryDTO categoryDTO : dto.getCategories()) {
//            Category category = new Category();
//            category.setId(categoryDTO.getId());
//            category.setName(categoryDTO.getName());
//            entity.getCategories().add(category);
//
//        }
//    }


}
