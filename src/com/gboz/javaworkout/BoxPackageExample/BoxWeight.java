package com.gboz.javaworkout.BoxPackageExample;

/**
 * Created by Grzegorz on 12.10.2016.
 */
class BoxWeight extends Box {
    double weight;

    BoxWeight(BoxWeight ob) {
        super(ob);
        weight = ob.weight;
    }

    BoxWeight(double w, double h, double d, double m) {
        super(w, h, d);
        weight = m;
    }

    BoxWeight() {
        super();
        weight = 0;
    }

    BoxWeight(double len, double m) {
        super(len);
        weight = m;
    }
}
