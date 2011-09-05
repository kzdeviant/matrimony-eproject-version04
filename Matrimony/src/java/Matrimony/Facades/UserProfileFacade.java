/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Matrimony.Facades;

import Matrimony.Entities.UserProfile;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 *
 * @author TuyenDN
 */
public class UserProfileFacade {

    private EntityManager em;

    public UserProfileFacade() {
        em = Persistence.createEntityManagerFactory("MatrimonyPU").createEntityManager();
    }

    //Create UserProfile
    public int UserProfileCreate(UserProfile u) throws Exception {
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

    //Update UserProfile
    public int UserProfileUpdate(UserProfile u) throws Exception {
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
