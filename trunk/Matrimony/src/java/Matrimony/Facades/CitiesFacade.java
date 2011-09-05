/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Matrimony.Facades;

import Matrimony.Entities.Cities;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author TuyenDN
 */
public class CitiesFacade {
    
    private EntityManager em;

    public CitiesFacade() {
        em = Persistence.createEntityManagerFactory("MatrimonyPU").createEntityManager();
    }

    public Cities getCityByID(Cities pCities) {
        Cities u = null;
        u = (Cities) em.createNamedQuery("Cities.findByCityID").setParameter("CityID", pCities.getCityID()).getSingleResult();
        return u;
    }

    //Get list City non conditions
    public List<Cities> getAllCities() {
        List<Cities> list;
        Query q = em.createNamedQuery("Cities.findAll");
        list = q.getResultList();
        return list;
    }

    //Create City
    public int CityCreate(Cities pCities) throws Exception {
        try {
            if (!em.getTransaction().isActive()) {
                em.getTransaction().begin();
            }
            em.persist(pCities);
            em.getTransaction().commit();
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
        return 1;
    }

    //Update City
    public int CityUpdate(Cities pCities) throws Exception {
        try {
            if (!em.getTransaction().isActive()) {
                em.getTransaction().begin();
            }
            if (pCities != null) {
                em.merge(pCities);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
        return 1;
    }

    //Delete user - set status = 0
    public int CityDelete(Cities pCities) throws Exception {
        try {
            if (!em.getTransaction().isActive()) {
                em.getTransaction().begin();
            }
            if (pCities != null) {
                pCities.setStatus(0);
                em.merge(pCities);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
        return 1;
    }
}
