package com.ui;


import com.dao.ICustomerDao;
import com.service.ICustomerService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Spring的入门案例
 */
public class Client {
    /**
     * ClassPathXmlApplicationContext:只能加载类路径下的配置文件
     * FileSystemXmlApplicationContext：可以加载磁盘任意位置配置文件
     * @param args
     */
    public static void main(String[] args) {
        //1.获取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //2.根据bean的id获取对象
        ICustomerService cs = (ICustomerService) ac.getBean("customerService");
        ICustomerDao cd = (ICustomerDao) ac.getBean("customerDao");
        System.out.println(cd);
    }
}