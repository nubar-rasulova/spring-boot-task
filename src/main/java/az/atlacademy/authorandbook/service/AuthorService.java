package az.atlacademy.authorandbook.service;

import az.atlacademy.authorandbook.dto.AuthorDTO;

import java.util.List;

public interface AuthorService {

    AuthorDTO save(AuthorDTO authorDto);

    AuthorDTO getById(Long id);

    List<AuthorDTO> getAll();

    void delete(Long id);

}
