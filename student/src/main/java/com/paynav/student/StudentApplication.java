package com.paynav.student;

import com.paynav.student.model.Student;
import com.paynav.student.repository.StudentRepo;
import com.paynav.student.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;

@SpringBootApplication
@RequiredArgsConstructor
@EnableEurekaClient
public class StudentApplication {
	private final StudentRepo repo;
	public static void main(String[] args) {
		SpringApplication.run(StudentApplication.class, args);
	}


	@Bean
	public CommandLineRunner commandLineRunner() {
		return args -> {
			repo.save(new Student(1, "John", "Science", "456 Elm St", "johnemily86@gmail.com", 20, "Male", "Parent John", "7894561230", "ADM-0001", LocalDateTime.now(), "Ryan"));
			repo.save(new Student(2, "Olivia", "English", "789 Oak St", "oliviamichael42@yahoo.com", 17, "Female", "Parent Olivia", "9876543210", "ADM-0002", LocalDateTime.now(), "Alex"));
			repo.save(new Student(3, "Michael", "Mathematics", "321 Pine St", "michaeldaniel89@hotmail.com", 18, "Male", "Parent Michael", "7890123456", "ADM-0003", LocalDateTime.now(), "Sarah"));
			repo.save(new Student(4, "Emma", "History", "123 Main St", "emmaolivia18@outlook.com", 19, "Female", "Parent Emma", "0123456789", "ADM-0004", LocalDateTime.now(), "Jessica"));
			repo.save(new Student(5, "Daniel", "Geography", "654 Maple St", "danieldavid92@gmail.com", 22, "Male", "Parent Daniel", "4567890123", "ADM-0005", LocalDateTime.now(), "Ryan"));
			repo.save(new Student(6, "Sophia", "Computer Science", "789 Oak St", "sophiadavid69@yahoo.com", 16, "Female", "Parent Sophia", "8901234567", "ADM-0006", LocalDateTime.now(), "Alex"));
			repo.save(new Student(7, "William", "Physics", "321 Pine St", "williamjacob11@hotmail.com", 17, "Male", "Parent William", "9012345678", "ADM-0007", LocalDateTime.now(), "Sarah"));
			repo.save(new Student(8, "Emily", "Chemistry", "123 Main St", "emilyemma28@outlook.com", 18, "Female", "Parent Emily", "3456789012", "ADM-0008", LocalDateTime.now(), "Jessica"));
			repo.save(new Student(9, "James", "Biology", "654 Maple St", "jamesmichael19@gmail.com", 20, "Male", "Parent James", "5678901234", "ADM-0009", LocalDateTime.now(), "Ryan"));
			repo.save(new Student(10, "Olivia", "History", "321 Pine St", "oliviamichael27@hotmail.com", 19, "Female", "Parent Olivia", "4567890123", "ADM-0010", LocalDateTime.now(), "Alex"));
		};
	}


}
