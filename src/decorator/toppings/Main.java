package decorator.toppings;

import decorator.Margareta;
import decorator.VeggieFeast;

public class Main {

    public static void main(String[] args) {
        System.out.println(new Cheese((new ChilliFlakes(new Cheese(new Margareta())))).getPrice());
    }
}
