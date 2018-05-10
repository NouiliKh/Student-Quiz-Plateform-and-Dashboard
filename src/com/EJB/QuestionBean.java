package com.EJB;

import com.Entity.QuestionEntity;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.faces.annotation.ManagedProperty;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless(name = "QuestionEJB")
public class QuestionBean {
    @PersistenceContext(name="QuizPlatform-ejbPU")
    private EntityManager em;
    public List<QuestionEntity> allquestions(){
        TypedQuery<QuestionEntity> sorgu = em.createNamedQuery("allquestions", QuestionEntity.class);
        return sorgu.getResultList();
    }



    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void dropquestion(QuestionEntity question)
    {
        em.remove(em.merge(question));
        em.flush();
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public QuestionEntity editquestion(QuestionEntity question) throws Exception {
        try {
            em.merge(question);
            em.flush();
            return question;
        } catch (Exception e) {
            return null;
        }
    }


    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public QuestionEntity saveQuestion(QuestionEntity question){

        em.persist(question);
        em.flush();
        return question;
    }

    public List<QuestionEntity> allquestionsbyid(Integer quizid){
        TypedQuery<QuestionEntity> sorgu = em.createNamedQuery("allquestionsByid", QuestionEntity.class).setParameter("quizid",quizid);
        return sorgu.getResultList();
    }

    public QuestionBean() {
    }
}
