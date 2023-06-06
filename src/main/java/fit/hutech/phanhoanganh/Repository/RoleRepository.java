package fit.hutech.phanhoanganh.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import fit.hutech.phanhoanganh.model.Role;
public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByName(String name);
}