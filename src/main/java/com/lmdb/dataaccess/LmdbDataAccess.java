package com.lmdb.dataaccess;

import java.util.List;

import com.lmdb.domain.Movie;

public interface LmdbDataAccess {
	
	public List<Movie> getAllMovies();
}
