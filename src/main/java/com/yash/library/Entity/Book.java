package com.yash.library.Entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NonNull;
import org.hibernate.validator.constraints.ISBN;
import org.hibernate.validator.constraints.NotBlank;
import jakarta.validation.constraints.Min;


import java.time.LocalDate;

@Data
@Entity
public class Book {

@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private  Long id;


@NotBlank(message = "Book name cannot be blank")
private  String name;

@Min(value = 0, message = "Quantity cannot be negative")
private int quantity;

@NotBlank(message = "Author name cannot be blank")
private String author;

@ISBN(type = ISBN.Type.ISBN_13, message = "Invalid ISBN")
private String isbn;

@NotBlank(message = "Publisher cannot be blank")
private  String publisher;


private LocalDate publishedDate;

private  String category;

private boolean available;

}
