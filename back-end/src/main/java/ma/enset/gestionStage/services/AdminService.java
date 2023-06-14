package ma.enset.gestionStage.services;

import ma.enset.gestionStage.dtos.AdminDTO;
import ma.enset.gestionStage.entities.Admin;

import java.util.List;

public interface AdminService {
    AdminDTO getAdminById(int id);
    List<AdminDTO> getAllAdmins();
    AdminDTO getAdminByLogin(String login);
    Admin saveAdmin(Admin admin);
    void saveAdmin(AdminDTO adminDTO);
}