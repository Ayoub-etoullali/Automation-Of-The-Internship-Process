package ma.enset.gestionStage.mappers;

import ma.enset.gestionStage.dtos.OffreDeStageDetailsDTO;
import ma.enset.gestionStage.entities.OffreDeStage;

public interface OffreDeStageDetailsMapper {
    OffreDeStageDetailsDTO offreDeStageToDetailsDTO(OffreDeStage offreDeStage);
}
