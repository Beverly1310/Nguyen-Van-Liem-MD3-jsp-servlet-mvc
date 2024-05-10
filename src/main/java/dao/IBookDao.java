package dao;

import dto.BookRequest;
import model.Book;

import java.util.List;

public interface IBookDao {
    List<Book> findAll();
    void save(BookRequest bookRequest);
    void deleteById(Integer id);
    Book findById(Integer id);
}
