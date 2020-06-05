package com.briup.estore.service.impl;

import com.briup.estore.bean.Customer;
import com.briup.estore.bean.CustomerExample;
import com.briup.estore.mapper.CustomerMapper;
import com.briup.estore.service.ICustomerService;
import com.briup.estore.util.MybatisSqlSessionUtil;
import org.apache.commons.lang3.StringUtils;
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
public class CustomerServiceImpl implements ICustomerService {
    @Override
    public void saveOrUpdate(Customer customer) throws RuntimeException {
        if (customer == null){
            throw new RuntimeException("参数为空");
        }

        SqlSession sqlSession = MybatisSqlSessionUtil.getSqlSession();
        CustomerMapper customerMapper = sqlSession.getMapper(CustomerMapper.class);
        if (customer.getId() == null){
            CustomerExample example = new CustomerExample();
            example.createCriteria().andNameEqualTo(customer.getName());
            List<Customer> list = customerMapper.selectByExample(example);
            if (list != null && list.size()>0){
                throw new RuntimeException("用户名已经存在");
            }
            // 保存
            customerMapper.insert(customer);

        }else {
            // 更新
            customerMapper.updateByPrimaryKey(customer);
        }

    }

    @Override
    public Customer findCustomerByUserNameAndPassword(String username, String password) throws RuntimeException {
        if (StringUtils.isBlank(username) || StringUtils.isBlank(password)){
            return null;
        }
        SqlSession sqlSession = MybatisSqlSessionUtil.getSqlSession();
        CustomerMapper customerMapper = sqlSession.getMapper(CustomerMapper.class);

        // 根据条件查询
        // 创建模板对象
        CustomerExample example = new CustomerExample();
        example.createCriteria().andNameEqualTo(username).andPasswordEqualTo(password);
        List<Customer> list = customerMapper.selectByExample(example);

        //
        if (list == null || list.size() <= 0){
            return null;
        }

        return list.get(0);
    }
}