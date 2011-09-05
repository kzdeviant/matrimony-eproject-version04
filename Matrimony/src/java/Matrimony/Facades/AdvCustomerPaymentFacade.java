/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Matrimony.Facades;

import Matrimony.Entities.AdvCustomerPayment;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author TuyenDN
 */
public class AdvCustomerPaymentFacade {

    private EntityManager em;

    public AdvCustomerPaymentFacade() {
        em = Persistence.createEntityManagerFactory("MatrimonyPU").createEntityManager();
    }

    public AdvCustomerPayment getUserByID(AdvCustomerPayment pAdvCustomerPayment) {
        AdvCustomerPayment u = null;
        u = (AdvCustomerPayment) em.createNamedQuery("AdvCustomerPayment.findByPaymentID").setParameter("paymentID", pAdvCustomerPayment.getPaymentID()).getSingleResult();
        return u;
    }

    //Get list AdvCustomerPayment non conditions
    public List<AdvCustomerPayment> getAllAdvCustomerPayment(int pageNumber, int pageSize) {
        List<AdvCustomerPayment> list;
        Query q = em.createNamedQuery("AdvCustomerPayment.findAll");
        q.setFirstResult(pageSize * pageNumber);
        q.setMaxResults(pageSize);
        list = q.getResultList();
        return list;
    }

    //Get list AdvCustomerPayment by Status
    public List<AdvCustomerPayment> getAllAdvCustomerPaymentByStatus(int status, int pageNumber, int pageSize) {
        List<AdvCustomerPayment> list;
        Query q = em.createNamedQuery("AdvCustomerPayment.findByStatus", AdvCustomerPayment.class);
        q.setParameter("status", status);
        q.setFirstResult(pageSize * pageNumber);
        q.setMaxResults(pageSize);
        list = q.getResultList();
        return list;
    }

    //Create AdvCustomerPayment
    public int AdvCustomerPaymentCreate(AdvCustomerPayment u) throws Exception {
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

    //Update AdvCustomerPayment
    public int AdvCustomerPaymentUpdate(AdvCustomerPayment u) throws Exception {
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

    //Delete AdvCustomerPayment - set status = 0
    public int AdvCustomerPaymentDelete(AdvCustomerPayment u) throws Exception {
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
