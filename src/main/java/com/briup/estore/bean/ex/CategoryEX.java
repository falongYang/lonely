package com.briup.estore.bean.ex;

import com.briup.estore.bean.Category;

import java.io.Serializable;
import java.util.List;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: yfl
 * \* Date: 2020/6/3
 * \* To change this template use File | Settings | File Templates.
 * \* Description:一级分类，一个一级分类对应的多个二级分类
 * \
 */
public class CategoryEX implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private String name;

    private String description;

    private Integer parentId;

    /*
    一个一级分类对应的多个二级分类
     */
    private List<Category> categories;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }
}