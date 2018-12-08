/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dao.DistrictDao;
import dao.ProvinceDao;
import domain.District;
import domain.Province;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.swing.JOptionPane;

/**
 *
 * @author Ndahigeze
 */
@ManagedBean
@SessionScoped
public class DistrictModel{
   private String pid;
    private Province pr=new Province();
    private District d=new District();
    private List<District> ds;

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

   
    public Province getPr() {
        return pr;
    }

    public void setPr(Province pr) {
        this.pr = pr;
    }

    public District getD() {
        return d;
    }

    public void setD(District d) {
        this.d = d;
    }

    public List<District> getDs() {
        return ds;
    }

    public void setDs(List<District> ds) {
        this.ds = ds;
    }
   
   public void byProvince(){   
      Province pro=new Province();
      List<Province> provinces=new ProvinceDao().findAll(Province.class);
      for(Province v: provinces){
           if(v.getProvincecode().equals(pid)){
               pro=v;
           }
       }
       ds=DistrictDao.viewAllByProvince(pro);
   }  
}
