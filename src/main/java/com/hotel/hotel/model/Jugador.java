package com.hotel.hotel.model;

public class Jugador {
    private static long idCounter = 0;
    private long id;
    private String nom;
    private String posicio;

    public Jugador() {
        this.id = idCounter++;
    }
    
    public Jugador(long id, String nom, String posicio) {
        this();
        this.id = id;
        this.nom = nom;
        this.posicio = posicio;
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getPosicio() {
        return posicio;
    }
    public void setPosicio(String posicio) {
        this.posicio = posicio;
    }


}
