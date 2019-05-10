package com.lmdb.dataaccess;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.lmdb.domain.Movie;

@Stateless
public class LmdbDataAccessProductionVersion implements LmdbDataAccess {
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Movie> getAllMovies() {
		Query query = em.createQuery("from Movie");
		System.out.println("Dataaccess called");
		List<Movie> movie = query.getResultList();
		return movie;
	}

	@Override
	public void registerMovie(Movie movie) {
		em.persist(movie);
	}	

	public Movie deleteMovie(int id) {
		Query query = em.createQuery("select movie from Movie movie where movie.id= :id");
		query.setParameter("id", id);
		Movie movie = (Movie) query.getSingleResult();
		em.remove(em.find(Movie.class, movie.getId()));
		return movie;
	}



	@Override
	public void changeTitle(int id, Movie movie) {

		Movie themovie = em.find(Movie.class, id);
		
		if(movie.getTitle() != null ) {
			themovie.setTitle(movie.getTitle());			
		}
		
		if(movie.getYear() != 0) {
			themovie.setYear(movie.getYear());
		}
		
		if(movie.getFormat() != null ) {
			themovie.setFormat(movie.getFormat());
		}
		
		


		
		
	}

}
