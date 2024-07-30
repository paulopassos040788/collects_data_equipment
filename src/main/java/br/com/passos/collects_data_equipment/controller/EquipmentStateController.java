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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
