package com.Controller;
import com.EJB.StudentBean;
import com.Entity.QuizEntity;
import  com.Entity.StudentEntity;
import org.glassfish.jersey.process.internal.RequestScoped;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name="studentController")
@RequestScoped
public class StudentController implements Serializable {
    @EJB
    StudentBean studentEJB;
    FacesContext context = FacesContext.getCurrentInstance();
    StudentEntity student =new StudentEntity();
    String usermail;
    String userpassword;
    int duration;
    private List<StudentEntity> studentList = new ArrayList();

    public List<StudentEntity> getUsers()
    {
        studentList=studentEJB.allusers();
        return (studentList);
    }


    public String loginStudent()
    {

        student = studentEJB.existUser(this.usermail,this.userpassword);

        switch (student.getRole()) {
            case 1:
                return ("index-admin.xhtml");

            case 0:
                return ("index-student.xhtml");
        }
        return ("index.xhtml");
    }

    public void addStudent(){
        try
        {
            if(!student.getUsermail().contains("@") || !student.getUsermail().contains("."))
            {
                context.addMessage(null, new FacesMessage("EROOR in mail"));
            }
            student = studentEJB.saveStudent(student);
            studentList=studentEJB.allStudent();
            context.addMessage(null,new FacesMessage("yes!"));
        }
        catch (Exception e)
        {
            context.addMessage(null ,new FacesMessage("Bara Rawa7"+e));
        }
    }

    public void editStudent(StudentEntity student1) throws Exception {

        student=studentEJB.saveStudent(student);
        studentEJB.dropStudent(student1);
    }

    public void dropUser(StudentEntity student1) throws Exception {
        studentEJB.dropStudent(student1);
    }

    public StudentEntity getStudent() {
        return student;
    }

    public void setStudent(StudentEntity student) {
        this.student = student;
    }

    public String getUserpassword() {
        return userpassword;
    }

    public void setUserpassword(String userpassword) {
        this.userpassword = userpassword;
    }

    public List<StudentEntity> getStudentList() {
        return studentList;
    }
    public String getUsermail() {
        return usermail;
    }

    public void setUsermail(String usermail) {
        this.usermail = usermail;
    }

    public void setUserList(List<StudentEntity> userList) {
        this.studentList = userList;
    }



}
