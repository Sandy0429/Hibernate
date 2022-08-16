package com.sandhya.springdata.product;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Optional;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.sandhya.springdata.product.entities.Product;
import com.sandhya.springdata.product.repos.ProductRepository;

@SpringBootTest
class ProductdataApplicationTests {

//	Entity Manager for caching
	@Autowired
	EntityManager entityManager;

	@Autowired
	ProductRepository repositiry;

	@Test
	void contextLoads() {
	}

	@Test
	public void testCreate() {
		Product product = new Product();
		product.setId(2);
		;
		product.setName("Iphone7");
		product.setDesc("Awesome phome rr");
		product.setPrice(1200d);

		repositiry.save(product);
	}

	@Test
	public void testRead() {
		Product product = repositiry.findById(1).get();
		assertNotNull(product);
		assertEquals("Iphone", product.getName());
		System.out.println(">>>>>>>>>>>>>>>>>>>>" + product.getDesc());
	}

	@Test
	public void testUpdate() {
		Product product = repositiry.findById(1).get();
		product.setPrice(1249d);

		repositiry.save(product);// already exists it will update it
	}

	@Test
	public void testDelete() {
		if (repositiry.existsById(2)) {
			repositiry.deleteById(2);
		}
	}

	@Test
	public void testCount() {
		System.out.println("Total Records = " + repositiry.count());
	}

//	>>>>>>>>>>>>>>>>caching in action>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>.

	@Test
	@Transactional
	public void testCaching() {
		repositiry.findById(1);
		repositiry.findById(1);
		repositiry.findById(2);

	}

	@Test
	@Transactional
	public void testCachingEvict() {
		Session session = entityManager.unwrap(Session.class);

		Optional<Product> product = repositiry.findById(1);

		repositiry.findById(1);
		repositiry.findById(1);
		session.evict(product.get());

		repositiry.findById(1);

	}
//	>>>>>>>>>>>>>>>>>second level Caching Test
	@Test
	@Transactional
	public void testCaching2Level() {
		Session session = entityManager.unwrap(Session.class);

		Optional<Product> product = repositiry.findById(1);

		repositiry.findById(1);
		repositiry.findById(1);
		session.evict(product.get());

		repositiry.findById(1);

	}
	
	

}
