/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.com.goit.gojava7.salivon.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Salivon Ivan
 */
@Entity
@Table(name = "payment")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Payment.findAll", query = "SELECT p FROM Payment p"),
    @NamedQuery(name = "Payment.findByIdInvestor", query = "SELECT p FROM Payment p WHERE p.idInvestor = :idInvestor"),
    @NamedQuery(name = "Payment.findByName", query = "SELECT p FROM Payment p WHERE p.name = :name"),
    @NamedQuery(name = "Payment.findByNumberCard", query = "SELECT p FROM Payment p WHERE p.numberCard = :numberCard"),
    @NamedQuery(name = "Payment.findByTotal", query = "SELECT p FROM Payment p WHERE p.total = :total")})
public class Payment implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IdInvestor")
    private Integer idInvestor;
    @Basic(optional = false)
    @Column(name = "Name")
    private String name;
    @Basic(optional = false)
    @Column(name = "NumberCard")
    private long numberCard;
    @Basic(optional = false)
    @Column(name = "Total")
    private int total;
    @JoinTable(name = "project_payment", joinColumns = {
        @JoinColumn(name = "IdInvestor", referencedColumnName = "IdInvestor")}, inverseJoinColumns = {
        @JoinColumn(name = "IdProject", referencedColumnName = "IdProject")})
    @ManyToMany
    private Collection<Project> projectCollection;
    @JoinColumn(name = "IdProject", referencedColumnName = "IdProject")
    @ManyToOne
    private Project idProject;

    public Payment() {
    }

    public Payment(Integer idInvestor) {
        this.idInvestor = idInvestor;
    }

    public Payment(Integer idInvestor, String name, long numberCard, int total) {
        this.idInvestor = idInvestor;
        this.name = name;
        this.numberCard = numberCard;
        this.total = total;
    }

    public Integer getIdInvestor() {
        return idInvestor;
    }

    public void setIdInvestor(Integer idInvestor) {
        this.idInvestor = idInvestor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getNumberCard() {
        return numberCard;
    }

    public void setNumberCard(long numberCard) {
        this.numberCard = numberCard;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    @XmlTransient
    public Collection<Project> getProjectCollection() {
        return projectCollection;
    }

    public void setProjectCollection(Collection<Project> projectCollection) {
        this.projectCollection = projectCollection;
    }

    public Project getIdProject() {
        return idProject;
    }

    public void setIdProject(Project idProject) {
        this.idProject = idProject;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idInvestor != null ? idInvestor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Payment)) {
            return false;
        }
        Payment other = (Payment) object;
        if ((this.idInvestor == null && other.idInvestor != null) || (this.idInvestor != null && !this.idInvestor.equals(other.idInvestor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ua.com.goit.gojava7.salivon.entity.Payment[ idInvestor=" + idInvestor + " ]";
    }
    
}
