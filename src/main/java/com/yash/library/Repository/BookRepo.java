package com.yash.library.Repository;

import com.yash.library.Entity.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepo extends JpaRepository<Book,Long> {

    List<Book> findByAuthor(String author);

    List<Book> findByCategory(String category);

    List<Book> findByOrderByQuantityDesc();

    @Override
    Page<Book> findAll(Pageable pageable);


}
