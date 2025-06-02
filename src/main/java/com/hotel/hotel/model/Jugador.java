package com.hotel.hotel.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;


@Entity
public class Jugador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
   
    private String nom;
    
    
    @Enumerated(EnumType.STRING)
    private Posicio posicio;
    
    @ManyToOne
    @JoinColumn(name = "equip_id")
    private Equip equip;

    public enum Posicio {
        DELANTER, MIGCAMPISTA, DEFENSA, PORTER
    }

    public Jugador() {}
    
    public Jugador(String nom, Posicio posicio) {
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

    public Posicio getPosicio() {
        return posicio;
    }

    public void setPosicio(Posicio posicio) {
        this.posicio = posicio;
    }

    public Equip getEquip() {
        return equip;
    }

    public void setEquip(Equip equip) {
        this.equip = equip;
    }
}
