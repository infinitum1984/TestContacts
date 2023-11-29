package com.privat.contacts.data.cloud.model;

public class CoordinatesNet {
    private final double lat;
    private final double lng;

    public CoordinatesNet(double lat, double lng) {
        this.lat = lat;
        this.lng = lng;
    }

    public double getLng() {
        return lng;
    }

    public double getLat() {
        return lat;
    }
}
