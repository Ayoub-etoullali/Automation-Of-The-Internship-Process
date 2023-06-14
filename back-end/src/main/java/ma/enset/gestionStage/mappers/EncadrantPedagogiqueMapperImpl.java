package ma.enset.gestionStage.mappers;

import ma.enset.gestionStage.dtos.EncadrantPedagogiqueDTO;
import ma.enset.gestionStage.entities.EncadrantPedagogique;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class EncadrantPedagogiqueMapperImpl implements EncadrantPedagogiqueMapper {

    @Override
    public EncadrantPedagogiqueDTO toDTO(EncadrantPedagogique encadrantPedagogique) {
        if (encadrantPedagogique == null) {
            return null;
        }
        EncadrantPedagogiqueDTO encadrantPedagogiqueDTO = new EncadrantPedagogiqueDTO();
        encadrantPedagogiqueDTO.setId(encadrantPedagogique.getId());
        encadrantPedagogiqueDTO.setNom(encadrantPedagogique.getNom());
        encadrantPedagogiqueDTO.setPrenom(encadrantPedagogique.getPrenom());
        encadrantPedagogiqueDTO.setEmail(encadrantPedagogique.getEmail());
        encadrantPedagogiqueDTO.setCNE(encadrantPedagogique.getCNE());
        encadrantPedagogiqueDTO.setCodeApogee(encadrantPedagogique.getCodeApogee());
        encadrantPedagogiqueDTO.setUsername(encadrantPedagogique.getUsername());
        encadrantPedagogiqueDTO.setPassword(encadrantPedagogique.getPassword());
        encadrantPedagogiqueDTO.setSessionEncadrement(null);
        return encadrantPedagogiqueDTO;
    }

    @Override
    public EncadrantPedagogique toEntity(EncadrantPedagogiqueDTO encadrantPedagogiqueDTO) {
        if (encadrantPedagogiqueDTO == null) {
            return null;
        }
        EncadrantPedagogique encadrantPedagogique = new EncadrantPedagogique();
        encadrantPedagogique.setId(encadrantPedagogiqueDTO.getId());
        encadrantPedagogique.setNom(encadrantPedagogiqueDTO.getNom());
        encadrantPedagogique.setPrenom(encadrantPedagogiqueDTO.getPrenom());
        encadrantPedagogique.setEmail(encadrantPedagogiqueDTO.getEmail());
        encadrantPedagogique.setCNE(encadrantPedagogiqueDTO.getCNE());
        encadrantPedagogique.setCodeApogee(encadrantPedagogiqueDTO.getCodeApogee());
        encadrantPedagogique.setUsername(encadrantPedagogiqueDTO.getUsername());
        encadrantPedagogique.setPassword(encadrantPedagogiqueDTO.getPassword());
        encadrantPedagogique.setSessionEncadrement(null);
        return encadrantPedagogique;
    }

    public List<EncadrantPedagogiqueDTO> toDTOList(List<EncadrantPedagogique> encadrantPedagogiques) {
        return encadrantPedagogiques.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }
}