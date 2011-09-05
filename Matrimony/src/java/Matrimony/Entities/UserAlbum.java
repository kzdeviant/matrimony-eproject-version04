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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "UserAlbum", catalog = "Matrimony", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserAlbum.findAll", query = "SELECT u FROM UserAlbum u"),
    @NamedQuery(name = "UserAlbum.findByAlbumID", query = "SELECT u FROM UserAlbum u WHERE u.albumID = :albumID"),
    @NamedQuery(name = "UserAlbum.findByAlbumTitle", query = "SELECT u FROM UserAlbum u WHERE u.albumTitle = :albumTitle"),
    @NamedQuery(name = "UserAlbum.findByAlbumProfile", query = "SELECT u FROM UserAlbum u WHERE u.albumProfile = :albumProfile"),
    @NamedQuery(name = "UserAlbum.findByLastUpdated", query = "SELECT u FROM UserAlbum u WHERE u.lastUpdated = :lastUpdated"),
    @NamedQuery(name = "UserAlbum.findByCreatedDate", query = "SELECT u FROM UserAlbum u WHERE u.createdDate = :createdDate"),
    @NamedQuery(name = "UserAlbum.findByStatus", query = "SELECT u FROM UserAlbum u WHERE u.status = :status")})
public class UserAlbum implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "AlbumID", nullable = false)
    private Integer albumID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "AlbumTitle", nullable = false, length = 250)
    private String albumTitle;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "AlbumProfile", nullable = false, length = 250)
    private String albumProfile;
    @Column(name = "LastUpdated")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdated;
    @Column(name = "CreatedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    @Column(name = "Status")
    private Integer status;
    @OneToMany(mappedBy = "albumID")
    private List<UserPhoto> userPhotoList;
    @JoinColumn(name = "UserID", referencedColumnName = "UserID")
    @ManyToOne
    private Users userID;

    public UserAlbum() {
    }

    public UserAlbum(Integer albumID) {
        this.albumID = albumID;
    }

    public UserAlbum(Integer albumID, String albumTitle, String albumProfile) {
        this.albumID = albumID;
        this.albumTitle = albumTitle;
        this.albumProfile = albumProfile;
    }

    public Integer getAlbumID() {
        return albumID;
    }

    public void setAlbumID(Integer albumID) {
        this.albumID = albumID;
    }

    public String getAlbumTitle() {
        return albumTitle;
    }

    public void setAlbumTitle(String albumTitle) {
        this.albumTitle = albumTitle;
    }

    public String getAlbumProfile() {
        return albumProfile;
    }

    public void setAlbumProfile(String albumProfile) {
        this.albumProfile = albumProfile;
    }

    public Date getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
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
    public List<UserPhoto> getUserPhotoList() {
        return userPhotoList;
    }

    public void setUserPhotoList(List<UserPhoto> userPhotoList) {
        this.userPhotoList = userPhotoList;
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
        hash += (albumID != null ? albumID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserAlbum)) {
            return false;
        }
        UserAlbum other = (UserAlbum) object;
        if ((this.albumID == null && other.albumID != null) || (this.albumID != null && !this.albumID.equals(other.albumID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Matrimony.Entities.UserAlbum[ albumID=" + albumID + " ]";
    }
    
}
