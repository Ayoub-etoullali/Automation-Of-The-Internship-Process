package ma.enset.gestionStage.mappers;

import ma.enset.gestionStage.dtos.AdminDTO;
import ma.enset.gestionStage.entities.Admin;
import org.springframework.stereotype.Component;

@Component
public class AdminMapperImpl implements AdminMapper {
    @Override
    public AdminDTO adminToDTO(Admin admin) {
        if (admin == null) {
            return null;
        }

        AdminDTO adminDTO = new AdminDTO();
        adminDTO.setId((int) admin.getId());
        adminDTO.setLogin(admin.getLogin());
        // adminDTO.setPassword(null);

        return adminDTO;
    }

    @Override
    public Admin DTOToAdmin(AdminDTO adminDTO) {
        if (adminDTO == null) {
            return null;
        }

        Admin admin = new Admin();
        admin.setId(adminDTO.getId());
        admin.setLogin(adminDTO.getLogin());
        admin.setPassword(adminDTO.getPassword());

        return admin;
    }
}