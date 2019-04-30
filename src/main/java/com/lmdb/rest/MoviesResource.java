package com.lmdb.rest;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;

import com.lmdb.domain.Movie;
import com.lmdb.management.LmdbServiceLocal;

@Stateless
//@Path("/movies")
@WebServlet("movies")
public class MoviesResource {
	
	@Inject
	private LmdbServiceLocal lmdb;
	
	@GET
	@Produces("application/JSON")
	public List<Movie> getAllMovies(){
		return lmdb.getAllMovies();
	}

}
