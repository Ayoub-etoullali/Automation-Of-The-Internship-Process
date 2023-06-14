package ma.enset.gestionStage.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Table(name = "enseignant")
@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Enseignant {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String nom;
        private String prenom;
        private String email;
        private  String CNE;
        private String codeApogee;
        private  String username;
        private String password;
        private boolean responsableFiliere;
        private boolean responsableDepartement;
        @ManyToOne
        private Filiere filiere;
        @ManyToOne
        private Departement departement;
        @ManyToMany(fetch = FetchType.LAZY)
        private List<Soutenance> soutenances;

}
