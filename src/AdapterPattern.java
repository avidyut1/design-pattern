import java.io.*;
import java.util.*;
import java.math.*;

class Apple{
    public void getAppleColor(String color){
        System.out.println("APple color is "+color);
    }
}
class Orange{
    public void getOrangeColor(String color){
        System.out.println("Orange color is "+color);
    }
}
//adapt an orange as an apple
class AppleAdapter extends Apple{
    private Orange oran;
    public AppleAdapter(Orange o){
        this.oran = o;
    }
    public void getColor(String color){
        oran.getOrangeColor(color);
    }
}
public class AdapterPattern {
    public static void main(String args[]) {
        try {
            Apple apple1 = new Apple();
            apple1.getAppleColor("green");
            Orange orange = new Orange();
            AppleAdapter apple2 = new AppleAdapter(orange);
            apple2.getColor("orange");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
