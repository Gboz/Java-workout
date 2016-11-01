package com.gboz.javaworkout.appletTest;

import java.applet.Applet;
import java.awt.*;

/*
<applet code+"SimpleApplet" width="200" height="60"></applet>
 */
public class SimpleApplet extends Applet {
    public void paint(Graphics graphics) {
        graphics.drawString("Prosty aplet", 20, 20);
    }

}
