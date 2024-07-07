package br.com.passos.collects_data_equipment.service;

import br.com.passos.collects_data_equipment.models.EquipmentModel;
import br.com.passos.collects_data_equipment.repository.EquipmentModelRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EquipmentModelService {

    private final EquipmentModelRepository equipmentModelRepository;

    public EquipmentModelService(EquipmentModelRepository equipmentModelRepository) {
        this.equipmentModelRepository = equipmentModelRepository;
    }

    @Transactional
    public void save(EquipmentModel equipmentModel) {
        equipmentModelRepository.save(equipmentModel);
    }

}
