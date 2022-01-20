package com.nexis.hermosa;
import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;

import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;

import android.Manifest;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Build;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;
import com.nexis.hermosa.databinding.ActivityMapsBinding;

import java.util.List;
public class MapsActivity extends FragmentActivity implements OnMapReadyCallback, LocationListener {
    private GoogleMap mMap;
    private ActivityMapsBinding binding;
    private Button btnav, btnbes, btntak;
    private Button btnkad, btnfat, btnbey;
    public double enlem;
    public double boylam;
    private String konumSaglayici = "gps";
    LocationManager locationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


        btnav = (Button) findViewById(R.id.btnav);
        btnkad = (Button) findViewById(R.id.btnkad);
        btnbes = (Button) findViewById(R.id.btnbes);
        btntak = (Button) findViewById(R.id.btntak);
        btnfat = (Button) findViewById(R.id.btnfat);
        btnbey = (Button) findViewById(R.id.btnbey);
        btnav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MapsActivity.this, Etkinlik.class);
                startActivity(i);
            }
        });
        btnkad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MapsActivity.this, Etkinlik2.class);
                startActivity(i);
            }
        });

    }

    @Override
    public void onLocationChanged(@NonNull Location location) {

        enlem = location.getLatitude();
        boylam = location.getLongitude();



    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        Location konum = locationManager.getLastKnownLocation(konumSaglayici);

        onLocationChanged(konum);


        googleMap.getUiSettings().setZoomControlsEnabled(true);
        googleMap.getUiSettings().setCompassEnabled(true);
        mMap.getUiSettings().isMyLocationButtonEnabled();
        mMap.getUiSettings().setMyLocationButtonEnabled(true);
        mMap.getUiSettings().isMapToolbarEnabled();

        LatLng ben = new LatLng(enlem, boylam);
        mMap.addMarker(new MarkerOptions().position(ben).title("ben").icon(BitmapDescriptorFactory.fromResource(R.drawable.lobe)));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(ben, 13f));

        LatLng avcilar = new LatLng(40.970851316666234, 28.721048948369706);
        mMap.addMarker(new MarkerOptions().position(avcilar).title("AVCILAR"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(avcilar, 9f));

        LatLng kadiköy = new LatLng(40.99096003216742, 29.029276548476066);
        mMap.addMarker(new MarkerOptions().position(kadiköy).title("KADIKÖY"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(kadiköy, 9f));

        PolylineOptions options = new PolylineOptions().add(ben).add(avcilar).width(5).color(Color.BLUE).visible(true).geodesic(true);
        mMap.addPolyline(options);

        PolylineOptions cig= new PolylineOptions().add(ben).add(kadiköy).width(5).color(Color.BLUE).visible(true).geodesic(true);
        mMap.addPolyline(cig);

        LatLng besiktas = new LatLng(41.0717769,28.9872267);
        mMap.addMarker(new MarkerOptions().position(besiktas).title("BEŞİKTAŞ"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(besiktas, 9));
        PolylineOptions op = new PolylineOptions().add(ben).add(besiktas).width(5).color(Color.BLUE).visible(true).geodesic(true);
        mMap.addPolyline(op);


        LatLng taks = new LatLng(41.0370176,28.9763155);
        mMap.addMarker(new MarkerOptions().position(taks).title("TAKSİM"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(taks, 9));
        PolylineOptions opt= new PolylineOptions().add(ben).add(taks).width(5).color(Color.BLUE).visible(true).geodesic(true);
        mMap.addPolyline(opt);

        LatLng fat = new LatLng(41.0143189,28.9185161);
        mMap.addMarker(new MarkerOptions().position(fat).title("FATİH"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(fat, 9));
        PolylineOptions optA= new PolylineOptions().add(ben).add(fat).width(5).color(Color.BLUE).visible(true).geodesic(true);
        mMap.addPolyline(optA);
    }





    @Override
    public void onFlushComplete(int requestCode) {

    }

    @Override
    public void onProviderEnabled(@NonNull String provider) {

    }
}

