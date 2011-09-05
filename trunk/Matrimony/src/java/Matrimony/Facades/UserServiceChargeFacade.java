/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Matrimony.Facades;

import Matrimony.Entities.UserServiceCharge;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author TuyenDN
 */
public class UserServiceChargeFacade {

    private EntityManager em;

    public UserServiceChargeFacade() {
        em = Persistence.createEntityManagerFactory("MatrimonyPU").createEntityManager();
    }

    public UserServiceCharge getUserServiceChargeByID(UserServiceCharge pUserServiceCharge) {
        UserServiceCharge u = null;
        u = (UserServiceCharge) em.createNamedQuery("UserServiceCharge.findByChargeID").setParameter("serviceID", pUserServiceCharge.getChargeID()).getSingleResult();
        return u;
    }

    //Get list UserServicePackage non conditions
    public List<UserServiceCharge> getAllUserServiceCharge(int pageNumber, int pageSize) {
        List<UserServiceCharge> list;
        Query q = em.createNamedQuery("UserServiceCharge.findAll");
        q.setFirstResult(pageSize * pageNumber);
        q.setMaxResults(pageSize);
        list = q.getResultList();
        return list;
    }

    //Get list UserServicePackage by Status
    public List<UserServiceCharge> getAllUserServiceChargeByStatus(int status, int pageNumber, int pageSize) {
        List<UserServiceCharge> list;
        Query q = em.createNamedQuery("UserServiceCharge.findByStatus", UserServiceCharge.class);
        q.setParameter("status", status);
        q.setFirstResult(pageSize * pageNumber);
        q.setMaxResults(pageSize);
        list = q.getResultList();
        return list;
    }

    //Create UserServicePackage
    public int UserServiceChargeCreate(UserServiceCharge u) throws Exception {
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

    //Update UserServicePackage
    public int UserServiceChargeUpdate(UserServiceCharge u) throws Exception {
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
}
