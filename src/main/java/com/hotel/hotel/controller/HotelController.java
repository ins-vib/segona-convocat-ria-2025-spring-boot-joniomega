package com.hotel.hotel.controller;

import com.hotel.hotel.model.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Controller
public class HotelController {
    private List<Equip> equips = new ArrayList<>();
    private List<Partit> partits = new ArrayList<>();
    private List<Jugador> jugadors = new ArrayList<>();

    @GetMapping("/")
    public String principal(Model model) {
        model.addAttribute("equips", equips);
        model.addAttribute("partits", partits);
        model.addAttribute("jugadors", jugadors);
        return "principal";
    }

    @PostMapping("/equip/nou")
    public String nouEquip(@RequestParam String nom) {
        Equip equip = new Equip();
        equip.setNom(nom);
        equips.add(equip);
        return "redirect:/";
    }

    @PostMapping("/jugador/nou")
    public String nouJugador(@RequestParam String nom, @RequestParam String posicio, @RequestParam long equipId) {
        Jugador jugador = new Jugador();
        jugador.setNom(nom);
        jugador.setPosicio(posicio);
        jugadors.add(jugador);
        
        equips.stream()
              .filter(e -> e.getId() == equipId)
              .findFirst()
              .ifPresent(e -> e.afegirJugadors(jugador));
        
        return "redirect:/";
    }

    @PostMapping("/partit/nou")
    public String nouPartit(@RequestParam long equipLocalId, 
                           @RequestParam long equipVisitantId,
                           @RequestParam String data) {
        Equip equipLocal = equips.stream().filter(e -> e.getId() == equipLocalId).findFirst().orElse(null);
        Equip equipVisitant = equips.stream().filter(e -> e.getId() == equipVisitantId).findFirst().orElse(null);
        
        if (equipLocal != null && equipVisitant != null) {
            Partit partit = new Partit();
            partit.setEquipLocal(equipLocal);
            partit.setEquipVisitant(equipVisitant);
            partit.setData(LocalDateTime.parse(data));
            partits.add(partit);
        }
        
        return "redirect:/";
    }

    @PostMapping("/partit/resultat")
    public String actualitzarResultat(@RequestParam long partitId,
                                    @RequestParam int golsLocal,
                                    @RequestParam int golsVisitant) {
        partits.stream()
               .filter(p -> p.getId() == partitId)
               .findFirst()
               .ifPresent(p -> {
                   p.setGolsLocal(golsLocal);
                   p.setGolsVisitant(golsVisitant);
                   p.setResultatLocal(golsLocal > golsVisitant ? 3 : golsLocal == golsVisitant ? 1 : 0);
                   p.setResultatVisitant(golsVisitant > golsLocal ? 3 : golsLocal == golsVisitant ? 1 : 0);
               });
        
        return "redirect:/";
    }

    @GetMapping("/partit/{id}")
    public String veurePartit(@PathVariable long id, Model model) {
        partits.stream()
               .filter(p -> p.getId() == id)
               .findFirst()
               .ifPresent(p -> model.addAttribute("partit", p));
        return "partit";
    }
}
