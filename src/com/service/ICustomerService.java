package com.service;
//客户的业务层接口

import com.dao.ICustomerDao;

public interface ICustomerService extends ICustomerDao {
    //    保存客户
    void saveCustomer();
}
