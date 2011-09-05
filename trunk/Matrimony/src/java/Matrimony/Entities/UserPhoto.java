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
@Table(name = "userPhoto", catalog = "Matrimony", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserPhoto.findAll", query = "SELECT u FROM UserPhoto u"),
    @NamedQuery(name = "UserPhoto.findByPhotoID", query = "SELECT u FROM UserPhoto u WHERE u.photoID = :photoID"),
    @NamedQuery(name = "UserPhoto.findByPhotoLabel", query = "SELECT u FROM UserPhoto u WHERE u.photoLabel = :photoLabel"),
    @NamedQuery(name = "UserPhoto.findByPhotoProfile", query = "SELECT u FROM UserPhoto u WHERE u.photoProfile = :photoProfile"),
    @NamedQuery(name = "UserPhoto.findByIsMainAvatar", query = "SELECT u FROM UserPhoto u WHERE u.isMainAvatar = :isMainAvatar"),
    @NamedQuery(name = "UserPhoto.findByFilePath", query = "SELECT u FROM UserPhoto u WHERE u.filePath = :filePath"),
    @NamedQuery(name = "UserPhoto.findByUploadDate", query = "SELECT u FROM UserPhoto u WHERE u.uploadDate = :uploadDate")})
public class UserPhoto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "PhotoID", nullable = false)
    private Integer photoID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "PhotoLabel", nullable = false, length = 250)
    private String photoLabel;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 525)
    @Column(name = "PhotoProfile", nullable = false, length = 525)
    private String photoProfile;
    @Column(name = "IsMainAvatar")
    private Integer isMainAvatar;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "FilePath", nullable = false, length = 250)
    private String filePath;
    @Column(name = "UploadDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date uploadDate;
    @JoinColumn(name = "AlbumID", referencedColumnName = "AlbumID")
    @ManyToOne
    private UserAlbum albumID;

    public UserPhoto() {
    }

    public UserPhoto(Integer photoID) {
        this.photoID = photoID;
    }

    public UserPhoto(Integer photoID, String photoLabel, String photoProfile, String filePath) {
        this.photoID = photoID;
        this.photoLabel = photoLabel;
        this.photoProfile = photoProfile;
        this.filePath = filePath;
    }

    public Integer getPhotoID() {
        return photoID;
    }

    public void setPhotoID(Integer photoID) {
        this.photoID = photoID;
    }

    public String getPhotoLabel() {
        return photoLabel;
    }

    public void setPhotoLabel(String photoLabel) {
        this.photoLabel = photoLabel;
    }

    public String getPhotoProfile() {
        return photoProfile;
    }

    public void setPhotoProfile(String photoProfile) {
        this.photoProfile = photoProfile;
    }

    public Integer getIsMainAvatar() {
        return isMainAvatar;
    }

    public void setIsMainAvatar(Integer isMainAvatar) {
        this.isMainAvatar = isMainAvatar;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public Date getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(Date uploadDate) {
        this.uploadDate = uploadDate;
    }

    public UserAlbum getAlbumID() {
        return albumID;
    }

    public void setAlbumID(UserAlbum albumID) {
        this.albumID = albumID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (photoID != null ? photoID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserPhoto)) {
            return false;
        }
        UserPhoto other = (UserPhoto) object;
        if ((this.photoID == null && other.photoID != null) || (this.photoID != null && !this.photoID.equals(other.photoID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Matrimony.Entities.UserPhoto[ photoID=" + photoID + " ]";
    }
    
}
