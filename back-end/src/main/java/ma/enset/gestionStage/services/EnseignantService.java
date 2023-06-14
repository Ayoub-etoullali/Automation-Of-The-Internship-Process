package ma.enset.gestionStage.services;

import ma.enset.gestionStage.dtos.EnseignantDTO;
import java.util.List;

public interface EnseignantService {
    List<EnseignantDTO> getAllEnseignants();
    EnseignantDTO getEnseignantById(Long id);
    EnseignantDTO saveEnseignant(EnseignantDTO enseignantDTO);
    void deleteEnseignantById(Long id);
}