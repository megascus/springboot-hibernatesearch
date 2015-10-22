/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo;

import javax.transaction.Transactional;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = HibernateSearchDemoApplication.class)
@WebAppConfiguration

public class BookRepositoryTest {
    
    @Autowired
    BookRepository repository;
    
    @Before
    @Transactional
    public void before() {
        Book save = repository.save(new Book(null, "idbn", "test title1", "100", "summary"));
        
    }

    @Test
    @Transactional
    public void testSomeMethod() throws InterruptedException {
        Thread.sleep(1000);
        System.out.println(repository.search("test"));
        Book save = repository.save(new Book(null, "idbn", "test title1", "100", "summary"));
        repository.delete(save);
    }
    
}
