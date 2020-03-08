package co.grandcircus.HotelAp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import co.grandcircus.HotelAp.DAO.HotelDao;
import co.grandcircus.HotelAp.DAO.HotelRepository;
import co.grandcircus.HotelAp.Entities.Hotel;

@Controller
public class HotelController {
	
	@Autowired
	HotelDao hotelDao;
	
	@Autowired
	HotelRepository hotelRep;
	
	@RequestMapping("/")
	public ModelAndView home() {
		return new ModelAndView("home", "cities", hotelDao.findAllCities());
				//, "hotels", hotelRep.findAll());
	}
	
	@PostMapping("/searchPrice")
	public ModelAndView searchPrice(@RequestParam("city") String city,
			@RequestParam("max") Double maxPrice) {
		ModelAndView mav = new ModelAndView("results", "hotels", hotelRep.findByCityOrderByPrice(city));
		mav.addObject("maxPrice", maxPrice);
		return mav;
		
	}
	
	
	@PostMapping("/searchRating")
	public ModelAndView searchRating(@RequestParam("city") String city,
			@RequestParam("max") Double maxPrice) {
		ModelAndView mav = new ModelAndView("results", "hotels", hotelRep.findByCityOrderByRatingDesc(city));
		mav.addObject("maxPrice", maxPrice);
		return mav;
		
	}
	
	
	@PostMapping("/search")
	public ModelAndView searchGen(@RequestParam("key") String search) {
		ModelAndView mav = new ModelAndView("results", "hotels", hotelRep.findByHotelNameLikeIgnoreCase(search));
		mav.addObject("maxPrice", 0);
		return mav;
		
	}
	
	
	@RequestMapping("/rateUp")
	public ModelAndView rateUp(@RequestParam("id") Long id) {
		Hotel hotel = hotelRep.findById(id).orElse(null);
		hotel.upVote();
		hotelRep.save(hotel);
		ModelAndView mav =new ModelAndView("redirect:/"+id);
		mav.addObject("clicked", "disabled");
		return mav;
	}
	
	@RequestMapping("/rateDown")
	public ModelAndView rateDown(@RequestParam("id") Long id) {
		Hotel hotel = hotelRep.findById(id).orElse(null);
		hotel.downVote();
		hotelRep.save(hotel);
		ModelAndView mav =new ModelAndView("redirect:/"+id);
		mav.addObject("click", "disabled");
		return mav; 
	}
	
	@RequestMapping("/{id}")
	public ModelAndView showHotel(@PathVariable("id") Hotel hotel) {
		return new ModelAndView("hotel-view", "hotel", hotel);
	}
	
	
}
