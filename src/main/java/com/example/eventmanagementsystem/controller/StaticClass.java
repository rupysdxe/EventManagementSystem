package com.example.eventmanagementsystem.controller;
import com.example.eventmanagementsystem.model.Event;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpSession;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
public class StaticClass {
    public static void addTimeValue(List<Event> eventList){
        Collections.reverse(eventList);
        for(Event event: eventList){
            LocalDateTime eventTime=event.getLocalDateTime();
            LocalDateTime now=LocalDateTime.now();
            Duration duration = Duration.between(now, eventTime);
            long diff = Math.abs(duration.toSeconds());
            if(diff<60){
                event.setHourDifference("few moments ago");
            }else if(diff<3600){
                event.setHourDifference(String.valueOf(Math.abs(duration.toMinutes()))+" minutes ago ");
            }else {
                event.setHourDifference(String.valueOf(Math.abs(duration.toHours()))+" hours ago ");
            }
        }
    }

}
