package com.example.projetocw;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;


import android.view.Menu;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private FragmentManager fragmentManager;
    //FirebaseAuth mFirebaseAuth;
    //private  FirebaseAuth.AuthStateListener mAuthStateListener;
    //FirebaseUser mFirebaseUser = mFirebaseAuth.getCurrentUser();

    public static Intent createIntent(Context context) {
        return new Intent(context, MainActivity.class);
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);






        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_eventos, R.id.nav_ranking,
                R.id.nav_usuario, R.id.nav_share, R.id.nav_send)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);




        fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.add(R.id.container_maps , new maps_activity() , "MapsFragment");
        transaction.commit();

        View v = getLayoutInflater().inflate(R.layout.activity_cadastroapos_activity, null);


    }

    /*
    private void preProcess() {
        Intent intent = getIntent();
        final String uid = mFirebaseAuth.getUid();
        mFirebaseAuth = FirebaseAuth.getInstance();

        mAuthStateListener = new FirebaseAuth.AuthStateListener() {
            FirebaseUser mFirebaseUser = mFirebaseAuth.getCurrentUser();
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                if(mFirebaseUser != null) {
                    Intent i = new Intent(MainActivity.this,cadastroapos_activity.class);
                    startActivity(i);
                }
                else {
                    Toast.makeText(MainActivity.this,"Redirecionado" , Toast.LENGTH_SHORT).show();
                }



            }
        };

     */


        //Verificar se Cadastro existe no firebase
        //se não fez chama a tela de cadastro










    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    @Override
    protected void onResume() {

        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.container_maps , new maps_activity() , "MapsFragment");
        transaction.commit();


        super.onResume();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.sair:
                FirebaseAuth.getInstance().signOut();
                Intent sair =new Intent(this , login_activity.class);
                startActivity(sair);
                return true;

            default:
                return super.onOptionsItemSelected(item);

        }
    }
}

