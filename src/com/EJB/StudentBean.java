package com.EJB;

import com.Entity.StudentEntity;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless(name = "StudentEJB")
public class StudentBean {
    @PersistenceContext(name="QuizPlatform-ejbPU")
    private EntityManager em;

    public List<StudentEntity> allStudent(){
        TypedQuery<StudentEntity> sorgu = em.createNamedQuery("allstudents", StudentEntity.class);
        return sorgu.getResultList();
    }

    public List<StudentEntity> allusers(){
        TypedQuery<StudentEntity> sorgu = em.createNamedQuery("allusers", StudentEntity.class);
        return sorgu.getResultList();
    }

    public StudentEntity existUser(String mail ,String password)
    {

        Query query=em.createQuery("select a from student a WHERE  a.usermail LIKE :mail and a.userpassword like :password");
        query.setParameter("mail",mail);
        query.setParameter("password",password);
        StudentEntity user =(StudentEntity)query.getSingleResult();
        return user;
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void dropStudent(StudentEntity student1)
    {
        em.remove(em.merge(student1));
        em.flush();
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public StudentEntity editUsers(StudentEntity user) throws Exception {
        try {
            em.merge(user);
            em.flush();
            return user;
        } catch (Exception e) {

            System.out.println(e);
            return null;
        }
    }


    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public StudentEntity saveStudent(StudentEntity student){
        em.persist(student);
        em.flush();
        return student;
    }

    public StudentBean() {
    }
}
