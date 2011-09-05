/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Matrimony.Controller;

import Matrimony.Entities.Countries;
import Matrimony.Facades.CountriesFacade;
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
public class CountriesController {

    private String countryName;
    private String defaultLanguage;
    private String code;
    private int Status;
    private Countries selectedCountry;
    private CountriesFacade countriesFacade;

    /** Creates a new instance of CountriesController */
    public CountriesController() {
        countriesFacade = new CountriesFacade();
    }

    public List<Countries> getAllCountries() {
        if (countriesFacade == null) {
            countriesFacade = new CountriesFacade();
        }
        List<Countries> list = countriesFacade.getAllCountries();
        return list;
    }

    public void countryCreate() {
        if (countriesFacade == null) {
            countriesFacade = new CountriesFacade();
        }
        Countries country;
        try {
            country = new Countries(-1, countryName, defaultLanguage, code);
            int result = countriesFacade.CountryCreate(country);
            if (result > 0) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success Message", "Create country successful!!!"));
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error Message", "Can not create country. Please try again later"));
            }
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error Message", ex.getMessage()));
        } finally {
            country = null;
        }
    }

    public int getStatus() {
        return Status;
    }

    public void setStatus(int Status) {
        this.Status = Status;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getDefaultLanguage() {
        return defaultLanguage;
    }

    public void setDefaultLanguage(String defaultLanguage) {
        this.defaultLanguage = defaultLanguage;
    }

    public Countries getSelectedCountry() {
        return selectedCountry;
    }

    public void setSelectedCountry(Countries selectedCountry) {
        this.selectedCountry = selectedCountry;
    }
}
