package ma.enset.gestionStage.mappers;

import ma.enset.gestionStage.dtos.OffreDeStageDTO;
import ma.enset.gestionStage.entities.OffreDeStage;

import java.util.List;

public interface OffreDeStageMapper {
    OffreDeStageDTO offreDeStageToDTO(OffreDeStage offreDeStage);
    OffreDeStage DTOToOffreDeStage(OffreDeStageDTO dto);
    List<OffreDeStageDTO> offreDeStageListToDTOList(List<OffreDeStage> offreDeStages);
}