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

/**
 *
 * @author Ndahigeze
 */
@Entity
public class Course implements Serializable {
    @Id
    @Column(unique=true)
    private String id;
    private String name;
    private int credit;
    @ManyToOne
    private Department department;
    @OneToMany(mappedBy = "course")
    private List<CourseSelection> courseSelection;

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

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
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
