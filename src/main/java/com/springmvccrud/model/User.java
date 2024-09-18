package com.springmvccrud.model;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class User {


    private int id;
    private String name;
    private String address;
    private int pincode;

}
