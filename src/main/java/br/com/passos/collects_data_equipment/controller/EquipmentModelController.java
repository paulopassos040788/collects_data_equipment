package br.com.passos.collects_data_equipment.controller;

import br.com.passos.collects_data_equipment.controller.exception.ErrorMessage;
import br.com.passos.collects_data_equipment.models.EquipmentModel;
import br.com.passos.collects_data_equipment.models.dtos.EquipmentModelDTO;
import br.com.passos.collects_data_equipment.models.dtos.EquipmentModelMapper;
import br.com.passos.collects_data_equipment.service.EquipmentModelService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
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

    @Operation(summary = "Novo modelo de equipamento", description = "Recurso para cadastrar um novo modelo de equipamento",
            responses = {
                    @ApiResponse(responseCode = "201", description = ""),
                    @ApiResponse(responseCode = "400", description = "Campo(s) inválido(s)",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class))),
            })
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

    @Operation(summary = "Deletar modelo de equipamento", description = "Recurso para deletar modelo de equipamento pelo seu ID de identificação ",
            responses = {
                    @ApiResponse(responseCode = "200", description = ""),
                    @ApiResponse(responseCode = "404", description = "Modelo do equipamento não encontrado",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class))),
            })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") Long id) {
        this.equipmentModelService.delete(id);
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "Atualizar modelo de equipamento", description = "Recurso para atualização do modelo de equipamento pelo seu ID de identificação ",
            responses = {
                    @ApiResponse(responseCode = "200", description = ""),
                    @ApiResponse(responseCode = "404", description = "Modelo do equipamento não encontrado",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class))),
            })
    @PutMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") Long id, @RequestBody EquipmentModelDTO equipmentModelDto) {
        EquipmentModel equipmentModel = equipmentModelMapper.equipmentDtoToModel(equipmentModelDto);
        this.equipmentModelService.update(id, equipmentModel);
        return ResponseEntity.ok().build();
    }

}
