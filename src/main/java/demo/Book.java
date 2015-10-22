/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.search.annotations.Analyze;
import org.hibernate.search.annotations.DocumentId;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;

/**
 *
 * @author megascus
 */
@Entity
@Getter
@Setter
@Indexed
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Book implements Serializable {

    @Id
    @GeneratedValue
    @DocumentId(name = "id")
    private Long id;
    
    @Field(analyze = Analyze.NO)
    String isbn;

    @Field
    String title;

    @Field(analyze = Analyze.NO)
    String price;

    @Field
    String summary;

}
