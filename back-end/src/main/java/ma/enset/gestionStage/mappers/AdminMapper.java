package ma.enset.gestionStage.mappers;

import ma.enset.gestionStage.dtos.AdminDTO;
import ma.enset.gestionStage.entities.Admin;

public interface AdminMapper {
    AdminDTO adminToDTO(Admin admin);
    Admin DTOToAdmin(AdminDTO adminDTO);
}