package com.privat.contacts.data.cache.model;

import androidx.room.Embedded;
import androidx.room.Relation;

public class UserFullDb {
    @Embedded
    public UserDb user;
    @Relation(parentColumn = "id", entityColumn = "userId")
    public AddressDb address;
    @Relation(parentColumn = "id", entityColumn = "userId")
    public CoordinatesDb coordinates;
    @Relation(parentColumn = "id", entityColumn = "userId")
    public CreditCardDb creditCard;
    @Relation(parentColumn = "id", entityColumn = "userId")
    public EmploymentDb employment;
    @Relation(parentColumn = "id", entityColumn = "userId")
    public SubscriptionDb subscription;
}