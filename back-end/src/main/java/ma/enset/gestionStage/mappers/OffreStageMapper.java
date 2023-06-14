package ma.enset.gestionStage.mappers;

import ma.enset.gestionStage.dtos.EtudiantDTO;
import ma.enset.gestionStage.dtos.OffreStageDTO;
import ma.enset.gestionStage.entities.Etudiant;
import ma.enset.gestionStage.entities.OffreStage;

import java.util.Optional;

public interface OffreStageMapper {
    OffreStageDTO fromOffreStage(OffreStage offreStage);
    OffreStage fromOffreStageDTO(OffreStageDTO offreStageDTO);
}
