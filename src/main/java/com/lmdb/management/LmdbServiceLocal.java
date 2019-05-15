package com.lmdb.management;

import java.util.List;

import javax.ejb.Local;

import com.lmdb.domain.Lender;
import com.lmdb.domain.Movie;

@Local
public interface LmdbServiceLocal {

	public List<Movie> getAllMovies();
	public void registerMovie(Movie movie);
	public void deleteMovie(int id);
	public void updateTitle(int id, Movie movie);
//	public void getJoinTable();
	public void registerLender(Lender lender);
	public List<Lender> getAllLenders();
	public void registerLoan(int film_id, int lender_id);
	

}
