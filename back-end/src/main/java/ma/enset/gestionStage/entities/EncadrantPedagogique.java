package ma.enset.gestionStage.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Table(name = "encadrant_pedagogique")
@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class EncadrantPedagogique {
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
    @OneToMany(mappedBy = "EncadrentPedagogique")
    private List<SessionEncadrement> sessionEncadrement;
}