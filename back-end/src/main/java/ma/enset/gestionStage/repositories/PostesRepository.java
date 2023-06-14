package ma.enset.gestionStage.repositories;

import ma.enset.gestionStage.entities.Postes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostesRepository extends JpaRepository<Postes, Long> {
    List<Postes> searchPostesByTag(String tag);
    List<Postes> searchPostesByTitre(String titre);
}
