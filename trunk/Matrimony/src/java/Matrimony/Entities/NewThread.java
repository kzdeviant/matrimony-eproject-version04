/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Matrimony.Entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author TuyenDN
 */
@Entity
@Table(name = "NewThread", catalog = "Matrimony", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "NewThread.findAll", query = "SELECT n FROM NewThread n"),
    @NamedQuery(name = "NewThread.findByNewThreadID", query = "SELECT n FROM NewThread n WHERE n.newThreadID = :newThreadID"),
    @NamedQuery(name = "NewThread.findByTitle", query = "SELECT n FROM NewThread n WHERE n.title = :title"),
    @NamedQuery(name = "NewThread.findByMessageThread", query = "SELECT n FROM NewThread n WHERE n.messageThread = :messageThread"),
    @NamedQuery(name = "NewThread.findByCreatedDate", query = "SELECT n FROM NewThread n WHERE n.createdDate = :createdDate"),
    @NamedQuery(name = "NewThread.findByStatus", query = "SELECT n FROM NewThread n WHERE n.status = :status")})
public class NewThread implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "NewThreadID", nullable = false)
    private Integer newThreadID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "Title", nullable = false, length = 255)
    private String title;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 525)
    @Column(name = "MessageThread", nullable = false, length = 525)
    private String messageThread;
    @Column(name = "CreatedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    @Column(name = "Status")
    private Integer status;
    @JoinColumn(name = "UserID", referencedColumnName = "UserID")
    @ManyToOne
    private Users userID;
    @OneToMany(mappedBy = "newThreadID")
    private List<Reply> replyList;

    public NewThread() {
    }

    public NewThread(Integer newThreadID) {
        this.newThreadID = newThreadID;
    }

    public NewThread(Integer newThreadID, String title, String messageThread) {
        this.newThreadID = newThreadID;
        this.title = title;
        this.messageThread = messageThread;
    }

    public Integer getNewThreadID() {
        return newThreadID;
    }

    public void setNewThreadID(Integer newThreadID) {
        this.newThreadID = newThreadID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessageThread() {
        return messageThread;
    }

    public void setMessageThread(String messageThread) {
        this.messageThread = messageThread;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Users getUserID() {
        return userID;
    }

    public void setUserID(Users userID) {
        this.userID = userID;
    }

    @XmlTransient
    public List<Reply> getReplyList() {
        return replyList;
    }

    public void setReplyList(List<Reply> replyList) {
        this.replyList = replyList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (newThreadID != null ? newThreadID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NewThread)) {
            return false;
        }
        NewThread other = (NewThread) object;
        if ((this.newThreadID == null && other.newThreadID != null) || (this.newThreadID != null && !this.newThreadID.equals(other.newThreadID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Matrimony.Entities.NewThread[ newThreadID=" + newThreadID + " ]";
    }
    
}
