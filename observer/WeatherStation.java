import java.util.ArrayList;
import java.util.Random;

public class WeatherStation extends Thread {
    public int temperature;
    public ArrayList<Subscriber> subscribers = new ArrayList<>();
    public WeatherStation()
    {
        changeTemperature();
    }

    public void notifySubscribers(){
        for (Subscriber s : subscribers){
            s.update(this.temperature);
        }

    }
    public void changeTemperature()
    {
        int baseTemp = 20;
        Random rand = new Random();
        //get random increase or decrease in the temperature
        this.temperature = baseTemp + rand.nextInt(-2, 2) ; //this will return random number between -1,1 so final result would be either 19, 20 or 21.
        this.notifySubscribers(); // after we changed the temperature, we notify the subscribers
    }
    public void addSubscriber(Subscriber subscriber)
    {
        this.subscribers.add(subscriber);
    }
    public  void removeSubscriber(Subscriber subscriber)
    {
        this.subscribers.remove(subscriber);
    }
    public void run()
    {
        Random rand = new Random();
        while(true)
        {
            int sleepTime = rand.nextInt(5) * 1000; //get random sleep time.
            try
            {
                this.changeTemperature(); //the notification is handled inside the function itself :)
                Thread.sleep(sleepTime);
            }
            catch (InterruptedException e)
            {
                System.out.println(e.getMessage());
            }
        }
    }

}