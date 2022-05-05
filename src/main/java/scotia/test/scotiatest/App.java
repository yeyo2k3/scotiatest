package scotia.test.scotiatest;

/**
 * Hello world!
 */
public class App {

  public static void main(String[] args) {
    App obj = new App();
    obj.startAirport();
  }

  public void startAirport() {
    Airport data = new Airport();
    data.run();
  }
}
