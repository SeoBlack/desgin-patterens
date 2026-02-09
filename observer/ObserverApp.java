public class ObserverApp {
    public static void main(String[] args) {
    WeatherStation station = new WeatherStation();
    Observer obs1 = new Observer();
    Observer obs2 = new Observer();
    Observer obs3 = new Observer();
    Observer obs4 = new Observer();
    Observer obs5 = new Observer();

    station.addSubscriber(obs1);
    station.addSubscriber(obs2);
    station.addSubscriber(obs3);
    station.addSubscriber(obs4);
    station.addSubscriber(obs5);

    station.run();
    }
}
