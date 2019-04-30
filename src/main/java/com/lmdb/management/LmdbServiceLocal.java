package com.lmdb.management;

import java.util.List;

import javax.ejb.Local;

import com.lmdb.domain.Movie;

@Local
public interface LmdbServiceLocal {

	public List<Movie> getAllMovies();

	public void registerMovie(Movie movie);
}
