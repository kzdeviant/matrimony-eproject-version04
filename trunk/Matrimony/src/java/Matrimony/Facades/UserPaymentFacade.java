/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Matrimony.Facades;

import Matrimony.Entities.UserPayment;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
/**
 *
 * @author TuyenDN
 */
public class UserPaymentFacade {
    
    private EntityManager em;

    public UserPaymentFacade() {
        em = Persistence.createEntityManagerFactory("MatrimonyPU").createEntityManager();
    }

    public UserPayment getUserByID(UserPayment pUserPayment) {
        UserPayment u = null;
        u = (UserPayment) em.createNamedQuery("UserPayment.findByPaymentID").setParameter("paymentID", pUserPayment.getPaymentID()).getSingleResult();
        return u;
    }

    //Get list UserPayment non conditions
    public List<UserPayment> getAllUserPayment(int pageNumber, int pageSize) {
        List<UserPayment> list;
        Query q = em.createNamedQuery("UserPayment.findAll");
        q.setFirstResult(pageSize * pageNumber);
        q.setMaxResults(pageSize);
        list = q.getResultList();
        return list;
    }

    //Get list UserPayment by Status
    public List<UserPayment> getAllUserPaymentByStatus(int status, int pageNumber, int pageSize) {
        List<UserPayment> list;
        Query q = em.createNamedQuery("UserPayment.findByStatus", UserPayment.class);
        q.setParameter("status", status);
        q.setFirstResult(pageSize * pageNumber);
        q.setMaxResults(pageSize);
        list = q.getResultList();
        return list;
    }

    //Create UserPayment
    public int UserPaymentCreate(UserPayment u) throws Exception {
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

    //Update UserPayment
    public int UserPaymentUpdate(UserPayment u) throws Exception {
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

    //Delete UserPayment - set status = 0
    public int UserPaymentDelete(UserPayment u) throws Exception {
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
