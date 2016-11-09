package com.clara.hellogeofence;

import java.util.List;

/**
 * Created by admin on 11/8/16.
 */

public class ScavengerHunt {

	String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Item> getPlaces_to_find() {
		return places_to_find;
	}

	public void setPlaces_to_find(List<Item> places_to_find) {
		this.places_to_find = places_to_find;
	}

	List<Item> places_to_find;


	ScavengerHunt()  {}


	@Override
	public String toString() {
		return "ScavengerHunt{" +
				"name='" + name + '\'' +
				", places_to_find=" + places_to_find +
				'}';
	}
}
