package br.com.passos.collects_data_equipment.repository;

import br.com.passos.collects_data_equipment.models.Equipment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface EquipmentRepository extends JpaRepository<Equipment, Long> {

    @Query("SELECT eq FROM Equipment eq WHERE  eq.name = :name")
    public Equipment findByName(@Param("name") String name);

}
