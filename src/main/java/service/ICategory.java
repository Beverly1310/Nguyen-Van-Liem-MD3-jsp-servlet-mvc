package service;

import model.Category;

import java.util.List;

public interface ICategory {
    List<Category> findAll();
    void save(Category category);
    void deleteById(Integer id);
    Category findById(Integer id);
}
