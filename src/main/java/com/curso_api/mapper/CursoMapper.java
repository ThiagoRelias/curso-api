package com.curso_api.mapper;

import com.curso_api.dto.CursoRequestDTO;
import com.curso_api.dto.CursoResponseDTO;
import com.curso_api.entity.Curso;
import com.curso_api.repository.CursoRepository;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface CursoMapper {

    @Mapping(source = "instrutor.nome", target = "instrutorNome")
    CursoResponseDTO toResponse(Curso curso);

    @Mapping(target ="instrutor", ignore = true)
    @Mapping(target = "id", ignore = true)
    Curso toEntity(CursoRequestDTO cursoRequestDTO);

    @Mapping(target = "id", ignore = true)
    @Mapping(target ="instrutor", ignore = true)
    void update(CursoRequestDTO dto, @MappingTarget Curso curso);

}
