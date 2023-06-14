package ma.enset.gestionStage.services;

import ma.enset.gestionStage.dtos.EncadrantPedagogiqueDTO;
import java.util.List;

public interface EncadrantPedagogiqueService {
    List<EncadrantPedagogiqueDTO> getAllEncadrantsPedagogiques();
    EncadrantPedagogiqueDTO getEncadrantPedagogiqueById(Long id);
    EncadrantPedagogiqueDTO saveEncadrantPedagogique(EncadrantPedagogiqueDTO encadrantPedagogiqueDTO);
    void deleteEncadrantPedagogiqueById(Long id);
    public List<EncadrantPedagogiqueDTO> getAllEncadrants();
    public EncadrantPedagogiqueDTO getEncadrantById(Long id);
}