package gurudemo.springframework.spring5webapp.repository;

import gurudemo.springframework.spring5webapp.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
