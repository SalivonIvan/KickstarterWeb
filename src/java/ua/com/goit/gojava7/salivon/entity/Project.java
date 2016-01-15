/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.com.goit.gojava7.salivon.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Salivon Ivan
 */
@Entity
@Table(name = "project")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Project.findAll", query = "SELECT p FROM Project p"),
    @NamedQuery(name = "Project.findByIdProject", query = "SELECT p FROM Project p WHERE p.idProject = :idProject"),
    @NamedQuery(name = "Project.findByTitle", query = "SELECT p FROM Project p WHERE p.title = :title"),
    @NamedQuery(name = "Project.findByTotal", query = "SELECT p FROM Project p WHERE p.total = :total"),
    @NamedQuery(name = "Project.findByDescription", query = "SELECT p FROM Project p WHERE p.description = :description"),
    @NamedQuery(name = "Project.findByHistoryProject", query = "SELECT p FROM Project p WHERE p.historyProject = :historyProject"),
    @NamedQuery(name = "Project.findByDateStart", query = "SELECT p FROM Project p WHERE p.dateStart = :dateStart"),
    @NamedQuery(name = "Project.findByPoster", query = "SELECT p FROM Project p WHERE p.poster = :poster"),
    @NamedQuery(name = "Project.findByNumberOfDaysToImplement", query = "SELECT p FROM Project p WHERE p.numberOfDaysToImplement = :numberOfDaysToImplement")})
public class Project implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IdProject")
    private Integer idProject;
    @Basic(optional = false)
    @Column(name = "Title")
    private String title;
    @Basic(optional = false)
    @Column(name = "Total")
    private int total;
    @Column(name = "Description")
    private String description;
    @Column(name = "HistoryProject")
    private String historyProject;
    @Column(name = "DateStart")
    @Temporal(TemporalType.DATE)
    private Date dateStart;
    @Column(name = "Poster")
    private String poster;
    @Column(name = "NumberOfDaysToImplement")
    private Integer numberOfDaysToImplement;
    @ManyToMany(mappedBy = "projectCollection")
    private Collection<Payment> paymentCollection;
    @JoinColumn(name = "IdCategory", referencedColumnName = "IdCategory")
    @ManyToOne
    private Category idCategory;
    @OneToMany(mappedBy = "idProject")
    private Collection<Payment> paymentCollection1;

    public Project() {
    }

    public Project(Integer idProject) {
        this.idProject = idProject;
    }

    public Project(Integer idProject, String title, int total) {
        this.idProject = idProject;
        this.title = title;
        this.total = total;
    }

    public Integer getIdProject() {
        return idProject;
    }

    public void setIdProject(Integer idProject) {
        this.idProject = idProject;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getHistoryProject() {
        return historyProject;
    }

    public void setHistoryProject(String historyProject) {
        this.historyProject = historyProject;
    }

    public Date getDateStart() {
        return dateStart;
    }

    public void setDateStart(Date dateStart) {
        this.dateStart = dateStart;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public Integer getNumberOfDaysToImplement() {
        return numberOfDaysToImplement;
    }

    public void setNumberOfDaysToImplement(Integer numberOfDaysToImplement) {
        this.numberOfDaysToImplement = numberOfDaysToImplement;
    }

    @XmlTransient
    public Collection<Payment> getPaymentCollection() {
        return paymentCollection;
    }

    public void setPaymentCollection(Collection<Payment> paymentCollection) {
        this.paymentCollection = paymentCollection;
    }

    public Category getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(Category idCategory) {
        this.idCategory = idCategory;
    }

    @XmlTransient
    public Collection<Payment> getPaymentCollection1() {
        return paymentCollection1;
    }

    public void setPaymentCollection1(Collection<Payment> paymentCollection1) {
        this.paymentCollection1 = paymentCollection1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProject != null ? idProject.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Project)) {
            return false;
        }
        Project other = (Project) object;
        if ((this.idProject == null && other.idProject != null) || (this.idProject != null && !this.idProject.equals(other.idProject))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ua.com.goit.gojava7.salivon.entity.Project[ idProject=" + idProject + " ]";
    }
    
}
