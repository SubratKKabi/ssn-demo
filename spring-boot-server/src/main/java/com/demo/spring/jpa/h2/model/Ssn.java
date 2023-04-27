package com.demo.spring.jpa.h2.model;

import javax.persistence.*;

@Entity
@Table(name = "ssn")
public class Ssn {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "ssn")
	private String ssn;

	public Ssn() {

	}

	public Ssn(String ssn) {
		this.ssn = ssn;
	}

	public long getId() {
		return id;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}



	@Override
	public String toString() {
		return "Ssn [id=" + id + ", ssn=" + ssn+ "]";
	}

}
