/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import domain.Users;
import java.io.Serializable;
import java.util.List;
import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author Lievre
 */
@Entity
public class Sector implements Serializable {
    @Id
    private String sectorcode=UUID.randomUUID().toString();
    private String namesector;
    @ManyToOne
    private District district;
    @OneToMany(mappedBy = "sector")
    private List<Users> users;

    public String getSectorcode() {
        return sectorcode;
    }

    public void setSectorcode(String sectorcode) {
        this.sectorcode = sectorcode;
    }

    public String getNamesector() {
        return namesector;
    }

    public void setNamesector(String namesector) {
        this.namesector = namesector;
    }

    public District getDistrict() {
        return district;
    }

    public void setDistrict(District district) {
        this.district = district;
    }

    public List<Users> getUsers() {
        return users;
    }

    public void setUsers(List<Users> users) {
        this.users = users;
    }
    
    @Override
    public String toString(){
     return sectorcode;
    }
    

}
