

package Manager;

import Model.LandingTrack;

public interface LandingTrackManager {

  public void delete(LandingTrack track);

  public LandingTrack getLandingTrack(Long id);

  public LandingTrack save(LandingTrack track);


}
