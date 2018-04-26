/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hibernate;

import persistence.HibernateUtil;
import Client.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
//import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
//import org.hibernate.cfg.AnnotationConfiguration;
//import org.hibernate.cfg.Configuration;


/**
 *
 * @author SAMSUNG
 */
public class PromotionImplement implements PromotionInterface {



    public static void main(String[] args) {
     
        // test
        System.out.println("Maven + Hibernate + MySQL1");
        PromotionImplement u = new PromotionImplement();
        System.out.println("Maven + Hibernate + MySQL2");
        Client us = new Client();
        us.setIdClient(3);
        us.setAdresse("jj");
        us.setNom("llll");
         us.setPrenom("llll");
//         System.out.println("Maven + Hibernate + MySQL3");
        u.addPromotion(us);
         System.out.println("Maven + Hibernate + MySQL4");
//        //u.updatePromotion(us);
//       // u.deletePromotion(2);
//      
    }

    @Override
    public void addPromotion(Client u) {
       Session session = HibernateUtil.getSessionFactory().openSession();
       Transaction tx = null;

        try {
              System.out.print("open");
            tx=session.beginTransaction();
            session.save(u);
                 System.out.print("sucess");
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
                      System.out.print("failure");
            }
            e.printStackTrace();
        } finally {
            session.close();
        }

    }

    @Override
    public void updatePromotion(Client u) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Client us = (Client) session.get(Client.class, u.getIdClient());
            us.setAdresse(u.getAdresse());
            us.setMail(u.getMail());
            us.setNom(u.getNom());
             us.setNom(u.getNom());
            //u.setMdp(mdp);
            session.update(us);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    @Override
    public void deletePromotion(Integer id) {
       Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Client u
                    = (Client) session.get(Client.class, id);
            session.delete(u);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
                 System.out.print("failure");
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

 
    
    @Override
    public List<Client> list() {
       Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
         List<Client> users=new ArrayList<>() ;
        try {
            tx = session.beginTransaction();
            
            // from "nom de la classe java" c'est le langage HQL hibernate
             users = session.createQuery("FROM Client").list();
          
            tx.commit();
             
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
         return  users;
    }
    

}
