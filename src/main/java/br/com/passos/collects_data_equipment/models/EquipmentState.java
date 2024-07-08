package br.com.passos.collects_data_equipment.models;

import jakarta.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "equipment_state")
public class EquipmentState {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String color;

    @OneToMany(mappedBy = "equipmentState")
    private List<EquipmentStateHistory> equipmentStateHistories;

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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public List<EquipmentStateHistory> getEquipmentStateHistories() {
        return equipmentStateHistories;
    }

    public void setEquipmentStateHistories(List<EquipmentStateHistory> equipmentStateHistories) {
        this.equipmentStateHistories = equipmentStateHistories;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EquipmentState that = (EquipmentState) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

}
