package br.com.passos.collects_data_equipment.models.dtos;

import jakarta.validation.constraints.NotEmpty;

public class EquipmentStateDTO {

    private Long id;

    @NotEmpty
    private String name;

    @NotEmpty
    private String color;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public @NotEmpty String getColor() {
        return color;
    }

    public void setColor(@NotEmpty String color) {
        this.color = color;
    }

}
