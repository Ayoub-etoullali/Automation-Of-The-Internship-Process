package ma.enset.gestionStage.services;


import ma.enset.gestionStage.entities.Livrable;
import ma.enset.gestionStage.repositories.LivrableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivrableServiceImp implements LivrableService {
    @Autowired
    private LivrableRepository livrableRepository;

    public List<Livrable> getLivrablesByStageId(Long stageId) {
        return livrableRepository.findByStageId(stageId);
    }
}
