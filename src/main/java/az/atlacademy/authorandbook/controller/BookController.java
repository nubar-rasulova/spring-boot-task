package az.atlacademy.authorandbook.controller;
import az.atlacademy.authorandbook.dto.BookDTO;
import az.atlacademy.authorandbook.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;

    @RestController
    @RequestMapping("/api/v1/books")
    public class BookController {
        private final BookService bookService;

        public BookController(BookService bookService) {
            this.bookService = bookService;
        }

        @PostMapping
        public ResponseEntity<BookDTO> createBook(@Validated @RequestBody BookDTO bookDto) {
            return ResponseEntity.ok(bookService.save(bookDto));
        }

        @GetMapping("/{id}")
        public ResponseEntity<BookDTO> getBook(@PathVariable Long id) {
            return ResponseEntity.ok(bookService.getById(id));
        }

        @GetMapping
        public ResponseEntity<List<BookDTO>> getAllBooks() {
            return ResponseEntity.ok(bookService.getAll());
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
            bookService.delete(id);
            return ResponseEntity.noContent().build();
        }
    }


