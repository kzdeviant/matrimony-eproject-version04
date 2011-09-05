/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Matrimony.Facades;

import Matrimony.Entities.Countries;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author TuyenDN
 */
public class CountriesFacade {

    private EntityManager em;

    public CountriesFacade() {
        em = Persistence.createEntityManagerFactory("MatrimonyPU").createEntityManager();
    }

    public Countries getCountryByID(Countries pCountries) {
        Countries u = null;
        u = (Countries) em.createNamedQuery("Countries.findByCountryID").setParameter("countryID", pCountries.getCountryID()).getSingleResult();
        return u;
    }

    //Get list Country non conditions
    public List<Countries> getAllCountries() {
        List<Countries> list;
        Query q = em.createNamedQuery("Countries.findAll");
        list = q.getResultList();
        return list;
    }

    //Create Country
    public int CountryCreate(Countries pCountries) throws Exception {
        try {
            if (!em.getTransaction().isActive()) {
                em.getTransaction().begin();
            }
            em.persist(pCountries);
            em.getTransaction().commit();
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
        return 1;
    }

    //Update Country
    public int CountryUpdate(Countries pCountries) throws Exception {
        try {
            if (!em.getTransaction().isActive()) {
                em.getTransaction().begin();
            }
            if (pCountries != null) {
                em.merge(pCountries);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
        return 1;
    }

    //Delete user - set status = 0
    public int CountryDelete(Countries pCountries) throws Exception {
        try {
            if (!em.getTransaction().isActive()) {
                em.getTransaction().begin();
            }
            if (pCountries != null) {
                pCountries.setStatus(0);
                em.merge(pCountries);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
        return 1;
    }
}
