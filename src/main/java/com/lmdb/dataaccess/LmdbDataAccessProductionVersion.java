package com.lmdb.dataaccess;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.Tuple;

import com.lmdb.domain.Lender;
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

//	public void getJoinTable() {
//		Query query = em.createNativeQuery("from JOIN_TABLE");
//		List list = query.getResultList();
//	      for (Object o : list) {
//	          if(o instanceof Object[]) {
//	              System.out.println(Arrays.toString((Object[]) o));
//	          }else{
//	              System.out.println(o);
//	          }
//	      }
//	}

	@Override
	public void changeTitle(int id, Movie movie) {

		Movie themovie = em.find(Movie.class, id);

		if (movie.getTitle() != null) {
			themovie.setTitle(movie.getTitle());
		}

		if (movie.getYear() != 0) {
			themovie.setYear(movie.getYear());
		}

		if (movie.getFormat() != null) {
			themovie.setFormat(movie.getFormat());
		}

	}

	@Override
	public void registerLender(Lender lender) {
		em.persist(lender);
		
	}

	@Override
	public List<Lender> getAllLenders() {
		Query query = em.createQuery("from Lender");
		System.out.println("Dataaccess called");
		List<Lender> lenders = query.getResultList();


		return lenders;
	}

	@Override
	public void registerLoan(int film_id, int lender_id) {
		
		Movie movie = em.find(Movie.class, film_id);
		Lender lender = em.find(Lender.class, lender_id);
		
		lender.getMovies().add(movie);

		
		
	}

	@Override
	public void deleteLoan(int lenderid, int filmId) {

		Lender lender = em.find(Lender.class, lenderid);
		Movie movie = em.find(Movie.class, filmId);
		
		lender.getMovies().remove(movie);		
	}
	
	@Override
	public List<String> getAllLoans() {
		Query query = em.createQuery("select l from loan l");
		List<Tuple> results = query.getResultList();
		List<String> loans = new ArrayList<>();
		
		for (Tuple tuple : results ) {
			loans.add(tuple.toString());
		}
		return loans;
	}

}

