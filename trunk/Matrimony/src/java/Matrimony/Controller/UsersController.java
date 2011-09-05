/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Matrimony.Controller;

import Matrimony.Common.MyTools;
import Matrimony.Entities.UserPersonal;
import Matrimony.Entities.UserProfile;
import Matrimony.Entities.Users;
import Matrimony.Facades.UsersFacade;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author TuyenDN
 */
@ManagedBean
@SessionScoped
public class UsersController {

    private int userID;
    private String userName;
    private String password;
    private int role;
    private String email;
    private UsersFacade usersFacade;
    private Users selectedUser;
    private int status;

    /** Creates a new instance of UsersController */
    public UsersController() {
        usersFacade = new UsersFacade();
    }

    public List<Users> getAllUsers() {
        List<Users> list = usersFacade.getAllUsers();
        return list;
    }

    public void createUserAdmin() {
        if (usersFacade == null) {
            usersFacade = new UsersFacade();
        }
        Users u;
        try {

            u = new Users(-1, role, userName, MyTools.MD5(password), email, 1);
            if (!usersFacade.CheckExistedUserName(u)) {
                int result = usersFacade.UserCreate(u);
                if (result > 0) {
                    UserProfile userProfile = new UserProfile(result);
                    UserPersonal userPersonal = new UserPersonal(result);
                    u.setUserID(result);
                    u.setUserPersonal(userPersonal);
                    u.setUserProfile(userProfile);
                    int result2 = usersFacade.UserUpdate(u);
                    if(result2>0)
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success Message", "Create user successful!!!"));
                   else
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error Message", "Can not create user. Please try again later"));
                } else {
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error Message", "Can not create user. Please try again later"));
                }
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error Message", "User exists. Please try another account"));
            }
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error Message", ex.getMessage()));
        } finally {
            u = null;
        }
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public int getRole() {
        return role;
    }

    public int getUserID() {
        return userID;
    }

    public String getUserName() {
        return userName;
    }

    public Users getSelectedUser() {
        return selectedUser;
    }

    public void setSelectedUser(Users selectedUser) {
        this.selectedUser = selectedUser;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int Status) {
        this.status = Status;
    }
}
