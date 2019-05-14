package com.lmdb.rest;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.ServiceUnavailableException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;

import com.lmdb.domain.Lender;
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
	
//	@GET
//	@Produces("application/JSON")
//	@Path("/join")
//	public void getJoinTable() {
//		lmdb.getJoinTable();
//		
//	}

	@POST
	@Produces("application/JSON")
	@Consumes("application/JSON")
	public Response registerMovie (Movie movie) {
		
		System.out.println(movie.getTitle());
		
		lmdb.registerMovie(movie);
		
		try {
			lmdb.registerMovie(movie);
			return Response.status(201).build();
			} catch (ServiceUnavailableException e ) {
			return Response.status(504).build();
		}
		
	};
	
	
	@PUT
	@Produces("application/JSON")
	@Consumes("application/JSON")
	@Path("/update/{id}")
	public Response updateMovieTitle (@PathParam("id") int id, @Context HttpHeaders header, Movie movie ) {
		
		try {
			System.out.println("rest update called on " + id );
			lmdb.updateTitle(id, movie);
			
			return Response.status(201).build();
			} catch (ServiceUnavailableException e ) {
			return Response.status(504).build();
		}
		
	};
	
	@DELETE
	@Produces("application/JSON")
	@Path("/delete/{id}")
	public Response removeMovie(@PathParam("id") int id, @Context HttpHeaders header) {
		try {
			lmdb.deleteMovie(id);
			return Response.status(201).build();
		}
		catch(ServiceUnavailableException e) {
			return Response.status(504).build();
		}
		
	}
	
	@POST
	@Produces("application/JSON")
	@Consumes("application/JSON")
	@Path("/lender")
	public Response registerLender (Lender lender) {
		
//		System.out.println(movie.getTitle());
		
		
		try {
			lmdb.registerLender(lender);
			return Response.status(201).build();
			} catch (ServiceUnavailableException e ) {
			return Response.status(504).build();
		}
		
	};
	
	@GET
	@Produces("application/JSON")
	@Path("/lender")
	public List<Lender> getAllLenders(){
		System.out.println("Webservice called");
		return lmdb.getAllLenders();
	}


}
