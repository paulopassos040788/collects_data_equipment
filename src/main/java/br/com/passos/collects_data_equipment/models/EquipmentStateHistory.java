package br.com.passos.collects_data_equipment.models;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "equipment_state_history")
public class EquipmentStateHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "equipment_id")
    private Equipment equipment;

    @ManyToOne
    @JoinColumn(name = "equipment_state_id")
    private EquipmentState equipmentState;

    private LocalDate date;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }

    public EquipmentState getEquipmentState() {
        return equipmentState;
    }

    public void setEquipmentState(EquipmentState equipmentState) {
        this.equipmentState = equipmentState;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EquipmentStateHistory that = (EquipmentStateHistory) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
