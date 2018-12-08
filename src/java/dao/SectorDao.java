/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.District;
import domain.Sector;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import utilPac.HibernateUtil;

/**
 *
 * @author Ndahigeze
 */
public class SectorDao extends GenericDao<Sector>{
    public static List<Sector> viewByDistrict(District dist){
        Session ses=HibernateUtil.getSessionFactory().openSession();
        Query que=ses.createQuery("from Sector s where s.district= :d");
        que.setString("d", dist.getDistrictcode());
        List<Sector> list=que.list();
        ses.close();
        return list;
    } 
}
