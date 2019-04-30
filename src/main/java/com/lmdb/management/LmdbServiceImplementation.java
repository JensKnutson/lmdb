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
	public Movie deleteMovie(int ID) {
		return lda.deleteMovie(ID);
		
	}

}
