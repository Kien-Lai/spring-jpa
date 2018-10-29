package com.example.jpa.springdata.service.impl;

import com.example.jpa.springdata.model.Student;
import com.example.jpa.springdata.repository.StudentRepository;
import com.example.jpa.springdata.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepository repository;

    @Override
    public List<Student> getListStudent() {
        List<Student> listStudent = repository.findAll();
        return listStudent;
    }

    @Override
    public void deleteARecord(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public Student getOne(Integer id) {
        return repository.getOne(id);
    }

    @Override
    public Student save(Student s) {
        return repository.save(s);
    }
}
