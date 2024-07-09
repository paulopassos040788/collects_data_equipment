package br.com.passos.collects_data_equipment.controller;

import br.com.passos.collects_data_equipment.models.EquipmentModel;
import br.com.passos.collects_data_equipment.models.dtos.EquipmentModelDTO;
import br.com.passos.collects_data_equipment.models.dtos.EquipmentModelMapper;
import br.com.passos.collects_data_equipment.service.EquipmentModelService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/v1/equipmentModel")
public class EquipmentModelController {

    private final EquipmentModelService equipmentModelService;

    private final EquipmentModelMapper equipmentModelMapper = EquipmentModelMapper.INSTANCE;

    public EquipmentModelController(EquipmentModelService equipmentModelService) {
        this.equipmentModelService = equipmentModelService;
    }

    @PostMapping
    public ResponseEntity<Void> createEquipmentModel(@Valid @RequestBody EquipmentModelDTO equipmentModelDto) {
        EquipmentModel equipmentModel = equipmentModelMapper.equipmentDtoToModel(equipmentModelDto);
        this.equipmentModelService.save(equipmentModel);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/{name}")
    public ResponseEntity<List<EquipmentModelDTO>> findByNameEquipmentModel(@PathVariable("name") String name) {
        List<EquipmentModel> equipmentModels = this.equipmentModelService.findByName(name);
        List<EquipmentModelDTO> equipmentModelDto = equipmentModels.stream().map(equipmentModelMapper::equipmentToModelDto).toList();
        return ResponseEntity.ok().body(equipmentModelDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") Long id) {
        this.equipmentModelService.delete(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") Long id, @RequestBody EquipmentModelDTO equipmentModelDto) {
        EquipmentModel equipmentModel = equipmentModelMapper.equipmentDtoToModel(equipmentModelDto);
        this.equipmentModelService.update(id, equipmentModel);
        return ResponseEntity.ok().build();
    }

}
