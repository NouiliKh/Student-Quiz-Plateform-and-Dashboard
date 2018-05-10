package com.Entity;

import javax.faces.annotation.ManagedProperty;
import javax.persistence.*;
import java.util.Collection;


@Entity(name="question")
@Table(name = "question")
@NamedQueries({
        @NamedQuery(name="allquestionsByid", query="SELECT s FROM question s WHERE s.quizid = :quizid ")
})

public class QuestionEntity {
    private int questionid;
    private Integer quizid;
    private String question;
    private QuizEntity quizByQuizid;
    private Collection<QuestionChoicesEntity> questionChoicesByQuestionid;
    private Collection<QuestionChoicesEntity> questionChoicesByQuestionid_0;
    private Collection<UseranswersEntity> useranswersByQuestionid;

    @GeneratedValue
    @Id
    @Column(name = "questionid", nullable = false)
    public int getQuestionid() {
        return questionid;
    }

    public void setQuestionid(int questionid) {
        this.questionid = questionid;
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
    @Column(name = "question", nullable = true, length = 30)
    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        QuestionEntity that = (QuestionEntity) o;

        if (questionid != that.questionid) return false;
        if (quizid != null ? !quizid.equals(that.quizid) : that.quizid != null) return false;
        if (question != null ? !question.equals(that.question) : that.question != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = questionid;
        result = 31 * result + (quizid != null ? quizid.hashCode() : 0);
        result = 31 * result + (question != null ? question.hashCode() : 0);
        return result;
    }


    public void setUseranswersByQuestionid(Collection<UseranswersEntity> useranswersByQuestionid) {
        this.useranswersByQuestionid = useranswersByQuestionid;
    }
}
