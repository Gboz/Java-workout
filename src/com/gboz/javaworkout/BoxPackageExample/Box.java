package com.gboz.javaworkout.BoxPackageExample;

/**
 * Created by Grzegorz on 12.10.2016.
 */
class Box {
    private double width;
    private double height;
    private double depth;

    Box(Box ob) {
        width = ob.width;
        height = ob.height;
        depth = ob.depth;
    }

    Box(double w, double h, double d) {
        width = w;
        height = h;
        depth = d;
    }

    Box() {
        width = 0;
        height = 0;
        depth = 0;
    }

    Box(double len) {
        width = height = depth = len;
    }

    double volume() {
        return width * height * depth;
    }

}
