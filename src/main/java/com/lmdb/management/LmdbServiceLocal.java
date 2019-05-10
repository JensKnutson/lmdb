package com.lmdb.management;

import java.util.List;

import javax.ejb.Local;
import javax.ws.rs.core.Response;

import com.lmdb.domain.Movie;

@Local
public interface LmdbServiceLocal {

	public List<Movie> getAllMovies();
	public void registerMovie(Movie movie);
	public void deleteMovie(int id);
	public void updateTitle(int id, Movie movie);
	

}
