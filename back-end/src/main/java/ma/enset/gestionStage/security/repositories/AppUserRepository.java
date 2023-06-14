package ma.enset.gestionStage.security.repositories;
import ma.enset.gestionStage.security.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
public interface AppUserRepository extends JpaRepository<AppUser, Long> {
    AppUser findAppUserByUsername(String username);
}