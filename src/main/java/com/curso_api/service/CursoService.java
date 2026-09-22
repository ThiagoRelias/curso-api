package com.curso_api.service;

import com.curso_api.dto.CursoRequestDTO;
import com.curso_api.dto.CursoResponseDTO;
import com.curso_api.entity.Curso;
import com.curso_api.entity.Instrutor;
import com.curso_api.mapper.CursoMapper;
import com.curso_api.repository.CursoRepository;
import com.curso_api.repository.InstrutorRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CursoService {

    private final CursoRepository cursoRepository;
    private final InstrutorRepository instrutorRepository;
    private final CursoMapper cursoMapper;

    public CursoService(CursoRepository cursoRepository, InstrutorRepository instrutorRepository, CursoMapper cursoMapper) {
        this.cursoRepository = cursoRepository;
        this.instrutorRepository = instrutorRepository;
        this.cursoMapper = cursoMapper;
    }

    @Transactional(readOnly = true)
    public List<CursoResponseDTO> listartodos() {
        return cursoRepository.findAll()
                .stream()
                .map(cursoMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public Curso buscarPorId(Long id) {
        return cursoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Curso não encontrado com o ID: " + id));
    }

    @Transactional(readOnly = true)
    public CursoResponseDTO buscarPorIdDTO(Long id) {
        return cursoMapper.toResponse(buscarPorId(id));
    }

    @Transactional
    public void deletar(Long id) {
        Curso curso = buscarPorId(id);
        cursoRepository.delete(curso);
    }

    @Transactional
    public CursoResponseDTO criar(CursoRequestDTO cursoRequestDTO) {
        Instrutor instrutor = instrutorRepository.findById(cursoRequestDTO.instrutorID())
                .orElseThrow(() -> new RuntimeException("Instrutor não encontrado"));

        Curso curso = cursoMapper.toEntity(cursoRequestDTO);
        curso.setInstrutor(instrutor);

        return cursoMapper.toResponse(cursoRepository.save(curso));
    }

    @Transactional
    public CursoResponseDTO atualizar(Long cursoId, CursoRequestDTO cursoRequestDTO){
        Curso curso = buscarPorId(cursoId);

        Instrutor instrutor = instrutorRepository.findById(cursoRequestDTO.instrutorID())
                .orElseThrow(() -> new RuntimeException("Instrutor não encontrado"));

        cursoMapper.update(cursoRequestDTO, curso);

        curso.setInstrutor(instrutor);

        return cursoMapper.toResponse(cursoRepository.save(curso));
    }
}
