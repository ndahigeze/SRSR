/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;

/**
 *
 * @author Ndahigeze
 */
@Entity
public class Users implements Serializable {

    @OneToOne(mappedBy = "dean")
    private Faculty faculty;

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }
    
    @Id 
   private String id;
   private String fname;
   private String lname;
   private String phone;
   private String pasword;
   private String status;
    @Temporal(javax.persistence.TemporalType.DATE)
   private Date dob; 
   @ManyToOne
   private Department department;
    @OneToMany(mappedBy = "student")
   private List<CourseSelection> courseSelection;
    @ManyToOne
    private Sector sector;
    private String type;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPasword() {
        return pasword;
    }

    public void setPasword(String pasword) {
        this.pasword = pasword;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Sector getSector() {
        return sector;
    }

    public void setSector(Sector sector) {
        this.sector = sector;
    }
   
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public List<CourseSelection> getCourseSelection() {
        return courseSelection;
    }

    public void setCourseSelection(List<CourseSelection> courseSelection) {
        this.courseSelection = courseSelection;
    }
   
   
}
