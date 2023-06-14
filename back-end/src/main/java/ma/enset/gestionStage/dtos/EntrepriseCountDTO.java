package ma.enset.gestionStage.dtos;
import lombok.AllArgsConstructor;
import lombok.Data;
import ma.enset.gestionStage.entities.Entreprise;

@Data
@AllArgsConstructor
public class EntrepriseCountDTO {
    private Entreprise enterprise;
    private Long count;
}