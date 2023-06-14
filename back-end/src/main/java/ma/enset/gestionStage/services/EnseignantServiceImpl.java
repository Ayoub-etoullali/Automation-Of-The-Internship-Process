package ma.enset.gestionStage.services;

import ma.enset.gestionStage.dtos.EnseignantDTO;
import ma.enset.gestionStage.entities.Enseignant;
import ma.enset.gestionStage.mappers.EnseignantMapper;
import ma.enset.gestionStage.repositories.EnseignantRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class EnseignantServiceImpl implements EnseignantService {

    private final EnseignantRepository enseignantRepository;
    private final EnseignantMapper enseignantMapper;

    public EnseignantServiceImpl(EnseignantRepository enseignantRepository, EnseignantMapper enseignantMapper) {
        this.enseignantRepository = enseignantRepository;
        this.enseignantMapper = enseignantMapper;
    }

    @Override
    public List<EnseignantDTO> getAllEnseignants() {
        List<Enseignant> enseignants = enseignantRepository.findAll();
        return enseignantMapper.toDTOList(enseignants);
    }

    @Override
    public EnseignantDTO getEnseignantById(Long id) {
        Enseignant enseignant = enseignantRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Enseignant with id " + id + " not found"));
        return enseignantMapper.toDTO(enseignant);
    }

    @Override
    public EnseignantDTO saveEnseignant(EnseignantDTO enseignantDTO) {
        Enseignant enseignant = enseignantMapper.toEntity(enseignantDTO);
        enseignant = enseignantRepository.save(enseignant);
        return enseignantMapper.toDTO(enseignant);
    }

    @Override
    public void deleteEnseignantById(Long id) {
        enseignantRepository.deleteById(id);
    }

}