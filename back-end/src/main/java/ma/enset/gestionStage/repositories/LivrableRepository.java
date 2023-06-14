package ma.enset.gestionStage.repositories;

import ma.enset.gestionStage.entities.Livrable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LivrableRepository extends JpaRepository<Livrable, Long> {
        List<Livrable> findByStageId(Long stageId);
    }

