package ma.enset.gestionStage.services;

import ma.enset.gestionStage.entities.Livrable;

import java.util.List;

public interface LivrableService {
    List<Livrable> getLivrablesByStageId(Long stageId);
}
