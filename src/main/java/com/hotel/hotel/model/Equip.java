package com.hotel.hotel.model;

import java.util.ArrayList;
import java.util.List;

public class Equip {
    private static long idCounter = 0;
    private long id;
    private String nom;
    private List<Jugador> jugadors = new ArrayList<>();

    public Equip() {
        this.id = idCounter++;
    }

    public Equip(long id, String nom) {
        this.id = id;
        this.nom = nom;
    }

    public static long getIdCounter() {
        return idCounter;
    }
    public static void setIdCounter(long idCounter) {
        Equip.idCounter = idCounter;
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
    public List<Jugador> getJugadors() {
        return jugadors;
    }
    public void setJugadors(List<Jugador> jugadors) {
        this.jugadors = jugadors;
    }
    public void afegirJugadors(Jugador jugador) {
        this.jugadors.add(jugador);
    }
    public void eliminarJugadorPerId(long id) {
        this.jugadors.removeIf(p -> p.getId() == id);
    }
}
