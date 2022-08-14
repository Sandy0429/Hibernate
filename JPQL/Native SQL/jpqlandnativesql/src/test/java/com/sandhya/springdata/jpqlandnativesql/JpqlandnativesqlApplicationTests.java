package com.sandhya.springdata.jpqlandnativesql;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.sandhya.springdata.jpqlandnativesql.entities.Student;
import com.sandhya.springdata.jpqlandnativesql.repos.StudentRepository;

@SpringBootTest
class JpqlandnativesqlApplicationTests {

	@Autowired
	StudentRepository repository;

	@Test
	public void testStudentCreate() {

		Student student = new Student();
		student.setFirstName("Sandhya");
		student.setLastName("Choudhari");
		student.setScore(99);
		repository.save(student);

		Student student1 = new Student();
		student1.setFirstName("Divyansh");
		student1.setLastName("Choudhari");
		student1.setScore(89);
		repository.save(student1);

		Student student2 = new Student();
		student2.setFirstName("Duggu");
		student2.setLastName("Choudhari");
		student2.setScore(79);
		repository.save(student2);

	}

	@Test
	public void testFindAllStudent() {
		System.out.println(repository.findAllStudents(PageRequest.of(1, 5, Direction.DESC, "id"))); // paging and
																									// sorting together
	}

	@Test
	public void testFindAllStudentPartial() {
		List<Object[]> partialData = repository.findAllStudentsPartialData();

		for (Object[] ob : partialData) {
			System.out.println(ob[0]);
			System.out.println(ob[1]);
		}
	}

	@Test
	public void testFindAllStudentByFirstName() {
		System.out.println(repository.findAllStudentsByFirstName("Duggu"));
	}

	@Test
	public void testFindAllStudentByscores() {
		System.out.println(repository.findAllStudentsBetweenScore(70, 90));
	}

	@Test
	@Transactional // when we perform update or delete we need to use this annotation
	// when we perform delete operation from test it will roll back the
	// transaction(only in test) so to prevent this we should use the below
	// annotation
	@Rollback(false) // use this with caution
	public void testdeleteStudentByFirstName() {
		repository.deleteStudentsByFirstName("Divyansh");
	}

// Native SQL
	@Test
	public void testFillAllStudentsNQ() {
		System.out.println(repository.findAllStudentNQ());
	}
	
	@Test
	public void testFindByFirstNameNQ() {
		System.out.println(repository.findByFirstNQ("Divyansh"));
	}
	
	@Test
	public void testFindAllStudentPartialNQ() {
		List<Object[]> partialData = repository.findAllStudentsPartialDataNQ();

		for (Object[] ob : partialData) {
			System.out.print(ob[0]);
			System.out.println(ob[1]);
		}
	}
	

}
