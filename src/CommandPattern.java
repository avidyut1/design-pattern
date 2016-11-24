import java.io.*;
import java.util.*;
import java.math.*;

interface Command{
    public void execute();
}
class Lunch{
    public void makeLunch(){
        System.out.println("lunch ready");
    }
}
class LunchCommand implements Command{
    Lunch l;
    public LunchCommand(Lunch la) {
        this.l = la;
    }
    public void execute(){
        l.makeLunch();
    }
}
class MealInvoker {
    Command c;
    public MealInvoker(Command command){
        this.c = command;
    }
    public void invoke(){
        c.execute();
    }
}
public class CommandPattern {
    public static void main(String args[]) {
        try {
            Command l = new LunchCommand(new Lunch());
            MealInvoker mi = new MealInvoker(l);
            mi.invoke();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
