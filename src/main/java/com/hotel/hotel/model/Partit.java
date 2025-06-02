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
/*Victoria = 3 punts, Empat = 1 punt, Derrota = 0 apunts*/
    
   
    

    public Partit() {
        this.id = idCounter++;
    }
    public static long getIdCounter() {
        return idCounter;
    }
    public static void setIdCounter(long idCounter) {
        Partit.idCounter = idCounter;
    }

    public Partit(LocalDateTime data, Equip equipLocal, Equip equipVisitant, int golsLocal, int golsVisitant, long id, int resultatLocal, int resultatVisitant) {
        this.data = data;
        this.equipLocal = equipLocal;
        this.equipVisitant = equipVisitant;
        this.golsLocal = golsLocal;
        this.golsVisitant = golsVisitant;
        this.id = id;
        this.resultatLocal = resultatLocal;
        this.resultatVisitant = resultatVisitant;
    }

    
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public Equip getEquipLocal() {
        return equipLocal;
    }
    public void setEquipLocal(Equip equipLocal) {
        this.equipLocal = equipLocal;
    }
    public Equip getEquipVisitant() {
        return equipVisitant;
    }
    public void setEquipVisitant(Equip equipVisitant) {
        this.equipVisitant = equipVisitant;
    }
    public LocalDateTime getData() {
        return data;
    }
    public void setData(LocalDateTime data) {
        this.data = data;
    }
    public int getGolsLocal() {
        return golsLocal;
    }
    public void setGolsLocal(int golsLocal) {
        this.golsLocal = golsLocal;
    }
    public int getGolsVisitant() {
        return golsVisitant;
    }
    public void setGolsVisitant(int golsVisitant) {
        this.golsVisitant = golsVisitant;
    }
    public int getResultatLocal() {
        return resultatLocal;
    }
    public void setResultatLocal(int resultatLocal) {
        this.resultatLocal = resultatLocal;
    }
    public int getResultatVisitant() {
        return resultatVisitant;
    }
    public void setResultatVisitant(int resultatVisitant) {
        this.resultatVisitant = resultatVisitant;
    }

}
