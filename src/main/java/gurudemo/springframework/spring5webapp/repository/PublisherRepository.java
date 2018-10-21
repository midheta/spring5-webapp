package gurudemo.springframework.spring5webapp.repository;

import gurudemo.springframework.spring5webapp.model.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
