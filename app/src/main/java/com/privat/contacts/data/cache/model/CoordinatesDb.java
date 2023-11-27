package com.privat.contacts.data.cache.model;

import androidx.room.Entity;

@Entity
public class CoordinatesDb {
    public int userId;
    public double lat;
    public double lng;
}
