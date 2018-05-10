package com.Controller;
import com.EJB.QuestionChoicesBean;
import com.Entity.QuestionChoicesEntity;
import org.glassfish.jersey.process.internal.RequestScoped;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name="questionchoicesController")
@RequestScoped
public class QuestionChoicesController implements Serializable {
    @EJB
    QuestionChoicesBean questionchoicesEJB;
    FacesContext context = FacesContext.getCurrentInstance();
    QuestionChoicesEntity questionchoice =new QuestionChoicesEntity();
    int quizid;
    String askedquestion;
    private List<QuestionChoicesEntity> questionchoicesList = new ArrayList();

    public List<QuestionChoicesEntity> getQuizes()
    {
        questionchoicesList = questionchoicesEJB.allquestions();
        return (questionchoicesList);
    }


    public void addQuestionchoices(QuestionChoicesEntity questionchoice){
        questionchoicesEJB.savequestionchoices(questionchoice);
        questionchoicesList = questionchoicesEJB.allquestions();
    }


    public void editeQuestionchoices(QuestionChoicesEntity questtionchoice1) throws Exception {
        questionchoice= questionchoicesEJB.savequestionchoices(questionchoice);
        questionchoicesEJB.dropquestionchoices(questtionchoice1);
    }

    public void dropQuestionchoice(QuestionChoicesEntity question) throws Exception {
        questionchoicesEJB.dropquestionchoices(question);
    }
    public List<QuestionChoicesEntity> getQuestionchoicesByquizid(Integer questionid)
    {
        questionchoicesList=questionchoicesEJB.allquestionchoicesbyid(questionid);
        return (questionchoicesList);
    }

    public QuestionChoicesEntity getQuestionchoice() {
        return questionchoice;
    }

    public void setQuestionchoice(QuestionChoicesEntity questionchoice) {
        this.questionchoice = questionchoice;
    }




}
