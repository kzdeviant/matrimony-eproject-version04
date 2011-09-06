/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Matrimony.Facades;

import Matrimony.Entities.Users;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author TuyenDN
 */
public class UsersFacade {

    private EntityManager em;

    public UsersFacade() {
        em = Persistence.createEntityManagerFactory("MatrimonyPU").createEntityManager();
    }

    public Users getUserByID(Users pUsers) {
        Users u = null;
        u = (Users) em.createNamedQuery("Users.findByUserID").setParameter("userID", pUsers.getUserID()).getSingleResult();
        return u;
    }

    //Check authentication
    public boolean UserLogin(Users u) {
        Query q = em.createQuery("SELECT a FROM Users a WHERE a.username = :username and a.password = :password");
        q.setParameter("username", u.getUsername());
        q.setParameter("password", u.getPassword());
        List<Users> list = q.getResultList();
        if (list.isEmpty()) {
            return false;
        }
        return true;
    }

    //Check authentication
    public boolean CheckExistedUserName(Users u) {
        Query q = em.createNamedQuery("Users.findByUsername");
        q.setParameter("username", u.getUsername());
        List<Users> list = q.getResultList();
        if (list.isEmpty()) {
            return false;
        }
        return true;
    }
    
    //Get list user non conditions
    public List<Users> getAllUsers() {
        List<Users> list;
        Query q = em.createNamedQuery("Users.findAll");
        list = q.getResultList();
        return list;
    }

    //Get list users by Status
    public List<Users> getAllUsersByStatus(int status, int pageNumber, int pageSize) {
        List<Users> list;
        Query q = em.createNamedQuery("Users.findByStatus", Users.class);
        q.setParameter("status", status);
        q.setFirstResult(pageSize * pageNumber);
        q.setMaxResults(pageSize);
        list = q.getResultList();
        return list;
    }

    //Create user
    public int UserCreate(Users u) throws Exception {
        try {
            if (!em.getTransaction().isActive()) {
                em.getTransaction().begin();
            }
            em.persist(u);
            em.getTransaction().commit();
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
        return u.getUserID();
    }

    //Update user
    public int UserUpdate(Users u) throws Exception {
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

    //Delete user - set status = 0
    public int UserDelete(Users u) throws Exception {
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
