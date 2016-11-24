interface Icecream{
    public String makeIceCream();
}
class SimpleIcecream implements Icecream{
    @Override
    public String makeIceCream(){
        return "Base icecream";
    }
}
class IceCreamDecorator implements Icecream{
    protected Icecream sp;
    public IceCreamDecorator(Icecream spi) {
        this.sp = spi;
    }
    public String makeIceCream(){
        return this.sp.makeIceCream();
    }
}
class NuttyDecorator extends IceCreamDecorator{
    public NuttyDecorator(Icecream sp) {
        super(sp);
    }
    public String makeIceCream(){
        return sp.makeIceCream() + addNuts();
    }
    public String addNuts(){
        return " Crunchy nuts";
    }
}
class HoneyDecorator extends IceCreamDecorator{
    public HoneyDecorator(Icecream sp) {
        super(sp);
    }
    public String makeIceCream(){
        return sp.makeIceCream() + addHoney();
    }
    public String addHoney(){
        return " honey";
    }
}
public class DecoratorPattern {
    public static void main(String[] args) {
        Icecream ic = new HoneyDecorator(new NuttyDecorator(new SimpleIcecream()));
        System.out.println(ic.makeIceCream());
    }
}
