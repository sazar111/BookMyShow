package com.example.bookmyshow.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity(name = "shows")
public class Show extends BaseModel{
    Date startTime;
    Date endTime;
    @ManyToOne
    Movie movie;
    @ManyToOne
    Screen screen;
    @Enumerated(EnumType.ORDINAL)
    @ElementCollection
    List<Feature> features;
    @Enumerated(EnumType.ORDINAL)
    ShowStatus showStatus;
}
