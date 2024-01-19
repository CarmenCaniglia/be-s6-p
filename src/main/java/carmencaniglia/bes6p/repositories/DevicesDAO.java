package carmencaniglia.bes6p.repositories;

import carmencaniglia.bes6p.entities.Device;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface DevicesDAO extends JpaRepository<Device,Long> {
}
