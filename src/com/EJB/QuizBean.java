package com.EJB;

import com.Entity.QuizEntity;
import com.Entity.StudentEntity;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless(name = "QuizEJB")
public class QuizBean {
    @PersistenceContext(name="QuizPlatform-ejbPU")
    private EntityManager em;

    public List<QuizEntity> allquizes(){
        TypedQuery<QuizEntity> sorgu = em.createNamedQuery("allquizes", QuizEntity.class);
        return sorgu.getResultList();
    }

    public List<QuizEntity> allsciencequizes(){
        TypedQuery<QuizEntity> sorgu = em.createNamedQuery("allsciencequizes", QuizEntity.class);
        return sorgu.getResultList();
    }



    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void dropquiz(QuizEntity quiz)
    {
        em.remove(em.merge(quiz));
        em.flush();
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public QuizEntity editquiz(QuizEntity quiz) throws Exception {
        try {
            em.merge(quiz);
            em.flush();
            return quiz;
        } catch (Exception e) {
            return null;
        }
    }


    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public Integer saveQuiz(QuizEntity quiz){
        em.persist(quiz);
        em.flush();
        return quiz.getQuizid();
    }

    public QuizEntity findQuiz(Integer quizid)
    {
        QuizEntity quiz = em.find(QuizEntity.class,quizid);
        return quiz;
    }

    public QuizBean() {
    }
}
