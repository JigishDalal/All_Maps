package com.example.jd.mapsgps;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;

public class Main2Activity extends AppCompatActivity implements OnMapReadyCallback{
    GoogleMap m_map;
    boolean mapReady=false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Button btnmap=(Button)findViewById(R.id.btnmap);
        btnmap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mapReady){
                    m_map.setMapType(GoogleMap.MAP_TYPE_NORMAL);
                }
            }
        });
        Button btnSat=(Button)findViewById(R.id.btnSatellite);
        btnSat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mapReady)
                {
                    m_map.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
                }
            }
        });
        Button btnhy=(Button)findViewById(R.id.btnHybrid);
        btnhy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mapReady){
                    m_map.setMapType(GoogleMap.MAP_TYPE_HYBRID);
                }
            }
        });
        Button fly=(Button)findViewById(R.id.btnfly);
        fly.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(),Main3Activity.class);
                startActivity(i);
            }
        });
        MapFragment mapFragment=(MapFragment) getFragmentManager().findFragmentById(R.id.map2);
        mapFragment.getMapAsync(this);

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mapReady=true;
        m_map=googleMap;
        LatLng newyork=new LatLng(40.7884,-73.9857);
        CameraPosition target=CameraPosition.builder().target(newyork).zoom(14).build();
        m_map.moveCamera(CameraUpdateFactory.newCameraPosition(target));


    }
}
