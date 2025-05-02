package ais.io.products_api_restful.service;

import ais.io.products_api_restful.dto.CategoryDTO;
import ais.io.products_api_restful.entity.Category;
import ais.io.products_api_restful.repository.CategoryRepository;
import ais.io.products_api_restful.service.exceptions.DatabaseException;
import ais.io.products_api_restful.service.exceptions.ResourceNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class CategoryService {

    private CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Transactional
    public CategoryDTO insert(CategoryDTO categoryDTO) {
        Category categoryEntity = new Category();
        categoryEntity.setName(categoryDTO.getName());
        categoryEntity = categoryRepository.save(categoryEntity);
        return new CategoryDTO(categoryEntity);
    }

    @Transactional
    public List<CategoryDTO> findAll() {
        List<Category> result = categoryRepository.findAll();
        return result.stream().map(category -> new CategoryDTO(category)).toList();
    }

    @Transactional
    public CategoryDTO findById(UUID uuid) {
        Category categoryEntity = categoryRepository.findById(uuid).orElseThrow(() -> new ResourceNotFoundException("Categoria não encontrada"));
        return new CategoryDTO(categoryEntity);
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void delete(UUID uuid) {
        if (!categoryRepository.existsById(uuid)) {
            throw new ResourceNotFoundException("Categoria não encontrada");
        }

        try {
            categoryRepository.deleteById(uuid);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Esta categoria não pode ser removida | Falha de integridade referencial");
        }
    }
}
