/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Matrimony.Entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author TuyenDN
 */
@Entity
@Table(name = "Cities", catalog = "Matrimony", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cities.findAll", query = "SELECT c FROM Cities c"),
    @NamedQuery(name = "Cities.findByCityID", query = "SELECT c FROM Cities c WHERE c.cityID = :cityID"),
    @NamedQuery(name = "Cities.findByCityName", query = "SELECT c FROM Cities c WHERE c.cityName = :cityName"),
    @NamedQuery(name = "Cities.findByCountryName", query = "SELECT c FROM Cities c WHERE c.countryName = :countryName"),
    @NamedQuery(name = "Cities.findByStatus", query = "SELECT c FROM Cities c WHERE c.status = :status")})
public class Cities implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @NotNull
    @Column(name = "CityID", nullable = false)
    private Integer cityID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "CityName", nullable = false, length = 250)
    private String cityName;
    @Size(max = 50)
    @Column(name = "CountryName", length = 50)
    private String countryName;
    @Column(name = "Status")
    private Integer status;

    public Cities() {
    }

    public Cities(Integer cityID) {
        this.cityID = cityID;
    }

    public Cities(Integer cityID, String cityName, String countryName, Integer status) {
        this.cityID = cityID;
        this.cityName = cityName;
        this.countryName = countryName;
        this.status = status;
    }

    public Integer getCityID() {
        return cityID;
    }

    public void setCityID(Integer cityID) {
        this.cityID = cityID;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
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
        hash += (cityID != null ? cityID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cities)) {
            return false;
        }
        Cities other = (Cities) object;
        if ((this.cityID == null && other.cityID != null) || (this.cityID != null && !this.cityID.equals(other.cityID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Matrimony.Entities.Cities[ cityID=" + cityID + " ]";
    }
    
}
