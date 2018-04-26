package Modele.user_faux;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/*import java.util.List; 
import javax.ws.rs.GET; 
import javax.ws.rs.Path; 
import javax.ws.rs.Produces; 
import javax.ws.rs.core.MediaType;  
@Path("/UserService") */

/*public class UserService {  
   UserDao userDao = new UserDao();  
   @GET 
   @Path("/users") 
   @Produces(MediaType.APPLICATION_XML) 
   public List<User> getUsers(){ 
      return userDao.getAllUsers(); 
   }  
}*/


import java.util.concurrent.atomic.AtomicLong;
import java.util.List; 
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserService {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    UserDao userDao = new UserDao();  

    @GetMapping("/users")
    @ResponseBody
    public List<User>  getUsers(@RequestParam(name="name", required=false, defaultValue="Stranger") String name) {
      return userDao.getAllUsers();
    }
    
    
     @GetMapping("/welcome/user")
    @ResponseBody
    public String welcomeUser(@RequestParam(name="name", required=false, defaultValue="Java Fan") String name) {
        return "test";
    }

}
