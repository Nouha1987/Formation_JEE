package com.prof.demo;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author SAMSUNG
 */

   // tutorial
  
import org.springframework.stereotype.Controller;  
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.RequestMethod;  
  
@Controller  
public class HomeController {  
      
    @RequestMapping("/")  
    public String init() {  
        return "../static/Home";  
    }  
    
     @RequestMapping("/home")  
    public String home() {  
        return "../static/Home";  
    }  
    
       @RequestMapping("/login")  
    public String login() {  
        return "login";  
    }  
    
         @RequestMapping("/header")  
    public String head() {  
        return "header";  
    } 
    
    @RequestMapping("/DTO")  
    public String DTO() {  
         return "../static/DTO";  
    }  
      
     @RequestMapping("/Source")  
    public String Source() {  
         return "../static/Source";  
    }  
    
    
      
    @RequestMapping("/salle")  
    public String salle() {  
        return "../static/ListSalle";  
    }  
}  

