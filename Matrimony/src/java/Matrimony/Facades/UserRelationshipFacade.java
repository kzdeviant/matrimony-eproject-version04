/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Matrimony.Facades;

import Matrimony.Entities.UserRelationship;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author TuyenDN
 */
public class UserRelationshipFacade {

    private EntityManager em;

    public UserRelationshipFacade() {
        em = Persistence.createEntityManagerFactory("MatrimonyPU").createEntityManager();
    }

    public UserRelationship getUserByID(UserRelationship pUserRelationship) {
        UserRelationship u = null;
        u = (UserRelationship) em.createNamedQuery("UserRelationship.findByRelationID").setParameter("relationID", pUserRelationship.getRelationID()).getSingleResult();
        return u;
    }

    //Get list UserRelationship non conditions
    public List<UserRelationship> getAllUserRelationship(int pageNumber, int pageSize) {
        List<UserRelationship> list;
        Query q = em.createNamedQuery("UserRelationship.findAll");
        q.setFirstResult(pageSize * pageNumber);
        q.setMaxResults(pageSize);
        list = q.getResultList();
        return list;
    }

    //Get list UserRelationship by Status
    public List<UserRelationship> getAllUserRelationshipByStatus(int status, int pageNumber, int pageSize) {
        List<UserRelationship> list;
        Query q = em.createNamedQuery("UserRelationship.findByStatus", UserRelationship.class);
        q.setParameter("status", status);
        q.setFirstResult(pageSize * pageNumber);
        q.setMaxResults(pageSize);
        list = q.getResultList();
        return list;
    }

    //Create UserRelationship
    public int UserRelationshipCreate(UserRelationship u) throws Exception {
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

    //Update UserRelationship
    public int UserRelationshipUpdate(UserRelationship u) throws Exception {
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

    //Delete UserRelationship - set status = 0
    public int UserRelationshipDelete(UserRelationship u) throws Exception {
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
