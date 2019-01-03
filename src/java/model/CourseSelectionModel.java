/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import config.Message;
import dao.CourseSelectionDao;
import domain.Course;
import domain.CourseSelection;
import domain.Users;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Ndahigeze
 */
@ManagedBean
@SessionScoped
public class CourseSelectionModel{
    private List<CourseSelection> selections=new CourseSelectionDao().findAll(CourseSelection.class);
    private CourseSelection selection=new CourseSelection();
    private CourseSelection update=new CourseSelection();
    private String search;
    private String course;
    private String student;
    private Users u=new Users();
    public Users getU() {
        return u;
    }

    public void setU(Users u) {
        this.u = u;
    }
    
    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getStudent() {
        return student;
    }

    public void setStudent(String student) {
        this.student = student;
    }
    
    public List<CourseSelection> getSelections() {
        return selections;
    }

    public void setSelections(List<CourseSelection> selections) {
        this.selections = selections;
    }

    public CourseSelection getSelection() {
        return selection;
    }

    public void setSelection(CourseSelection selection) {
        this.selection = selection;
    }

    public CourseSelection getUpdate() {
        return update;
    }

    public void setUpdate(CourseSelection update) {
        this.update = update;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }
    
    public void save(){
     Users u=new Users();
     u.setId(student);
     Course c=new Course();
     c.setId(course);
     try{
         selection.setCourse(c);
         selection.setStudent(u);
         selection.setStatus("pass");
         selection.setSelectionDate(new Date());
         String msg=new CourseSelectionDao().create(selection);
         student=new String();
         course=new String();
           Message.succes(msg, "","");
     }catch(Exception ex){
           Message.failure(ex.getLocalizedMessage(), "","");
     }
    }
}
