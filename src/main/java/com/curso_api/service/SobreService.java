package com.curso_api.service;

import com.curso_api.dto.SobreResponseDTO;
import org.springframework.stereotype.Service;

@Service
public class SobreService {

    public SobreResponseDTO buscarSobre() {
        return new SobreResponseDTO(
                "Sobre nós",
                "Somos uma plataforma de cursos dedicada ao desenvolvimento de profissionais na área de tecnologia."
        );
    }
}