package com.lmdb.management;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.lmdb.dataaccess.LmdbDataAccess;
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

}
