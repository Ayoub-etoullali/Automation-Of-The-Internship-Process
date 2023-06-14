package ma.enset.gestionStage.repositories;

import ma.enset.gestionStage.entities.Commentaire;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentairRepository extends JpaRepository<Commentaire, Long> {
    List<Commentaire> findByLivrableId(Long livrableId);
}
