package carmencaniglia.bes6p.repositories;

import carmencaniglia.bes6p.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersDAO extends JpaRepository<User, Long> {
}
