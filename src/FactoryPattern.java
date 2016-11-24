interface Phone{
    public int batteryPower();
    public int cost();
}
class Lenovo implements Phone{
    public int batteryPower(){
        return 1000;
    }
    public int cost(){
        return 3000;
    }
}
class Samsung implements Phone{
    public int batteryPower(){
        return 10;
    }
    public int cost(){
        return 30;
    }
}
class MobileFactory{
    public MobileFactory(){

    }
    public Phone getMobile(String type) {
        if(type == "lenovo") {
            return new Lenovo();
        }
        else {
            return new Samsung();
        }
    }
}
public class FactoryPattern {
    public static void main(String[] args) {
        MobileFactory mf = new MobileFactory();
        Phone len = mf.getMobile("lenovo");
        Phone sam = mf.getMobile("sam");
        System.out.println(len.cost());
        System.out.println(sam.batteryPower());
    }

}
