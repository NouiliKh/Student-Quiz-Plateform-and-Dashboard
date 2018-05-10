package com.Controller;
import com.EJB.QuizBean;
import com.EJB.StudentBean;
import com.Entity.QuizEntity;
import  com.Entity.StudentEntity;
import org.glassfish.jersey.process.internal.RequestScoped;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name="quizController")
@RequestScoped
public class QuizController implements Serializable {
    @EJB
    QuizBean quizEJB;
    FacesContext context = FacesContext.getCurrentInstance();
    QuizEntity quiz =new QuizEntity();
    int themeid;
    int quizid;
    String quiztitle;
    int duration;
    private List<QuizEntity> quizList = new ArrayList();
    List<String>array=new ArrayList<>();
    public List<QuizEntity> getQuizes()
    {
        quizList=quizEJB.allquizes();
        return (quizList);
    }


    public void addQuiz() throws IOException {
        quizid = quizEJB.saveQuiz(quiz);
        quizList=quizEJB.allquizes();

        FacesContext.getCurrentInstance().getExternalContext().redirect("quiz-details.xhtml?quizid=" + quiz.getQuizid());
    }


    public void editQuiz(QuizEntity quiz1) throws Exception {
        quizEJB.saveQuiz(quiz);
        quizEJB.dropquiz(quiz1);
    }

    public void dropquiz(QuizEntity quiz) throws Exception {
        quizEJB.dropquiz(quiz);
    }

    public QuizEntity getQuiz(Integer quizid)
    {
        quiz = quizEJB.findQuiz(quizid);
        return quiz;
    }

    public void viewMore(Integer quizid) throws IOException {
        FacesContext.getCurrentInstance().getExternalContext().redirect("quiz.xhtml?quizid=" + quizid);
    }


    public void viewResults()
    {
        System.out.println("****************************************************************************");
        System.out.println(array);
    }
    public QuizEntity getQuiz() {
        return quiz;
    }

    public void setQuiz(QuizEntity quiz) {
        this.quiz = quiz;
    }




}
