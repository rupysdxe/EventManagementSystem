package com.example.eventmanagementsystem.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
@Getter
@Setter
@Entity
@Table(name = "Event")
public class Event {
    @Id
    @GeneratedValue
    private int eid;
    @OneToOne
    private Admin admin;
    private String notice;
    private LocalDateTime localDateTime;
    private String hourDifference;
    private String Topic;
    public Event(){
        this.hourDifference="";
        this.localDateTime=LocalDateTime.now();
    }

}
