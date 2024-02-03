package decorator.toppings;

import decorator.BasePizza;

public class ChilliFlakes extends ToppingDecorator {
    BasePizza pizza;
    public ChilliFlakes(BasePizza pizza) {
        this.pizza = pizza;
    }

    @Override
    public double getPrice() {
        return pizza.getPrice() + 5;
    }
}
