class Singleton{
    private static Singleton instance = new Singleton();
    private Singleton(){
        System.out.println("creating");
    }
    public static Singleton getInstance(){
        return instance;
    }
    public void test(){
        System.out.println("hi");
    }
}
public class SingletonPattern {
    public static void main(String[] args) {
        try{
            Singleton ob = Singleton.getInstance();
            ob.test();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
