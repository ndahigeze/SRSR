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
import java.util.Optional;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Ndahigeze
 */
@ManagedBean
@SessionScoped
public class FacultyModel {

    private List<Faculty> faculties = new FacultyDao().findAll(Faculty.class);
    private Faculty faculty = new Faculty();
    private Faculty update = new Faculty();
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
    public void province() {
        faculties = new FacultyDao().findAll(Faculty.class);
    }

    boolean checkUser() {
        Optional<Users> u = Optional.ofNullable(user);
        return u.isPresent();
    }

    public void recordFaculty() {
        try {
            if (!checkUser() || faculty.getName().length() == 0) {
                Message.succes("User or name Is empty", "", "frecod");
            }else if(!user.getType().equals("Student")){
                 Message.succes("Student can not be a dean", "", "frecod");
            }else{
                faculty.setDean(user);
                String msg = new FacultyDao().create(faculty);
                faculty = new Faculty();
                faculties = new FacultyDao().findAll(Faculty.class);
                Message.succes(msg, "", "frecod");

            }
        } catch (Exception ex) {
            Message.failure(ex.getLocalizedMessage(), "", "frecod");
        }

    }

    public void setfaculty(Faculty f) {
        user = f.getDean();
        faculty = f;
    }

    public void updateFaculty() {
        try {
            faculty.setDean(user);
            String msg = new FacultyDao().update(faculty);
            faculty = new Faculty();
            faculties = new FacultyDao().findAll(Faculty.class);
            Message.succes(msg, "", "frecod");
        } catch (Exception ex) {
            Message.failure(ex.getLocalizedMessage(), "", "frecod");
        }

    }
}
