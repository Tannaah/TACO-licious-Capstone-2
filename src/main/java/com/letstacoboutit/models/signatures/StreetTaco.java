package com.letstacoboutit.models.signatures;

import com.letstacoboutit.models.Taco;
import com.letstacoboutit.models.Topping;
import com.letstacoboutit.models.ToppingCategory;

public class StreetTaco extends Taco {

    public StreetTaco() {
        super("3-Taco Plate", "corn", false);

        addTopping(new Topping("carne asada", ToppingCategory.MEAT, false, 1.00));
        addTopping(new Topping("onions", ToppingCategory.VEGGIE, false, 0));
        addTopping(new Topping("cilantro", ToppingCategory.VEGGIE, false, 0));
        addTopping(new Topping("salsa verde", ToppingCategory.SAUCE, false, 0));
        addTopping(new Topping("lime wedges", ToppingCategory.OTHER, false, 0));
    }
}