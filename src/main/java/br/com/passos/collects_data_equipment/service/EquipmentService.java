package br.com.passos.collects_data_equipment.service;

import br.com.passos.collects_data_equipment.models.Equipment;
import br.com.passos.collects_data_equipment.repository.EquipmentRepository;
import br.com.passos.collects_data_equipment.service.exception.ModelNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;

@Service
@Transactional
public class EquipmentService {

    private final EquipmentRepository equipmentRepository;

    public EquipmentService(EquipmentRepository equipmentRepository) {
        this.equipmentRepository = equipmentRepository;
    }

    public void save(Equipment equipment) {
        this.equipmentRepository.save(equipment);
    }

    public Equipment findByName(String name){
        try {
            return this.equipmentRepository.findByName(name);
        } catch (Exception ex){
            throw new ModelNotFoundException("Equipamento " + name + " não encontrado");
        }

    }

    public void delete(Long id) {
        Optional<Equipment> equipmentModel = Optional.ofNullable(
                this.equipmentRepository.findById(id).orElseThrow(
                        () -> new ModelNotFoundException("Equipamento não encontrado")));
        this.equipmentRepository.deleteById(equipmentModel.get().getId());
    }

    public void update(Long id, Equipment equipment) {
        Optional<Equipment> equipmentOptional = this.equipmentRepository.findById(id);

        if (equipmentOptional.isEmpty()) {
            throw new ModelNotFoundException("Equipamento não encontrado");
        }

        Equipment existingEquipment  = equipmentOptional.get();
        existingEquipment.setName(equipment.getName());
        this.equipmentRepository.save(existingEquipment);
    }

}
