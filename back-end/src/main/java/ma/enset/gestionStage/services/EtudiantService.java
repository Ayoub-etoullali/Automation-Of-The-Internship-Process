package ma.enset.gestionStage.services;

import java.util.List;
import java.util.Optional;

import ma.enset.gestionStage.dtos.EtudiantDTO;
import ma.enset.gestionStage.entities.Etudiant;

public interface EtudiantService {
    EtudiantDTO createEtudiant(EtudiantDTO etudiantDTO);
    List<EtudiantDTO> getAllEtudiants();
    EtudiantDTO getEtudiantById(Long id);
    EtudiantDTO updateEtudiant(Long id, EtudiantDTO newEtudiantDTO);
    void deleteEtudiantById(Long id);
    EtudiantDTO ChercherEtudiantByCNE(String cne);
}
