package br.com.passos.collects_data_equipment.models;

import jakarta.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "equipment")
public class Equipment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "equipment_model_id")
    private EquipmentModel equipmentModel;

    @OneToMany(mappedBy = "equipment")
    private List<EquipmentStateHistory> equipmentStateHistories;

    @OneToMany(mappedBy = "equipment")
    private List<EquipmentPositionHistory> equipmentPositionHistories;

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

    public EquipmentModel getEquipmentModel() {
        return equipmentModel;
    }

    public void setEquipmentModel(EquipmentModel equipmentModel) {
        this.equipmentModel = equipmentModel;
    }

    public List<EquipmentStateHistory> getEquipmentStateHistories() {
        return equipmentStateHistories;
    }

    public void setEquipmentStateHistories(List<EquipmentStateHistory> equipmentStateHistories) {
        this.equipmentStateHistories = equipmentStateHistories;
    }

    public List<EquipmentPositionHistory> getEquipmentPositionHistories() {
        return equipmentPositionHistories;
    }

    public void setEquipmentPositionHistories(List<EquipmentPositionHistory> equipmentPositionHistories) {
        this.equipmentPositionHistories = equipmentPositionHistories;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Equipment equipment = (Equipment) o;
        return Objects.equals(id, equipment.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

}
