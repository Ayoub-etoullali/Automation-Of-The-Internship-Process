package ma.enset.gestionStage.entities;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Soutenance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;

    public void setID(Long id) {
        this.ID = id;
    }

    public Long getID() {
        return ID;
    }


    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private  Date Date_soutenance;

    private  int heure;

    private String lieu;


    @ManyToMany
    private List<Enseignant>  enseignants;

    @OneToOne
    private Stage stage;
}