/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dao.CourseSelectionDao;
import domain.CourseSelection;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

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
    
}
