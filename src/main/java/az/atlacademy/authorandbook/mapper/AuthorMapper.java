package az.atlacademy.authorandbook.mapper;

import az.atlacademy.authorandbook.dto.AuthorDTO;
import az.atlacademy.authorandbook.entity.AuthorEntity;
import org.springframework.stereotype.Component;


@Component
public class AuthorMapper {
    public AuthorDTO toDto(AuthorEntity entity) {
        AuthorDTO dto = new AuthorDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setSurname(entity.getSurname());
        return dto;
    }

    public AuthorEntity toEntity(AuthorDTO dto) {
        AuthorEntity entity = new AuthorEntity();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setSurname(dto.getSurname());
        return entity;
    }
}
