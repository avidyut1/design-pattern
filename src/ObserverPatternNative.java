import java.util.ArrayList;
import java.util.List;

interface Subject{
    public void registerObserver(Observer observer);
    public void removeObserver(Observer observer);
    public void notifyObserver();
}
interface Observer {
    public void update();
    public void setSubject(Subject sub);
}
class Blog implements Subject{
    List<Observer> oblist;
    public Blog(){
        this.oblist = new ArrayList<Observer>();
    }
    @Override
    public void registerObserver(Observer observer){
        oblist.add(observer);
    }
    @Override
    public void notifyObserver(){
        for(Observer ob: oblist) {
            ob.update();
        }
    }
    @Override
    public void removeObserver(Observer observer) {
        oblist.remove(observer);
    }
    public void postArticle(){
        notifyObserver();
    }
}

class User implements Observer {
    Subject blog;
    public User(){

    }
    @Override
    public void setSubject(Subject blog) {
        this.blog = blog;
    }
    @Override
    public void update(){
        System.out.println("update called");
    }
}
public class ObserverPatternNative {
    public static void main(String[] args) {
        Blog blog = new Blog();
        User u1 = new User();
        User u2 = new User();
        blog.registerObserver(u1);
        blog.registerObserver(u2);
        u1.setSubject(blog);
        u2.setSubject(blog);
        blog.postArticle();
        //update called twice from each observer
    }
}
