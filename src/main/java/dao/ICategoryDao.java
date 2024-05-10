package dao;

import model.Category;

import java.util.List;

public interface ICategoryDao {
    List<Category> findAll();
    void save(Category category);
    void deleteById(Integer id);
    Category findById(Integer id);
}
