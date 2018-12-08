/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import config.Message;
import dao.CourseDao;
import domain.Course;
import domain.Department;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Ndahigeze
 */
@ManagedBean
@SessionScoped
public class CourseModel{
    private List<Course> courses=new CourseDao().findAll(Course.class);
    private Course course=new Course();
    private Course update=new Course();
    private String search;
    private String department;

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Course getUpdate() {
        return update;
    }

    public void setUpdate(Course update) {
        this.update = update;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
    
      public void ccourse(){
       try{
            if(search.length()!=0){
           List<Course> list=new CourseDao().findAll(Course.class);
           courses=new ArrayList();
           list.stream().filter((l) -> (l.getId().contains(search)||l.getDepartment().getName().contains(search)||l.getName().contains(search)||search.contains(l.getCredit()+""))).forEachOrdered((Course l) -> {
               courses.add(l);
           });
       }else{
           courses=new CourseDao().findAll(Course.class);
       }
       }catch(Exception ex){
       }
      
      }
      
        public void recordDepartment(){
            Department f=new Department();
            f.setId(department);
        try{
            course.setDepartment(f);
            String msg=new CourseDao().create(course);
            course=new Course();
           courses=new CourseDao().findAll(Course.class);
            Message.succes(msg, "");
        }catch(Exception ex){
              Message.failure(ex.getLocalizedMessage(), "");
        }
        
    }
   
     public void updateDepartment(){
         Department f=new Department();
            f.setId(department);
        try{
            course.setDepartment(f);
            String msg=new CourseDao().update(course);
            course=new Course();
           courses=new CourseDao().findAll(Course.class);
            Message.succes(msg, "");
        }catch(Exception ex){
              Message.failure(ex.getLocalizedMessage(), "");
        }
        
    } 
}
