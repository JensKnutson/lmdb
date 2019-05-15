package com.lmdb.dataaccess;

import java.util.List;

import com.lmdb.domain.Lender;
import com.lmdb.domain.Movie;


public interface LmdbDataAccess {
	
	public List<Movie> getAllMovies();


	public void registerMovie(Movie movie);

	public Movie deleteMovie(int id);

	public void changeTitle(int id, Movie movie);
	
//	public void getJoinTable();
	
	public void registerLender(Lender lender);
	
	public List<Lender> getAllLenders();
	
	public void registerLoan(int film_id, int lender_id);

	public void deleteLoan(int lenderId, int filmId);



}


