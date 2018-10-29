package com.example.jpa.springdata.service;

import com.example.jpa.springdata.model.Student;
import org.springframework.stereotype.Service;

import java.util.List;

public interface StudentService {

    public List<Student> getListStudent();

    public void deleteARecord(Integer id);

    public Student getOne(Integer id);

    public Student save(Student s);
}
