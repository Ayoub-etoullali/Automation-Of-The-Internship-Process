package ma.enset.gestionStage.dtos;

import lombok.Data;

@Data
public class ProjetDTO {
    private Long id;
    private String intitule;
    private String description;
    private String path;
    private StageDTO stageDTO;

}
