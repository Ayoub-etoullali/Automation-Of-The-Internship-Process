package ma.enset.gestionStage.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.enset.gestionStage.dtos.EtudiantDTO;
import ma.enset.gestionStage.entities.Etudiant;
import ma.enset.gestionStage.mappers.EtudiantMapper;
import ma.enset.gestionStage.repositories.EtudiantRepository;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class EtudiantServiceImpl implements EtudiantService {
    private EtudiantRepository etudiantRepository;
    private EtudiantMapper mapper;

    public EtudiantDTO createEtudiant(EtudiantDTO etudiantDTO) {
        Etudiant etudiant = mapper.fromEtudiantDTO(etudiantDTO);
        Etudiant etudiant1=etudiantRepository.save(etudiant);
        return mapper.fromEtudiant(etudiant1);
    }

    public List<EtudiantDTO> getAllEtudiants() {
        List<Etudiant> etudiants = etudiantRepository.findAll();
        List<EtudiantDTO> etudiantDTOS = etudiants
                .stream()
                .map(etudiant -> mapper.fromEtudiant(etudiant))
                .collect(Collectors.toList()); //String to list
        return etudiantDTOS;
    }

    public EtudiantDTO getEtudiantById(Long id) {
        return mapper.fromEtudiant(etudiantRepository.findById(id).orElse(null));
    }

    public EtudiantDTO updateEtudiant(Long id, EtudiantDTO newEtudiantDTO) {
        Etudiant etudiant = mapper.fromEtudiantDTO(newEtudiantDTO);
        Etudiant save = etudiantRepository.save(etudiant);
        return mapper.fromEtudiant(save);
        /*
        Optional<Etudiant> optionalEtudiant = etudiantRepository.findById(id);
        if (optionalEtudiant.isPresent()) {
            Etudiant existingEtudiant = optionalEtudiant.get();
            existingEtudiant.setNom(newEtudiant.getNom());
            existingEtudiant.setPrenom(newEtudiant.getPrenom());
            existingEtudiant.setEmail(newEtudiant.getEmail());
            existingEtudiant.setTelephone(newEtudiant.getTelephone());
            return etudiantRepository.save(existingEtudiant);
        } else {
            return null;
        }
         */
    }

    public void deleteEtudiantById(Long id) {
        etudiantRepository.deleteById(id);
    }

    public EtudiantDTO ChercherEtudiantByCNE(String cne) {
        return mapper.fromEtudiant(etudiantRepository.searchEtudiantByCNE(cne));
    }

}
