package br.com.passos.collects_data_equipment.controller;

import br.com.passos.collects_data_equipment.controller.exception.ErrorMessage;
import br.com.passos.collects_data_equipment.models.Equipment;
import br.com.passos.collects_data_equipment.models.dtos.EquipmentDTO;
import br.com.passos.collects_data_equipment.models.dtos.ModelMapper;
import br.com.passos.collects_data_equipment.service.EquipmentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/equipment")
public class EquipmentController {

    private final EquipmentService equipmentService;

    private final ModelMapper equipmentMapper = ModelMapper.INSTANCE;

    public EquipmentController(EquipmentService equipmentService) {
        this.equipmentService = equipmentService;
    }

    @Operation(summary = "Cadastro do equipamento", description = "Recurso para cadastrar um novo equipamento",
            responses = {
                    @ApiResponse(responseCode = "201", description = "Equipamento cadastrodo"),
                    @ApiResponse(responseCode = "400", description = "Campo(s) inválido(s)",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class))),
            })
    @PostMapping
    public ResponseEntity<Void> createEquipment(@Valid @RequestBody EquipmentDTO equipmentDTO) {
        Equipment equipment = equipmentMapper.equipmentDtoTo(equipmentDTO);
        equipmentService.save(equipment);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/{name}")
    public ResponseEntity<EquipmentDTO> findEquipmentByName(@PathVariable String name) {
        Equipment equipment = equipmentService.findByName(name);
        EquipmentDTO equipmentDTO = equipmentMapper.equipmentToDto(equipment);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(equipmentDTO);
    }

    @Operation(summary = "Deletar equipamento", description = "Recurso para deletar equipamento pelo seu ID de identificação ",
            responses = {
                    @ApiResponse(responseCode = "200", description = ""),
                    @ApiResponse(responseCode = "404", description = "Equipamento não encontrado",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class))),
            })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") Long id) {
        this.equipmentService.delete(id);
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "Atualizar equipamento", description = "Recurso para atualização de equipamento pelo seu ID de identificação ",
            responses = {
                    @ApiResponse(responseCode = "200", description = ""),
                    @ApiResponse(responseCode = "404", description = "Equipamento não encontrado",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class))),
            })
    @PutMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") Long id, @RequestBody EquipmentDTO equipmentDto) {
        Equipment equipmentModel = equipmentMapper.equipmentDtoTo(equipmentDto);
        this.equipmentService.update(id, equipmentModel);
        return ResponseEntity.ok().build();
    }

}
