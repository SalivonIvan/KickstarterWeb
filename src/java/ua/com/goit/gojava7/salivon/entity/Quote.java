/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.com.goit.gojava7.salivon.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Salivon Ivan
 */
@Entity
@Table(name = "quote")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Quote.findAll", query = "SELECT q FROM Quote q"),
    @NamedQuery(name = "Quote.findByIdQuote", query = "SELECT q FROM Quote q WHERE q.idQuote = :idQuote"),
    @NamedQuery(name = "Quote.findByAuthor", query = "SELECT q FROM Quote q WHERE q.author = :author")})
public class Quote implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IdQuote")
    private Integer idQuote;
    @Basic(optional = false)
    @Lob
    @Column(name = "Text")
    private String text;
    @Basic(optional = false)
    @Column(name = "Author")
    private String author;

    public Quote() {
    }

    public Quote(Integer idQuote) {
        this.idQuote = idQuote;
    }

    public Quote(Integer idQuote, String text, String author) {
        this.idQuote = idQuote;
        this.text = text;
        this.author = author;
    }

    public Integer getIdQuote() {
        return idQuote;
    }

    public void setIdQuote(Integer idQuote) {
        this.idQuote = idQuote;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idQuote != null ? idQuote.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Quote)) {
            return false;
        }
        Quote other = (Quote) object;
        if ((this.idQuote == null && other.idQuote != null) || (this.idQuote != null && !this.idQuote.equals(other.idQuote))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ua.com.goit.gojava7.salivon.entity.Quote[ idQuote=" + idQuote + " ]";
    }
    
}
