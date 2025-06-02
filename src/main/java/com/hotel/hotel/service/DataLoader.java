package com.hotel.hotel.service;

import com.hotel.hotel.model.*;
import org.springframework.stereotype.Service;
import org.springframework.core.io.ClassPathResource;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class DataLoader {
    private List<Equip> equips = new ArrayList<>();
    private List<Jugador> jugadors = new ArrayList<>();
    private List<Partit> partits = new ArrayList<>();

    public void loadData() {
        try {
            ClassPathResource resource = new ClassPathResource("data/example_data.txt");
            BufferedReader reader = new BufferedReader(new InputStreamReader(resource.getInputStream()));
            String line;

            while ((line = reader.readLine()) != null) {
                if (line.startsWith("#") || line.trim().isEmpty()) continue;

                String[] parts = line.split(":");
                switch (parts[0]) {
                    case "Equip":
                        Equip equip = new Equip(Long.parseLong(parts[1]), parts[2]);
                        equips.add(equip);
                        break;
                    case "Jugador":
                        Jugador jugador = new Jugador(Long.parseLong(parts[1]), parts[2], parts[3]);
                        jugadors.add(jugador);
                        equips.stream()
                              .filter(e -> e.getId() == Long.parseLong(parts[4]))
                              .findFirst()
                              .ifPresent(e -> e.afegirJugadors(jugador));
                        break;
                    case "Partit":
                        Equip equipLocal = equips.stream()
                                               .filter(e -> e.getId() == Long.parseLong(parts[4]))
                                               .findFirst()
                                               .orElse(null);
                        Equip equipVisitant = equips.stream()
                                                  .filter(e -> e.getId() == Long.parseLong(parts[5]))
                                                  .findFirst()
                                                  .orElse(null);
                        
                        if (equipLocal != null && equipVisitant != null) {
                            Partit partit = new Partit(
                                LocalDateTime.parse(parts[3]),
                                equipLocal,
                                equipVisitant,
                                Integer.parseInt(parts[6]),
                                Integer.parseInt(parts[7]),
                                Long.parseLong(parts[1]),
                                Integer.parseInt(parts[8]),
                                Integer.parseInt(parts[9])
                            );
                            partits.add(partit);
                        }
                        break;
                }
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Equip> getEquips() {
        return equips;
    }

    public List<Jugador> getJugadors() {
        return jugadors;
    }

    public List<Partit> getPartits() {
        return partits;
    }
} 