package com.lmdb.management;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.lmdb.dataaccess.LmdbDataAccess;
import com.lmdb.domain.Movie;

@Stateless
public class MovieImplementation implements LmdbServiceLocal {
	
	@Inject
	private LmdbDataAccess lmdbDA;

	@Override
	public List<Movie> getAllMovies() {
		return lmdbDA.getAllMovies();
	}
}
