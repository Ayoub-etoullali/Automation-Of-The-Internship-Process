package ma.enset.gestionStage.services;

import ma.enset.gestionStage.dtos.OffreDeStageDTO;
import ma.enset.gestionStage.dtos.OffreDeStageDetailsDTO;
import ma.enset.gestionStage.entities.OffreDeStage;
import ma.enset.gestionStage.mappers.OffreDeStageDetailsMapper;
import ma.enset.gestionStage.mappers.OffreDeStageMapper;
import ma.enset.gestionStage.repositories.OffreDeStageRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OffreDeStageServiceImpl implements OffreDeStageService {
    private final OffreDeStageRepository offreDeStageRepository;
    private final OffreDeStageMapper offreDeStageMapper;
    private final OffreDeStageDetailsMapper offreDeStageDetailsMapper;

    public OffreDeStageServiceImpl(OffreDeStageRepository offreDeStageRepository,
                                 OffreDeStageMapper offreDeStageMapper,
                                 OffreDeStageDetailsMapper offreDeStageDetailsMapper) {
        this.offreDeStageRepository = offreDeStageRepository;
        this.offreDeStageMapper = offreDeStageMapper;
        this.offreDeStageDetailsMapper = offreDeStageDetailsMapper;
    }

    @Override
    public List<OffreDeStageDTO> getAllOffreDeStages() {
        List<OffreDeStage> offreDeStages = offreDeStageRepository.findAll();
        return offreDeStages.stream()
                .map(offreDeStageMapper::offreDeStageToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public OffreDeStageDTO getOffreDeStageById(Long id) {
        OffreDeStage offreDeStage = offreDeStageRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid OffreDeStage ID"));
        return offreDeStageMapper.offreDeStageToDTO(offreDeStage);
    }

    @Override
    public OffreDeStageDetailsDTO getOffreDeStageDetailsById(Long id) {
        OffreDeStage offreDeStage = offreDeStageRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid OffreDeStage ID"));
        return offreDeStageDetailsMapper.offreDeStageToDetailsDTO(offreDeStage);
    }

    @Override
    public OffreDeStageDTO createOffreDeStage(OffreDeStageDTO offreDeStageDTO) {
        OffreDeStage offreDeStage = offreDeStageMapper.DTOToOffreDeStage(offreDeStageDTO);
        offreDeStage.setValidated(false);
        OffreDeStage savedOffreDeStage = offreDeStageRepository.save(offreDeStage);
        return offreDeStageMapper.offreDeStageToDTO(savedOffreDeStage);
    }

    @Override
    public OffreDeStageDTO updateOffreDeStage(Long id, OffreDeStageDTO offreDeStageDTO) {
        OffreDeStage existingOffreDeStage = offreDeStageRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid OffreDeStage ID"));
        OffreDeStage updatedOffreDeStage = offreDeStageMapper.DTOToOffreDeStage(offreDeStageDTO);
        updatedOffreDeStage.setId(existingOffreDeStage.getId());
        OffreDeStage savedOffreDeStage = offreDeStageRepository.save(updatedOffreDeStage);
        return offreDeStageMapper.offreDeStageToDTO(savedOffreDeStage);
    }

    @Override
    public void deleteOffreDeStage(Long id) {
        offreDeStageRepository.deleteById(id);
    }

    @Override
    public List<OffreDeStageDTO> searchOffreDeStages(String keyword) {
        List<OffreDeStage> offreDeStages = offreDeStageRepository.findByPosteContainingIgnoreCase(keyword);
        return offreDeStages.stream()
                .map(offreDeStageMapper::offreDeStageToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<OffreDeStageDTO> filterOffreDeStagesByDate(Date date) {
        List<OffreDeStage> offreDeStages = offreDeStageRepository.findByDateDebutGreaterThanEqual(date);
        return offreDeStages.stream()
                .map(offreDeStageMapper::offreDeStageToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public OffreDeStageDTO validateOffreDeStage(Long id) {
        OffreDeStage offreDeStage = offreDeStageRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("OffreDeStage with ID " + id + " not found"));
        offreDeStage.setValidated(true);
        OffreDeStage updatedOffreDeStage = offreDeStageRepository.save(offreDeStage);
        return offreDeStageMapper.offreDeStageToDTO(updatedOffreDeStage);
    }

    @Override
    public List<OffreDeStageDTO> getOffreDeStagesByEntreprise(String entreprise) {
        List<OffreDeStage> offreDeStages = offreDeStageRepository.findByEntrepriseIgnoreCase(entreprise);
        return offreDeStageMapper.offreDeStageListToDTOList(offreDeStages);
    }

    @Override
    public OffreDeStage saveOffreDeStage(OffreDeStage offreDeStage) {
        return offreDeStageRepository.save(offreDeStage);
    }

    @Override
    public void saveOffreDeStage(OffreDeStageDTO offreDeStageDTO) {
        offreDeStageDTO.setValidated(false);
        offreDeStageRepository.save(offreDeStageMapper.DTOToOffreDeStage(offreDeStageDTO));
    }

    @Override
    public List<OffreDeStageDTO> getNonValidatedOffers() {
        List<OffreDeStage> nonValidatedOffers = offreDeStageRepository.findByValidatedFalse();
        return offreDeStageMapper.offreDeStageListToDTOList(nonValidatedOffers);
    }
}