package com.vishwa.crudproject.dao;

import com.vishwa.crudproject.entity.Student;

import java.util.List;

public interface StudentDAO {

    void save(Student student);

    Student findById(Integer id);

    List<Student> findAll();

    List<Student> findByLastName(String lastName);

    void update(Student student);

    void deleteData(Integer id);

    int deleteAllData();
}
