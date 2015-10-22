/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo;

import java.util.List;

/**
 *
 * @author megascus
 */
public interface BookRepositoryCustom {
    
    public List<Book> search(String keyword);
    
}
