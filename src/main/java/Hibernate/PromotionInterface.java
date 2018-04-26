/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hibernate;

import Client.Client;
import java.util.List;


public interface PromotionInterface {
     void addPromotion(Client u);
     void updatePromotion(Client u);
     void deletePromotion(Integer id);
          List<Client> list();
     
}
