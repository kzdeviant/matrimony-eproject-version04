/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Matrimony.Entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author TuyenDN
 */
@Entity
@Table(name = "Reply", catalog = "Matrimony", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Reply.findAll", query = "SELECT r FROM Reply r"),
    @NamedQuery(name = "Reply.findByReplyID", query = "SELECT r FROM Reply r WHERE r.replyID = :replyID"),
    @NamedQuery(name = "Reply.findByTitle", query = "SELECT r FROM Reply r WHERE r.title = :title"),
    @NamedQuery(name = "Reply.findByMessageReply", query = "SELECT r FROM Reply r WHERE r.messageReply = :messageReply"),
    @NamedQuery(name = "Reply.findByCreatedDate", query = "SELECT r FROM Reply r WHERE r.createdDate = :createdDate")})
public class Reply implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ReplyID", nullable = false)
    private Integer replyID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "Title", nullable = false, length = 255)
    private String title;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 525)
    @Column(name = "MessageReply", nullable = false, length = 525)
    private String messageReply;
    @Column(name = "CreatedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    @JoinColumn(name = "UserID", referencedColumnName = "UserID")
    @ManyToOne
    private Users userID;
    @JoinColumn(name = "NewThreadID", referencedColumnName = "NewThreadID")
    @ManyToOne
    private NewThread newThreadID;

    public Reply() {
    }

    public Reply(Integer replyID) {
        this.replyID = replyID;
    }

    public Reply(Integer replyID, String title, String messageReply) {
        this.replyID = replyID;
        this.title = title;
        this.messageReply = messageReply;
    }

    public Integer getReplyID() {
        return replyID;
    }

    public void setReplyID(Integer replyID) {
        this.replyID = replyID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessageReply() {
        return messageReply;
    }

    public void setMessageReply(String messageReply) {
        this.messageReply = messageReply;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Users getUserID() {
        return userID;
    }

    public void setUserID(Users userID) {
        this.userID = userID;
    }

    public NewThread getNewThreadID() {
        return newThreadID;
    }

    public void setNewThreadID(NewThread newThreadID) {
        this.newThreadID = newThreadID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (replyID != null ? replyID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reply)) {
            return false;
        }
        Reply other = (Reply) object;
        if ((this.replyID == null && other.replyID != null) || (this.replyID != null && !this.replyID.equals(other.replyID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Matrimony.Entities.Reply[ replyID=" + replyID + " ]";
    }
    
}
