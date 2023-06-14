package ma.enset.gestionStage.repositories;

import ma.enset.gestionStage.entities.Etudiant;
import ma.enset.gestionStage.entities.SessionEncadrement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SessionEncadramentRepository extends JpaRepository<SessionEncadrement, Long> {

//    @Query("SELECT DISTINCT s.etudiant FROM Stage s JOIN s.livrables. se WHERE s.livrables.id = :encadrantId AND s.dateFin >= CURRENT_DATE")
//    List<Etudiant> findEtudiantsEnCoursByEncadrantId(@Param("encadrantId") Long encadrantId);
}