package janna_1997.dodam.myapplication;

import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {

    GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // SupportMapFragment을 통해 레이아웃에 만든 fragment의 ID를 참조하고 구글맵을 호출한다.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this); // getMapAsync must be called on the main thread.


    }

    @Override

    public void onMapReady(GoogleMap googleMap) {
        // 구글 맵 객체를 불러온다.
        mMap = googleMap;


        // 서울에 대한 위치 설정
        LatLng seoul = new LatLng(37.52487, 126.92723);

        // 구글 맵에 표시할 마커에 대한 옵션 설정
        MarkerOptions makerOptions = new MarkerOptions();
        makerOptions.position(new LatLng(37.52487, 126.92723))
                .title("위험!!")
                .snippet("위험지역입니다.")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE))
                .alpha(0.5f); //마커의 투명도

        // 마커를 생성한다.
        mMap.addMarker(makerOptions);

        //카메라를 서울 위치로 옮긴다.
        mMap.moveCamera(CameraUpdateFactory.newLatLng(seoul));
    }


    /*
    public void setMyPosition() {
        LocationManager manager = (LocationManager) getSystemService(this.LOCATION_SERVICE);

        LocationManager locationManager = new LocationListener()

        {
            public void onLocationChanged(Location location)
            {
                if(changed_check == 0)
                {
                    my_latitude = location.getLatitude();
                    my_longitude = location.getLatitude();
                    LatLng startingPoint = new LatLng(my_latitude, my_longitude)
                }
            }
        }
    }
    */
}