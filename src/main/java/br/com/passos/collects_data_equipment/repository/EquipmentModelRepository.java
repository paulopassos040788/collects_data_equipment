package br.com.passos.collects_data_equipment.repository;

import br.com.passos.collects_data_equipment.models.EquipmentModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface EquipmentModelRepository extends JpaRepository<EquipmentModel, Long> {

    @Query("SELECT model FROM EquipmentModel model WHERE model.name LIKE %:name%")
    public List<EquipmentModel> findByName(@Param("name") String name);

}
