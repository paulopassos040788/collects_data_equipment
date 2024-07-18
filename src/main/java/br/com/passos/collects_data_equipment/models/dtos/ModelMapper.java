package br.com.passos.collects_data_equipment.models.dtos;

import br.com.passos.collects_data_equipment.models.Equipment;
import br.com.passos.collects_data_equipment.models.EquipmentModel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ModelMapper {

    ModelMapper INSTANCE = Mappers.getMapper(ModelMapper.class);

    EquipmentModelDTO equipmentToModelDto(EquipmentModel equipmentModel);

    EquipmentModel equipmentDtoToModel(EquipmentModelDTO equipmentModelDTO);

    EquipmentDTO equipmentToDto(Equipment equipment);

    Equipment equipmentDtoTo(EquipmentDTO equipmentDTO);

}
