package com.kenfukuyama.examples.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.kenfukuyama.examples.models.Book;
import com.kenfukuyama.examples.repositories.BookRepository;

@Service
public class BookService {
	// adding the book repository as a dependency
    private final BookRepository bookRepository;
    
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    
    // implementing all the methods defined
    // returns all the books
    public List<Book> allBooks() {
        return bookRepository.findAll();
    }
    
    // creates a book
    public Book createBook(Book b) {
        return bookRepository.save(b);
    }
    
    
    // update a book
    public Book updateBook(Long id, String title, String desc ,String lang, Integer numOfPages) {
    	Optional<Book> optionalBook = bookRepository.findById(id);
    	Book b;
        if(optionalBook.isPresent()) {
        	b =  optionalBook.get();
        	b.setTitle(title);
        	b.setDescription(desc);
        	b.setLanguage(lang);
        	b.setNumberOfPages(numOfPages);
        	
        } else {
        	// create new ones
           b = new Book(title, desc, lang, numOfPages);
           
        }
       // save afterwards
        return bookRepository.save(b);
    }
    
    
    public Book updateBook(Book book) {
    	
//    	Optional<Book> optionalBook = bookRepository.findById(book.getId());
//    	Book b;
//        if(optionalBook.isPresent()) {
//        	b =  optionalBook.get();
//        	b.setTitle(title);
//        	b.setDescription(desc);
//        	b.setLanguage(lang);
//        	b.setNumberOfPages(numOfPages);
//        	
//        } else {
//        	// create new ones
//           b = new Book(title, desc, lang, numOfPages);
//           
//        }
       // save afterwards
        return bookRepository.save(book);
    }
    
    
    
    
    // retrieves a book
    public Book findBook(Long id) {
    	// Optional Book that may or may not conatin Book
        Optional<Book> optionalBook = bookRepository.findById(id);
        if(optionalBook.isPresent()) {
            return optionalBook.get();
        } else {
            return null;
        }
    }
    
    
    // Delete a book
    public void deleteBook(Long id) {
    	bookRepository.deleteById(id);
    	return;
    }
    

}
