package br.com.passos.collects_data_equipment.controller;

import br.com.passos.collects_data_equipment.controller.exception.ErrorMessage;
import br.com.passos.collects_data_equipment.models.EquipmentModel;
import br.com.passos.collects_data_equipment.models.EquipmentState;
import br.com.passos.collects_data_equipment.models.dtos.EquipmentModelDTO;
import br.com.passos.collects_data_equipment.models.dtos.EquipmentStateDTO;
import br.com.passos.collects_data_equipment.models.dtos.ModelMapper;
import br.com.passos.collects_data_equipment.service.EquipmentStateService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/v1/equipmentState")
public class EquipmentStateController {

    private final EquipmentStateService equipmentStateService;

    private final ModelMapper equipmentStateMapper = ModelMapper.INSTANCE;

    public EquipmentStateController(EquipmentStateService equipmentStateService) {
        this.equipmentStateService = equipmentStateService;
    }

    @Operation(summary = "Estado do equipamento", description = "Recurso para cadastrar um novo modelo estado do equipamento",
            responses = {
                    @ApiResponse(responseCode = "201", description = ""),
                    @ApiResponse(responseCode = "400", description = "Campo(s) inválido(s)",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class))),
            })
    @PostMapping
    public ResponseEntity<Void> createEquipmentState(@Valid @RequestBody EquipmentStateDTO equipmentStateDTO) {
        EquipmentState equipmentState = equipmentStateMapper.equipmentStateDtoTo(equipmentStateDTO);
        this.equipmentStateService.save(equipmentState);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @Operation(summary = "Lista de estado equipamento", description = "Lista de todos os estados possíveis do equipamento",
            responses = {
                    @ApiResponse(responseCode = "200", description = ""),
                    @ApiResponse(responseCode = "500", description = "",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class))),
            })
    @GetMapping
    public ResponseEntity<Map<String, String>> getAll() {
        Map<String, String> map = this.equipmentStateService.getAll();
        return ResponseEntity.ok().body(map);
    }

    @Operation(summary = "Deletar tipo estado dos equipamentos", description = "Recurso para deletar os tipos de estados dos equipamentos, pelo seu ID de identificação ",
            responses = {
                    @ApiResponse(responseCode = "200", description = ""),
                    @ApiResponse(responseCode = "404", description = "Estado de equipamentos não encontrado",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class))),
            })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") Long id) {
        this.equipmentStateService.delete(id);
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "Atualizar estado dos equipamentos", description = "Recurso para atualização os estados de equipamentos pelo seu ID de identificação ",
            responses = {
                    @ApiResponse(responseCode = "200", description = ""),
                    @ApiResponse(responseCode = "404", description = "Estado de equipamentos não encontrado",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class))),
            })
    @PutMapping("/{id}")
    public ResponseEntity<Void> updateById(@PathVariable("id") Long id, @RequestBody EquipmentStateDTO equipmentStateDTO) {
        EquipmentState equipmentState = equipmentStateMapper.equipmentStateDtoTo(equipmentStateDTO);
        this.equipmentStateService.update(id, equipmentState);
        return ResponseEntity.ok().build();
    }

}
