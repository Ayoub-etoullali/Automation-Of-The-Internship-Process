package ma.enset.gestionStage.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.enset.gestionStage.dtos.OffreStageDTO;
import ma.enset.gestionStage.dtos.OffreStageHistoryDTO;
import ma.enset.gestionStage.entities.OffreStage;
import ma.enset.gestionStage.mappers.OffreStageMapper;
import ma.enset.gestionStage.repositories.OffreStageRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class OffreStageServiceImpl implements OffreStageService {
    private OffreStageRepository offreStageRepository;
    private OffreStageMapper mapper;

    public List<OffreStageDTO> findAllOffreStage() {
        List<OffreStage> offreStages =  offreStageRepository.findAll();
        List<OffreStageDTO> offreStageDTOS = offreStages
                .stream()
                .map(offreStage -> mapper.fromOffreStage(offreStage))
                .collect(Collectors.toList()); //String to list
        return offreStageDTOS;
    }

    public OffreStageDTO findOffreStageById(Long id) {
        return mapper.fromOffreStage(offreStageRepository.findById(id).orElse(null));
    }

    public OffreStageDTO saveOffreStage(OffreStageDTO offreStageDTO) {
        OffreStage offreStage=mapper.fromOffreStageDTO(offreStageDTO);
        OffreStage save = offreStageRepository.save(offreStage);
        return mapper.fromOffreStage(save);
    }

    public OffreStageDTO UpdateOffreStage(Long id, OffreStageDTO offreStageDTO) {
        OffreStage offreStage = mapper.fromOffreStageDTO(offreStageDTO);
        return mapper.fromOffreStage(offreStageRepository.save(offreStage));
        /*
        Optional<OffreStage> optionalOffreStage = offreStageRepository.findById(id);
        if (optionalOffreStage.isPresent()) {
            OffreStage offreStage = optionalOffreStage.get();
            offreStage.setPoste(NewoffreStage.getPoste());
            offreStage.setEntreprise(NewoffreStage.getEntreprise());
            offreStage.setDescription(NewoffreStage.getDescription());
            offreStage.setDateDebut(NewoffreStage.getDateDebut());
            offreStage.setDateFin(NewoffreStage.getDateFin());
            offreStage.setTechnologie(NewoffreStage.getTechnologie());
            return offreStageRepository.save(offreStage);
        } else {
            return null;
        }
         */
    }

    public void deleteOffreStageById(Long id) {
        offreStageRepository.deleteById(id);
    }

    public List<OffreStageDTO> ChercherOffreStageByPoste(String poste) {
        List<OffreStage> offreStages =  offreStageRepository.searchOffreStageByPoste(poste);
        List<OffreStageDTO> offreStageDTOS = offreStages
                .stream()
                .map(offreStage -> mapper.fromOffreStage(offreStage))
                .collect(Collectors.toList()); //String to list
        return offreStageDTOS;
    }

    public List<OffreStageDTO> ChercherOffreStageByEntreprise(String entreprise) {
        List<OffreStage> offreStages =  offreStageRepository.searchOffreStageByEntreprise(entreprise);
        List<OffreStageDTO> offreStageDTOS = offreStages
                .stream()
                .map(offreStage -> mapper.fromOffreStage(offreStage))
                .collect(Collectors.toList()); //String to list
        return offreStageDTOS;
    }

    public List<OffreStageDTO> ChercherOffreStageByTechnologie(String technologie) {
        List<OffreStage> offreStages =  offreStageRepository.searchOffreStageByTechnologie(technologie);
        List<OffreStageDTO> offreStageDTOS = offreStages
                .stream()
                .map(offreStage -> mapper.fromOffreStage(offreStage))
                .collect(Collectors.toList()); //String to list
        return offreStageDTOS;
    }

    @Override
    public OffreStageHistoryDTO getOffreStageHistory(Long id, int page, int size) {
        OffreStage offreStage = offreStageRepository.findById(id).orElse(null);
        Page<OffreStage> offreStageById = offreStageRepository.findOffreStageById(id, PageRequest.of(page, size));

        OffreStageHistoryDTO offreStageHistoryDTO = new OffreStageHistoryDTO();
        List<OffreStageDTO> accountOperationDTOS = offreStageById
                .getContent()
                .stream()
                .map(
                        accountOperation -> mapper.fromOffreStage(accountOperation)
                )
                .collect(Collectors.toList());
        offreStageHistoryDTO.setOffreStageDTOS(accountOperationDTOS);
        offreStageHistoryDTO.setId(offreStage.getId());
        offreStageHistoryDTO.setSizePage(size);
        offreStageHistoryDTO.setTotalPage(offreStageById.getTotalPages());
        offreStageHistoryDTO.setCurrentPage(page);
        return offreStageHistoryDTO;
    }

}
