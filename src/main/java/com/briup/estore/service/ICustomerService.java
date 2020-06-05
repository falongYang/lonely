package com.briup.estore.service;

import com.briup.estore.bean.Customer;

public interface ICustomerService {

    void saveOrUpdate(Customer customer)throws RuntimeException;

    Customer findCustomerByUserNameAndPassword(String username,String password)throws RuntimeException;
}
