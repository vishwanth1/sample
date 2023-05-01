package com.vishwa.crudproject.dao;

import com.vishwa.crudproject.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO{

    private EntityManager entityManager;

    public StudentDAOImpl(EntityManager entityManager)
    {
        this.entityManager = entityManager;
    }
    @Override
    @Transactional
    public void save(Student student) {
        entityManager.persist(student);
    }

    @Override
    public Student findById(Integer id) {
        return entityManager.find(Student.class,id);
    }

    @Override
    public List<Student> findAll() {
        TypedQuery<Student> theQuery = entityManager.createQuery("From Student order by lastName", Student.class);

        return theQuery.getResultList();
    }

    @Override
    public List<Student> findByLastName(String lastName) {
        TypedQuery<Student> theQuery = entityManager.createQuery("From Student where lastName=:theData", Student.class);
        theQuery.setParameter("theData",lastName);
        return theQuery.getResultList();
    }

    @Override
    @Transactional
    public void update(Student student) {
        entityManager.merge(student);
    }

    @Override
    @Transactional
    public void deleteData(Integer id) {
        Student student = entityManager.find(Student.class,id);
        entityManager.remove(student);
    }

    @Override
    @Transactional
    public int deleteAllData() {
        int rowsUpdated = entityManager.createQuery("Delete From Student").executeUpdate();
        return rowsUpdated;
    }
}
