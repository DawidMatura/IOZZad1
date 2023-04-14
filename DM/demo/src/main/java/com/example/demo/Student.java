package com.example.demo;

public class Student {
    public long Id;
    public String Name;
    public String grupa;
    public String number;

    public Student(long id, String name, String grupa, String number) {
        Id = id;
        Name = name;
        this.grupa = grupa;
        this.number = number;
    }
}
