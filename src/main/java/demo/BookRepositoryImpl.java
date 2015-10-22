/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import org.apache.lucene.search.Query;
import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.jpa.FullTextQuery;
import org.hibernate.search.jpa.Search;
import org.hibernate.search.query.dsl.EntityContext;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author megascus
 */
public class BookRepositoryImpl implements BookRepositoryCustom {

    @Autowired
    private EntityManager em;

    private FullTextEntityManager getFullTextEntityManager() {
        return Search.getFullTextEntityManager(em);
    }

    @Override
    public List<Book> search(String keyword) {
        FullTextEntityManager ftem = getFullTextEntityManager();
        try {
            ftem.createIndexer(Book.class).startAndWait();
        } catch (InterruptedException ex) {
            Logger.getLogger(BookRepositoryImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        EntityContext bookContext = ftem.getSearchFactory().buildQueryBuilder().forEntity(Book.class);
        QueryBuilder builder = bookContext.get();
        Query q = builder.keyword()
                .onFields("title", "summary")
                .matching(keyword)
                .createQuery();
        FullTextQuery ftq = ftem.createFullTextQuery(q, Book.class);
        return ftq.getResultList();
    }
}
