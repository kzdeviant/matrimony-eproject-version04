/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Matrimony.Facades;

import Matrimony.Entities.SiteContact;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author TuyenDN
 */
public class SiteContactFacade {
    
    private EntityManager em;

    public SiteContactFacade() {
        em = Persistence.createEntityManagerFactory("MatrimonyPU").createEntityManager();
    }

    public SiteContact getUserByID(SiteContact pSiteContact) {
        SiteContact u = null;
        u = (SiteContact) em.createNamedQuery("SiteContact.findByContactID").setParameter("contactID", pSiteContact.getContactID()).getSingleResult();
        return u;
    }

    //Get list SiteContact non conditions
    public List<SiteContact> getAllSiteContact(int pageNumber, int pageSize) {
        List<SiteContact> list;
        Query q = em.createNamedQuery("SiteContact.findAll");
        q.setFirstResult(pageSize * pageNumber);
        q.setMaxResults(pageSize);
        list = q.getResultList();
        return list;
    }

    //Get list SiteContact by Status
    public List<SiteContact> getAllSiteContactByStatus(int status, int pageNumber, int pageSize) {
        List<SiteContact> list;
        Query q = em.createNamedQuery("SiteContact.findByStatus", SiteContact.class);
        q.setParameter("status", status);
        q.setFirstResult(pageSize * pageNumber);
        q.setMaxResults(pageSize);
        list = q.getResultList();
        return list;
    }

    //Create SiteContact
    public int SiteContactCreate(SiteContact u) throws Exception {
        try {
            if (!em.getTransaction().isActive()) {
                em.getTransaction().begin();
            }
            em.persist(u);
            em.getTransaction().commit();
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
        return 1;
    }

    //Update SiteContact
    public int SiteContactUpdate(SiteContact u) throws Exception {
        try {
            if (!em.getTransaction().isActive()) {
                em.getTransaction().begin();
            }
            if (u != null) {
                em.merge(u);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
        return 1;
    }

    //Delete SiteContact - set status = 0
    public int SiteContactDelete(SiteContact u) throws Exception {
        try {
            if (!em.getTransaction().isActive()) {
                em.getTransaction().begin();
            }
            if (u != null) {
                u.setStatus(0);
                em.merge(u);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
        return 1;
    }
    
}
