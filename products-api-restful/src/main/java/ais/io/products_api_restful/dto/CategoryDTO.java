package ais.io.products_api_restful.dto;

import ais.io.products_api_restful.entity.Category;

import java.util.UUID;

public class CategoryDTO {

    private UUID id;
    private String name;

    public CategoryDTO() {
    }

    public CategoryDTO(UUID id, String name) {
        this.id = id;
        this.name = name;
    }

    public CategoryDTO(Category entity) {
        id = entity.getId();
        name = entity.getName();
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
