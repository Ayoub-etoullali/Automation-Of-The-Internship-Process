package ma.enset.gestionStage.mappers;

import ma.enset.gestionStage.dtos.EncadrantPedagogiqueDTO;
import ma.enset.gestionStage.entities.EncadrantPedagogique;

import java.util.List;

public interface EncadrantPedagogiqueMapper {
    EncadrantPedagogiqueDTO toDTO(EncadrantPedagogique encadrantPedagogique);
    EncadrantPedagogique toEntity(EncadrantPedagogiqueDTO encadrantPedagogiqueDTO);
    List<EncadrantPedagogiqueDTO> toDTOList(List<EncadrantPedagogique> encadrantPedagogiques);
}