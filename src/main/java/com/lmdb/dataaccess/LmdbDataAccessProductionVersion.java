package com.lmdb.dataaccess;

import java.util.List;

import javax.ejb.Stateless;
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
		System.out.println(id);
		Query query = em.createQuery("delete from Movie as ua where ua.id like ?1").setParameter(1, id);
		Movie movie = (Movie) query.getSingleResult();
		System.out.println(movie + " " + id);
		em.remove(query);
		return null;

	}

	@Override
	public void changeMovie(int id, String title, int year, String format) {
		Query query = em.createQuery("update movie set title=:title, year=:year, format=:format where id =:id");
		query.setParameter("title", title);
		query.setParameter("year", year);
		query.setParameter("format", format);
		query.setParameter("id", id);
		
		Movie movie = (Movie) query.getSingleResult();
		
		System.out.println(movie);	
		
		
	}

}
