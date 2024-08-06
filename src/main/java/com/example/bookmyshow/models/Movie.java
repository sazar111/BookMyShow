package com.example.bookmyshow.models;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Movie extends BaseModel{
    String name;
    List<Feature> features;

}
