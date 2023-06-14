package ma.enset.gestionStage.mappers;

import ma.enset.gestionStage.dtos.EtudiantDTO;
import ma.enset.gestionStage.dtos.StageDTO;
import ma.enset.gestionStage.entities.Etudiant;
import ma.enset.gestionStage.entities.Stage;

import java.util.Optional;

public interface StageMapper {
    StageDTO fromStage(Stage stage);
    Stage fromStageDTO(StageDTO stageDTO);
}
