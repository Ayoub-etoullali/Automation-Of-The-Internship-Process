package ma.enset.gestionStage.security.repositories;
import ma.enset.gestionStage.security.entities.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;
public interface AppRoleRepository extends JpaRepository<AppRole, Long> {
    AppRole findAppRoleByRoleName(String username);
}