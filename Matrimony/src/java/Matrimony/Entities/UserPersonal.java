/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Matrimony.Entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author TuyenDN
 */
@Entity
@Table(name = "UserPersonal", catalog = "Matrimony", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserPersonal.findAll", query = "SELECT u FROM UserPersonal u"),
    @NamedQuery(name = "UserPersonal.findByUserID", query = "SELECT u FROM UserPersonal u WHERE u.userID = :userID"),
    @NamedQuery(name = "UserPersonal.findBySelfFeatures", query = "SELECT u FROM UserPersonal u WHERE u.selfFeatures = :selfFeatures"),
    @NamedQuery(name = "UserPersonal.findByFamilyDetails", query = "SELECT u FROM UserPersonal u WHERE u.familyDetails = :familyDetails"),
    @NamedQuery(name = "UserPersonal.findByQualificationStatus", query = "SELECT u FROM UserPersonal u WHERE u.qualificationStatus = :qualificationStatus"),
    @NamedQuery(name = "UserPersonal.findByDesignation", query = "SELECT u FROM UserPersonal u WHERE u.designation = :designation"),
    @NamedQuery(name = "UserPersonal.findByLocation", query = "SELECT u FROM UserPersonal u WHERE u.location = :location"),
    @NamedQuery(name = "UserPersonal.findByFavoriteHobbies", query = "SELECT u FROM UserPersonal u WHERE u.favoriteHobbies = :favoriteHobbies"),
    @NamedQuery(name = "UserPersonal.findByFavoriteMusics", query = "SELECT u FROM UserPersonal u WHERE u.favoriteMusics = :favoriteMusics"),
    @NamedQuery(name = "UserPersonal.findByFavoriteMovies", query = "SELECT u FROM UserPersonal u WHERE u.favoriteMovies = :favoriteMovies"),
    @NamedQuery(name = "UserPersonal.findByFavoriteBooks", query = "SELECT u FROM UserPersonal u WHERE u.favoriteBooks = :favoriteBooks"),
    @NamedQuery(name = "UserPersonal.findByFavoriteCuisines", query = "SELECT u FROM UserPersonal u WHERE u.favoriteCuisines = :favoriteCuisines"),
    @NamedQuery(name = "UserPersonal.findByFavoritePlace", query = "SELECT u FROM UserPersonal u WHERE u.favoritePlace = :favoritePlace")})
public class UserPersonal implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "UserID", nullable = false)
    private Integer userID;
    @Size(max = 250)
    @Column(name = "SelfFeatures", length = 250)
    private String selfFeatures;
    @Size(max = 250)
    @Column(name = "FamilyDetails", length = 250)
    private String familyDetails;
    @Size(max = 250)
    @Column(name = "QualificationStatus", length = 250)
    private String qualificationStatus;
    @Size(max = 250)
    @Column(name = "Designation", length = 250)
    private String designation;
    @Size(max = 250)
    @Column(name = "Location", length = 250)
    private String location;
    @Size(max = 250)
    @Column(name = "FavoriteHobbies", length = 250)
    private String favoriteHobbies;
    @Size(max = 250)
    @Column(name = "FavoriteMusics", length = 250)
    private String favoriteMusics;
    @Size(max = 250)
    @Column(name = "FavoriteMovies", length = 250)
    private String favoriteMovies;
    @Size(max = 250)
    @Column(name = "FavoriteBooks", length = 250)
    private String favoriteBooks;
    @Size(max = 250)
    @Column(name = "favoriteCuisines", length = 250)
    private String favoriteCuisines;
    @Size(max = 250)
    @Column(name = "FavoritePlace", length = 250)
    private String favoritePlace;
    @JoinColumn(name = "UserID", referencedColumnName = "UserID", nullable = false, insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Users users;

    public UserPersonal() {
    }

    public UserPersonal(Integer userID) {
        this.userID = userID;
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public String getSelfFeatures() {
        return selfFeatures;
    }

    public void setSelfFeatures(String selfFeatures) {
        this.selfFeatures = selfFeatures;
    }

    public String getFamilyDetails() {
        return familyDetails;
    }

    public void setFamilyDetails(String familyDetails) {
        this.familyDetails = familyDetails;
    }

    public String getQualificationStatus() {
        return qualificationStatus;
    }

    public void setQualificationStatus(String qualificationStatus) {
        this.qualificationStatus = qualificationStatus;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getFavoriteHobbies() {
        return favoriteHobbies;
    }

    public void setFavoriteHobbies(String favoriteHobbies) {
        this.favoriteHobbies = favoriteHobbies;
    }

    public String getFavoriteMusics() {
        return favoriteMusics;
    }

    public void setFavoriteMusics(String favoriteMusics) {
        this.favoriteMusics = favoriteMusics;
    }

    public String getFavoriteMovies() {
        return favoriteMovies;
    }

    public void setFavoriteMovies(String favoriteMovies) {
        this.favoriteMovies = favoriteMovies;
    }

    public String getFavoriteBooks() {
        return favoriteBooks;
    }

    public void setFavoriteBooks(String favoriteBooks) {
        this.favoriteBooks = favoriteBooks;
    }

    public String getFavoriteCuisines() {
        return favoriteCuisines;
    }

    public void setFavoriteCuisines(String favoriteCuisines) {
        this.favoriteCuisines = favoriteCuisines;
    }

    public String getFavoritePlace() {
        return favoritePlace;
    }

    public void setFavoritePlace(String favoritePlace) {
        this.favoritePlace = favoritePlace;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userID != null ? userID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserPersonal)) {
            return false;
        }
        UserPersonal other = (UserPersonal) object;
        if ((this.userID == null && other.userID != null) || (this.userID != null && !this.userID.equals(other.userID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Matrimony.Entities.UserPersonal[ userID=" + userID + " ]";
    }
    
}
