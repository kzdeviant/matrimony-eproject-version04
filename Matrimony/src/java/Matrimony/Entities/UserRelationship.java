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
@Table(name = "UserRelationship", catalog = "Matrimony", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserRelationship.findAll", query = "SELECT u FROM UserRelationship u"),
    @NamedQuery(name = "UserRelationship.findByRelationID", query = "SELECT u FROM UserRelationship u WHERE u.relationID = :relationID"),
    @NamedQuery(name = "UserRelationship.findByRelationship", query = "SELECT u FROM UserRelationship u WHERE u.relationship = :relationship"),
    @NamedQuery(name = "UserRelationship.findByCreatedDate", query = "SELECT u FROM UserRelationship u WHERE u.createdDate = :createdDate"),
    @NamedQuery(name = "UserRelationship.findByStatus", query = "SELECT u FROM UserRelationship u WHERE u.status = :status")})
public class UserRelationship implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "RelationID", nullable = false)
    private Integer relationID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "Relationship", nullable = false, length = 250)
    private String relationship;
    @Column(name = "CreatedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    @Column(name = "Status")
    private Integer status;
    @JoinColumn(name = "ResUserID", referencedColumnName = "UserID")
    @ManyToOne
    private Users resUserID;
    @JoinColumn(name = "ReqUserID", referencedColumnName = "UserID")
    @ManyToOne
    private Users reqUserID;

    public UserRelationship() {
    }

    public UserRelationship(Integer relationID) {
        this.relationID = relationID;
    }

    public UserRelationship(Integer relationID, String relationship) {
        this.relationID = relationID;
        this.relationship = relationship;
    }

    public Integer getRelationID() {
        return relationID;
    }

    public void setRelationID(Integer relationID) {
        this.relationID = relationID;
    }

    public String getRelationship() {
        return relationship;
    }

    public void setRelationship(String relationship) {
        this.relationship = relationship;
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

    public Users getResUserID() {
        return resUserID;
    }

    public void setResUserID(Users resUserID) {
        this.resUserID = resUserID;
    }

    public Users getReqUserID() {
        return reqUserID;
    }

    public void setReqUserID(Users reqUserID) {
        this.reqUserID = reqUserID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (relationID != null ? relationID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserRelationship)) {
            return false;
        }
        UserRelationship other = (UserRelationship) object;
        if ((this.relationID == null && other.relationID != null) || (this.relationID != null && !this.relationID.equals(other.relationID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Matrimony.Entities.UserRelationship[ relationID=" + relationID + " ]";
    }
    
}
