package br.com.passos.collects_data_equipment.repository;

import br.com.passos.collects_data_equipment.models.Equipment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EquipmentRepository extends JpaRepository<Equipment, Long> {
}
