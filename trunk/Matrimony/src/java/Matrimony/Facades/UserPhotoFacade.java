/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Matrimony.Facades;

import Matrimony.Entities.UserPhoto;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author TuyenDN
 */
public class UserPhotoFacade {
    
     private EntityManager em;

    public UserPhotoFacade() {
        em = Persistence.createEntityManagerFactory("MatrimonyPU").createEntityManager();
    }

    public UserPhoto getUserByID(UserPhoto pUserPhoto) {
        UserPhoto u = null;
        u = (UserPhoto) em.createNamedQuery("UserPhoto.findByPhotoID").setParameter("photoID", pUserPhoto.getPhotoID()).getSingleResult();
        return u;
    }

    //Get list UserPhoto non conditions
    public List<UserPhoto> getAllUserPhoto(int pageNumber, int pageSize) {
        List<UserPhoto> list;
        Query q = em.createNamedQuery("UserPhoto.findAll");
        q.setFirstResult(pageSize * pageNumber);
        q.setMaxResults(pageSize);
        list = q.getResultList();
        return list;
    }

    //Create UserPhoto
    public int UserPhotoCreate(UserPhoto u) throws Exception {
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

    //Update UserPhoto
    public int UserPhotoUpdate(UserPhoto u) throws Exception {
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
