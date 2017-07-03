package com.example.jd.mapsgps;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;

public class Main3Activity extends AppCompatActivity implements OnMapReadyCallback {
    GoogleMap m_map;
    boolean mapReady = false;
    static final CameraPosition Tokyo = CameraPosition.builder()
            .target(new LatLng(35.6895, 139.6917))
            .zoom(21)
            .bearing(0)
            .tilt(45)
            .build();
    static final CameraPosition Dublin = CameraPosition.builder()
            .target(new LatLng(53.3478, -6.2597))
            .zoom(17)
            .bearing(90)
            .tilt(90)
            .build();
    static final CameraPosition Vadodara = CameraPosition.builder()
            .target(new LatLng(22.3110904, 73.1679335))
            .zoom(19)
            .bearing(0)
            .tilt(45)
            .build();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        Button tokyo = (Button) findViewById(R.id.btntokyo);
        tokyo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplication(), "Tokyo", Toast.LENGTH_SHORT).show();
                if (mapReady) {
                    flyto(Tokyo);
                }
            }
        });
        Button dublin = (Button) findViewById(R.id.btndublin);
        dublin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplication(), "dublin", Toast.LENGTH_SHORT).show();
                if (mapReady) {
                    flyto(Dublin);
                }
            }
        });
        Button baroda = (Button) findViewById(R.id.btnind);
        baroda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mapReady) {
                    flyto(Vadodara);
                }
            }
        });
        Button mark=(Button)findViewById(R.id.btnmark);
        mark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"marker",Toast.LENGTH_LONG).show();
                Intent i= new Intent(getApplicationContext(),Main4Activity.class);
                startActivity(i);
            }
        });

        MapFragment mapFragment=(MapFragment) getFragmentManager().findFragmentById(R.id.map2);
        mapFragment.getMapAsync(this);

    }


    @Override
    public void onMapReady(GoogleMap googleMap) {

        mapReady = true;
        m_map = googleMap;
        m_map.setMapType(GoogleMap.MAP_TYPE_HYBRID);
        flyto(Tokyo);
    }

    void flyto(CameraPosition target)
    {
        m_map.animateCamera(CameraUpdateFactory.newCameraPosition(target),10000,null);
    }

}
