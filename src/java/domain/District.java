/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import domain.Province;
import domain.Sector;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author Lievre
 */
@Entity
public class District implements Serializable {
    @Id
    private String districtcode;
    private String namedistrict;
    @ManyToOne
    private Province province;
    @OneToMany(mappedBy = "district")
    private List<Sector> sector;

    public String getDistrictcode() {
        return districtcode;
    }

    public void setDistrictcode(String districtcode) {
        this.districtcode = districtcode;
    }

    public String getNamedistrict() {
        return namedistrict;
    }

    public void setNamedistrict(String namedistrict) {
        this.namedistrict = namedistrict;
    }

    public Province getProvince() {
        return province;
    }

    public void setProvince(Province province) {
        this.province = province;
    }

    public List<Sector> getSector() {
        return sector;
    }

    public void setSector(List<Sector> sector) {
        this.sector = sector;
    }
 
    @Override
    public String toString(){
     return districtcode;
    }
   
}
