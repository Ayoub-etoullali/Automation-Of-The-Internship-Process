package ma.enset.gestionStage.services;

import java.util.List;
import java.util.Optional;

import ma.enset.gestionStage.dtos.OffreStageDTO;
import ma.enset.gestionStage.dtos.OffreStageHistoryDTO;
import ma.enset.gestionStage.entities.OffreStage;

public interface OffreStageService {
    List<OffreStageDTO> findAllOffreStage();
    OffreStageDTO findOffreStageById(Long id);
    OffreStageDTO saveOffreStage(OffreStageDTO offreStageDTO);
    OffreStageDTO UpdateOffreStage(Long id, OffreStageDTO offreStageDTO);
    void deleteOffreStageById(Long id);
    List<OffreStageDTO> ChercherOffreStageByPoste(String poste);
    List<OffreStageDTO> ChercherOffreStageByEntreprise(String entreprise);
    List<OffreStageDTO> ChercherOffreStageByTechnologie(String technologie);

    OffreStageHistoryDTO getOffreStageHistory(Long id, int page, int size);
}
