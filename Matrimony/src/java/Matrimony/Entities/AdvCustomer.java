/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Matrimony.Entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author TuyenDN
 */
@Entity
@Table(name = "AdvCustomer", catalog = "Matrimony", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AdvCustomer.findAll", query = "SELECT a FROM AdvCustomer a"),
    @NamedQuery(name = "AdvCustomer.findByCustomerID", query = "SELECT a FROM AdvCustomer a WHERE a.customerID = :customerID"),
    @NamedQuery(name = "AdvCustomer.findByFullName", query = "SELECT a FROM AdvCustomer a WHERE a.fullName = :fullName"),
    @NamedQuery(name = "AdvCustomer.findByEmail", query = "SELECT a FROM AdvCustomer a WHERE a.email = :email"),
    @NamedQuery(name = "AdvCustomer.findByGender", query = "SELECT a FROM AdvCustomer a WHERE a.gender = :gender"),
    @NamedQuery(name = "AdvCustomer.findByCompany", query = "SELECT a FROM AdvCustomer a WHERE a.company = :company"),
    @NamedQuery(name = "AdvCustomer.findByPhone", query = "SELECT a FROM AdvCustomer a WHERE a.phone = :phone"),
    @NamedQuery(name = "AdvCustomer.findByContactAddress", query = "SELECT a FROM AdvCustomer a WHERE a.contactAddress = :contactAddress"),
    @NamedQuery(name = "AdvCustomer.findByNote", query = "SELECT a FROM AdvCustomer a WHERE a.note = :note"),
    @NamedQuery(name = "AdvCustomer.findByEdition", query = "SELECT a FROM AdvCustomer a WHERE a.edition = :edition"),
    @NamedQuery(name = "AdvCustomer.findByPostContent", query = "SELECT a FROM AdvCustomer a WHERE a.postContent = :postContent"),
    @NamedQuery(name = "AdvCustomer.findByCreatedDate", query = "SELECT a FROM AdvCustomer a WHERE a.createdDate = :createdDate"),
    @NamedQuery(name = "AdvCustomer.findByStatus", query = "SELECT a FROM AdvCustomer a WHERE a.status = :status")})
public class AdvCustomer implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CustomerID", nullable = false)
    private Integer customerID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "FullName", nullable = false, length = 250)
    private String fullName;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Email", nullable = false, length = 50)
    private String email;
    @Column(name = "Gender")
    private Boolean gender;
    @Size(max = 50)
    @Column(name = "Company", length = 50)
    private String company;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Size(max = 125)
    @Column(name = "Phone", length = 125)
    private String phone;
    @Size(max = 525)
    @Column(name = "ContactAddress", length = 525)
    private String contactAddress;
    @Size(max = 525)
    @Column(name = "Note", length = 525)
    private String note;
    @Size(max = 250)
    @Column(name = "Edition", length = 250)
    private String edition;
    @Size(max = 525)
    @Column(name = "PostContent", length = 525)
    private String postContent;
    @Column(name = "CreatedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    @Column(name = "Status")
    private Integer status;
    @OneToMany(mappedBy = "customerID")
    private List<AdvCustomerPayment> advCustomerPaymentList;

    public AdvCustomer() {
    }

    public AdvCustomer(Integer customerID) {
        this.customerID = customerID;
    }

    public AdvCustomer(Integer customerID, String fullName, String email) {
        this.customerID = customerID;
        this.fullName = fullName;
        this.email = email;
    }

    public Integer getCustomerID() {
        return customerID;
    }

    public void setCustomerID(Integer customerID) {
        this.customerID = customerID;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getContactAddress() {
        return contactAddress;
    }

    public void setContactAddress(String contactAddress) {
        this.contactAddress = contactAddress;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    public String getPostContent() {
        return postContent;
    }

    public void setPostContent(String postContent) {
        this.postContent = postContent;
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

    @XmlTransient
    public List<AdvCustomerPayment> getAdvCustomerPaymentList() {
        return advCustomerPaymentList;
    }

    public void setAdvCustomerPaymentList(List<AdvCustomerPayment> advCustomerPaymentList) {
        this.advCustomerPaymentList = advCustomerPaymentList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (customerID != null ? customerID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AdvCustomer)) {
            return false;
        }
        AdvCustomer other = (AdvCustomer) object;
        if ((this.customerID == null && other.customerID != null) || (this.customerID != null && !this.customerID.equals(other.customerID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Matrimony.Entities.AdvCustomer[ customerID=" + customerID + " ]";
    }
    
}
