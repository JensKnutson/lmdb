package com.lmdb.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Loan implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="LOAN_ID")
	int id;
	
	
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="MOVIE_ID")
	private Movie movie;
	
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getLoan_ID() {
		return loan_ID;
	}


	public void setLoan_ID(int loan_ID) {
		this.loan_ID = loan_ID;
	}


	public int getMovie_ID() {
		return movie_ID;
	}


	public void setMovie_ID(int movie_ID) {
		this.movie_ID = movie_ID;
	}


	public Movie getMovie() {
		return movie;
	}


	public void setMovie(Movie movie) {
		this.movie = movie;
	}


	private int loan_ID;
	private int movie_ID;
	

	
}
