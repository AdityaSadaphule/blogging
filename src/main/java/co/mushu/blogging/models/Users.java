package co.mushu.blogging.models;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.Set;
import java.util.TimeZone;

@Entity
public class Users {
    @Id
    private String username;
    @NotNull
    private String password;
    @OneToMany(mappedBy="createdBy", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Set<Blog> blogs;
    @NotNull
    private Date createDate;
    @NotNull
    private Date dateOfBirth;
    private Boolean isActive;
    private String roleList;
    private String email;
    private String phoneNumber;
    private Date lastBlogCreationTime;

    public Date getLastBlogCreationTime() {
        return lastBlogCreationTime;
    }

    public void setLastBlogCreationTime(Date lastBlogCreationTime) {
        this.lastBlogCreationTime = lastBlogCreationTime;
    }

    public Users(){}

    public Users(String username, String password, Set<Blog> blogs, Date createDate, Date dateOfBirth, Boolean isActive, String roleList, String email, String phoneNumber) {
        this.username = username;
        this.password = password;
        this.blogs = blogs;
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

    public Set<Blog> getBlogs() {
        return blogs;
    }

    public void setBlogs(Set<Blog> blogs) {
        this.blogs = blogs;
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
