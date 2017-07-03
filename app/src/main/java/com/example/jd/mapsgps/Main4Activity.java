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
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

public class Main4Activity extends AppCompatActivity implements OnMapReadyCallback{
    GoogleMap m_map;
    boolean mapReady=true;

    MarkerOptions renton;
    MarkerOptions kent;
    MarkerOptions kir;
    LatLng ren=new LatLng(47.489805,-122.120502);
    LatLng ken=new LatLng(47.385938,-122.258212);

    static final CameraPosition Seattle=CameraPosition.builder()
            .target(new LatLng(47.620,-122.2491))
            .zoom(17)
            .bearing(0)
            .tilt(45)
            .build();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        Button btn=(Button)findViewById(R.id.btnstreet);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(getApplicationContext(),Main5Activity.class);
                startActivity(i);
            }
        });
        renton =new MarkerOptions()
                .position(new LatLng(47.489,-122.120))
                .title("renton");
        kent=new MarkerOptions()
                .position(new LatLng(47.385938,-122.258))
                .title("kent");
//this is custom marker
        kir=new MarkerOptions()
                .position(new LatLng(49.7301986,-122.1768858))
                .title("kirkland")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_album_black_24dp));

        MapFragment mapFragment=(MapFragment) getFragmentManager().findFragmentById(R.id.map2);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mapReady=true;
        m_map=googleMap;
        m_map.addMarker(renton);
        m_map.addMarker(kent);
       // m_map.addMarker(kir);
        flyto(Seattle);


    }
    void flyto(CameraPosition target)
    {
        m_map.moveCamera(CameraUpdateFactory.newCameraPosition(target));
        m_map.addPolyline(new PolylineOptions().geodesic(true)
                .add(ren)
                .add(ken)
                .add(ren));
        /*
        * fill the color round up area
        *  m_map.moveCamera(CameraUpdateFactory.newCameraPosition(target));
        *  m_map.addCircle(new CircleOption()
        *  .center(renton)
        *  .radius(5000)
        *  .strokeColor(Color.Green)
        *  .fillColor(Color.argb(64,0,255,0)));
        * */
    }
}
