package com.example.quizApp.services;

import com.example.quizApp.dao.CategoryDao;
import com.example.quizApp.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service("categoryService")
public class CategoryService  {
    @Autowired
    private CategoryDao categoryDao;

    @Transactional
    public List<Category> displayCategory(){
        return categoryDao.getCategory();
    }

    @Transactional
    public String getCategoryNameById(Integer id){
        return categoryDao.getCategoryName(id);
    }
}
