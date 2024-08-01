package br.com.passos.collects_data_equipment.service;

import br.com.passos.collects_data_equipment.controller.exception.ErrorMessage;
import br.com.passos.collects_data_equipment.models.EquipmentModel;
import br.com.passos.collects_data_equipment.models.EquipmentState;
import br.com.passos.collects_data_equipment.models.dtos.EquipmentModelDTO;
import br.com.passos.collects_data_equipment.repository.EquipmentStateRepository;
import br.com.passos.collects_data_equipment.service.exception.ModelNotFoundException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Map;
import java.util.Optional;
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

    public void delete(Long id) {
        Optional<EquipmentState> equipmentModel = Optional.ofNullable(
                this.equipmentStateRepository.findById(id).orElseThrow(
                        () -> new ModelNotFoundException("Estado de equipamentos não encontrado")));
        this.equipmentStateRepository.deleteById(equipmentModel.get().getId());
    }

    public void update(Long id, EquipmentState equipmentState) {
        Optional<EquipmentState> equipmentStateOptional = equipmentStateRepository.findById(id);

        if (equipmentStateOptional.isEmpty()) {
            throw new ModelNotFoundException("Estado de equipamentos não encontrado");
        }

        EquipmentState existingEquipmentState  = equipmentStateOptional.get();
        existingEquipmentState.setName(equipmentState.getName());
        existingEquipmentState.setColor(equipmentState.getColor());
        this.equipmentStateRepository.save(existingEquipmentState);
    }

}
