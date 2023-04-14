package com.example.demo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class NewStudent {
    public String Name;
    public String grupa;
    public String number;

    public NewStudent(@JsonProperty("name") String name,@JsonProperty("grupa") String grupa, @JsonProperty("number") String number) {
        Name = name;
        this.grupa = grupa;
        this.number = number;
    }
}
