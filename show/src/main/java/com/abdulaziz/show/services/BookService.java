package com.abdulaziz.show.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.abdulaziz.show.models.Book;
import com.abdulaziz.show.repositories.BookRepository;
@Service
public class BookService {
    // adding the book repository as a dependency
    private final BookRepository bookRepository;
    
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    // returns all the books
    public List<Book> allBooks() {
        return bookRepository.findAll();
    }
    // creates a book
    public Book createBook(Book b) {
        return bookRepository.save(b);
    }
    // retrieves a book
    public Book findBook(Long id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if(optionalBook.isPresent()) {
            return optionalBook.get();
        } else {
            return null;
        }
    }
    
    // Update a book from data
    public Book updateBook(Long id, String title, String desc, String lang, Integer numberOfPages) {
		Optional<Book> optionalBook = bookRepository.findById(id);
		  if(optionalBook.isPresent()) {
			  Book optionalBook1 = optionalBook.get();
			  optionalBook1.setTitle(title);
			  optionalBook1.setDescription(desc);
			  optionalBook1.setLanguage(lang);
			  optionalBook1.setNumberOfPages(numberOfPages);
			  return bookRepository.save(optionalBook1);   
	        } else {
	        	System.out.println("Book does not exist");
	            return null;
	        }
		
	}

    // Update a book from obj
    public void updateBook(Book book) {
			   bookRepository.save(book);   
	}

 // delete a book
    public void deleteBook(Long id) {
    	bookRepository.deleteById(id);
    }
}