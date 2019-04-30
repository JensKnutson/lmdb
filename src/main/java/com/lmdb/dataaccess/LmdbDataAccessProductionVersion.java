package com.lmdb.dataaccess;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.lmdb.domain.Movie;
import com.lmdb.management.LmdbServiceLocal;

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
//		Query query = em.createQuery("delete from Movie as ua where ua.id like ?1").setParameter(1, id);
		Movie movie = (Movie) query.getSingleResult();
		System.out.println(movie + " " + id);
//		em.remove(query);
		return movie;

	}

}
