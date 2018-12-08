/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author Ndahigeze
 */
@Entity

@Table( uniqueConstraints = @UniqueConstraint(columnNames = { "course", "student" }))
public class CourseSelection implements Serializable {
    @Id
   private String id=UUID.randomUUID().toString();
    @ManyToOne
     @JoinColumn(name="course")
   private Course course;
    @ManyToOne
    @JoinColumn(name="student")
   private Users student;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Users getStudent() {
        return student;
    }

    public void setStudent(Users student) {
        this.student = student;
    }

   
   
   
}
