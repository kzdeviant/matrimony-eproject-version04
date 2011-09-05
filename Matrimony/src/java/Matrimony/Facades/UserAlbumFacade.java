/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Matrimony.Facades;

import Matrimony.Entities.UserAlbum;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author TuyenDN
 */
public class UserAlbumFacade {

    private EntityManager em;

    public UserAlbumFacade() {
        em = Persistence.createEntityManagerFactory("MatrimonyPU").createEntityManager();
    }

    public UserAlbum getUserByID(UserAlbum pUserAlbum) {
        UserAlbum u = null;
        u = (UserAlbum) em.createNamedQuery("UserAlbum.findByAlbumID").setParameter("albumID", pUserAlbum.getAlbumID()).getSingleResult();
        return u;
    }

    //Get list UserAlbum non conditions
    public List<UserAlbum> getAllUserAlbum(int pageNumber, int pageSize) {
        List<UserAlbum> list;
        Query q = em.createNamedQuery("UserAlbum.findAll");
        q.setFirstResult(pageSize * pageNumber);
        q.setMaxResults(pageSize);
        list = q.getResultList();
        return list;
    }

    //Get list UserAlbum by Status
    public List<UserAlbum> getAllUserAlbumByStatus(int status, int pageNumber, int pageSize) {
        List<UserAlbum> list;
        Query q = em.createNamedQuery("UserAlbum.findByStatus", UserAlbum.class);
        q.setParameter("status", status);
        q.setFirstResult(pageSize * pageNumber);
        q.setMaxResults(pageSize);
        list = q.getResultList();
        return list;
    }

    //Create UserAlbum
    public int UserAlbumCreate(UserAlbum u) throws Exception {
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

    //Update UserAlbum
    public int UserAlbumUpdate(UserAlbum u) throws Exception {
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

    //Delete UserAlbum - set status = 0
    public int UserAlbumDelete(UserAlbum u) throws Exception {
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
