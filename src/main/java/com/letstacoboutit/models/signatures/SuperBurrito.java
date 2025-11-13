package com.letstacoboutit.models.signatures;

import com.letstacoboutit.models.Taco;
import com.letstacoboutit.models.Topping;
import com.letstacoboutit.models.ToppingCategory;

public class SuperBurrito extends Taco {

    public SuperBurrito() {
        super("Burrito", "flour", false);

        addTopping(new Topping("carnitas", ToppingCategory.MEAT, false, 1.00));
        addTopping(new Topping("cheddar", ToppingCategory.CHEESE, false, 0.75));
        addTopping(new Topping("pico de gallo", ToppingCategory.VEGGIE, false, 0));
        addTopping(new Topping("lettuce", ToppingCategory.VEGGIE, false, 0));
        addTopping(new Topping("tomatoes", ToppingCategory.VEGGIE, false, 0));
        addTopping(new Topping("birria dipped", ToppingCategory.SAUCE, false, 0));
    }
}