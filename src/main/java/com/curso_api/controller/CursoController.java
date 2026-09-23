package com.curso_api.controller;

import com.curso_api.dto.CursoRequestDTO;
import com.curso_api.dto.CursoResponseDTO;
import com.curso_api.service.CursoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/curso")
public class CursoController {

    private final CursoService cursoService;

    public CursoController(CursoService cursoService) {
        this.cursoService = cursoService;
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CursoResponseDTO criar(@Valid @RequestBody CursoRequestDTO dtoRequest) {
        return cursoService.criar(dtoRequest);
    }

    @GetMapping
    public List<CursoResponseDTO> listarTodos() {
        return cursoService.listartodos();
    }

    @GetMapping("/{id}")
    public CursoResponseDTO buscarPorId(@PathVariable Long id){
        return cursoService.buscarPorIdDTO(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        cursoService.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public CursoResponseDTO atualizar(@PathVariable Long id, @Valid @RequestBody CursoRequestDTO cursoRequestDTO){
        return cursoService.atualizar(id, cursoRequestDTO);
    }
}
