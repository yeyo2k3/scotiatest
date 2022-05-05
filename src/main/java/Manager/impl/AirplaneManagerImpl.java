

package Manager.impl;

import javax.inject.Inject;

import Dao.AirplaneDAO;
import Manager.AirplaneManager;
import Model.Airplane;


public class AirplaneManagerImpl implements AirplaneManager {

  private AirplaneDAO dao;


  @Inject
  public AirplaneManagerImpl(AirplaneDAO dao) {
    super();
    this.dao = dao;
  }

  public void delete(Airplane plane) {
    dao.delete(plane);
  }

  public Airplane getAirplane(Long id) {

    return dao.getById(id);
  }

  public Airplane save(Airplane plane) {

    return dao.save(plane);
  }

}
