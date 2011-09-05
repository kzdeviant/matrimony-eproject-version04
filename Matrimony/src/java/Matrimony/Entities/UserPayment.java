/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Matrimony.Entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author TuyenDN
 */
@Entity
@Table(name = "UserPayment", catalog = "Matrimony", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserPayment.findAll", query = "SELECT u FROM UserPayment u"),
    @NamedQuery(name = "UserPayment.findByPaymentID", query = "SELECT u FROM UserPayment u WHERE u.paymentID = :paymentID"),
    @NamedQuery(name = "UserPayment.findByPayGate", query = "SELECT u FROM UserPayment u WHERE u.payGate = :payGate"),
    @NamedQuery(name = "UserPayment.findByAccountID", query = "SELECT u FROM UserPayment u WHERE u.accountID = :accountID"),
    @NamedQuery(name = "UserPayment.findByTotalMoney", query = "SELECT u FROM UserPayment u WHERE u.totalMoney = :totalMoney"),
    @NamedQuery(name = "UserPayment.findByCreatedDate", query = "SELECT u FROM UserPayment u WHERE u.createdDate = :createdDate"),
    @NamedQuery(name = "UserPayment.findByStatus", query = "SELECT u FROM UserPayment u WHERE u.status = :status")})
public class UserPayment implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "PaymentID", nullable = false)
    private Integer paymentID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "PayGate", nullable = false, length = 50)
    private String payGate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "AccountID", nullable = false, length = 50)
    private String accountID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TotalMoney", nullable = false)
    private double totalMoney;
    @Column(name = "CreatedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    @Column(name = "Status")
    private Integer status;
    @JoinColumn(name = "UserID", referencedColumnName = "UserID")
    @ManyToOne
    private Users userID;

    public UserPayment() {
    }

    public UserPayment(Integer paymentID) {
        this.paymentID = paymentID;
    }

    public UserPayment(Integer paymentID, String payGate, String accountID, double totalMoney) {
        this.paymentID = paymentID;
        this.payGate = payGate;
        this.accountID = accountID;
        this.totalMoney = totalMoney;
    }

    public Integer getPaymentID() {
        return paymentID;
    }

    public void setPaymentID(Integer paymentID) {
        this.paymentID = paymentID;
    }

    public String getPayGate() {
        return payGate;
    }

    public void setPayGate(String payGate) {
        this.payGate = payGate;
    }

    public String getAccountID() {
        return accountID;
    }

    public void setAccountID(String accountID) {
        this.accountID = accountID;
    }

    public double getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(double totalMoney) {
        this.totalMoney = totalMoney;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Users getUserID() {
        return userID;
    }

    public void setUserID(Users userID) {
        this.userID = userID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (paymentID != null ? paymentID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserPayment)) {
            return false;
        }
        UserPayment other = (UserPayment) object;
        if ((this.paymentID == null && other.paymentID != null) || (this.paymentID != null && !this.paymentID.equals(other.paymentID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Matrimony.Entities.UserPayment[ paymentID=" + paymentID + " ]";
    }
    
}
