/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Matrimony.Controller;

import Matrimony.Entities.Cities;
import Matrimony.Entities.Countries;
import Matrimony.Facades.CitiesFacade;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author TuyenDN
 */
@ManagedBean
@SessionScoped
public class CitiesController {

    private String cityName;
    private int countryID;
    private Cities selectedCity;
    private CitiesFacade citiesFacade;
    
    /** Creates a new instance of CitiesController */
    public CitiesController() {
        citiesFacade = new CitiesFacade();
    }

   public List<Cities> getAllCountries() {
        if (citiesFacade == null) {
            citiesFacade = new CitiesFacade();
        }
        List<Cities> list = citiesFacade.getAllCities();
        return list;
    }
        
    public void cityCreate() {
        if (citiesFacade == null) {
            citiesFacade = new CitiesFacade();
        }
        Cities city;
        try {
            Countries country = new Countries(countryID);
            city = new Cities(-1, cityName, country);
            int result = citiesFacade.CityCreate(city);
            if (result > 0) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success Message", "Create city successful!!!"));
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error Message", "Can not create city. Please try again later"));
            }
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error Message", ex.getMessage()));
        } finally {
            city = null;
        }
    }
    
    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public int getCountryID() {
        return countryID;
    }

    public void setCountryID(int countryID) {
        this.countryID = countryID;
    }

    public Cities getSelectedCity() {
        return selectedCity;
    }

    public void setSelectedCity(Cities selectedCity) {
        this.selectedCity = selectedCity;
    }
    
    
}
