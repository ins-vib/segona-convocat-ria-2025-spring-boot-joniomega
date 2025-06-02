package com.hotel.hotel.model;

import java.time.LocalDateTime;

public class Partit {
    private static long idCounter = 0;
    private long id;
    private Equip equipLocal;
    private Equip equipVisitant;
    private LocalDateTime data;
    private int golsLocal;
    private int golsVisitant;
    private int resultatLocal;
    private int resultatVisitant;
/*Victoria = 3 punts, Empat = 1 punt, Derrota = 0 punts*/
    public Partit() {
        this.id = idCounter++;
    }
}
