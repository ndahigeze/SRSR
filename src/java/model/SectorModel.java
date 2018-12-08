/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dao.DistrictDao;
import dao.SectorDao;
import domain.District;
import domain.Sector;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Ndahigeze
 */
@ManagedBean
@SessionScoped
public class SectorModel{
      private String did=new String();
       private Sector d=new Sector();
       private List<Sector> ds;
    public String getDid() {
        return did;
    }

    public void setDid(String did) {
        this.did = did;
    }

    public Sector getD() {
        return d;
    }

    public void setD(Sector d) {
        this.d = d;
    }

    public List<Sector> getDs() {
        return ds;
    }

    public void setDs(List<Sector> ds) {
        this.ds = ds;
    }
    public void byDistrict(){
       List<District> districts=new DistrictDao().findAll(District.class);
       District pro=new District();
       for(District j: districts){
           if(j.getDistrictcode().equals(did)){
               pro=j;
           }
       }
       ds=SectorDao.viewByDistrict(pro);
   }  
}
