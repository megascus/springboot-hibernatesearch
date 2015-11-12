/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author megascus
 */
@Controller
public class RequestController {
    
    @RequestMapping("/")
    public String get() {
        return "index";
    }
}
