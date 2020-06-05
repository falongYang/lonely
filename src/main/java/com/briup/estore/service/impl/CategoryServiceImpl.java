package com.briup.estore.service.impl;

import com.briup.estore.bean.ex.CategoryEX;
import com.briup.estore.mapper.ex.CategoryEXMapper;
import com.briup.estore.service.ICategoryService;
import com.briup.estore.util.MybatisSqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: yfl
 * \* Date: 2020/6/3
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
public class CategoryServiceImpl implements ICategoryService {
    @Override
    public List<CategoryEX> findAllCategoryEX() throws RuntimeException {
        SqlSession sqlSession = MybatisSqlSessionUtil.getSqlSession();
        CategoryEXMapper categoryEXMapper = sqlSession.getMapper(CategoryEXMapper.class);
        return categoryEXMapper.selectAllcategoryEx();
    }
}