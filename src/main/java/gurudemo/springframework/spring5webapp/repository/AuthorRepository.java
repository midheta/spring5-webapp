package gurudemo.springframework.spring5webapp.repository;

import gurudemo.springframework.spring5webapp.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {


}
