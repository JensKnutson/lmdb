package com.lmdb.dataaccess;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.inject.Alternative;

import com.lmdb.domain.Movie;

@Stateless
@Alternative
public class LmdbDataAccessTestingVersion implements LmdbDataAccess {

	@Override
	public List<Movie> getAllMovies() {
		List<Movie> movieList = new ArrayList<>();
		movieList.add(new Movie(1, 1999, "This is not real"));
		movieList.add(new Movie(2, 1998, "This is a reel"));
		movieList.add(new Movie(3, 1997, "The real Real Madrid?"));
		
		return null;
	}

	@Override
	public void registerMovie(Movie movie) {

	}

	@Override
	public Movie deleteMovie(int id) {
		return new Movie(1, 1997, "Honey...I deleted the kids!");
	}

	@Override
	public void changeTitle(int id, Movie movie) {

	}

}
