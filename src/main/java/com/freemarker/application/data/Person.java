package com.freemarker.application.data;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class Person {
    private String name;
    private int age;
    private String email;
    private Date registrationDate;
}
