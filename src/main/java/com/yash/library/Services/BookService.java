package com.yash.library.Services;


import com.yash.library.Entity.Book;
import com.yash.library.Repository.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private final BookRepo bookrepo;

    public BookService(BookRepo bookRepo) {
        this.bookrepo = bookRepo;
    }

    public void addBook(Book book){

        bookrepo.save(book);

    }

    public List<Book> getAllBooks(){

       return bookrepo.findAll();
    }


    public Optional<Book> getBookById(Long id){

        return bookrepo.findById(id);
    }


    public List<Book> getBookByAuthor(String Author){

        return   bookrepo.findByAuthor(Author);
    }


    public  List<Book> getBooksByCategory(String category){

        return  bookrepo.findByCategory(category);
    }


    public List<Book> getBooksSortedByQuantityDesc(){

        return bookrepo.findByOrderByQuantityDesc();
    }


    public Book updateBook(Book book){

        if(getBookById(book.getId()).isPresent()){

           return  bookrepo.save(book);
        }
        else {

            throw new RuntimeException("Book Dose not exist in book store");

        }
    }


    public void deleteBook(Book book){


        bookrepo.delete(book);
    }







}
