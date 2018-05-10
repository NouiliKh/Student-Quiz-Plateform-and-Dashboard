package com.EJB;

import com.Entity.QuestionChoicesEntity;
import com.Entity.QuestionEntity;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.io.Serializable;
import java.util.List;

@Stateless(name = "QuestionChoicesEJB")
public class QuestionChoicesBean implements Serializable {
    @PersistenceContext(name="QuizPlatform-ejbPU")
    private EntityManager em;

    public List<QuestionChoicesEntity> allquestions(){
        TypedQuery<QuestionChoicesEntity> sorgu = em.createNamedQuery("allquestionchoices", QuestionChoicesEntity.class);
        return sorgu.getResultList();
    }



    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void dropquestionchoices(QuestionChoicesEntity questionchoices)
    {
        em.remove(em.merge(questionchoices));
        em.flush();
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public QuestionChoicesEntity editquestionchoice(QuestionChoicesEntity questionchoice) throws Exception {
        try {
            em.merge(questionchoice);
            em.flush();
            return questionchoice;
        } catch (Exception e) {
            return null;
        }
    }


    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public QuestionChoicesEntity savequestionchoices  (QuestionChoicesEntity questionchoice){
        em.persist(questionchoice);
        em.flush();
        return questionchoice;
    }

    public List<QuestionChoicesEntity> allquestionchoicesbyid(Integer questionid){
        TypedQuery<QuestionChoicesEntity> sorgu = em.createNamedQuery("allquestionchoicesByid", QuestionChoicesEntity.class).setParameter("questionid",questionid);
        return sorgu.getResultList();
    }

    public QuestionChoicesBean() {
    }
}
