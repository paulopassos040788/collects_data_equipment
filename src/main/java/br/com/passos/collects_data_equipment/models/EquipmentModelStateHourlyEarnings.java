package br.com.passos.collects_data_equipment.models;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "equipment_model_state_hourly_earnings")
public class EquipmentModelStateHourlyEarnings {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "equipment_model_id")
    private EquipmentModel equipmentModel;

    @ManyToOne
    @JoinColumn(name = "equipment_state_id")
    private EquipmentState equipmentState;

    private BigDecimal amount;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public EquipmentModel getEquipmentModel() {
        return equipmentModel;
    }

    public void setEquipmentModel(EquipmentModel equipmentModel) {
        this.equipmentModel = equipmentModel;
    }

    public EquipmentState getEquipmentState() {
        return equipmentState;
    }

    public void setEquipmentState(EquipmentState equipmentState) {
        this.equipmentState = equipmentState;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EquipmentModelStateHourlyEarnings that = (EquipmentModelStateHourlyEarnings) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

}
