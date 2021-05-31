package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.model.Author;
import guru.springframework.spring5webapp.model.Book;
import guru.springframework.spring5webapp.model.Publisher;
import guru.springframework.spring5webapp.repository.AuthorRepository;
import guru.springframework.spring5webapp.repository.BookRepository;
import guru.springframework.spring5webapp.repository.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Publisher pub1 = new Publisher("Orielly", "2870 Kaiser Dr", "San Francisco",  "California", 95050);
        Book book1 = new Book( "Introduction to Algorithms","fjkwe23");
        Book book2 = new Book("Let us C", "dfjkwr34");
        Author auth1 = new Author("Thomas","Cormen" );
        Author auth2 = new Author("Balaguru","Swamy" );

        auth1.getBooks().add(book1);
        auth2.getBooks().add(book2);
        book1.getAuthors().add(auth1);
        book1.setPublisher(pub1);
        book2.getAuthors().add(auth2);
        book2.setPublisher(pub1);
        pub1.getBooks().add(book1);
        pub1.getBooks().add(book2);

        authorRepository.save(auth2);
        bookRepository.save(book2);
        authorRepository.save(auth1);
        bookRepository.save(book1);
        publisherRepository.save(pub1);
        System.out.println(auth1);
        System.out.println(book2);
        System.out.println(book1);

        System.out.println(bookRepository.count());
        System.out.println(authorRepository.count());
        System.out.println(publisherRepository.count());

    }
}
