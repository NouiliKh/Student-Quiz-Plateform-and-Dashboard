package com.Controller;
import com.EJB.QuestionBean;
import com.EJB.QuestionChoicesBean;
import com.EJB.QuizBean;
import com.Entity.QuestionChoicesEntity;
import com.Entity.QuestionEntity;
import com.Entity.QuizEntity;
import org.glassfish.jersey.process.internal.RequestScoped;

import javax.ejb.EJB;
import javax.faces.annotation.ManagedProperty;
import javax.faces.bean.ManagedBean;
import javax.faces.component.html.HtmlSelectBooleanCheckbox;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@ManagedBean(name="questionController")
@RequestScoped
public class QuestionController implements Serializable {
    @EJB
    QuestionBean questionEJB;
    @EJB
    QuestionChoicesBean questionChoicesEJB;
    @EJB
    QuizBean quizEJB;
    QuestionChoicesEntity questionchoice = new QuestionChoicesEntity();
    QuestionChoicesController qscontroler ;
    FacesContext context = FacesContext.getCurrentInstance();
    QuestionEntity question =new QuestionEntity();
    QuizEntity quiz = new QuizEntity();
    QuizController qControler;
    QuestionChoicesEntity questionchoices =new QuestionChoicesEntity();
    int questionid;
    String askedquestion;
    String choice1;
    String choice2;
    String choice3;
    String choice4;
    Boolean isright1;
    Boolean isright2;
    Boolean Isright3;
    Boolean isright4;
    private EntityManager em;

    private List<QuestionEntity> questionList = new ArrayList();

    public List<QuestionEntity> getQuestionList()
    {
        questionList= questionEJB.allquestions();
        return (questionList);
    }


    public void addQuestion(){
        question = questionEJB.saveQuestion(question);
        questionList= questionEJB.allquestions();
    }


    public void addQuestionNChoices(String choice1,HtmlSelectBooleanCheckbox isCorrect1,String choice2,HtmlSelectBooleanCheckbox isCorrect2,String choice3,HtmlSelectBooleanCheckbox isCorrect3,String choice4,HtmlSelectBooleanCheckbox isCorrect4) throws IOException {
        FacesContext fc = FacesContext.getCurrentInstance();
        Map<String, String> params = fc.getExternalContext().getRequestParameterMap();
        this.question.setQuizid(Integer.valueOf(params.get("quizid")));
        question=questionEJB.saveQuestion(this.question);

        QuestionChoicesEntity qc1 =new QuestionChoicesEntity();
        QuestionChoicesEntity qc2 =new QuestionChoicesEntity();
        QuestionChoicesEntity qc3 =new QuestionChoicesEntity();
        QuestionChoicesEntity qc4 =new QuestionChoicesEntity();



        qc1.setChoice(choice1);
        if((Boolean) isCorrect1.getValue()==true)
        {
            qc1.setIsrightchoice((byte) 1);
        }
        else
        {
            qc1.setIsrightchoice((byte) 0);
        }
        qc1.setQuestionid(question.getQuestionid());


        qc2.setChoice(choice2);
        if((Boolean) isCorrect2.getValue()==true)
        {
            qc2.setIsrightchoice((byte) 1);
        }
        else
        {
            qc2.setIsrightchoice((byte) 0);
        }
        qc2.setQuestionid(question.getQuestionid());

        qc3.setChoice(choice3);
        if((Boolean) isCorrect3.getValue()==true)
        {
            qc3.setIsrightchoice((byte) 1);
        }
        else
        {
            qc3.setIsrightchoice((byte) 0);
        }
        qc3.setQuestionid(question.getQuestionid());

        qc4.setChoice(choice4);
        if((Boolean) isCorrect4.getValue()==true)
        {
            qc4.setIsrightchoice((byte) 1);
        }
        else
        {
            qc4.setIsrightchoice((byte) 0);
        }
        qc4.setQuestionid(question.getQuestionid());

        qc1 = questionChoicesEJB.savequestionchoices(qc1);
        qc2 = questionChoicesEJB.savequestionchoices(qc2);
        qc3 = questionChoicesEJB.savequestionchoices(qc3);
        qc4 = questionChoicesEJB.savequestionchoices(qc4);

        FacesContext.getCurrentInstance().getExternalContext().redirect("quiz-details.xhtml?quizid=" + params.get("quizid"));

    }

    public List<QuestionEntity> getQuestionsByquizid(Integer quizid)
    {
        questionList=questionEJB.allquestionsbyid(quizid);
        return (questionList);
    }



    public void editeQuestion(QuestionEntity questtion1) throws Exception {
        question= questionEJB.saveQuestion(question);
        questionEJB.dropquestion(questtion1);
    }

    public void dropQuestion(QuestionEntity question,QuizEntity quizEntity,List<QuestionChoicesEntity> questtionchicesList) throws Exception {
        FacesContext fc = FacesContext.getCurrentInstance();
        Map<String, String> params = fc.getExternalContext().getRequestParameterMap();

        for(int i=0 ;i<questtionchicesList.size();i++) {
            questionChoicesEJB.dropquestionchoices((questtionchicesList.get(i)));
        }
        questionEJB.dropquestion(question);
    }

    public QuestionEntity getQuestion() {
        return question;
    }

    public void setQuestionchoice(QuestionChoicesEntity questionchoice) {
        this.questionchoice = questionchoice;
    }
    public QuestionChoicesEntity getQuestionchoice() {
        return questionchoice;
    }

    public void setQuestion(QuestionEntity question) {
        this.question = question;
    }




}
