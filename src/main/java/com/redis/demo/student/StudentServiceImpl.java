package com.redis.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepo studentRepo;

    /**
     * to save the student details
     *
     * @param student
     * @return
     */
    @Override
    public Student addStudentDetails(Student student) {
        this.studentRepo.save(student);
        return student;
    }

    /**
     * to fetch the all student details
     *
     * @return
     */
    @Override
    public List<Student> getAllStudentDetails() {
        return (List<Student>) this.studentRepo.findAll();
    }

    /**
     * to fetch particular user details
     *
     * @param id
     * @return
     */
    @Override
    public Student getStudentDetails(String id) {
        return this.studentRepo.findById(id).get();
    }

    /**
     * to delete particular user
     *
     * @param id
     */
    @Override
    public String deleteStudent(String id) {
        if (this.studentRepo.findById(id).isPresent()) {
            this.studentRepo.deleteById(id);
            return "Deleted User";
        }
        return "User not found";
    }

    /**
     * 'to update particular user details
     *
     * @param student
     * @return
     */
    @Override
    public Student updateStudentDetails(Student student) {

        if (this.studentRepo.findById(student.getId()).isPresent()) {
            Student studentDetails = this.studentRepo.findById(student.getId()).get();
            if (student.getAge() != null) {
                studentDetails.setAge(student.getAge());
            } else if (student.getName() != null) {
                studentDetails.setName(student.getName());
            } else if (student.getGender() != null) {
                studentDetails.setGender(student.getGender());
            }
            this.studentRepo.save(studentDetails);
            return studentDetails;
        }
        return null;

    }
}
