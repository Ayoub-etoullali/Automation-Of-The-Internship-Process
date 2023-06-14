package ma.enset.gestionStage.services;

import ma.enset.gestionStage.dtos.AdminDTO;
import ma.enset.gestionStage.entities.Admin;
import ma.enset.gestionStage.mappers.AdminMapper;
import ma.enset.gestionStage.repositories.AdminRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {
    private final AdminRepository adminRepository;
    private final AdminMapper adminMapper;

    public AdminServiceImpl(AdminRepository adminRepository, AdminMapper adminMapper) {
        this.adminRepository = adminRepository;
        this.adminMapper = adminMapper;
    }

    @Override
    public AdminDTO getAdminById(int id) {
        Admin admin = adminRepository.findById((long) id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid Admin ID"));
        return adminMapper.adminToDTO(admin);
    }

    @Override
    public List<AdminDTO> getAllAdmins() {
        List<Admin> admins = adminRepository.findAll();
        List<AdminDTO> adminDTOs = null;
        for (Admin admin:admins) {
            adminDTOs.add(adminMapper.adminToDTO(admin));
        }
        return adminDTOs;
    }

    @Override
    public AdminDTO getAdminByLogin(String login) {
        Admin admin = adminRepository.findByLogin(login);
        if (admin == null) {
            throw new IllegalArgumentException("Invalid Admin Login");
        }
        return adminMapper.adminToDTO(admin);
    }

    @Override
    public Admin saveAdmin(Admin admin) {
        return adminRepository.save(admin);
    }

    @Override
    public void saveAdmin(AdminDTO adminDTO) {
        adminRepository.save(adminMapper.DTOToAdmin(adminDTO));
    }
}