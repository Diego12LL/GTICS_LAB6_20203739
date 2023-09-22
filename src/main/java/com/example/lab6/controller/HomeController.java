package com.example.lab6.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller

public class HomeController {

    @RequestMapping(value = {""})
    public String pagInicial() {
        return "paginaInicial";
    }
}