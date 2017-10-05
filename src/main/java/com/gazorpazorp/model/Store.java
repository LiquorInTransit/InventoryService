package com.gazorpazorp.model;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;

@Embeddable
public class Store {
	private Long id;
	
	public Store() {}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
//	public double getLatitude() {
//		return latitude;
//	}
//	public void setLatitude(double latitude) {
//		this.latitude = latitude;
//	}
//	public double getLongitude() {
//		return longitude;
//	}
//	public void setLongitude(double longitude) {
//		this.longitude = longitude;
//	}

	@Override
	public String toString() {
		return "Store [id=" + id + "]";
	}
	
	
	
	
	
}
