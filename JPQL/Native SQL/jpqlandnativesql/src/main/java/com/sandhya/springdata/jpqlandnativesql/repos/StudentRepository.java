package com.sandhya.springdata.jpqlandnativesql.repos;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.sandhya.springdata.jpqlandnativesql.entities.Student;

public interface StudentRepository extends CrudRepository<Student, Long> {

	// find all the students in the student table
	@Query("from Student") // select everything
	List<Student> findAllStudents(Pageable pageable);

	// partial info

	@Query("select st.firstName, st.lastName from Student st")
	List<Object[]> findAllStudentsPartialData();

	// named Parameter passing parameter to the string
	@Query("from Student where firstName=:fname")
	List<Student> findAllStudentsByFirstName(@Param("fname") String firstName);

	// find all the students between a given score range
	@Query("from Student where score>:min and score<:max")
	List<Student> findAllStudentsBetweenScore(@Param("min") int min, @Param("max") int max);

	// NON select operations : INSERT UPDATE and DELETE
	@Modifying
	@Query("delete from Student where firstName=:fname")
	void deleteStudentsByFirstName(@Param("fname") String firstName);

	// >>>>>>>>>>>>>>Using native SQL<<<<<<<<<<<<<<<<<<<
	@Query(value = "select * from student", nativeQuery = true)
	List<Student> findAllStudentNQ();
	
	@Query(value="select * from student where fname=:firstName", nativeQuery=true)
	List<Student> findByFirstNQ(@Param("firstName") String firstName);
	
	@Query(value="select st.fname, st.lname from student st", nativeQuery=true)
	List<Object[]> findAllStudentsPartialDataNQ();

}
