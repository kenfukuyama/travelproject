package com.kenfukuyama.examples.repositories;


import java.util.List;

// curd imports
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

// Domain import
import com.kenfukuyama.examples.models.Book;



// Repository
@Repository
// asking you to implement those queries
public interface BookRepository extends CrudRepository<Book, Long> { // <T (class, book domain model), ID type>
	 // this method retrieves all the books from the database
    List<Book> findAll(); // we need to specify b/c the return type is Iterable();
    
    // this method finds books with descriptions containing the search string
    List<Book> findByDescriptionContaining(String search);
    // this method counts how many titles contain a certain string
    Long countByTitleContaining(String search);
    // this method deletes a book that starts with a specific title
    Long deleteByTitleStartingWith(String search);
	
}
