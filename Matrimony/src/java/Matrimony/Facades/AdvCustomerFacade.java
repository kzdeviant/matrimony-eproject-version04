/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Matrimony.Facades;

import Matrimony.Entities.AdvCustomer;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author TuyenDN
 */
public class AdvCustomerFacade {

    private EntityManager em;

    public AdvCustomerFacade() {
        em = Persistence.createEntityManagerFactory("MatrimonyPU").createEntityManager();
    }

    public AdvCustomer getUserByID(AdvCustomer pAdvCustomer) {
        AdvCustomer u = null;
        u = (AdvCustomer) em.createNamedQuery("AdvCustomer.findByCustomerID").setParameter("customerID", pAdvCustomer.getCustomerID()).getSingleResult();
        return u;
    }

    //Get list AdvCustomer non conditions
    public List<AdvCustomer> getAllAdvCustomer(int pageNumber, int pageSize) {
        List<AdvCustomer> list;
        Query q = em.createNamedQuery("AdvCustomer.findAll");
        q.setFirstResult(pageSize * pageNumber);
        q.setMaxResults(pageSize);
        list = q.getResultList();
        return list;
    }

    //Get list AdvCustomer by Status
    public List<AdvCustomer> getAllAdvCustomerByStatus(int status, int pageNumber, int pageSize) {
        List<AdvCustomer> list;
        Query q = em.createNamedQuery("AdvCustomer.findByStatus", AdvCustomer.class);
        q.setParameter("status", status);
        q.setFirstResult(pageSize * pageNumber);
        q.setMaxResults(pageSize);
        list = q.getResultList();
        return list;
    }

    //Create AdvCustomer
    public int AdvCustomerCreate(AdvCustomer u) throws Exception {
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

    //Update AdvCustomer
    public int AdvCustomerUpdate(AdvCustomer u) throws Exception {
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

    //Delete AdvCustomer - set status = 0
    public int AdvCustomerDelete(AdvCustomer u) throws Exception {
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
