package com.sandhya.springdata.associations.onetomany.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String name;
	
//	@OneToMany(mappedBy="customer", cascade = CascadeType.ALL, fetch=FetchType.LAZY)//lazy loading --bydefault its lazy loading
	@OneToMany(mappedBy="customer", cascade = CascadeType.ALL, fetch=FetchType.EAGER) //customer owns the mapping Cascade means what ever we are doing on
															// Customer also do it on phonenumbers for inserts update delete.
	private Set<PhoneNumber> numbers;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<PhoneNumber> getNumbers() {
		return numbers;
	}

	public void setNumbers(Set<PhoneNumber> numbers) {
		this.numbers = numbers;
	}
	
	//better way of saving the foreign key value
	public void addPhoneNumber(PhoneNumber number) {
		
		if (number != null) {
			if(numbers == null) {
				numbers= new HashSet<>();
			}
			
			number.setCustomer(this);
				numbers.add(number);
			
		}
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", numbers=" + numbers + "]";
	}
	
	

}
