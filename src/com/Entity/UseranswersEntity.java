package com.Entity;

import javax.persistence.*;

@Entity
@Table(name = "useranswers", schema = "QuizPlateform", catalog = "")
public class UseranswersEntity {
    private int id;
    private Integer userid;
    private Integer questionid;
    private Integer choiceid;
    private Byte isright;
    private Integer answertime;
    private Integer points;
    private StudentEntity studentByUserid;
    private QuestionEntity questionByQuestionid;
    private QuestionChoicesEntity questionChoicesByChoiceid;

    @Id
    @Column(name = "Id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "userid", nullable = true)
    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    @Basic
    @Column(name = "questionid", nullable = true)
    public Integer getQuestionid() {
        return questionid;
    }

    public void setQuestionid(Integer questionid) {
        this.questionid = questionid;
    }

    @Basic
    @Column(name = "choiceid", nullable = true)
    public Integer getChoiceid() {
        return choiceid;
    }

    public void setChoiceid(Integer choiceid) {
        this.choiceid = choiceid;
    }

    @Basic
    @Column(name = "isright", nullable = true)
    public Byte getIsright() {
        return isright;
    }

    public void setIsright(Byte isright) {
        this.isright = isright;
    }

    @Basic
    @Column(name = "answertime", nullable = true)
    public Integer getAnswertime() {
        return answertime;
    }

    public void setAnswertime(Integer answertime) {
        this.answertime = answertime;
    }

    @Basic
    @Column(name = "points", nullable = true)
    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UseranswersEntity that = (UseranswersEntity) o;

        if (id != that.id) return false;
        if (userid != null ? !userid.equals(that.userid) : that.userid != null) return false;
        if (questionid != null ? !questionid.equals(that.questionid) : that.questionid != null) return false;
        if (choiceid != null ? !choiceid.equals(that.choiceid) : that.choiceid != null) return false;
        if (isright != null ? !isright.equals(that.isright) : that.isright != null) return false;
        if (answertime != null ? !answertime.equals(that.answertime) : that.answertime != null) return false;
        if (points != null ? !points.equals(that.points) : that.points != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (userid != null ? userid.hashCode() : 0);
        result = 31 * result + (questionid != null ? questionid.hashCode() : 0);
        result = 31 * result + (choiceid != null ? choiceid.hashCode() : 0);
        result = 31 * result + (isright != null ? isright.hashCode() : 0);
        result = 31 * result + (answertime != null ? answertime.hashCode() : 0);
        result = 31 * result + (points != null ? points.hashCode() : 0);
        return result;
    }

    public void setQuestionChoicesByChoiceid(QuestionChoicesEntity questionChoicesByChoiceid) {
        this.questionChoicesByChoiceid = questionChoicesByChoiceid;
    }
}
