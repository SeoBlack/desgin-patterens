public class Observer implements Subscriber {
    private int observerID = 0;
    static int observers = 0;
    private int temperature;
    public Observer() {
        observers += 1;
        this.observerID = observers;


    }
    @Override
    public void update(int  temperature) {
        this.temperature = temperature;
        System.out.println("Observer " + this.observerID + " received WeatherStation: " + this.temperature + "C");
    }
}
