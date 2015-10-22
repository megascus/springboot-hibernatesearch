/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.jpa.Search;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author megascus
 */
@Aspect
@Component
@Transactional
public class RepositoryMonitor {

    @Autowired
    private EntityManager em;

    private FullTextEntityManager getFullTextEntityManager() {
        return Search.getFullTextEntityManager(em);
    }

    @AfterReturning("!execution(* delete(..)) && target(demo.BookRepository) && args(book)")
    public void index(JoinPoint joinPoint, Book book) {
        FullTextEntityManager ftem = getFullTextEntityManager();
        ftem.index(book);
    }
    
    @AfterReturning("execution(* delete(..)) && target(demo.BookRepository) && args(book)")
    public void remove(JoinPoint joinPoint, Book book) {
        FullTextEntityManager ftem = getFullTextEntityManager();
        ftem.purge(Book.class, book.getId());
    }
}
