package ma.enset.gestionStage.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "offres_stages")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OffreStage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String poste;
    private String entreprise;
    private String description;
    private Date dateDebut;
    private Date dateFin;
    private String technologie;
    @ManyToOne
    private Admin admin;
    @ManyToOne
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Etudiant etudiant;

}
