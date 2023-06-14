package ma.enset.gestionStage.repositories;

import java.util.List;
import ma.enset.gestionStage.entities.OffreStage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OffreStageRepository extends JpaRepository<OffreStage, Long> {
    List<OffreStage> searchOffreStageByPoste(String poste);
    List<OffreStage> searchOffreStageByEntreprise(String entreprise);
    List<OffreStage> searchOffreStageByTechnologie(String technologie);
    Page<OffreStage> findOffreStageByIdOrderByDateDebut(Long accountId, Pageable pageable);
    Page<OffreStage> findOffreStageById(Long accountId, Pageable pageable);


}
