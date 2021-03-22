package com.darkside.studentsmanagement.students;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    public void addNewStudent(Student student) {
        Optional<Student> studentByEmail =
        studentRepository.findByEmail(student.getEmail());
        if(studentByEmail.isPresent()) {
            try {
                throw new IllegalAccessException("email taken");
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        studentRepository.save(student);
    }

    public void deleteStudent(Long id) {
        boolean exists = studentRepository.existsById(id);
        if(!exists) {
            throw new IllegalStateException(
                    "student with if " + id + " doesn't exists"
            );
        }
        studentRepository.deleteById(id);
    }

    @Transactional
    public void updateStudent(Long id, String lastName, String email) {

        Student myStudent = studentRepository.findById(id).orElseThrow(
                () -> new IllegalStateException(
                        "student with id " + id + "doesn't exists")
                );

        if(lastName != null && lastName.length() > 0 &&
            !Objects.equals(myStudent.getLastName(), lastName)) {
            myStudent.setLastName(lastName);
        }

        if(email != null && email.length() > 0 &&
            !Objects.equals(myStudent.getEmail(), email)) {
            Optional<Student> studentOptional = studentRepository.findByEmail(email);
           if(studentOptional.isPresent()) {
               throw new IllegalStateException("email taken");
           }
           myStudent.setEmail(email);
        }

    }
}
