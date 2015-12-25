package ua.com.goit.gojava7.salivon.beans;

import java.util.Calendar;
import java.util.Date;

public class Project {

    private int idProject;
    private int idCategory;
    private String title;
    private String description;
    private int total;
    private int numberOfDaysToImplement;
    private Date dateStart;
    private String historyProject;

    public Date getDateStart() {
        return dateStart;
    }

    public void setDateStart(Date date) {
        dateStart = date;

    }

    public int getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(int idCategory) {
        this.idCategory = idCategory;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getNumberOfDaysToImplement() {
        return numberOfDaysToImplement;
    }

    public void setNumberOfDaysToImplement(int numberOfDaysToImplement) {
        this.numberOfDaysToImplement = numberOfDaysToImplement;
    }

    public String getHistoryProject() {
        return historyProject;
    }

    public void setHistoryProject(String historyProject) {
        this.historyProject = historyProject;
    }

    public void setIdProject(int id) {
        this.idProject = id;
    }

    public int getIdProject() {
        return idProject;
    }

    public int getNumberOfDaysToEnd() {
        long milSecondStart = dateStart.getTime();
        long milSecondEnd = Calendar.getInstance().getTimeInMillis();
        int numberOfDaysInWork = (int) (milSecondEnd - milSecondStart) / (1000 * 60 * 60 * 24);
        return numberOfDaysToImplement - numberOfDaysInWork;
    }

}
