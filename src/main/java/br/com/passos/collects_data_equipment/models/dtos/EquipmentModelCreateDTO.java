package br.com.passos.collects_data_equipment.models.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class EquipmentModelCreateDTO {

    private Long id;

    @NotEmpty
    @Size(min = 5, max = 50)
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotBlank @Size(min = 5, max = 50) String getName() {
        return name;
    }

    public void setName(@NotBlank @Size(min = 5, max = 50) String name) {
        this.name = name;
    }

}
