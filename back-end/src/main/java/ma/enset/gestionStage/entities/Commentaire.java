package ma.enset.gestionStage.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Commentaire {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Livrable livrable;

    private String texte;

    private LocalDateTime date;

    //Commentaires de l'encadrant une section pour que l'encadrant
    // puisse laisser des commentaires et des remarques sur les livrables
    // soumis par l'étudiant, ainsi que sur l'avancement général de l'étudiant
    // pendant la période de stage.


}
