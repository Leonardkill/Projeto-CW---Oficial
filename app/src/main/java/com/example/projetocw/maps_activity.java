package com.example.projetocw;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.projetocw.Classes.PontoColeta;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;

import java.util.ArrayList;
import java.util.List;

import static android.content.ContentValues.TAG;

<<<<<<< HEAD

public class maps_activity extends SupportMapFragment implements OnMapReadyCallback  {


    LocationManager locationManager;
    LocationListener locationListener;
    LatLng userLatLogn;
    Location location;
=======
public class maps_activity extends SupportMapFragment implements OnMapReadyCallback
{
>>>>>>> 697f8f7d38f72bd03621572fcc3d8d1c2ab80772

    private GoogleMap mMap;




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        getMapAsync(this);
    }




    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

<<<<<<< HEAD
        locationManager = (LocationManager) getContext().getSystemService(Context.LOCATION_SERVICE);
        locationListener = new LocationListener() {

            //Quando localizacao for alterada
            @Override
            public void onLocationChanged(Location location) {
                double latitude = location.getLatitude();
                double longitude = location.getLongitude();

                userLatLogn = new LatLng(latitude, longitude);
                mMap.setMyLocationEnabled(true);
                mMap.getUiSettings().setMyLocationButtonEnabled(false);
            }

            @Override
            public void onStatusChanged(String s, int i, Bundle bundle) {

            }

            @Override
            public void onProviderEnabled(String s) {

            }

            @Override
            public void onProviderDisabled(String s) {

            }
        };

        askLocationPermission();


        DatabaseReference ref = FirebaseDatabase.getInstance().getReference();
        //Marcadores

        Toast.makeText(getContext(), "Iniciando Marcadores", Toast.LENGTH_SHORT).show();



        ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    double posicao_latitude = dataSnapshot.child("PontoColeta").child("-LrknSc_4S9joTy0VI0t").child("latitude").getValue(Double.class);
                    double posicao_longitude = dataSnapshot.child("PontoColeta").child("-LrknSc_4S9joTy0VI0t").child("longitude").getValue(Double.class);
                    LatLng tucuruvi = new LatLng(posicao_latitude, posicao_longitude);
                    mMap.addMarker(new MarkerOptions().position(tucuruvi).title("Marcador Tucuruvi"));
                } else {
                    Log.e(TAG, "onDataChange: no Data");
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
=======

>>>>>>> 697f8f7d38f72bd03621572fcc3d8d1c2ab80772
    }

    private void askLocationPermission() {


<<<<<<< HEAD
        Dexter.withActivity(getActivity()).withPermission(Manifest.permission.ACCESS_FINE_LOCATION).withListener(new PermissionListener() {
            @Override
            public void onPermissionGranted(PermissionGrantedResponse response) {
                if (ContextCompat.checkSelfPermission(getContext(),Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ContextCompat.checkSelfPermission(getContext(),Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                    return;
                }
                locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, locationListener);




                Location lastLocation = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
                double latitude = lastLocation.getLatitude();
                double longitude = lastLocation.getLongitude();


                userLatLogn = new LatLng(latitude, longitude);
                mMap.addMarker(new MarkerOptions().position(userLatLogn).title("Você está aqui").icon(BitmapDescriptorFactory.fromResource(R.drawable.marker2)));
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(userLatLogn, 15));
                mMap.getUiSettings().setMyLocationButtonEnabled(false);
                mMap.setMyLocationEnabled(true);

            }

            @Override
            public void onPermissionDenied(PermissionDeniedResponse response) {

            }



            @Override
            public void onPermissionRationaleShouldBeShown(PermissionRequest permission, PermissionToken token) {
                token.continuePermissionRequest();
            }
        }).check();
=======
    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference();
        //Marcadores

        Toast.makeText(getContext(),"Teste",Toast.LENGTH_SHORT).show();


        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));

        ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    double posicao_latitude = dataSnapshot.child("PontoColeta").child("-LrknSc_4S9joTy0VI0t").child("latitude").getValue(Double.class);
                    double posicao_longitude = dataSnapshot.child("PontoColeta").child("-LrknSc_4S9joTy0VI0t").child("longitude").getValue(Double.class);
                    LatLng tucuruvi = new LatLng(posicao_latitude,posicao_longitude);
                    mMap.addMarker(new MarkerOptions().position(tucuruvi).title("Marcador Tucuruvi"));
                    mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(tucuruvi,18));
                }
                else {
                    Log.e(TAG,"onDataChange: no Data" );
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
>>>>>>> 697f8f7d38f72bd03621572fcc3d8d1c2ab80772
    }


}