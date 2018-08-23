package com.service.imple;


import com.factory.BeanFactory;
import com.service.ICustomerService;
import com.dao.impl.CustomerDaoImpl;
import com.dao.ICustomerDao;

public class CustomerServiceImpl implements ICustomerService {

    private ICustomerDao customerDao = null;
    @Override
    public void saveCustomer() {
        System.out.println("业务层调用持久层");
        customerDao.saveCustomer();
    }
}
