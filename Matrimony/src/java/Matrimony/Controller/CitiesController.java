/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Matrimony.Controller;

import Matrimony.Entities.Cities;
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
    private String code;
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
            city = new Cities(-1, cityName, code, 1);
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
    
    public void cityUpdate()
    {
         if (citiesFacade == null) {
            citiesFacade = new CitiesFacade();
        }
        Cities city;
        try {
            city = new Cities(selectedCity.getCityID(), selectedCity.getCityName(), selectedCity.getCountryName(), selectedCity.getStatus());
            int result = citiesFacade.CityUpdate(city);
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

    public Cities getSelectedCity() {
        return selectedCity;
    }

    public void setSelectedCity(Cities selectedCity) {
        this.selectedCity = selectedCity;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
    
    
}
