/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tdt.edu.persistence;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Diep Nguyen
 */
@Entity
@Table(name = "BOOKS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Books.findAll", query = "SELECT b FROM Books b")
    , @NamedQuery(name = "Books.findById", query = "SELECT b FROM Books b WHERE b.id = :id")
    , @NamedQuery(name = "Books.findByName", query = "SELECT b FROM Books b WHERE b.name = :name")
    , @NamedQuery(name = "Books.findByCategoryId", query = "SELECT b FROM Books b WHERE b.categoryId = :categoryId")
    , @NamedQuery(name = "Books.findByPublisherId", query = "SELECT b FROM Books b WHERE b.publisherId = :publisherId")
    , @NamedQuery(name = "Books.findByAuthorId", query = "SELECT b FROM Books b WHERE b.authorId = :authorId")
    , @NamedQuery(name = "Books.findByQuality", query = "SELECT b FROM Books b WHERE b.quality = :quality")
    , @NamedQuery(name = "Books.findByCost", query = "SELECT b FROM Books b WHERE b.cost = :cost")
    , @NamedQuery(name = "Books.findByDescription", query = "SELECT b FROM Books b WHERE b.description = :description")})
public class Books implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Size(max = 200)
    @Column(name = "NAME")
    private String name;
    @Column(name = "CATEGORY_ID")
    private Integer categoryId;
    @Column(name = "PUBLISHER_ID")
    private Integer publisherId;
    @Column(name = "AUTHOR_ID")
    private Integer authorId;
    @Column(name = "QUALITY")
    private Integer quality;
    @Column(name = "COST")
    private Integer cost;
    @Size(max = 1000)
    @Column(name = "DESCRIPTION")
    private String description;

    public Books() {
    }

    public Books(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(Integer publisherId) {
        this.publisherId = publisherId;
    }

    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    public Integer getQuality() {
        return quality;
    }

    public void setQuality(Integer quality) {
        this.quality = quality;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Books)) {
            return false;
        }
        Books other = (Books) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tdt.edu.persistence.Books[ id=" + id + " ]";
    }
    
}
