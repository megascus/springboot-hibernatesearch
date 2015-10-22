/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo;

import org.springframework.stereotype.Controller;

/**
 *
 * @author megascus
 */
@Controller(value = "/")
public class RequestController {
    
    public String get() {
        return "";
    }
}
