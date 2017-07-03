package com.example.jd.mapsgps;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.maps.OnStreetViewPanoramaReadyCallback;
import com.google.android.gms.maps.StreetViewPanorama;
import com.google.android.gms.maps.StreetViewPanoramaFragment;
import com.google.android.gms.maps.SupportStreetViewPanoramaFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.StreetViewPanoramaCamera;
import com.google.android.gms.maps.model.StreetViewPanoramaLocation;

public class Main5Activity extends AppCompatActivity implements OnStreetViewPanoramaReadyCallback{

    private static final LatLng SYDNEY = new LatLng(-33.87365, 151.20689);
    @Override
   protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
       StreetViewPanoramaFragment streetViewPanoramaFragment=(StreetViewPanoramaFragment) getFragmentManager()
                .findFragmentById(R.id.mp);
        streetViewPanoramaFragment.getStreetViewPanoramaAsync(this);
        Toast.makeText(getApplication(),"Get "+streetViewPanoramaFragment,Toast.LENGTH_LONG).show();


    }

    /*@OverridestreetViewPanoramaFragment.getStreetViewPanoramaAsync(
                new OnStreetViewPanoramaReadyCallback() {
                    @Override
                    public void onStreetViewPanoramaReady(StreetViewPanorama panorama) {
                        // Only set the panorama to SYDNEY on startup (when no panoramas have been
                        // loaded which is when the savedInstanceState is null).
                        if (savedInstanceState == null) {
                            panorama.setPosition(SYDNEY);
                        }
                    }
                });*/
    public void onStreetViewPanoramaReady(StreetViewPanorama streetViewPanorama) {
         /* panorama.setPosition(new LatLng(-33.87365, 151.20689));*/
        streetViewPanorama.setPosition(new LatLng(36.0579667,-122.1430996));
        //streetViewPanorama.setStreetNamesEnabled(false);
        Toast.makeText(getApplication(),"method call "+streetViewPanorama,Toast.LENGTH_LONG).show();
       // StreetViewPanoramaCamera camera=new StreetViewPanoramaCamera.Builder()
         //       .zoom(0.5f)
           //     .bearing(180)
             //   .build();
    //    streetViewPanorama.animateTo(camera,1000);

    }
}
