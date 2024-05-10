package service.impl;

import dao.IBookDao;
import dao.iml.BookDaoIml;
import dto.BookRequest;
import model.Book;
import service.IBook;

import java.util.List;

public class BookImpl implements IBook {
    private static final IBookDao bookRequestDao = new BookDaoIml();

    @Override
    public List<Book> findAll() {
        return bookRequestDao.findAll();
    }

    @Override
    public void save(BookRequest bookRequest) {
        bookRequestDao.save(bookRequest);
    }

    @Override
    public void deleteById(Integer id) {
        bookRequestDao.deleteById(id);
    }

    @Override
    public Book findById(Integer id) {
        return bookRequestDao.findById(id);
    }
}
