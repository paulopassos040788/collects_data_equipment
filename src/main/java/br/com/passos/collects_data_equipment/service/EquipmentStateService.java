package br.com.passos.collects_data_equipment.service;

import br.com.passos.collects_data_equipment.models.EquipmentState;
import br.com.passos.collects_data_equipment.repository.EquipmentStateRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

    public Map<String, String> getAll() {
        List<EquipmentState> list = equipmentStateRepository.findAll();
        return list.stream()
                .collect(Collectors
                        .toMap(EquipmentState::getColor, EquipmentState::getName, (existing, replacement) -> existing));
    }

}
