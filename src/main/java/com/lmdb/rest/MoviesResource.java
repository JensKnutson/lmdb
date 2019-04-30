package com.lmdb.rest;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;

import com.lmdb.domain.Movie;
import com.lmdb.management.LmdbServiceLocal;

@Stateless
@Path("/movies")
public class MoviesResource {
	
	@Inject
	private LmdbServiceLocal lmdb;
	
	@GET
	@Produces("application/JSON")
	public List<Movie> getAllMovies(){
		System.out.println("Webservice called");
		return lmdb.getAllMovies();
	}
	
	@DELETE
	@Path("/delete/{id}")
	public Movie removeMovie(@PathParam("id") int id, @Context HttpHeaders header) {
		return lmdb.deleteMovie(id);
	}

}
