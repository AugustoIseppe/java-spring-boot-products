package ais.io.products_api_restful.dto;

import ais.io.products_api_restful.entity.Product;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.UUID;

public class ProductMinDTO {

    private UUID id;

    @NotBlank(message = "O nome é obrigatório")
    @Size(min = 3, max = 50, message = "O nome deve ter entre 3 e 50 caracteres")
    private String name;

    @NotBlank(message = "A descrição é obrigatória")
    @Size(min = 10, max = 200, message = "A descrição deve ter entre 10 e 200 caracteres")
    private String description;

    public ProductMinDTO() {
    }

    public ProductMinDTO(UUID id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public ProductMinDTO(Product entity) {
        id = entity.getId();
        name = entity.getName();
        description = entity.getDescription();
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
