package com.Entity;

import javax.persistence.*;
import java.util.Collection;


@Entity(name="quiz")
@Table(name = "quiz")
@NamedQueries({
        @NamedQuery(name="allquizes", query="SELECT s FROM quiz s "),
        @NamedQuery(name="allsciencequizes",query = "select s FROM quiz s where s.themeid=0")
})

public class QuizEntity {
    private int quizid;
    private Integer themeid;
    private String quiztitel;
    private Integer duration;
    private Collection<QuestionEntity> questionsByQuizid;
    private Collection<QuizusersignedinEntity> quizusersignedinsByQuizid;

    @Id
    @GeneratedValue
    @Column(name = "quizid", nullable = false)
    public int getQuizid() {
        return quizid;
    }

    public void setQuizid(int quizid) {
        this.quizid = quizid;
    }

    @Basic
    @Column(name = "themeid", nullable = true)
    public Integer getThemeid() {
        return themeid;
    }

    public void setThemeid(Integer themeid) {
        this.themeid = themeid;
    }

    @Basic
    @Column(name = "quiztitel", nullable = false, length = -1)
    public String getQuiztitel() {
        return quiztitel;
    }

    public void setQuiztitel(String quiztitel) {
        this.quiztitel = quiztitel;
    }

    @Basic
    @Column(name = "duration", nullable = true)
    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        QuizEntity that = (QuizEntity) o;

        if (quizid != that.quizid) return false;
        if (themeid != null ? !themeid.equals(that.themeid) : that.themeid != null) return false;
        if (quiztitel != null ? !quiztitel.equals(that.quiztitel) : that.quiztitel != null) return false;
        if (duration != null ? !duration.equals(that.duration) : that.duration != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = quizid;
        result = 31 * result + (themeid != null ? themeid.hashCode() : 0);
        result = 31 * result + (quiztitel != null ? quiztitel.hashCode() : 0);
        result = 31 * result + (duration != null ? duration.hashCode() : 0);
        return result;
    }

    public void setQuizusersignedinsByQuizid(Collection<QuizusersignedinEntity> quizusersignedinsByQuizid) {
        this.quizusersignedinsByQuizid = quizusersignedinsByQuizid;
    }
}
