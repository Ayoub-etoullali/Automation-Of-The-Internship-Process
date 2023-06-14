package ma.enset.gestionStage.security.services;
import ma.enset.gestionStage.security.entities.AppRole;
import ma.enset.gestionStage.security.entities.AppUser;
import java.util.List;
public interface AccountService {
    AppUser addNewUser(AppUser appUser);
    AppRole addNewRole(AppRole appRole);
    void addRoleToUser(String username, String rolename);
    AppUser loadUserByUsername(String username);
    List<AppUser> listUsers();
}