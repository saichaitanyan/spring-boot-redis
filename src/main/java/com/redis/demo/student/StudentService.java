package com.redis.demo.student;

import java.util.List;

public interface StudentService {

    /**
     * to save the student details
     *
     * @param student
     * @return
     */
    Student addStudentDetails(Student student);

    /**
     * to fetch the all student details
     *
     * @return
     */
    List<Student> getAllStudentDetails();

    /**
     * to fetch particular user details
     *
     * @return
     */
    Student getStudentDetails(String id);


    /**
     * to delete particular user
     *
     * @param id
     */
    String deleteStudent(String id);

    /**
     * 'to update particular user details
     *
     * @param student
     * @return
     */
    Student updateStudentDetails(Student student);
}
