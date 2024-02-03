package decorator.toppings;

import decorator.BasePizza;

public class Cheese extends ToppingDecorator{

    private BasePizza pizza;

    public Cheese(BasePizza pizza) {
        this.pizza = pizza;
    }

    @Override
    public double getPrice() {
        return pizza.getPrice() + 14;
    }
}
