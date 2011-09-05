/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Matrimony.Entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author TuyenDN
 */
@Entity
@Table(name = "UserServicePackage", catalog = "Matrimony", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserServicePackage.findAll", query = "SELECT u FROM UserServicePackage u"),
    @NamedQuery(name = "UserServicePackage.findByServiceID", query = "SELECT u FROM UserServicePackage u WHERE u.serviceID = :serviceID"),
    @NamedQuery(name = "UserServicePackage.findByServiceName", query = "SELECT u FROM UserServicePackage u WHERE u.serviceName = :serviceName"),
    @NamedQuery(name = "UserServicePackage.findByDescription", query = "SELECT u FROM UserServicePackage u WHERE u.description = :description"),
    @NamedQuery(name = "UserServicePackage.findByPrice", query = "SELECT u FROM UserServicePackage u WHERE u.price = :price"),
    @NamedQuery(name = "UserServicePackage.findByStatus", query = "SELECT u FROM UserServicePackage u WHERE u.status = :status")})
public class UserServicePackage implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ServiceID", nullable = false)
    private Integer serviceID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "ServiceName", nullable = false, length = 50)
    private String serviceName;
    @Size(max = 60)
    @Column(name = "Description", length = 60)
    private String description;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Price", nullable = false)
    private double price;
    @Column(name = "Status")
    private Integer status;
    @OneToMany(mappedBy = "serviceID")
    private List<UserServiceCharge> userServiceChargeList;

    public UserServicePackage() {
    }

    public UserServicePackage(Integer serviceID) {
        this.serviceID = serviceID;
    }

    public UserServicePackage(Integer serviceID, String serviceName, double price) {
        this.serviceID = serviceID;
        this.serviceName = serviceName;
        this.price = price;
    }

    public Integer getServiceID() {
        return serviceID;
    }

    public void setServiceID(Integer serviceID) {
        this.serviceID = serviceID;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @XmlTransient
    public List<UserServiceCharge> getUserServiceChargeList() {
        return userServiceChargeList;
    }

    public void setUserServiceChargeList(List<UserServiceCharge> userServiceChargeList) {
        this.userServiceChargeList = userServiceChargeList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (serviceID != null ? serviceID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserServicePackage)) {
            return false;
        }
        UserServicePackage other = (UserServicePackage) object;
        if ((this.serviceID == null && other.serviceID != null) || (this.serviceID != null && !this.serviceID.equals(other.serviceID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Matrimony.Entities.UserServicePackage[ serviceID=" + serviceID + " ]";
    }
    
}
