/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import config.Message;
import dao.FacultyDao;
import domain.Faculty;
import domain.Users;
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
public class FacultyModel{
    private List<Faculty> faculties=new FacultyDao().findAll(Faculty.class);
    private Faculty faculty=new Faculty();
    private Faculty update=new Faculty();
    private String search;
    private Users user;

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

   

    public List<Faculty> getFaculties() {
        return faculties;
    }

    public void setFaculties(List<Faculty> faculties) {
        this.faculties = faculties;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public Faculty getUpdate() {
        return update;
    }

    public void setUpdate(Faculty update) {
        this.update = update;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }
    
    
      @PostConstruct
      public void province(){
      faculties=new FacultyDao().findAll(Faculty.class);
      }
      
        public void recordFaculty(){
           
        try{
            faculty.setDean(user);
             String msg=new FacultyDao().create(faculty);
            faculty=new Faculty();
            faculties=new FacultyDao().findAll(Faculty.class);
             Message.succes(msg, "");
        }catch(Exception ex){
              Message.failure(ex.getLocalizedMessage(), "");
        }
        
    }
   
     public void updateFaculty(){
        try{
             String msg=new FacultyDao().update(update);
            update=new Faculty();
            faculties=new FacultyDao().findAll(Faculty.class);
             Message.succes(msg, "");
        }catch(Exception ex){
             Message.failure(ex.getLocalizedMessage(), "");
        }
        
    }
}
