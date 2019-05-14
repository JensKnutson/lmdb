package com.lmdb.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import static javax.persistence.FetchType.LAZY;
import static javax.persistence.FetchType.EAGER;

import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlRootElement;



@Entity
@XmlRootElement
public class Movie implements Serializable {

	@OneToOne(fetch=EAGER)
	@JoinColumn(name="film_id")
	private Lender lender;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int id;
	private int year;

	@Column(length=100)
	private String title;
	
	@Column(length=100)
	private String format;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int releaseYear) {
		this.year = releaseYear;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String movieName) {
		this.title = movieName;
	}
	
	public void setFormat(String format) {
		this.format = format;
	}
	
	public String getFormat() {
		return format;
	}
	
	public Movie() {
		
	}
	
	public Movie( int releaseYear, String movieName) {
		super();
//		this.id = id;
		this.year = releaseYear;
		this.title = movieName;
	}
}
