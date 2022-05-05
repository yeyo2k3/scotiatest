

package Manager.impl;

import Dao.LandingTrackDAO;
import Manager.LandingTrackManager;
import Model.LandingTrack;


public class LandingTrackManagerImpl implements LandingTrackManager {

  private LandingTrackDAO dao;


  public LandingTrackManagerImpl(LandingTrackDAO dao) {
    super();
    this.dao = dao;
  }

  public void delete(LandingTrack track) {
    dao.delete(track);
  }

  public LandingTrack getLandingTrack(Long id) {

    return dao.getById(id);
  }

  public LandingTrack save(LandingTrack track) {

    return dao.save(track);
  }

}
