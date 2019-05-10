package com.lmdb.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;

@Entity
public class Loan implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@OneToOne
	@JoinTable(name = "JOIN_TABLE", joinColumns = {
			@JoinColumn(name = "id", referencedColumnName = "id") }, inverseJoinColumns = {
					@JoinColumn(name = "loan_id", referencedColumnName = "id") })
	private Movie movie;
	private int id;
	private int loan_ID;
	private int movie_ID;

}
