package service.impl;

import dao.ICategoryDao;
import dao.iml.CategoryImplDao;
import model.Category;
import service.ICategory;

import java.util.List;

public class CategoryImpl implements ICategory {
    private static final ICategoryDao categoryDao = new CategoryImplDao();

    @Override
    public List<Category> findAll() {
        return categoryDao.findAll();
    }

    @Override
    public void save(Category category) {
        categoryDao.save(category);
    }

    @Override
    public void deleteById(Integer id) {
        categoryDao.deleteById(id);
    }

    @Override
    public Category findById(Integer id) {
        return categoryDao.findById(id);
    }
}
