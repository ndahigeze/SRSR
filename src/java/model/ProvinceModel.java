/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dao.ProvinceDao;
import domain.District;
import domain.Province;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Ndahigeze
 */
@ManagedBean
@SessionScoped
public class ProvinceModel{
      private Province province=new Province();
    private List<Province> provinces=new ProvinceDao().findAll(Province.class);
    private String search=new String();
    private String proUp=new String();
    private String pid=new String();
    private Province pr=new Province();
    private District d=new District();
    private List<District> ds=new ArrayList<>();
    private String prod;

    public String getProd() {
        return prod;
    }

    public void setProd(String prod) {
        this.prod = prod;
    }

  
    
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


    public Province getProvince() {
        return province;
    }

    public void setProvince(Province province) {
        this.province = province;
    }

    public List<Province> getProvinces() {
        return provinces;
    }

    public void setProvinces(List<Province> provinces) {
        this.provinces = provinces;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    public String getProUp() {
        return proUp;
    }

    public void setProUp(String proUp) {
        this.proUp = proUp;
    }
    
//    public void byProvince(){
//       Province p=new Province();
//       p.getProvincecode(prod);
//       ds=new ArrayList();
//       ds=DistrictDao.viewAllByProvince(pr);
//   }
      public void create(){
        new ProvinceDao().create(province);
        province=new Province();
        provinces=new ProvinceDao().findAll(Province.class);
        FacesContext fc=FacesContext.getCurrentInstance();
         fc.addMessage(null, new FacesMessage("ok"));
    } 
      @PostConstruct
      public void province(){
      provinces=new ProvinceDao().findAll(Province.class);
      }
}
