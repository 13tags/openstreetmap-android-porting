package com.example.mapsosm;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import org.osmdroid.views.MapView;
import org.osmdroid.api.IMapController;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.overlay.ItemizedOverlayWithFocus;
import org.osmdroid.views.overlay.OverlayItem;
import org.osmdroid.views.overlay.ItemizedIconOverlay.OnItemGestureListener;

public class MainActivity extends ActionBarActivity {
	
	private MapView mapView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		mapView = (MapView) findViewById(R.id.mapView);
		mapView.setBuiltInZoomControls(true);
		mapView.setMultiTouchControls(true);
						
		IMapController myMapController = mapView.getController();
		myMapController.setZoom(20);
		myMapController.setCenter(new GeoPoint(19.3797695, -99.1580429));
				
		ArrayList<OverlayItem> overlayItemArray = new ArrayList<OverlayItem>();
		overlayItemArray.add(new OverlayItem("Activ", "Activ Developing Experiences - Aqu’ Estoy", new GeoPoint(19.3797695, -99.1580429)));		
		
		OnItemGestureListener<OverlayItem> onItemGestureListener = new myItemGestureListener<OverlayItem>();
	
		ItemizedOverlayWithFocus<OverlayItem> itemizedIconOverlay = new ItemizedOverlayWithFocus<OverlayItem>(this, overlayItemArray, onItemGestureListener);
		itemizedIconOverlay.setFocusItemsOnTap(true);
		
		mapView.getOverlays().add(itemizedIconOverlay);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

}
