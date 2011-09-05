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
import javax.persistence.Lob;
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
@Table(name = "SiteContact", catalog = "Matrimony", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SiteContact.findAll", query = "SELECT s FROM SiteContact s"),
    @NamedQuery(name = "SiteContact.findByContactID", query = "SELECT s FROM SiteContact s WHERE s.contactID = :contactID"),
    @NamedQuery(name = "SiteContact.findByContactName", query = "SELECT s FROM SiteContact s WHERE s.contactName = :contactName"),
    @NamedQuery(name = "SiteContact.findByContactNumber", query = "SELECT s FROM SiteContact s WHERE s.contactNumber = :contactNumber"),
    @NamedQuery(name = "SiteContact.findByEmail", query = "SELECT s FROM SiteContact s WHERE s.email = :email"),
    @NamedQuery(name = "SiteContact.findByCreatedDate", query = "SELECT s FROM SiteContact s WHERE s.createdDate = :createdDate"),
    @NamedQuery(name = "SiteContact.findByStatus", query = "SELECT s FROM SiteContact s WHERE s.status = :status")})
public class SiteContact implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ContactID", nullable = false)
    private Integer contactID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "ContactName", nullable = false, length = 250)
    private String contactName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "ContactNumber", nullable = false, length = 250)
    private String contactNumber;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Email", nullable = false, length = 50)
    private String email;
    @Lob
    @Size(max = 1073741823)
    @Column(name = "Comment", length = 1073741823)
    private String comment;
    @Column(name = "CreatedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    @Column(name = "Status")
    private Integer status;

    public SiteContact() {
    }

    public SiteContact(Integer contactID) {
        this.contactID = contactID;
    }

    public SiteContact(Integer contactID, String contactName, String contactNumber, String email) {
        this.contactID = contactID;
        this.contactName = contactName;
        this.contactNumber = contactNumber;
        this.email = email;
    }

    public Integer getContactID() {
        return contactID;
    }

    public void setContactID(Integer contactID) {
        this.contactID = contactID;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (contactID != null ? contactID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SiteContact)) {
            return false;
        }
        SiteContact other = (SiteContact) object;
        if ((this.contactID == null && other.contactID != null) || (this.contactID != null && !this.contactID.equals(other.contactID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Matrimony.Entities.SiteContact[ contactID=" + contactID + " ]";
    }
    
}
