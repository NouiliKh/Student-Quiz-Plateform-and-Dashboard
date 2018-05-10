package com.Entity;

import javax.persistence.*;
import java.util.Collection;
@Entity(name="questionChoices")
@Table(name = "questionChoices")
@NamedQueries({
        @NamedQuery(name="allquestionchoicesByid", query="SELECT s FROM questionChoices s WHERE S.questionid=:questionid ")
})
public class QuestionChoicesEntity {
    private int choicesid;
    private Integer questionid;
    private int isrightchoice;
    private String choice;
    private QuestionEntity questionByQuestionid;
    private Collection<UseranswersEntity> useranswersByChoicesid;

    @Id
    @Column(name = "choicesid", nullable = false)
    public int getChoicesid() {
        return choicesid;
    }

    public void setChoicesid(int choicesid) {
        this.choicesid = choicesid;
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
    @Column(name = "isrightchoice", nullable = true)
    public int getIsrightchoice() {
        return isrightchoice;
    }

    public void setIsrightchoice(int isrightchoice) {
        this.isrightchoice = isrightchoice;
    }

    @Basic
    @Column(name = "choice", nullable = true, length = 25)
    public String getChoice() {
        return choice;
    }

    public void setChoice(String choice) {
        this.choice = choice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        QuestionChoicesEntity that = (QuestionChoicesEntity) o;

        if (choicesid != that.choicesid) return false;
        if (isrightchoice != that.isrightchoice) return false;
        if (questionid != null ? !questionid.equals(that.questionid) : that.questionid != null) return false;
        if (choice != null ? !choice.equals(that.choice) : that.choice != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = choicesid;
        result = 31 * result + (questionid != null ? questionid.hashCode() : 0);
        result = 31 * result + (int) isrightchoice;
        result = 31 * result + (choice != null ? choice.hashCode() : 0);
        return result;
    }

    public void setUseranswersByChoicesid(Collection<UseranswersEntity> useranswersByChoicesid) {
        this.useranswersByChoicesid = useranswersByChoicesid;
    }
}
