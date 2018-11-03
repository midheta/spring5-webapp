package gurudemo.springframework.spring5webapp.bootstrap;

import gurudemo.springframework.spring5webapp.model.Author;
import gurudemo.springframework.spring5webapp.model.Book;
import gurudemo.springframework.spring5webapp.model.Publisher;
import gurudemo.springframework.spring5webapp.repository.AuthorRepository;
import gurudemo.springframework.spring5webapp.repository.BookRepository;
import gurudemo.springframework.spring5webapp.repository.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository,
                        PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }


    public void initData() {

        Author eric = new Author("Eric", "Evans");
        Publisher harper = new Publisher("Harper Collins", "Address 123");
        publisherRepository.save(harper);
        Book ddd = new Book("Domain Driven Design", "1234", harper);

        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(ddd);

        Author rod = new Author("Rod", "Johnson");
        Publisher worx = new Publisher("Worx", "Address 234");
        publisherRepository.save(worx);
        Book noEJB = new Book("J2EE Development without EJB", "2344", worx);
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        authorRepository.save(rod);
        bookRepository.save(noEJB);
    }
}
