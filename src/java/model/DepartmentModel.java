/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import config.Message;
import dao.DepartmentDao;
import domain.Department;
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
public class DepartmentModel{
     private List<Department> departments=new DepartmentDao().findAll(Department.class);
    private Department departmnent=new Department();
    private Department update=new Department();
    private String search;
    private Users user;
    private String faculty;

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public List<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(List<Department> departments) {
        this.departments = departments;
    }

    public Department getDepartmnent() {
        return departmnent;
    }

    public void setDepartmnent(Department departmnent) {
        this.departmnent = departmnent;
    }

    public Department getUpdate() {
        return update;
    }

    public void setUpdate(Department update) {
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
      departments=new DepartmentDao().findAll(Department.class);
      }
      
        public void recordDepartment(){
            Faculty f=new Faculty();
            f.setId(faculty);
        try{
            departmnent.setFaculty(f);
            departmnent.setDean(user);
            String msg=new DepartmentDao().create(departmnent);
            departmnent=new Department();
            departments=new DepartmentDao().findAll(Department.class);
            Message.succes(msg, "","");
        }catch(Exception ex){
              Message.failure(ex.getLocalizedMessage(), "","");
        }
        
    }
      public void setdepartment(Department d){
          user=d.getDean();
          departmnent=d;
        }
     public void updateDepartment(){
         Faculty f=new Faculty();
         f.setId(faculty);
        try{
            departmnent.setFaculty(f);
            departmnent.setDean(user);
             String msg=new DepartmentDao().update(update);
            update=new Department();
            departments=new DepartmentDao().findAll(Department.class);
             Message.succes(msg, "","");
        }catch(Exception ex){
             Message.failure(ex.getLocalizedMessage(), "","");
        }
        
    }
}
