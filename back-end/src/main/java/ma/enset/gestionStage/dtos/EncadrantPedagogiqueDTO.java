package ma.enset.gestionStage.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.enset.gestionStage.entities.SessionEncadrement;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EncadrantPedagogiqueDTO {
    private Long id;
    private String nom;
    private String prenom;
    private String email;
    private String CNE;
    private String codeApogee;
    private String username;
    private String password;
    private List<SessionEncadrement> sessionEncadrement;
}