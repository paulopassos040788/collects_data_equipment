package br.com.passos.collects_data_equipment.models.dtos;

import br.com.passos.collects_data_equipment.models.EquipmentModel;
import jakarta.validation.constraints.NotEmpty;

public class EquipmentDTO {

    private Long id;

    @NotEmpty
    private String name;

    private EquipmentModel equipmentModel;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotEmpty String getName() {
        return name;
    }

    public void setName(@NotEmpty String name) {
        this.name = name;
    }

    public EquipmentModel getEquipmentModel() {
        return equipmentModel;
    }

    public void setEquipmentModel(EquipmentModel equipmentModel) {
        this.equipmentModel = equipmentModel;
    }

}
