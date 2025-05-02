package ais.io.products_api_restful.dto;

import ais.io.products_api_restful.entity.Category;
import ais.io.products_api_restful.entity.Product;
import jakarta.validation.constraints.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ProductDTO {

    private UUID id;

    @NotBlank(message = "O nome é obrigatório")
    @Size(min = 3, max = 50, message = "O nome deve ter entre 3 e 50 caracteres")
    private String name;

    @NotNull(message = "O valor é obrigatório")
    @Positive(message = "O valor deve ser positivo")
    private BigDecimal value;

    @NotBlank(message = "A descrição é obrigatória")
    @Size(min = 10, max = 200, message = "A descrição deve ter entre 10 e 200 caracteres")
    private String description;

    @NotBlank(message = "A URL da imagem é obrigatória")
    private String imgUrl;

    @NotEmpty(message = "Campo requerido - Deve haver pelo menos uma categoria")
    private List<CategoryDTO> categories = new ArrayList<>();

    public ProductDTO() {
    }

    public ProductDTO(UUID id, String name, BigDecimal value, String description, String imgUrl, List<CategoryDTO> categories) {
        this.id = id;
        this.name = name;
        this.value = value;
        this.description = description;
        this.imgUrl = imgUrl;
        this.categories = categories;
    }

    public ProductDTO(Product entity) {
        id = entity.getId();
        name = entity.getName();
        value = entity.getValue();
        description = entity.getDescription();
        imgUrl = entity.getImgUrl();
        for (Category category : entity.getCategories()) {
            categories.add(new CategoryDTO(category));
        }
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getValue() {
        return value;
    }

    public String getDescription() {
        return description;
    }


    public String getImgUrl() {
        return imgUrl;
    }

    public List<CategoryDTO> getCategories() {
        return categories;
    }
}
