/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Matrimony.Facades;

import Matrimony.Entities.UserServicePackage;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
/**
 *
 * @author TuyenDN
 */
public class UserServicePackageFacade {

    private EntityManager em;

    public UserServicePackageFacade() {
        em = Persistence.createEntityManagerFactory("MatrimonyPU").createEntityManager();
    }

    public UserServicePackage getUserByID(UserServicePackage pUserServicePackage) {
        UserServicePackage u = null;
        u = (UserServicePackage) em.createNamedQuery("UserServiceCharge.findByChargeID").setParameter("chargeID", pUserServicePackage.getServiceID()).getSingleResult();
        return u;
    }

    //Get list UserServicePackage non conditions
    public List<UserServicePackage> getAllUsers(int pageNumber, int pageSize) {
        List<UserServicePackage> list;
        Query q = em.createNamedQuery("UserServicePackage.findAll");
        q.setFirstResult(pageSize * pageNumber);
        q.setMaxResults(pageSize);
        list = q.getResultList();
        return list;
    }

    //Get list UserServicePackage by Status
    public List<UserServicePackage> getAllUserServicePackageByStatus(int status, int pageNumber, int pageSize) {
        List<UserServicePackage> list;
        Query q = em.createNamedQuery("UserServicePackage.findByStatus", UserServicePackage.class);
        q.setParameter("status", status);
        q.setFirstResult(pageSize * pageNumber);
        q.setMaxResults(pageSize);
        list = q.getResultList();
        return list;
    }

    //Create UserServicePackage
    public int UserServicePackageCreate(UserServicePackage u) throws Exception {
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
    public int UserServicePackageUpdate(UserServicePackage u) throws Exception {
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

    //Delete UserServicePackage - set status = 0
    public int UserServicePackageDelete(UserServicePackage u) throws Exception {
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
