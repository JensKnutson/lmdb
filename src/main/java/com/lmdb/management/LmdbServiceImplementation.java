package com.lmdb.management;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.lmdb.dataaccess.LmdbDataAccess;
import com.lmdb.domain.Lender;
import com.lmdb.domain.Movie;

@Stateless
public class LmdbServiceImplementation implements LmdbServiceLocal {
	
	@Inject
	LmdbDataAccess lda;

	@Override
	public List<Movie> getAllMovies() {
		return lda.getAllMovies();
	}

	@Override
	public void registerMovie(Movie movie) {
		lda.registerMovie(movie);
		
	}



	public void deleteMovie(int ID) {
		lda.deleteMovie(ID);
		
	}

	@Override
	public void updateTitle(int id, Movie movie) {
		lda.changeTitle(id, movie);
		
	}

	@Override
	public void registerLender(Lender lender) {
		lda.registerLender(lender);
		
	}

	@Override
	public List<Lender> getAllLenders() {
		return lda.getAllLenders();
	}

	@Override
	public void registerLoan(int film_id, int lender_id) {
		lda.registerLoan(film_id, lender_id);
		
	}

	@Override
	public void deleteLoan(int lenderId, int filmId) {
		lda.deleteLoan(lenderId, filmId);
	}

//	@Override
//	public void getJoinTable() {
//		lda.getJoinTable();
//		
//	}

}
