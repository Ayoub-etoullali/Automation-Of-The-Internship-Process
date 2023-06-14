package ma.enset.gestionStage.services;

import ma.enset.gestionStage.dtos.StageDTO;
import ma.enset.gestionStage.entities.Stage;


import java.util.List;

public interface StageService {
    public List<StageDTO> getStagesByEtudiantId(Long etudiantId);
    StageDTO saveStage(StageDTO stage);
}
