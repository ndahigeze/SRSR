/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.District;
import domain.Province;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import utilPac.HibernateUtil;


/**
 *
 * @author Ndahigeze
 */
public class DistrictDao extends GenericDao<District>{
     public static List<District> viewAllByProvince(Province pr){
      Session ses=HibernateUtil.getSessionFactory().openSession();
      Query que=ses.createQuery("FROM District b WHERE b.province= :v ");
      que.setString("v", pr.getProvincecode());
      List<District> list=que.list();
      ses.close();
      return list;
    }
}
