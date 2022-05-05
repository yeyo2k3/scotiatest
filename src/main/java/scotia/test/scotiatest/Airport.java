
package scotia.test.scotiatest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

import javax.inject.Inject;

import Manager.LandingTrackManager;
import Model.Airplane;
import Model.LandingTrack;
import Model.Status;

public class Airport extends Thread {

  private Queue<Airplane> arrives;

  private Queue<Airplane> takeoff;

  private LandingTrack takeoffTrack;

  private LandingTrack arrivesTrack;

  private LandingTrackManager trackManager;
  public BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

  @Inject
  public Airport() {
    takeoffTrack = new LandingTrack();
    takeoffTrack.setId(new Long(1));
    takeoffTrack.setName("Takeoff");
    Status takeoffStatus = new Status();
    takeoffStatus.setId(new Long(1));
    takeoffStatus.setName("Active");
    takeoffTrack.setStatus(takeoffStatus);

    arrivesTrack = new LandingTrack();
    arrivesTrack.setId(new Long(1));
    arrivesTrack.setName("Takeoff");
    Status arrivesStatus = new Status();
    arrivesTrack.setId(new Long(1));
    arrivesTrack.setName("Active");
    arrivesTrack.setStatus(arrivesStatus);
  }


  public void arrives(Airplane airplane) {
    if (airplane.getId() != null) {
      if (this.validateArrives(airplane)) {
        if (arrives.size() == 0) {
          airplane.activateStatus();
          arrivesTrack.disableTrack();
        } else {
          if (arrivesTrack.getStatus().getId().longValue() == 2) {
            System.out.println("Added to queue");
          } else {
            arrivesTrack.disableTrack();
          }
        }
        arrives.add(airplane);
      } else {
        System.out.println("Airplane are on list");
      }
      System.out.println("Airplanes arriving " + arrives.size());
    }
  }

  public void reportStatus(Airplane airplane) throws IOException {
    System.out.println("Select option to report(1-TakeOff, 2-Arrive)");
    Long option = Long.valueOf(reader.readLine());
    if (option == 1) {
      if (!takeoff.isEmpty()) {
        // validates if arirplane are in the takeoff list
        if (takeoff.stream().filter(c -> c.getId().longValue() == airplane.getId().longValue()).findFirst()
          .orElse(null) != null) {
          if (takeoff.peek().getId().longValue() == airplane.getId().longValue()) {
            takeoff.poll();
            takeoffTrack.enableTrack();
          } else {
            System.out.println("airplane are on queue");
          }
        } else {
          System.out.println("airplane are not listed for taking off");
        }
      } else {
        System.out.println("cannot report taking off the track is empty");
      }
      System.out.println("Airplanes taking off " + takeoff.size());
    } else if (option == 2) {
      if (!arrives.isEmpty()) {
        if (arrives.stream().filter(c -> c.getId().longValue() == airplane.getId().longValue()).findFirst()
          .orElse(null) != null) {
          if (arrives.peek().getId().longValue() == airplane.getId().longValue()) {
            arrives.poll();
            arrivesTrack.enableTrack();
          } else {
            System.out.println("airplane are on queue");
          }
        } else {
          System.out.println("airplane are not listed for arrives");
        }
      } else {
        System.out.println("cannot report arrives because the track is empty");
      }
      System.out.println("Airplanes arriving " + arrives.size());
    }
  }

  @Override
  public void run() {
    this.arrives = new LinkedList<Airplane>();
    this.takeoff = new LinkedList<Airplane>();

    System.out.println("Listen Radio request");
    super.run();
    while (true) {
      try {
        System.out.println("Airplane number");
        String id = reader.readLine();
        System.out.println("Airplane name");
        String name = reader.readLine();
        System.out.println("Airplane Option (1-TakeOff, 2-Arrive, 3-Report Status");
        String option = reader.readLine();
        Airplane airplane = new Airplane();
        airplane.setId(Long.parseLong(id));
        airplane.setName(name);
        switch (Integer.valueOf(option)) {
          case 1:
            this.takeoff(airplane);
            break;
          case 2:
            this.arrives(airplane);
            break;
          case 3:
            this.reportStatus(airplane);
            break;
        }
      } catch (Exception e) {
      }
      try {
        Thread.sleep(1000);
      } catch (Exception e) {
      }
    }
  }

  public void takeoff(Airplane airplane) {
    if (airplane.getId() != null) {
      if (this.validateTakeoff(airplane)) {
        if (takeoff.size() == 0) {
          airplane.activateStatus();
          takeoffTrack.disableTrack();
        } else {
          if (takeoffTrack.getStatus().getId() == 2) {
            System.out.println("Added to queue");
          } else {
            takeoffTrack.disableTrack();
          }
        }
        takeoff.add(airplane);
      } else {
        System.out.println("Airplanes are on list");
      }
    }
    System.out.println("Airplanes taking off " + takeoff.size());
  }

  public boolean validateArrives(Airplane plane) {
    if (arrives.stream().filter(c -> c.getId().longValue() == plane.getId().longValue()).findAny()
      .orElse(null) != null) {
      return false;
    }
    return true;
  }

  public boolean validateTakeoff(Airplane plane) {
    if (takeoff.stream().filter(c -> c.getId().longValue() == plane.getId().longValue()).findAny()
      .orElse(null) != null) {
      return false;
    }
    return true;
  }

}

