package ma.enset.gestionStage.services;

import java.util.List;
import java.util.Optional;

import ma.enset.gestionStage.dtos.ProjetDTO;
import ma.enset.gestionStage.entities.Projet;

public interface ProjetService {
    ProjetDTO saveProjet(ProjetDTO projetDTO);

    List<ProjetDTO> getAllProjets();

    ProjetDTO getProjetById(Long id);

    ProjetDTO UpdateProjet(Long id, ProjetDTO projetDTO);

    void deleteProjet(Long id);

    List<ProjetDTO> ChercherProjetByIntitule(String intitule);
}
