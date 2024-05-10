package service;

import dto.BookRequest;
import model.Book;

import java.util.List;

public interface IBook {
    List<Book> findAll();
    void save(BookRequest bookRequest);
    void deleteById(Integer id);
    Book findById(Integer id);
}
