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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
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
@Table(name = "UserProfile", catalog = "Matrimony", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserProfile.findAll", query = "SELECT u FROM UserProfile u"),
    @NamedQuery(name = "UserProfile.findByUserID", query = "SELECT u FROM UserProfile u WHERE u.userID = :userID"),
    @NamedQuery(name = "UserProfile.findByFirstname", query = "SELECT u FROM UserProfile u WHERE u.firstname = :firstname"),
    @NamedQuery(name = "UserProfile.findByMiddleName", query = "SELECT u FROM UserProfile u WHERE u.middleName = :middleName"),
    @NamedQuery(name = "UserProfile.findByLastName", query = "SELECT u FROM UserProfile u WHERE u.lastName = :lastName"),
    @NamedQuery(name = "UserProfile.findByGender", query = "SELECT u FROM UserProfile u WHERE u.gender = :gender"),
    @NamedQuery(name = "UserProfile.findByDateOfBirth", query = "SELECT u FROM UserProfile u WHERE u.dateOfBirth = :dateOfBirth"),
    @NamedQuery(name = "UserProfile.findByMaritalStatus", query = "SELECT u FROM UserProfile u WHERE u.maritalStatus = :maritalStatus"),
    @NamedQuery(name = "UserProfile.findByHeight", query = "SELECT u FROM UserProfile u WHERE u.height = :height"),
    @NamedQuery(name = "UserProfile.findByWeight", query = "SELECT u FROM UserProfile u WHERE u.weight = :weight"),
    @NamedQuery(name = "UserProfile.findByMotherTongue", query = "SELECT u FROM UserProfile u WHERE u.motherTongue = :motherTongue"),
    @NamedQuery(name = "UserProfile.findByContactNumber", query = "SELECT u FROM UserProfile u WHERE u.contactNumber = :contactNumber"),
    @NamedQuery(name = "UserProfile.findByWork", query = "SELECT u FROM UserProfile u WHERE u.work = :work"),
    @NamedQuery(name = "UserProfile.findByReligion", query = "SELECT u FROM UserProfile u WHERE u.religion = :religion"),
    @NamedQuery(name = "UserProfile.findByCaste", query = "SELECT u FROM UserProfile u WHERE u.caste = :caste"),
    @NamedQuery(name = "UserProfile.findByCountryLiving", query = "SELECT u FROM UserProfile u WHERE u.countryLiving = :countryLiving"),
    @NamedQuery(name = "UserProfile.findByCity", query = "SELECT u FROM UserProfile u WHERE u.city = :city")})
public class UserProfile implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "UserID", nullable = false)
    private Integer userID;
    @Size(max = 50)
    @Column(name = "Firstname", length = 50)
    private String firstname;
    @Size(max = 50)
    @Column(name = "MiddleName", length = 50)
    private String middleName;
    @Size(max = 50)
    @Column(name = "LastName", length = 50)
    private String lastName;
    @Column(name = "Gender")
    private Integer gender;
    @Column(name = "DateOfBirth")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateOfBirth;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "MaritalStatus", nullable = false, length = 50)
    private String maritalStatus;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "Height", precision = 53)
    private Double height;
    @Column(name = "Weight", precision = 53)
    private Double weight;
    @Size(max = 250)
    @Column(name = "MotherTongue", length = 250)
    private String motherTongue;
    @Size(max = 50)
    @Column(name = "ContactNumber", length = 50)
    private String contactNumber;
    @Size(max = 250)
    @Column(name = "Work", length = 250)
    private String work;
    @Size(max = 255)
    @Column(name = "Religion", length = 255)
    private String religion;
    @Size(max = 255)
    @Column(name = "Caste", length = 255)
    private String caste;
    @Size(max = 255)
    @Column(name = "countryLiving", length = 255)
    private String countryLiving;
    @Size(max = 200)
    @Column(name = "City", length = 200)
    private String city;
    @JoinColumn(name = "UserID", referencedColumnName = "UserID", nullable = false, insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Users users;

    public UserProfile() {
    }

    public UserProfile(Integer userID) {
        this.userID = userID;
    }

    public UserProfile(Integer userID, String maritalStatus) {
        this.userID = userID;
        this.maritalStatus = maritalStatus;
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public String getMotherTongue() {
        return motherTongue;
    }

    public void setMotherTongue(String motherTongue) {
        this.motherTongue = motherTongue;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getWork() {
        return work;
    }

    public void setWork(String work) {
        this.work = work;
    }

    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    public String getCaste() {
        return caste;
    }

    public void setCaste(String caste) {
        this.caste = caste;
    }

    public String getCountryLiving() {
        return countryLiving;
    }

    public void setCountryLiving(String countryLiving) {
        this.countryLiving = countryLiving;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
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
        if (!(object instanceof UserProfile)) {
            return false;
        }
        UserProfile other = (UserProfile) object;
        if ((this.userID == null && other.userID != null) || (this.userID != null && !this.userID.equals(other.userID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Matrimony.Entities.UserProfile[ userID=" + userID + " ]";
    }
    
}
