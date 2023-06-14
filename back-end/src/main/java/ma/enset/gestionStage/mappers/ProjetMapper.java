package ma.enset.gestionStage.mappers;

import ma.enset.gestionStage.dtos.EtudiantDTO;
import ma.enset.gestionStage.dtos.ProjetDTO;
import ma.enset.gestionStage.entities.Etudiant;
import ma.enset.gestionStage.entities.Projet;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface ProjetMapper {
    ProjetDTO fromProjet(Projet projet);
    Projet fromProjetDTO(ProjetDTO projetDTO);
}
