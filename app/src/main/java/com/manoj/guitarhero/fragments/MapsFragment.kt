package com.manoj.guitarhero.fragments

import androidx.fragment.app.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.manoj.guitarhero.R
import com.manoj.guitarhero.entity.LatitudeLongitude

class MapsFragment : Fragment(), OnMapReadyCallback {
    private lateinit var mMap: GoogleMap
    private var lstLatitudeLongitude = ArrayList<LatitudeLongitude>()


    private val callback = OnMapReadyCallback { googleMap ->
        mMap = googleMap
        lstLatitudeLongitude.add(LatitudeLongitude(27.7061949, 85.3300394, "GuitarHero"))
        lstLatitudeLongitude.add(LatitudeLongitude(27.7061949, 85.3300394, "GuitarHero"))
        for (location in lstLatitudeLongitude) {
            mMap.addMarker(
                    MarkerOptions().position(LatLng(location.latitude, location.longitude))
                            .title(location.markerName)
                            .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN))
            )
        }
        mMap.animateCamera(
                CameraUpdateFactory.newLatLngZoom(LatLng(27.7061949, 85.3300394), 16F), 4000, null
        )
        mMap.uiSettings.isZoomControlsEnabled=true
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_maps, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?
        mapFragment?.getMapAsync(callback)
    }

    override fun onMapReady(p0: GoogleMap?) {
        TODO("Not yet implemented")
    }

}