import java.io.*;
import java.util.*;

class WeatherData extends Observable {
    private float temprature;
    public WeatherData(float temp){
        this.temprature = temp;
    }
    public void setValue(float t) {
        this.temprature = t;
        setChanged();
        notifyObservers();
    }
    public float getValue() {
        return temprature;
    }
}
class WeatherReport implements Observer{
    Observable ob = null;
    float temp;
    public WeatherReport(Observable ob) {
        this.ob = ob;
        ob.addObserver(this);
    }
    public void update(Observable obs, Object ar) {
        if (obs instanceof WeatherData) {
            WeatherData wd = (WeatherData) obs;
            this.temp = wd.getValue();
            display();
        }
    }
    public void display(){
        System.out.println(temp + " is the temperature");
    }
}
public class ObserverPattern {
    public static void main(String[] args) {
        WeatherData wd = new WeatherData(99.9f);
        WeatherReport wr = new WeatherReport(wd);
        wd.setValue(98.9f);
    }
}
