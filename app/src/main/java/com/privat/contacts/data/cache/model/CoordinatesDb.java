package com.privat.contacts.data.cache.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class CoordinatesDb {
    @PrimaryKey
    public int userId;
    public double lat;
    public double lng;
}
