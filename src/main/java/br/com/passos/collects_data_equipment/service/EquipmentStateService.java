package br.com.passos.collects_data_equipment.service;

import br.com.passos.collects_data_equipment.models.EquipmentState;
import br.com.passos.collects_data_equipment.repository.EquipmentStateRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class EquipmentStateService {

    private final EquipmentStateRepository equipmentStateRepository;

    public EquipmentStateService(EquipmentStateRepository equipmentStateRepository) {
        this.equipmentStateRepository = equipmentStateRepository;
    }

    public void save(EquipmentState equipmentState) {
        equipmentStateRepository.save(equipmentState);
    }
}
