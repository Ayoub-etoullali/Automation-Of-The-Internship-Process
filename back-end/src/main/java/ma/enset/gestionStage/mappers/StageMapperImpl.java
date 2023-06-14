package ma.enset.gestionStage.mappers;

import lombok.AllArgsConstructor;
import ma.enset.gestionStage.dtos.StageDTO;
import ma.enset.gestionStage.entities.Stage;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
@AllArgsConstructor
public class StageMapperImpl implements StageMapper {
    private EtudiantMapper mapper;
    @Override
    public StageDTO fromStage(Stage stage) {
        StageDTO stageDTO=new StageDTO();
        BeanUtils.copyProperties(stage,stageDTO);
//        stageDTO.setEtudiantDTO(mapper.fromEtudiant(stage.getEtudiant()));
        return stageDTO;
    }

    @Override
    public Stage fromStageDTO(StageDTO stageDTO) {
        Stage stage=new Stage();
        BeanUtils.copyProperties(stageDTO,stage);
//        stage.setEtudiant(mapper.fromEtudiantDTO(stageDTO.getEtudiantDTO()));
        return stage;
    }

}
