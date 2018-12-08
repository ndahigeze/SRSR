/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author Ndahigeze
 */
@Entity
public class Faculty implements Serializable {
    @Id
   private String id=UUID.randomUUID().toString();
   @Column(unique = true)
   private String name;
    @OneToMany(mappedBy = "faculty")
   private List<Department> departments;
    @OneToOne
   private Users dean;

    public Users getDean() {
        return dean;
    }

    public void setDean(Users dean) {
        this.dean = dean;
    }
   
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(List<Department> departments) {
        this.departments = departments;
    }

   
    @Override
   public String toString(){
       return id;
   }
   
}
