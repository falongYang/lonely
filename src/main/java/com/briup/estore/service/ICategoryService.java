package com.briup.estore.service;

import com.briup.estore.bean.ex.CategoryEX;

import java.util.List;

public interface ICategoryService {
    List<CategoryEX> findAllCategoryEX() throws RuntimeException;
}
