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

//		System.out.println("Received value = " + id);

//		Query query = em.createQuery("select movie from Movie movie where movie.id=:id");
//		query.setParameter("id", id);
//		Movie present_movie = (Movie) query.getSingleResult();
		Movie themovie = em.find(Movie.class, id);
		themovie.setTitle(movie.getTitle());

//		themovie = movie;

//		movie.setTitle(title);
		
//		em.getTransaction().begin();
//		em.merge(themovie);
//		em.getTransaction().commit();
		
//		System.out.println(movie.getTitle());
		
		
	}

}
