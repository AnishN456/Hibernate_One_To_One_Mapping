package com.example.demo.onetoone;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.onetoone.dao.AppDAO;
import com.example.demo.onetoone.entity.Instructor;
import com.example.demo.onetoone.entity.InstructorDetail;

@SpringBootApplication
public class OneToOneApplication {

	public static void main(String[] args) {
		SpringApplication.run(OneToOneApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner runner(AppDAO appDAO) {
		return runner ->{
			//createInstructor(appDAO);
			findById(appDAO);
			//deleteById(appDAO);
		};
	}

	private void deleteById(AppDAO appDAO) {
		int theId = 1;
		System.out.println("Deleting the Instructor with Id: "+theId);
		appDAO.delete(theId);
		System.out.println("Done!!!");
		
	}

	private void findById(AppDAO appDAO) {
		int id = 1;
		Instructor instructor = appDAO.findById(id);
		System.out.println("Instructor : "+instructor);
		InstructorDetail instructorDetail = instructor.getInstructorDetail();
		System.out.println("Instructor Detail: "+instructorDetail);
	}

	private void createInstructor(AppDAO dao) {
		
		Instructor instructor = new Instructor("Anish","N","anish@luv2code.com");
		
		InstructorDetail instructorDetail = new InstructorDetail(
				"http://www.luv2code.com/1youtube",
				"luv 2 code"
				);
		
		instructor.setInstructorDetail(instructorDetail);
		
		System.out.println("Saving the Istructor "+instructor);
		
		dao.save(instructor);
		
		
		
		
	}

}
