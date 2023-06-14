package ma.enset.gestionStage.dtos;

import lombok.Data;

import java.util.Date;

@Data
public class PostesDTO {
    private Long id;
    private String titre;
    private String autheur;
    private String description;
    private Date date;
    private String tag;
}
