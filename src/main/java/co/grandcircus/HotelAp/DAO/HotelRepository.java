package co.grandcircus.HotelAp.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import co.grandcircus.HotelAp.Entities.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, Long> {
	
	List<Hotel> findByCityOrderByPrice(String city);
	
	List<Hotel> findByCityOrderByRatingDesc(String city);
	
	List<Hotel> findAllOrderByCity(String city);
	
	List<Hotel> findByHotelNameLikeIgnoreCase(String search);

//	List<Hotel> findDistinctByCity();

}
