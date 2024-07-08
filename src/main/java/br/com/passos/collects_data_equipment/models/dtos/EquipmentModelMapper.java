package br.com.passos.collects_data_equipment.models.dtos;

import br.com.passos.collects_data_equipment.models.EquipmentModel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EquipmentModelMapper {

    EquipmentModelMapper INSTANCE = Mappers.getMapper(EquipmentModelMapper.class);

    EquipmentModelCreateDTO equipmentToModelDto(EquipmentModel equipmentModel);

    EquipmentModel equipmentDtoToModel(EquipmentModelCreateDTO equipmentModelCreateDTO);

}
