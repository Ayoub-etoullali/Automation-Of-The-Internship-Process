package ma.enset.gestionStage.repositories;

import ma.enset.gestionStage.entities.EncadrantPedagogique;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface EncadrantPedagogiqueRepository extends JpaRepository<EncadrantPedagogique, Long> {
    List<EncadrantPedagogique> findByNomContainingIgnoreCase(String nom);
}