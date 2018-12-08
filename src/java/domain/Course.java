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
    private String id=UUID.randomUUID().toString();
    @Column(unique=true)
    private String code;
    private String name;
    @ManyToOne
    private Department department;
    @OneToMany(mappedBy = "course")
    private List<CourseSelection> courseSelection;
   
}
