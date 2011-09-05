/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Matrimony.Facades;

import Matrimony.Entities.NewThread;
import Matrimony.Entities.SiteContact;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author CuongNH
 */
public class NewThreadFacade {
    private EntityManager em;

    public NewThreadFacade() {
        em = Persistence.createEntityManagerFactory("MatrimonyPU").createEntityManager();
    }
    public List<NewThread> getAllNewThread() {
        List<NewThread> list;
        Query q = em.createNamedQuery("NewThread.findAll");
        list = q.getResultList();
        return list;
    }
}
