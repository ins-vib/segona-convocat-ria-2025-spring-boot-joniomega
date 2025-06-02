package com.hotel.hotel.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Equip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    
    private String nom;
    
    @OneToMany(mappedBy = "equip", cascade = CascadeType.ALL)
    private List<Jugador> jugadors = new ArrayList<>();

    public Equip() {}

    public Equip(String nom) {
        this.nom = nom;
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
        jugador.setEquip(this);
        this.jugadors.add(jugador);
    }

    public void eliminarJugadorPerId(long id) {
        this.jugadors.removeIf(p -> p.getId() == id);
    }
}
