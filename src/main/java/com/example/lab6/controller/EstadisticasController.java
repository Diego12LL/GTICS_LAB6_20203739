package com.example.lab6.controller;
import com.example.lab6.entity.Sitio;
import com.example.lab6.repository.LocacionRepository;
import com.example.lab6.repository.SitioRepository;
import com.example.lab6.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
public class EstadisticasController {
    @Autowired
    TicketRepository ticketRepository;
    @GetMapping(value = {"/estadisticasSitio"})
    public String estadisticaSitio(Model model) {


        model.addAttribute("listaEstadisticas", ticketRepository.obtenerEstadisticasSitio());
        model.addAttribute("listaSitioMinimo", ticketRepository.obtenerMinimo());

        return "estadisticasTicket";
    }

}


