package com.sandhya.springdata.transactionmanagement.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class BankAccount {

	@Id
	private int accno;
	private String firstName;
	private String lastName;
	private int bal;

	public int getAccno() {
		return accno;
	}

	public void setAccno(int accno) {
		this.accno = accno;
	}

	public String getFirastName() {
		return firstName;
	}

	public void setFirastName(String firastName) {
		this.firstName = firastName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getBal() {
		return bal;
	}

	public void setBal(int bal) {
		this.bal = bal;
	}

	@Override
	public String toString() {
		return "BankAccount [accno=" + accno + ", firastName=" + firstName + ", lastName=" + lastName + ", bal=" + bal
				+ "]";
	}

}
