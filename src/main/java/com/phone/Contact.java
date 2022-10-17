package com.phone;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Contact {
    private String id;

    private String firstName;

    private String lastName;

    private String phoneNumber;

}
