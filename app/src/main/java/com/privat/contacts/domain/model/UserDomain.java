package com.privat.contacts.domain.model;

import org.jetbrains.annotations.NotNull;

import java.util.LinkedList;
import java.util.List;

public interface UserDomain {
    static <T> List<T> mapList(List<UserDomain> userDomainList, Mapper<T> mapper) {
        LinkedList<T> newList = new LinkedList();
        for (UserDomain item :
                userDomainList) {
            newList.add(item.map(mapper));
        }
        return newList;
    }

    @NotNull
    <T> T map(Mapper<T> mapper);

    interface Mapper<T> {
        @NotNull
        T map(int id,
              String uid,
              String password,
              String firstName,
              String lastName,
              String username,
              String email,
              String avatar,
              String gender,
              String phoneNumber,
              String socialInsuranceNumber,
              String dateOfBirth,
              String cardNumber,
              boolean favorite,
              AddressDomain address,
              EmploymentDomain employment,
              SubscriptionDomain subscription);
    }
}
