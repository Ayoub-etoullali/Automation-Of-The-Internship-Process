package ma.enset.gestionStage.mappers;

import lombok.AllArgsConstructor;
import ma.enset.gestionStage.dtos.PostesDTO;
import ma.enset.gestionStage.entities.Postes;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PostesMapperImpl implements PostesMapper {
    @Override
    public PostesDTO fromPostes(Postes postes) {
        PostesDTO postesDTO=new PostesDTO();
        BeanUtils.copyProperties(postes, postesDTO);
        return postesDTO;
    }
    @Override
    public Postes fromPostesDTO(PostesDTO postesDTO) {
        Postes postes=new Postes();
        BeanUtils.copyProperties(postesDTO, postes);
        return postes;
    }

}
