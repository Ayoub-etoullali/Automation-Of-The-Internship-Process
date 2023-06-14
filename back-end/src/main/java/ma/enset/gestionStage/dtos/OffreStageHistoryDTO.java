package ma.enset.gestionStage.dtos;

import lombok.Data;
import java.util.List;

@Data
public class OffreStageHistoryDTO {
    private Long id;
    private int currentPage;
    private int totalPage;
    private int sizePage;
    List<OffreStageDTO> offreStageDTOS;

}
