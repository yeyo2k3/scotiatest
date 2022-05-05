
package Dao;

import Model.Airplane;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AirplaneDAO extends JpaRepository<Airplane, Long> {

}
