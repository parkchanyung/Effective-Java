package chapter02.item02.hierachicalbuilder;

import static chapter02.item02.hierachicalbuilder.NyPizza.Size.SMALL;
import static chapter02.item02.hierachicalbuilder.Pizza.Topping.*;

public class PizzaTest {
    public static void main(String[] args) {
        NyPizza pizza = new NyPizza.Builder(SMALL)
                                   .addToping(SAUSAGE)
                                   .addToping(ONION)
                                   .build();

        Calzone calzone = new Calzone.Builder()
                                     .addToping(HAM)
                                     .sauceInside()
                                     .build();
    }
}
