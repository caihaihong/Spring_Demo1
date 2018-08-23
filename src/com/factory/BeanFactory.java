package com.factory;
/**
 * 一个工厂类
 */

import com.dao.ICustomerDao;
import com.service.ICustomerService;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class BeanFactory {
    /**
     * 读取properties的方法一
     */
//    1.定义一个properties对象
//    private static Properties props = new Properties();
//    // 使用静态代码块给对象赋值
//    static {
//        try {
//            InputStream in = BeanFactory.class.getClassLoader().getResourceAsStream("com/bean.properties");
//            InputStream in = new FileInputStream("src/bean.properties"); //绝对不能使用，web工程一旦发布，就没有src
//            props.load(in);
//        } catch (Exception e) {
//            throw new ExceptionInInitializerError("读取配置文件失败");
//        }
//    }
//    public static void main(String[] args) {
//        System.out.println(props.get("CUSTOMERSERVICE"));
//    }


    private static ResourceBundle bundle = ResourceBundle.getBundle("bean");

    private static Map<String, Object> beans = new HashMap<String, Object>();

    static {
//        1.读取配置文件中所有的配置:key的部分
        Enumeration<String> keys = bundle.getKeys();
//        2.遍历keys
        while (keys.hasMoreElements()) {
//        3.取出一个key
            String key = keys.nextElement();
//          4.根据key获取beanpath
            String beanPath = bundle.getString(key);
            try {
//                5.根據beanPath反射创建类对象
                Object value = Class.forName(beanPath).newInstance();
//                6.把key和value存入map中
                beans.put(key, value);
            } catch (Exception e) {
                throw new ExceptionInInitializerError("創建容器失敗。");
            }
        }
    }

    /**
     * 根据bean的名称创建对象
     *
     * @param beanName
     * @return
     */
    public static Object getBean(String beanName) {
        return beans.get(beanName);

        //不严谨的工厂模式，创建多个不同的对象
//        try {
//            //1.读取配置文件，跟BeanNam获取全限定类名
//            String beanPath = bundle.getString(beanName);
//            System.out.println(beanPath);
//            return Class.forName(beanPath).newInstance();
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
    }

//    public static ICustomerService getCustomerService() {
//        try {
//            return (ICustomerService) Class.forName("com.service.imple.CustomerServiceImpl").newInstance();
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    public static ICustomerDao getCustomerDao() {
//        try {
//            return (ICustomerDao) Class.forName("com.dao.impl.CustomerDaoImpl").newInstance();
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//    }

}
