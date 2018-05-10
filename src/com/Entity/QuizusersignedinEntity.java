package com.Entity;

import javax.persistence.*;

@Entity
@Table(name = "quizusersignedin", schema = "QuizPlateform", catalog = "")
public class QuizusersignedinEntity {
    private int id;
    private Integer quizid;
    private Integer userid;
    private QuizEntity quizByQuizid;
    private StudentEntity studentByUserid;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "quizid", nullable = true)
    public Integer getQuizid() {
        return quizid;
    }

    public void setQuizid(Integer quizid) {
        this.quizid = quizid;
    }

    @Basic
    @Column(name = "userid", nullable = true)
    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        QuizusersignedinEntity that = (QuizusersignedinEntity) o;

        if (id != that.id) return false;
        if (quizid != null ? !quizid.equals(that.quizid) : that.quizid != null) return false;
        if (userid != null ? !userid.equals(that.userid) : that.userid != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (quizid != null ? quizid.hashCode() : 0);
        result = 31 * result + (userid != null ? userid.hashCode() : 0);
        return result;
    }

    public void setStudentByUserid(StudentEntity studentByUserid) {
        this.studentByUserid = studentByUserid;
    }
}
