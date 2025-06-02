package com.hotel.hotel.controller;

import com.hotel.hotel.model.*;
import com.hotel.hotel.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class HotelController {
    @Autowired
    private EquipRepository equipRepository;
    
    @Autowired
    private JugadorRepository jugadorRepository;
    
    @Autowired
    private PartitRepository partitRepository;

    @GetMapping("/")
    public String principal(Model model) {
        model.addAttribute("equips", equipRepository.findAll());
        model.addAttribute("partits", partitRepository.findAll());
        model.addAttribute("jugadors", jugadorRepository.findAll());
        model.addAttribute("posicions", Jugador.Posicio.values());
        return "principal";
    }

    @PostMapping("/equip/nou")
    public String nouEquip(@RequestParam String nom, RedirectAttributes redirectAttributes) {
        Equip equip = new Equip(nom);
        equipRepository.save(equip);
        return "redirect:/";
    }

    @PostMapping("/jugador/nou")
    public String nouJugador(@RequestParam String nom, 
                            @RequestParam Jugador.Posicio posicio, 
                            @RequestParam long equipId,
                            RedirectAttributes redirectAttributes) {
        Equip equip = equipRepository.findById(equipId).get();
        Jugador jugador = new Jugador(nom, posicio);
        equip.afegirJugadors(jugador);
        jugadorRepository.save(jugador);
        equipRepository.save(equip);
        return "redirect:/";
    }

    @PostMapping("/partit/nou")
    public String nouPartit(@RequestParam long equipLocalId, 
                           @RequestParam long equipVisitantId,
                           @RequestParam String data,
                           RedirectAttributes redirectAttributes) {
        Equip equipLocal = equipRepository.findById(equipLocalId).get();
        Equip equipVisitant = equipRepository.findById(equipVisitantId).get();
        LocalDateTime dataPartit = LocalDateTime.parse(data);
        Partit partit = new Partit(dataPartit, equipLocal, equipVisitant);
        partitRepository.save(partit);
        return "redirect:/";
    }

    @PostMapping("/partit/resultat")
    public String actualitzarResultat(@RequestParam long partitId,
                                    @RequestParam int golsLocal,
                                    @RequestParam int golsVisitant,
                                    RedirectAttributes redirectAttributes) {
        Partit partit = partitRepository.findById(partitId).get();
        partit.setGolsLocal(golsLocal);
        partit.setGolsVisitant(golsVisitant);
        partit.setResultatLocal(golsLocal > golsVisitant ? 3 : golsLocal == golsVisitant ? 1 : 0);
        partit.setResultatVisitant(golsVisitant > golsLocal ? 3 : golsLocal == golsVisitant ? 1 : 0);
        partitRepository.save(partit);
        return "redirect:/";
    }

    @GetMapping("/partit/{id}")
    public String veurePartit(@PathVariable long id, Model model) {
        Partit partit = partitRepository.findById(id).get();
        model.addAttribute("partit", partit);
        return "partit";
    }
}
