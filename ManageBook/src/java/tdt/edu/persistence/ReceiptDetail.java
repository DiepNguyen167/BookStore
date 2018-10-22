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
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Diep Nguyen
 */
@Entity
@Table(name = "RECEIPT_DETAIL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ReceiptDetail.findAll", query = "SELECT r FROM ReceiptDetail r")
    , @NamedQuery(name = "ReceiptDetail.findByReceiptId", query = "SELECT r FROM ReceiptDetail r WHERE r.receiptId = :receiptId")
    , @NamedQuery(name = "ReceiptDetail.findByBookId", query = "SELECT r FROM ReceiptDetail r WHERE r.bookId = :bookId")
    , @NamedQuery(name = "ReceiptDetail.findByQuality", query = "SELECT r FROM ReceiptDetail r WHERE r.quality = :quality")
    , @NamedQuery(name = "ReceiptDetail.findByCost", query = "SELECT r FROM ReceiptDetail r WHERE r.cost = :cost")})
public class ReceiptDetail implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "RECEIPT_ID")
    private Integer receiptId;
    @Column(name = "BOOK_ID")
    private Integer bookId;
    @Column(name = "QUALITY")
    private Integer quality;
    @Column(name = "COST")
    private Integer cost;

    public ReceiptDetail() {
    }

    public ReceiptDetail(Integer receiptId) {
        this.receiptId = receiptId;
    }

    public Integer getReceiptId() {
        return receiptId;
    }

    public void setReceiptId(Integer receiptId) {
        this.receiptId = receiptId;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (receiptId != null ? receiptId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ReceiptDetail)) {
            return false;
        }
        ReceiptDetail other = (ReceiptDetail) object;
        if ((this.receiptId == null && other.receiptId != null) || (this.receiptId != null && !this.receiptId.equals(other.receiptId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tdt.edu.persistence.ReceiptDetail[ receiptId=" + receiptId + " ]";
    }
    
}
