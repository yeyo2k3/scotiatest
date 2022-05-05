

package Manager;

import Model.Airplane;

public interface AirplaneManager {

  public void delete(Airplane plane);

  public Airplane getAirplane(Long id);

  public Airplane save(Airplane plane);


}
