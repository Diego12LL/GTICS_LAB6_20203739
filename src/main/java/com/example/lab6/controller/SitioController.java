package com.example.lab6.controller;

import com.example.lab6.entity.Sitio;
import com.example.lab6.repository.LocacionRepository;
import com.example.lab6.repository.SitioRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
public class SitioController {

    final SitioRepository sitioRepository;
    final LocacionRepository locacionRepository;


    public SitioController(SitioRepository sitioRepository, LocacionRepository locacionRepository) {
        this.sitioRepository = sitioRepository;
        this.locacionRepository=locacionRepository;
    }

    @GetMapping(value = {"/listaSitios"})
    public String listarSitios(Model model) {
        model.addAttribute("listaSitios", sitioRepository.findAll());

        return "listaSitios";
    }


    @GetMapping("/crearSitio")
    public String crearSitio(Model model) {

        model.addAttribute("listaPaises", locacionRepository.findAll());
        return "crearSitio";
    }

    @PostMapping("/guardarSitio")
    public String guardarSitio(Sitio sitio, RedirectAttributes attr) {
        attr.addFlashAttribute("msg", "Sitio creado correctamente");
        sitioRepository.save(sitio);

        return "redirect:/listaSitios";
    }
    @GetMapping("/borrarSitio")
    public String borrarSitio(@RequestParam("id") int id, RedirectAttributes attr) {

        Optional<Sitio> optional = sitioRepository.findById(id);

        if (optional.isPresent()) {

            sitioRepository.deleteById(id);
            attr.addFlashAttribute("msg", "Sitio borrado correctamente");
        }

        return "redirect:/listaSitios";
    }

}
