package com.lmdb.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Loan  implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private int loan_ID;
	private int movie_ID;

}
