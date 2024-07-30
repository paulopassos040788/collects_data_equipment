package br.com.passos.collects_data_equipment.repository;

import br.com.passos.collects_data_equipment.models.EquipmentState;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EquipmentStateRepository extends JpaRepository<EquipmentState, Long> {
}
