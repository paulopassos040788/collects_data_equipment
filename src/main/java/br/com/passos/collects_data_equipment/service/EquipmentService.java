package br.com.passos.collects_data_equipment.service;

import br.com.passos.collects_data_equipment.models.Equipment;
import br.com.passos.collects_data_equipment.repository.EquipmentRepository;
import br.com.passos.collects_data_equipment.service.exception.ModelNotFoundException;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class EquipmentService {

    private final EquipmentRepository equipmentRepository;

    public EquipmentService(EquipmentRepository equipmentRepository) {
        this.equipmentRepository = equipmentRepository;
    }

    public void save(Equipment equipment) {
        equipmentRepository.save(equipment);
    }

    public Equipment findByName(String name){
        try {
            return equipmentRepository.findByName(name);
        } catch (Exception ex){
            throw new ModelNotFoundException("Equipamento " + name + " não encontrado");
        }

    }

}
