package com.lmdb.dataaccess;

import java.util.List;

import com.lmdb.domain.Movie;

public interface LmdbDataAccess {

	List<Movie> getAllMovies();

}