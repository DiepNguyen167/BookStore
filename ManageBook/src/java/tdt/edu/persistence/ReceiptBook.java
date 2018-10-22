/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tdt.edu.persistence;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Diep Nguyen
 */
@Entity
@Table(name = "RECEIPT_BOOK")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ReceiptBook.findAll", query = "SELECT r FROM ReceiptBook r")
    , @NamedQuery(name = "ReceiptBook.findById", query = "SELECT r FROM ReceiptBook r WHERE r.id = :id")
    , @NamedQuery(name = "ReceiptBook.findByReceiptDate", query = "SELECT r FROM ReceiptBook r WHERE r.receiptDate = :receiptDate")
    , @NamedQuery(name = "ReceiptBook.findByEmployeeId", query = "SELECT r FROM ReceiptBook r WHERE r.employeeId = :employeeId")})
public class ReceiptBook implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "RECEIPT_DATE")
    @Temporal(TemporalType.DATE)
    private Date receiptDate;
    @Column(name = "EMPLOYEE_ID")
    private Integer employeeId;

    public ReceiptBook() {
    }

    public ReceiptBook(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getReceiptDate() {
        return receiptDate;
    }

    public void setReceiptDate(Date receiptDate) {
        this.receiptDate = receiptDate;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
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
        if (!(object instanceof ReceiptBook)) {
            return false;
        }
        ReceiptBook other = (ReceiptBook) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tdt.edu.persistence.ReceiptBook[ id=" + id + " ]";
    }
    
}
