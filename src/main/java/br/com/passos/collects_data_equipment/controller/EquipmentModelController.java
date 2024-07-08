package br.com.passos.collects_data_equipment.controller;

import br.com.passos.collects_data_equipment.models.EquipmentModel;
import br.com.passos.collects_data_equipment.models.dtos.EquipmentModelCreateDTO;
import br.com.passos.collects_data_equipment.models.dtos.EquipmentModelMapper;
import br.com.passos.collects_data_equipment.service.EquipmentModelService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/equipmentModel")
public class EquipmentModelController {

    private final EquipmentModelService equipmentModelService;

    private final EquipmentModelMapper equipmentModelMapper = EquipmentModelMapper.INSTANCE;

    public EquipmentModelController(EquipmentModelService equipmentModelService) {
        this.equipmentModelService = equipmentModelService;
    }

    @PostMapping
    public ResponseEntity<Void> createEquipmentModel(@Valid @RequestBody EquipmentModelCreateDTO equipmentModelDto) {
        EquipmentModel equipmentModel = equipmentModelMapper.equipmentDtoToModel(equipmentModelDto);
        this.equipmentModelService.save(equipmentModel);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
