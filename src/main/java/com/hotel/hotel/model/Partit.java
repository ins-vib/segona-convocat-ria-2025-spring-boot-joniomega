package com.hotel.hotel.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Partit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
   
    @ManyToOne
    @JoinColumn(name = "equip_local_id")
    private Equip equipLocal;
    
    
    @ManyToOne
    @JoinColumn(name = "equip_visitant_id")
    private Equip equipVisitant;
    
   
    private LocalDateTime data;
    
    private Integer golsLocal;
    private Integer golsVisitant;
    private Integer resultatLocal;
    private Integer resultatVisitant;
/*Victoria = 3 punts, Empat = 1 punt, Derrota = 0 apunts*/
    
   
    

    public Partit() {}

    public Partit(LocalDateTime data, Equip equipLocal, Equip equipVisitant) {
        if (equipLocal.getId() == equipVisitant.getId()) {
            throw new IllegalArgumentException("Els equips han de ser diferents");
        }
        this.data = data;
        this.equipLocal = equipLocal;
        this.equipVisitant = equipVisitant;
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
        if (equipVisitant != null && equipLocal.getId() == equipVisitant.getId()) {
            throw new IllegalArgumentException("Els equips han de ser diferents");
        }
        this.equipLocal = equipLocal;
    }

    public Equip getEquipVisitant() {
        return equipVisitant;
    }

    public void setEquipVisitant(Equip equipVisitant) {
        if (equipLocal != null && equipVisitant.getId() == equipLocal.getId()) {
            throw new IllegalArgumentException("Els equips han de ser diferents");
        }
        this.equipVisitant = equipVisitant;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public Integer getGolsLocal() {
        return golsLocal;
    }

    public void setGolsLocal(Integer golsLocal) {
        this.golsLocal = golsLocal;
    }

    public Integer getGolsVisitant() {
        return golsVisitant;
    }

    public void setGolsVisitant(Integer golsVisitant) {
        this.golsVisitant = golsVisitant;
    }

    public Integer getResultatLocal() {
        return resultatLocal;
    }

    public void setResultatLocal(Integer resultatLocal) {
        this.resultatLocal = resultatLocal;
    }

    public Integer getResultatVisitant() {
        return resultatVisitant;
    }

    public void setResultatVisitant(Integer resultatVisitant) {
        this.resultatVisitant = resultatVisitant;
    }
}
