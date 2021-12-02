
package br.com.senai.projetofinal.projetofinalds2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Tayanne
 */
@Controller
@RequestMapping("/home")
public class HomeController {
    
    @GetMapping
    public String home() {
        return "home";
    }
    
}
