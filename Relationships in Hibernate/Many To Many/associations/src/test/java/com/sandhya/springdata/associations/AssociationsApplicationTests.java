package com.sandhya.springdata.associations;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.sandhya.springdata.associations.manytomany.entities.Programmer;
import com.sandhya.springdata.associations.manytomany.entities.Project;
import com.sandhya.springdata.associations.manytomany.repos.ProgrammerRepository;


@SpringBootTest
class AssociationsApplicationTests {

	
	@Autowired
	ProgrammerRepository prepo;

	@Test
	void contextLoads() {
	}

	
	//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>MANY TO MANY>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	
	@Test
	public void testmtomCreateProgrammer() {
		Programmer programmer = new Programmer();
		programmer.setName("John");
		programmer.setSalary(10000);
		
		HashSet<Project> projects = new HashSet<Project>();
		Project project = new Project();
		project.setName("Hibernate Project");
		projects.add(project);
		programmer.setProjects(projects);
		
		prepo.save(programmer);
	}
	
	@Test
	@Transactional //if we are not using EAGER then we can use transactional in place of it it will solve the problem
	public void testmtomFindProgrammer() {
		Optional<Programmer> programmer = prepo.findById(1);
		
		System.out.println(programmer.get());
		System.out.println(programmer.get().getProjects());
		
	}

}
