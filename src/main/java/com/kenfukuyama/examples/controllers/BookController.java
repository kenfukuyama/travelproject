
package com.kenfukuyama.examples.controllers;


import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kenfukuyama.examples.models.Book;
import com.kenfukuyama.examples.services.BookService;

@Controller // this will return .jsp
public class BookController {
	
//	@Autowired
//	BookService bookService; // depency injection
	
	private final BookService bookService;
    
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }
	

    // new book routes
    @GetMapping("/books/new")
    public String newBook( @ModelAttribute("book") Book book) {
    	return "newBook.jsp";
    	
    	    
    }
    	
    
    @PostMapping("/books")
    public String create(@Valid @ModelAttribute("book") Book book, BindingResult result)      {
          
    	// CODE TO MAKE A NEW BOOK AND SAVE TO THE DB
    	if (result.hasErrors()) {
    		return "newBook.jsp";
    	}
		bookService.createBook(book);
        return "redirect:/books";
    }
    
    // get all books
    @GetMapping("/books")
    public String books(Model model) {
        List<Book> books = bookService.allBooks();
        model.addAttribute("books", books);
        return "books.jsp";
    }
    
    
    // create books
//    @PostMapping("/books")
//    public String create(
//        @RequestParam("title") String title,
//        @RequestParam("description") String description,
//        @RequestParam("language") String language,
//        @RequestParam("pages") Integer pages) 
//    {
//        // CODE TO MAKE A NEW BOOK AND SAVE TO THE DB
//        Book book = new Book(title, description, language, pages);
//        bookService.createBook(book);
//        return "redirect:/books";
//    }
    
    

    
  
	@GetMapping("/books/{bookId}")
	public String bookHome(@PathVariable("bookId") Long bookId, Model model) {
		
//		System.out.println(bookId);
		Book book = bookService.findBook(bookId);
//		System.out.println(book);
		
		model.addAttribute("book", book);
		
		
		List<Book> books = bookService.allBooks();
		model.addAttribute("books", books);
		
	
		return "show.jsp";
	}	
	
	
	// edit page
	@RequestMapping("/books/{id}/edit")
    public String edit(@PathVariable("id") Long id, Model model) {
        Book book = bookService.findBook(id);
        model.addAttribute("book", book);
        return "bookeEdit.jsp";
    }
    
    // edit put request
    @RequestMapping(value="/books/{id}", method=RequestMethod.PUT)
    public String update(@Valid @ModelAttribute("book") Book book, BindingResult result) {
        if (result.hasErrors()) {
            return  "bookeEdit.jsp";
        } else {
        	
            bookService.updateBook(book);
            return "redirect:/books";
        }
        
        
        
    }
    
    
    @RequestMapping(value="/books/{id}", method=RequestMethod.DELETE)
    public String destroy(@PathVariable("id") Long id) {
        bookService.deleteBook(id);
        return "redirect:/books";
    }
    
    
//    Alternative way of deleting
//    
//    @DeleteMapping("/books/{id}")
//    public String destroy(@PathVariable("id") Long id) {
//        bookService.deleteBook(id);
//        return "redirect:/books";
//    }
    
    

}
