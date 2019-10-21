package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

public class maps_activity extends SupportMapFragment implements OnMapReadyCallback
{

    private GoogleMap mMap;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getMapAsync(this);
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

        LatLng tucuruvi = new LatLng(-23.480074615926885 , -46.60350501537323 );
        MarkerOptions marker = new MarkerOptions();
        marker.position(tucuruvi);
        marker.title("Ponto de coleta Tucuruvi");
        mMap.addMarker(marker);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(tucuruvi));

        LatLng belem = new LatLng(-23.539753417272976 , -46.594905853271484 );
        marker.position(belem);
        marker.title("Marcador Belem ");
        mMap.addMarker(marker);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(belem));

        LatLng bras = new LatLng(-23.544159878865862 , -46.616835594177246 );
        marker.position(bras);
        marker.title("Marcador Brás ");
        mMap.addMarker(marker);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(bras));

        LatLng liberdade = new LatLng(-23.568078093330698 , -46.63155555725098 );
        marker.position(liberdade);
        marker.title("Marcador Liberdade ");
        mMap.addMarker(marker);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(liberdade));

        LatLng vguilherme = new LatLng(-23.520237312986335 , -46.61069869995117 );
        marker.position(vguilherme);
        marker.title("Marcador Vila Guilherme ");
        mMap.addMarker(marker);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(vguilherme));

        LatLng mooca = new LatLng(-23.56367243356796 , -46.59524917602539 );
        marker.position(mooca);
        marker.title("Marcador Mooca ");
        mMap.addMarker(marker);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(mooca));

        LatLng pinheiros = new LatLng(-23.56776340824804 , -46.6838264465332 );
        marker.position(pinheiros);
        marker.title("Marcador Pinheiros ");
        mMap.addMarker(marker);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(pinheiros));

        LatLng bfunda = new LatLng(-23.52653314675258 , -46.67558670043945 );
        marker.position(bfunda);
        marker.title("Marcador Barra Funda ");
        mMap.addMarker(marker);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(bfunda));
    }
}
