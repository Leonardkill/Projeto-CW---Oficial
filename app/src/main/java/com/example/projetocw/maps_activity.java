package com.example.projetocw;

import androidx.annotation.NonNull;

import android.os.Bundle;
import android.widget.Toast;

import com.example.projetocw.Classes.PontoColeta;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class maps_activity extends SupportMapFragment implements OnMapReadyCallback
{

    private GoogleMap mMap;

    private List<PontoColeta> lista = new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getMapAsync(this);

        DatabaseReference myRef = FirebaseDatabase.getInstance().getReference().child("PontoColeta").child("-LrknSc_4S9joTy0VI0t");

        myRef.addListenerForSingleValueEvent( new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String name = dataSnapshot.child("nomePontoColeta").getValue(String.class);
                double latt = dataSnapshot.child("latitude").getValue(Double.class);
                double lng = dataSnapshot.child("longitude").getValue(Double.class);
                mMap.addMarker(new MarkerOptions().position(new LatLng(latt, lng)).title(name));

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }



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
        //Marcadores

        Toast.makeText(getContext(),"Teste",Toast.LENGTH_SHORT).show();


    }
}