package com.curso_api.controller;

import com.curso_api.dto.SobreResponseDTO;
import com.curso_api.service.SobreService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/sobre")
public class SobreController {

    private final SobreService sobreService;

    public SobreController(SobreService sobreService) {
        this.sobreService = sobreService;
    }

    @GetMapping
    public SobreResponseDTO buscarSobre() {
        return sobreService.buscarSobre();
    }
}