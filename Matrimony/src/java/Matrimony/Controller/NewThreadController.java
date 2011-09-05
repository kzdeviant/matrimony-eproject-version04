/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Matrimony.Controller;

import Matrimony.Entities.NewThread;
import Matrimony.Facades.NewThreadFacade;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author CuongNH
 */
@ManagedBean
@RequestScoped
public class NewThreadController {

    private NewThreadFacade threadFacade;
    
    public NewThreadController() {
        threadFacade = new NewThreadFacade();
    }
    
    public List<NewThread> getAllNewThread() {
        List<NewThread> list = threadFacade.getAllNewThread();
        return list;
    }
    
     public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getMessageThread() {
        return messageThread;
    }

    public void setMessageThread(String messageThread) {
        this.messageThread = messageThread;
    }

    public Integer getNewThreadID() {
        return newThreadID;
    }

    public void setNewThreadID(Integer newThreadID) {
        this.newThreadID = newThreadID;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    private Integer newThreadID;
    private String title;
    private String messageThread;
    private Date createdDate;
    private Integer status;
}
