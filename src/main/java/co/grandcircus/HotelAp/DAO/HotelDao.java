package co.grandcircus.HotelAp.DAO;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Table;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

@Repository
@Transactional

public class HotelDao {
	
	@PersistenceContext
	private EntityManager em;
	
	public Set<String> findAllCities() {
		// This query returns a list of Strings, so I give it String.class
		List<String> cityList = em.createQuery("SELECT DISTINCT city FROM Hotel", String.class)
				.getResultList(); 							//^map from the ENTITY not from the table	
		// Convert the List to a Set.
		return new TreeSet<>(cityList);
	}

}
