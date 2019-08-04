package com.lesson5.Homework;

import com.lesson2.OrderService;
import com.lesson2.homework.task1.Route;
import com.lesson2.homework.task1.Service;
import com.lesson2.homework.task1.Step;
import com.lesson2.homework.task2.ItemDAO;
import com.lesson2.homework.task2.ItemService;
import com.lesson3.homework.DAO.FileDAO;
import com.lesson3.homework.DAO.StorageDAO;
import com.lesson3.homework.File;
import com.lesson3.homework.Service.ServiceFile;
import com.lesson3.homework.Service.ServicePtoject;
import com.lesson3.homework.Service.ServiceStorage;
import com.lesson3.homework.Storage;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Configuration
@EnableTransactionManagement
public class AppConfig {
//    @Bean(name = "file")
//    public File file() {
//        File file = new File();
//        file.setId(0);
//        file.setName("TestName");
//        file.setFormat("txt");
//        file.setSize(555);
//        return file;
//    }
//
//    @Bean(name = "orderService")
//    public OrderService orderService() {
//        return new OrderService();
//    }
//
//    @Bean(name = "service")
//    public Service service() {
//        List list = null;
//        return new Service(9999, "newName", list);
//
//    }
//
//    @Bean(name = "step")
//    public Step step(Service serviceFrom, Service serviceTo) {
//
//        Map<String, Service> mapFrom = new HashMap<>();
//        Map<String, Service> mapTo = new HashMap<>();
//        mapFrom.put("key1", serviceFrom);
//        mapTo.put("key2", serviceTo);
//        return new Step(0, serviceFrom, serviceTo, mapFrom, mapTo);
//    }
//
//    @Bean(name = "route")
//    public Route route(Step step) {
//        List<Step> steps = new ArrayList<>();
//        steps.add(step);
//        return new Route(0, steps);
//
//    }
//
//    @Bean(name = "itemService")
//    public ItemService itemService() {
//        return new ItemService();
//    }

//    @Bean(name = "itemDAO")
//    public ItemDAO itemDAO() {
//        return new ItemDAO();
//    }

//    @Bean(name = "storage")
//    public Storage storage() {
//        return new Storage(0, "txt, png, doc", "test", 1000);
//    }
//
//
//    @Bean(name = "fileDAI")
//    public FileDAO fileDAO() {
//        return new FileDAO();
//    }
//
//    @Bean(name = "storageDAO")
//    public StorageDAO storageDAO() {
//        return new StorageDAO();
//    }
//
//    @Bean(name = "serviceFile")
//    public ServiceFile serviceFile() {
//        return new ServiceFile();
//    }
//
//    @Bean(name = "serviceStorage")
//    public ServiceStorage serviceStorage() {
//        return new ServiceStorage();
//    }
//
//
//    @Bean(name = "servicePtoject")
//    public ServicePtoject servicePtoject() {
//        return new ServicePtoject();
//    }

    @Bean
    public DriverManagerDataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
        dataSource.setUrl("jdbc:oracle:thin:@gromecode-lessons.cbgpstxxjmkw.us-east-2.rds.amazonaws.com:1521:ORCL");
        dataSource.setUsername("main");
        dataSource.setPassword("*****");
        return dataSource;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource());
        em.setPackagesToScan(new String[]{("com")});

        JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        return em;
    }


    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory emf){
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(emf);

        return transactionManager;

    }
}
