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
  
import Client.*;

import Client.ClientServiceImpl;
import Client.IClientService;
import Hibernate.PromotionImplement;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import org.springframework.stereotype.Controller;  
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.RequestMethod;  
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
  
@Controller  
//@ComponentScan({"Client"})
public class HomeController {  
      
    @RequestMapping("/")  
    public String init() {  
       return "../static/Home";  
       //return "redirect:swagger-ui.html";
    }  
   private static final Logger lmogger = LoggerFactory.getLogger(HomeController.class);
    @RequestMapping(value = "/home1", method = RequestMethod.GET)
	public String home(@RequestParam(value="serverTime", required=false, defaultValue="World!!") String serverTime, Model model) {
	
                model.addAttribute("serverTime",serverTime);
		return "../static/Home";
	}
        
        
	
      public static void main(String[] args) {
           ClientServiceImpl clientServicee=new ClientServiceImpl();
            System.out.println("ddd");
            try{
		List<Client> clients = clientServicee.selectAll();
		if (clients == null) {
			clients = new ArrayList<Client>();
		}
                 System.out.println("dd5");
//		model.addAttribute("clients", clients);
                 System.out.println("d=4dd");
            }
            catch(Exception ex){
                ex.printStackTrace();
            }
            
                 
//		return  "../static/ListClient";
	}
      
       @RequestMapping(value = "/client")
	public String client1(Model model) {
            System.out.println("ddd");
            try{
                PromotionImplement cli=new PromotionImplement();
		List<Client> clients = cli.list();
		if (clients == null) {
			clients = new ArrayList<Client>();
		}
                 System.out.println("dd5");
		model.addAttribute("clients", clients);
                 System.out.println("d=4dd");
            }
            catch (Exception ex )
            {
                System.out.println(ex);
            }
		return  "../static/ListClient";
	}
        
        
        
         @RequestMapping(value = "/client/new" , method = RequestMethod.GET)
	public String new_client(Model model) {
            Client client=new Client();
            // client.setNom("ff"); c'est^por test ce que le formulaire fonctionne
            model.addAttribute("client", client);
            return  "../static/AjoutClient";
        
        }
        PromotionImplement cli=new PromotionImplement();
          @RequestMapping(value = "/client/ajout" , method = RequestMethod.POST)
	public String ajout(Model model,Client client) {
            if (client!=null) 
            {
                if (client.getIdClient() == 0)
                {
                     cli.addPromotion(client);
                }
                else
                     
                {
                     cli.updatePromotion(client);
                }
           
            }
            
            return  "redirect:/client/";
        
        }
        
         @RequestMapping(value = "/client/update/{id}" , method = RequestMethod.GET)
	public String update_client(Model model, @PathVariable("id") int idClient) {
            
            Client client = cli.getById(idClient);
            if (client != null)
            {
                model.addAttribute("client", client);
            }
            
            
            return  "../static/AjoutClient";
        
        }
        
        
          @RequestMapping(value = "/client/delete/{id}")
	public String supp(Model model,@PathVariable("id") int idClient) {
            Client client=new Client();
            client = cli.getById(idClient);
            if (client != null)
            {
               cli.deletePromotion(idClient);
                
           
            }
            
            return  "redirect:/client/";
        
        }
        
        
        
        
        //@Autowired
        private IClientService clientService;

        @RequestMapping(value = "/client1")
	public String client2(Model model) {
            System.out.println("ddd");
            try{
		List<Client> clients = clientService.selectAll();
		if (clients == null) {
			clients = new ArrayList<Client>();
		}
                 System.out.println("dd5");
		model.addAttribute("clients", clients);
                 System.out.println("d=4dd");
            }
            catch (Exception ex )
            {
                System.out.println(ex);
            }
		return  "../static/ListClient";
	}
        
        
        
         @RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home1(Locale locale, Model model) {
		lmogger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
              		return "../static/Home";
	}
        
    /*@RequestMapping(value = "/saveUser/{id}", method = RequestMethod.POST)
public String saveUser(@ModelAttribute("user") User user, @PathVariable Long id, Model model) {
    model.addAttribute("user", user);
    userRepo.save(user); //JPA Repo
    return "success";
}*/
    
   /*  @RequestMapping("/home")  
    public String home() {  
        return "../static/Home";  
    }  */
    
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
    
    @RequestMapping("/Lien")  
    public String Lien() {  
         return "../static/Lien";  
    }  
    
    
      
    @RequestMapping("/salle")  
    public String salle() {  
        return "../static/ListSalle";  
    }  
}  

