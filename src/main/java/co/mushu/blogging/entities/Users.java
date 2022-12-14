package co.mushu.blogging.entities;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
public class Users {
    @Id
    private String username;
    @NotNull
    private String password;
    @NotNull
    private Date createDate;
    @NotNull
    private Date dateOfBirth;
    private Boolean isActive;
    private String roleList;
    private String email;
    private String phoneNumber;


    public Users(){}

    public Users(String username, String password, Date createDate, Date dateOfBirth, Boolean isActive, String roleList, String email, String phoneNumber) {
        this.username = username;
        this.password = password;
        this.createDate = createDate;
        this.dateOfBirth = dateOfBirth;
        this.isActive = isActive;
        this.roleList = roleList;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public String getRoleList() {
        return roleList;
    }

    public void setRoleList(String roleList) {
        this.roleList = roleList;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
