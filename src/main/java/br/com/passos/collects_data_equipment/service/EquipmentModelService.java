package br.com.passos.collects_data_equipment.service;

import br.com.passos.collects_data_equipment.models.EquipmentModel;
import br.com.passos.collects_data_equipment.repository.EquipmentModelRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

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

    @Transactional
    public List<EquipmentModel> findByName(String name) {
        return equipmentModelRepository.findByName(name);
    }

    public void delete(Long id) {
        Optional<EquipmentModel> equipmentModel = Optional.ofNullable(this.equipmentModelRepository.findById(id).orElseThrow(() -> new RuntimeException("Modelo nao encontrado")));
        equipmentModelRepository.deleteById(equipmentModel.get().getId());
    }

    public void update(Long id, EquipmentModel equipmentModel) {
        Optional<EquipmentModel> equipmentModelOptional = equipmentModelRepository.findById(id);

        if (equipmentModelOptional.isEmpty()) {
            throw new RuntimeException("Modelo nao encontrado");
        }

        EquipmentModel existingEquipmentModel  = equipmentModelOptional.get();
        existingEquipmentModel.setName(equipmentModel.getName());
        this.equipmentModelRepository.save(existingEquipmentModel);
    }

}
