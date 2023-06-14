package ma.enset.gestionStage.mappers;

import lombok.AllArgsConstructor;
import ma.enset.gestionStage.dtos.EtudiantDTO;
import ma.enset.gestionStage.entities.Etudiant;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
@AllArgsConstructor
public class EtudiantMapperImpl implements EtudiantMapper {
//    private  StageMapper mapper;
    @Override
    public EtudiantDTO fromEtudiant(Etudiant etudiant) {
        EtudiantDTO etudiantDTO=new EtudiantDTO();
        BeanUtils.copyProperties(etudiant,etudiantDTO);
//        etudiantDTO.setStage(mapper.fromStage(etudiant.getStage()));
        return etudiantDTO;
    }

    @Override
    public Etudiant fromEtudiantDTO(EtudiantDTO etudiantDTO) {
        Etudiant etudiant=new Etudiant();
        BeanUtils.copyProperties(etudiantDTO,etudiant);
//        etudiant.setStage(mapper.fromStageDTO(etudiantDTO.getStage()));
        return etudiant;
    }
}
