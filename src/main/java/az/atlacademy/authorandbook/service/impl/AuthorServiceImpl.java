package az.atlacademy.authorandbook.service.impl;

import az.atlacademy.authorandbook.dto.AuthorDTO;
import az.atlacademy.authorandbook.entity.AuthorEntity;
import az.atlacademy.authorandbook.exception.ResourceNotFoundException;
import az.atlacademy.authorandbook.mapper.AuthorMapper;
import az.atlacademy.authorandbook.repository.AuthorRepository;
import az.atlacademy.authorandbook.service.AuthorService;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class AuthorServiceImpl implements AuthorService {
    private static final Logger logger = LoggerFactory.getLogger(AuthorServiceImpl.class);
    private final AuthorRepository authorRepository;
    private final AuthorMapper authorMapper;

    public AuthorServiceImpl(AuthorRepository authorRepository, AuthorMapper authorMapper) {
        this.authorRepository = authorRepository;
        this.authorMapper = authorMapper;
    }

    @Override
    public AuthorDTO save(AuthorDTO authorDto) {
        logger.info("Saving author: {}", authorDto);
        AuthorEntity entity = authorMapper.toEntity(authorDto);
        AuthorDTO savedAuthor = authorMapper.toDto(authorRepository.save(entity));
        logger.info("Author saved successfully with ID: {}", savedAuthor.getId());
        return savedAuthor;
    }

    @Override
    public AuthorDTO getById(Long id) {
        logger.info("Fetching author with ID: {}", id);
        return authorRepository.findById(id)
                .map(authorMapper::toDto)
                .orElseThrow(() -> {
                    logger.error("Author not found with ID: {}", id);
                    return new ResourceNotFoundException("Author not found");
                });
    }

    @Override
    public List<AuthorDTO> getAll() {
        logger.info("Fetching all authors");
        return authorRepository.findAll()
                .stream()
                .map(authorMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        logger.info("Deleting author with ID: {}", id);
        if (!authorRepository.existsById(id)) {
            logger.error("Author not found with ID: {}", id);
            throw new ResourceNotFoundException("Author not found");
        }
        authorRepository.deleteById(id);
        logger.info("Author with ID: {} deleted successfully", id);
    }
}


