package com.clara.hellogeofence;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 11/6/16.
 */

public class Firebase {

	private FirebaseDatabase database;
	private DatabaseReference geofenceEventsReference;

	//Firebase key constants
	private static final String GEOFENCE_EVENTS = "geofence_events";


	public Firebase() {
		database = FirebaseDatabase.getInstance();
		geofenceEventsReference = database.getReference().child(GEOFENCE_EVENTS);
	}

	public void addGeoFenceEvent(String event) {
		geofenceEventsReference.push().setValue(event);
	}

	interface GeoFenceEventCallback  {
		public void newGeoFenceEventMessages(ArrayList<String> messages);
	}

	public void beNotifiedOfGeoFenceEvents(final GeoFenceEventCallback callback) {
		Query allEvents = geofenceEventsReference;    //get all the data. TODO real app will probably filter somehow.

		allEvents.addValueEventListener(new ValueEventListener() {

			//Will be called every time data is changed - in this app, when new GeoFence message is added.

			@Override
			public void onDataChange(DataSnapshot dataSnapshot) {

				ArrayList<String> messages = new ArrayList<String>();

				for (DataSnapshot ds : dataSnapshot.getChildren()) {
					messages.add(ds.getValue(String.class));
				}

				callback.newGeoFenceEventMessages(messages);
			}

			@Override
			public void onCancelled(DatabaseError databaseError) {

			}
		});
	}


}
