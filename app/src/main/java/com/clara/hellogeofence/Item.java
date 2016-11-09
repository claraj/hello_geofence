package com.clara.hellogeofence;

/**
 * Created by admin on 11/8/16.
 */

public class Item {

	//Used by Firebase
	Item() {}

	//Constructor for use in code


	public Item(String placeName, double lat, double lon) {
		this.placeName = placeName;
		this.lat = lat;
		this.lon = lon;
	}

	public String getPlaceName() {
		return placeName;
	}

	public void setPlaceName(String placeName) {
		this.placeName = placeName;
	}

	String placeName;
	double lat;
	double lon;


	@Override
	public String toString() {
		return "Item{" +
				"placeName='" + placeName + '\'' +
				", lat=" + lat +
				", lon=" + lon +
				'}';
	}
}
