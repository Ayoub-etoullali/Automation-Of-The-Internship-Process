package ma.enset.gestionStage.mappers;

import ma.enset.gestionStage.dtos.EtudiantDTO;
import ma.enset.gestionStage.entities.Etudiant;

public interface EtudiantMapper {
    EtudiantDTO fromEtudiant(Etudiant etudiant);
    Etudiant fromEtudiantDTO(EtudiantDTO etudiantDTO);
}
