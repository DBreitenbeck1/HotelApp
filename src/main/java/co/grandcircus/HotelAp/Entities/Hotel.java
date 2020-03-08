package co.grandcircus.HotelAp.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity 
@Table (name="hotel_listing")
public class Hotel {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long hotelId;
	private String hotelName;
	private String city;
	@Column(name="price_per_night")
	private Double price;
	@Column(name="up_votes")
	private int rating =0;
	
	public Hotel() {
		
	}
	
	public Long getHotelId() {
		return hotelId;
	}
	public void setHotelId(Long id) {
		this.hotelId = id;
	}
	public String getHotelName() {
		return hotelName;
	}
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double pricePerNight) {
		this.price = pricePerNight;
	}
	
	public int getRating() {
		return rating;
	}
	
	public void upVote() {
		setRating(this.rating+1);
	}

	public void downVote() {
		this.rating-=1;
	}
	
	public void setRating(int rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "Hotel [id=" + hotelId + ", hotelName=" + hotelName + ", city=" + city + ", pricePerNight=" + price
				+ "]";
	}
	
	

}
