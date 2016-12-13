package com.gboz.javaworkout.test;

import java.util.Date;

/**
 * Created by Grzegorz on 02.12.2016.
 */
public class Kot {
    String imie;
    Date dataUrodzenia;
    Double waga;
    String imieOpiekuna;

    Kot(String imie, Date dataUrodzenia, Double waga, String imieOpiekuna) {
        this.imie = imie;
        this.dataUrodzenia = dataUrodzenia;
        this.waga = waga;
        this.imieOpiekuna = imieOpiekuna;
    }

    String przedstawSie() {
        return this.imie + "\n" + this.dataUrodzenia + "\n" + this.waga + "\n" + this.imieOpiekuna;
    }
}
