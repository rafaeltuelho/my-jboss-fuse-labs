package br.rafaeltuelho.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the CUSTOMERS database table.
 * 
 */
@Entity
@Table(name="CUSTOMERS", schema="CAMEL_TEST_DB", catalog="TEST")
@NamedQuery(name="Customer.findAll", query="SELECT c FROM Customer c")
public class Customer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;

	@Temporal(TemporalType.DATE)
	@Column(name="BIRTH_DATE")
	private Date birthDate;

	private String email;

	@Column(name="FIRST_NAME")
	private String firstName;

	@Column(name="LAST_NAME")
	private String lastName;

	public Customer() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getBirthDate() {
		return this.birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return String
				.format("Customer [id=%s, birthDate=%s, email=%s, firstName=%s, lastName=%s]",
						id, birthDate, email, firstName, lastName);
	}

}