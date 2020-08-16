package Items;

public class Element extends Item {

    //PT general classification
    int number;
    String symbol;
    //String name; //inherited by item
    double weight;

    //location
    int period;
    int group;

    int state; //default state at 20C / 273K
    //0 = unknown, 1 = solid, 2 = liquid, 3 = gas, 4 = plasma, 5 = bose-einstein
    //String groupName; //determined by the registry

    //temps: in Celsius
    int melting; //solid -> liquid
    int boiling; //liquid -> gas

    public Element(int period, int number, String symbol, String name, double weight) {
        super(name);
        this.period = period; //file will contain this info, but not the group
        this.number = number;
        this.symbol = symbol;
        this.weight = weight;
        this.state = 1; //defaults to solid, can be changed later
    }

    public void setGroup(int group) {
        this.group = group;
    }

    public void changeState(int state) {
        this.state = state;
    }

    public void addTemps(int melting, int boiling) {
        this.melting = melting;
        this.boiling = boiling;
    }

    //period, number, symbol, name, weight
    //1: H, Hydrogen, 1, 1.008
    public void print() {
        System.out.println(this.period + ": " + this.symbol + ", " + this.name + ", " + this.number + ", " + this.weight);
    }
}