package com.paynav.teacher;

import com.paynav.teacher.model.Teacher;
import com.paynav.teacher.repository.TeacherRepo;
import com.paynav.teacher.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;

@SpringBootApplication
@RequiredArgsConstructor
@EnableEurekaClient
@EnableFeignClients
@EnableCaching
public class TeacherApplication {
	private final TeacherRepo repo;
	public static void main(String[] args) {
		SpringApplication.run(TeacherApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner() {
		return args -> {
			repo.save(new Teacher(1, "John", "Science", "1234567890", "456 Elm St", LocalDateTime.now(), "johnsmith@example.com", "M.Sc.", 5, 50000.0));
			repo.save(new Teacher(2, "Olivia", "English", "9876543210", "789 Oak St", LocalDateTime.now(), "oliviamartin@example.com", "B.A.", 3, 40000.0));
			repo.save(new Teacher(3, "Michael", "Mathematics", "0123456789", "321 Pine St", LocalDateTime.now(), "michaeldavis@example.com", "M.Sc.", 8, 60000.0));
			repo.save(new Teacher(4, "Emma", "History", "4567890123", "123 Main St", LocalDateTime.now(), "emmajohnson@example.com", "B.A.", 4, 45000.0));
			repo.save(new Teacher(5, "Daniel", "Geography", "7890123456", "654 Maple St", LocalDateTime.now(), "danielsmith@example.com", "M.A.", 6, 55000.0));
			repo.save(new Teacher(6, "Sophia", "Computer Science", "8901234567", "789 Oak St", LocalDateTime.now(), "sophiamiller@example.com", "M.Tech", 2, 42000.0));
			repo.save(new Teacher(7, "William", "Physics", "9012345678", "321 Pine St", LocalDateTime.now(), "williamthompson@example.com", "M.Sc.", 7, 58000.0));
			repo.save(new Teacher(8, "Emily", "Chemistry", "3456789012", "123 Main St", LocalDateTime.now(), "emilywilson@example.com", "B.Sc.", 5, 47000.0));
			repo.save(new Teacher(9, "James", "Biology", "5678901234", "654 Maple St", LocalDateTime.now(), "jamesbrown@example.com", "M.Sc.", 4, 52000.0));
			repo.save(new Teacher(10, "Olivia", "History", "4567890123", "321 Pine St", LocalDateTime.now(), "oliviasmith@example.com", "B.A.", 3, 41000.0));
		};
	}
}
