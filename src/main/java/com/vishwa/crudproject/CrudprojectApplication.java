package com.vishwa.crudproject;

import com.vishwa.crudproject.dao.StudentDAO;
import com.vishwa.crudproject.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CrudprojectApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudprojectApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO)
	{
		return runner -> {
			// createStudent(studentDAO);

			createMultipleStudent(studentDAO);

			// findStudent(studentDAO);

			// findAllStudents(studentDAO);

			// findStudentByLastName(studentDAO);

			// updateStudent(studentDAO);

			// removeStudent(studentDAO);

			// removeAllData(studentDAO);
		};
	}

	private void createStudent(StudentDAO studentDAO)
	{
		System.out.println("Created a new Student Object");
		Student student = new Student("Vishwa","G","sample@gmail.com");
		System.out.println("Save the Student");
		studentDAO.save(student);
		System.out.println("Saved the Student" + student.getId());

	}

	private void createMultipleStudent(StudentDAO studentDAO)
	{
		System.out.println("Created a 3 Student Object");
		Student student = new Student("Vishwa","G","sample@gmail.com");
		Student student1 = new Student("Rama","K","sample@gmail.com");
		Student student2 = new Student("Kakkurthi","G","sample@gmail.com");
		studentDAO.save(student);
		studentDAO.save(student1);
		studentDAO.save(student2);
	}

	private void findStudent(StudentDAO studentDAO)
	{
		Student student = new Student("Vishwa","G","sample@gmail.com");
		studentDAO.save(student);
		System.out.println("Saved the Student" + student.getId());
		Student getStudent = studentDAO.findById(student.getId());
		System.out.println("Found" + getStudent);
	}

	private void findAllStudents(StudentDAO studentDAO)
	{
		List<Student> students = studentDAO.findAll();

		System.out.println(students);

		for(Student theStudent : students)
		{
			System.out.println(theStudent);
		}
	}

	private void findStudentByLastName(StudentDAO studentDAO)
	{
		List<Student> studentList = studentDAO.findByLastName("G");

		for(Student students : studentList)
		{
			System.out.println(students);
		}
	}

	private void updateStudent(StudentDAO studentDAO)
	{
		int studentId = 3;
		Student student = studentDAO.findById(studentId);
		student.setLastName("Kamma");
		studentDAO.update(student);
		Student studentDetails = studentDAO.findById(studentId);
		System.out.println(studentDetails);

	}

	private void removeStudent(StudentDAO studentDAO)
	{
		int studentId = 3;
		studentDAO.deleteData(studentId);
	}

	private void removeAllData(StudentDAO studentDAO)
	{
		studentDAO.deleteAllData();
		System.out.println("All Data has been deleted");
	}


}
