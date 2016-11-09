package com.clara.hellogeofence;

import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

/**
 * Created by admin on 11/8/16.
 */

public class Firebase_Hunt {


	private static final String TAG = "FIREBASE_HUNT";

	private FirebaseDatabase mDatabase;
	private DatabaseReference mDatabaseReference;

	//private HuntClass mHuntClass;

	private static final String Scavenger_Lists_Key = "scavenger_hunts_345354";
	private static final String LIST_TAG = "ckascbk";


	public Firebase_Hunt() {

		mDatabase = FirebaseDatabase.getInstance();
		mDatabaseReference = mDatabase.getReference();


	}


	public void getAllScavengerLists() {

		Query query = mDatabaseReference.child(Scavenger_Lists_Key);


		query.addValueEventListener(new ValueEventListener() {
			@Override
			public void onDataChange(DataSnapshot dataSnapshot) {


				Log.d(LIST_TAG, dataSnapshot.getValue().toString());

				ArrayList arrayList = new ArrayList();

				for (DataSnapshot ds : dataSnapshot.getChildren()) {

					ScavengerHunt huntClass = ds.getValue(ScavengerHunt.class);

					arrayList.add(huntClass);

				}

				Log.d(LIST_TAG, arrayList.toString());

			}

			@Override
			public void onCancelled(DatabaseError databaseError) {

			}
		});
	}


	public void addTestHuntData() {

		Item item1 = new Item("IDS Center", 43, -90.9);
		Item item2 = new Item("MCTC", 44, -93.9);
		Item item3 = new Item("Loring Park", 42.4, -90);
		Item item4 = new Item("Starbucks", 47.4, -92.3);

		ScavengerHunt hunt1 = new ScavengerHunt();
		ArrayList<Item> items = new ArrayList<>();
		items.add(item1);
		items.add(item2);

		hunt1.setPlaces_to_find(items);
		hunt1.setName("Hunt 1");


		ScavengerHunt hunt2 = new ScavengerHunt();
		ArrayList items2 = new ArrayList();
		items.add(item3);
		items.add(item4);
		hunt2.setPlaces_to_find(items2);

		Log.d(TAG, "Created test scavenger hunts");

		DatabaseReference newHuntRef = mDatabaseReference.child(Scavenger_Lists_Key).push();
		newHuntRef.setValue(hunt1);
		Log.d(TAG, newHuntRef.toString());

		DatabaseReference newHuntRef2 = mDatabaseReference.child(Scavenger_Lists_Key).push();
		newHuntRef2.setValue(hunt2);

		Log.d(TAG, newHuntRef2.toString());

	}
}
