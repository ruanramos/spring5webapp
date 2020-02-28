package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
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

        Publisher panini = new Publisher("panini", "No name street", "Rio de Janeiro", "Rio de Janeiro", "23523523632");
        publisherRepository.save(panini);

        Author ruan = new Author("Ruan", "Ramos");
        Book hr1 = new Book("Harry Potter 1", "24122352");
        ruan.getBooks().add(hr1);
        hr1.getAuthors().add(ruan);

        hr1.setPublisher(panini);
        panini.getBooks().add(hr1);

        authorRepository.save(ruan);
        bookRepository.save(hr1);
        publisherRepository.save(panini);


        Author igor = new Author("Igor", "Ramos");
        Book literature = new Book("Literature for dummies", "3523527");
        igor.getBooks().add(literature);
        literature.getAuthors().add(igor);

        literature.setPublisher(panini);
        panini.getBooks().add(literature);

        authorRepository.save(igor);
        bookRepository.save(literature);
        publisherRepository.save(panini);

        Author joao = new Author("joao", "silva");
        Book book1 = new Book("book 1", "246528251");
        Book book2 = new Book("book 2", "24125128512");
        Book book3 = new Book("book 3", "24652851251");
        joao.getBooks().add(book1);
        joao.getBooks().add(book2);
        joao.getBooks().add(book3);
        book1.getAuthors().add(joao);
        book2.getAuthors().add(joao);
        book3.getAuthors().add(joao);
        book1.setPublisher(panini);
        book2.setPublisher(panini);
        book3.setPublisher(panini);
        panini.getBooks().add(book1);
        panini.getBooks().add(book2);
        panini.getBooks().add(book3);

        authorRepository.save(joao);
        bookRepository.save(book1);
        bookRepository.save(book2);
        bookRepository.save(book3);

        System.out.println("Started in Bootstrap");
        System.out.println("Number of Books: " + bookRepository.count());
        System.out.println("Number of Authors: " + authorRepository.count());
        System.out.println("Number of Publishers: " + publisherRepository.count());
        System.out.println("Publishers: " + publisherRepository.findAll());
        System.out.println("Authors: " + authorRepository.findAll());
        System.out.println("Books: " + bookRepository.findAll());

    }
}
