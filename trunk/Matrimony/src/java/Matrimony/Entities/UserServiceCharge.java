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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author TuyenDN
 */
@Entity
@Table(name = "UserServiceCharge", catalog = "Matrimony", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserServiceCharge.findAll", query = "SELECT u FROM UserServiceCharge u"),
    @NamedQuery(name = "UserServiceCharge.findByChargeID", query = "SELECT u FROM UserServiceCharge u WHERE u.chargeID = :chargeID"),
    @NamedQuery(name = "UserServiceCharge.findByStartedDate", query = "SELECT u FROM UserServiceCharge u WHERE u.startedDate = :startedDate"),
    @NamedQuery(name = "UserServiceCharge.findByExpiredDate", query = "SELECT u FROM UserServiceCharge u WHERE u.expiredDate = :expiredDate"),
    @NamedQuery(name = "UserServiceCharge.findByStatus", query = "SELECT u FROM UserServiceCharge u WHERE u.status = :status")})
public class UserServiceCharge implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ChargeID", nullable = false)
    private Integer chargeID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "StartedDate", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date startedDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ExpiredDate", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date expiredDate;
    @Column(name = "Status")
    private Integer status;
    @JoinColumn(name = "ServiceID", referencedColumnName = "ServiceID")
    @ManyToOne
    private UserServicePackage serviceID;
    @JoinColumn(name = "UserID", referencedColumnName = "UserID")
    @ManyToOne
    private Users userID;

    public UserServiceCharge() {
    }

    public UserServiceCharge(Integer chargeID) {
        this.chargeID = chargeID;
    }

    public UserServiceCharge(Integer chargeID, Date startedDate, Date expiredDate) {
        this.chargeID = chargeID;
        this.startedDate = startedDate;
        this.expiredDate = expiredDate;
    }

    public Integer getChargeID() {
        return chargeID;
    }

    public void setChargeID(Integer chargeID) {
        this.chargeID = chargeID;
    }

    public Date getStartedDate() {
        return startedDate;
    }

    public void setStartedDate(Date startedDate) {
        this.startedDate = startedDate;
    }

    public Date getExpiredDate() {
        return expiredDate;
    }

    public void setExpiredDate(Date expiredDate) {
        this.expiredDate = expiredDate;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public UserServicePackage getServiceID() {
        return serviceID;
    }

    public void setServiceID(UserServicePackage serviceID) {
        this.serviceID = serviceID;
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
        hash += (chargeID != null ? chargeID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserServiceCharge)) {
            return false;
        }
        UserServiceCharge other = (UserServiceCharge) object;
        if ((this.chargeID == null && other.chargeID != null) || (this.chargeID != null && !this.chargeID.equals(other.chargeID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Matrimony.Entities.UserServiceCharge[ chargeID=" + chargeID + " ]";
    }
    
}
