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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author Ndahigeze
 */
@Entity
public class Department implements Serializable {
    @Id
    private String id=UUID.randomUUID().toString();
    @Column(unique=true)
    private String name;
    @ManyToOne
    private Faculty faculty;
    @OneToMany(mappedBy = "department")
    private List<Users> users;
    @OneToMany(mappedBy = "department")
    private List<Course> courses;
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

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public List<Users> getUsers() {
        return users;
    }

    public void setUsers(List<Users> users) {
        this.users = users;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
    
    @Override
    public String toString(){
     return id;
    }
    
}
