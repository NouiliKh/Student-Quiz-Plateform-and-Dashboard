package com.Entity;

import javax.persistence.*;
import java.util.Collection;

@Entity(name="student")
@Table(name = "student")
@NamedQueries({
        @NamedQuery(name="allstudents", query="SELECT s FROM student s WHERE s.role=1 "),
        @NamedQuery(name="allusers",query = "SELECT s FROM student s ")
})
public class StudentEntity {
    private int userid;
    private String usermail;
    private String userpassword;
    private String username;
    private int role;
    private Collection<QuizusersignedinEntity> quizusersignedinsByUserid;
    private Collection<UseranswersEntity> useranswersByUserid;

    @Id
    @Column(name = "userid", nullable = false)
    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    @Basic
    @Column(name = "usermail", nullable = true, length = 50)
    public String getUsermail() {
        return usermail;
    }

    public void setUsermail(String usermail) {
        this.usermail = usermail;
    }

    @Basic
    @Column(name = "userpassword", nullable = true, length = -1)
    public String getUserpassword() {
        return userpassword;
    }

    public void setUserpassword(String userpassword) {
        this.userpassword = userpassword;
    }

    @Basic
    @Column(name = "username", nullable = true, length = 25)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "role", nullable = false)
    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StudentEntity that = (StudentEntity) o;

        if (userid != that.userid) return false;
        if (role != that.role) return false;
        if (usermail != null ? !usermail.equals(that.usermail) : that.usermail != null) return false;
        if (userpassword != null ? !userpassword.equals(that.userpassword) : that.userpassword != null) return false;
        if (username != null ? !username.equals(that.username) : that.username != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userid;
        result = 31 * result + (usermail != null ? usermail.hashCode() : 0);
        result = 31 * result + (userpassword != null ? userpassword.hashCode() : 0);
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + role;
        return result;
    }

    public void setUseranswersByUserid(Collection<UseranswersEntity> useranswersByUserid) {
        this.useranswersByUserid = useranswersByUserid;
    }
}
