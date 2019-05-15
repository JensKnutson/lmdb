package com.lmdb.dataaccess;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.inject.Alternative;

import com.lmdb.domain.Lender;
import com.lmdb.domain.Movie;

@Stateless
@Alternative
public class LmdbDataAccessTestingVersion implements LmdbDataAccess {

	@Override
	public List<Movie> getAllMovies() {
		System.out.println("Test called");
		List<Movie> movieList = new ArrayList<>();
		movieList.add(new Movie(1999, "This is not real"));
		movieList.add(new Movie(1998, "This is a reel"));
		movieList.add(new Movie(1997, "The real Real Madrid?"));
		
		return movieList;
	}

	@Override
	public void registerMovie(Movie movie) {

	}

	@Override
	public Movie deleteMovie(int id) {
		return new Movie(1997, "Honey...I deleted the kids!");
	}

	@Override
	public void changeTitle(int id, Movie movie) {

	}

	@Override
	public void registerLender(Lender lender) {
		
	}

	@Override
	public List<Lender> getAllLenders() {
		List<Lender> lenders = new ArrayList<>();
		lenders.add(new Lender("Testis Testsson"));
		return lenders;
	}

	@Override
	public void registerLoan(int film_id, int lender_id) {
		
	}

	@Override
	public void deleteLoan(int lenderId, int filmId) {
		
	}



//	@Override 
//	public void getJoinTable() {}

}
